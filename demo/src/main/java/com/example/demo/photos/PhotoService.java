package com.example.demo.photos;

import com.example.demo.FileSystem;
import com.example.demo.event.NewPhotoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class PhotoService {

    private final FileSystem fs ;
   @Autowired
  final private Thumbnail thumbnail;
  //  private final ApplicationEventPublisher publisher;

    public PhotoService(FileSystem fs, Thumbnail thumbnail /*, ApplicationEventPublisher publisher */) {
        this.fs = fs;
        this.thumbnail = thumbnail;
     //   this.publisher = publisher;
    }

    public Optional<byte[]> download(String imageName){
        try {
            return Optional.ofNullable(fs.load(imageName + ".jpg"));
        }
        catch (Exception e){
           return Optional.empty();
        }
    }

    public String upload( byte[] imageBytes ) {
        String imageName = UUID.randomUUID().toString();

//        NewPhotoEvent newPhotoEvent = new NewPhotoEvent(imageName, OffsetDateTime.now());
//publisher.publishEvent(newPhotoEvent);

        // First: store original image
        fs.store( imageName + ".jpg", imageBytes );

        // Second: store thumbnail
        byte[] thumbnailBytes = thumbnail.thumbnail( imageBytes );
        fs.store( imageName + "-thumb.jpg", thumbnailBytes );

        return imageName;
    }

}


