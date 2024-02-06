package com.example.demo.shell;

import com.example.demo.photos.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@ShellComponent
public class PhotoCommands {

    @Autowired
    private final PhotoService photoService ;

    public PhotoCommands(PhotoService photoService) {
        this.photoService = photoService;
    }

    @ShellMethod("Show Photo")
    String showPhoto(String name) { //show-photo
        return photoService.download(name)
                .map(bytes -> {
                    try {
                        var image = ImageIO.read(new ByteArrayInputStream(bytes));
                        return "Width: " +image.getWidth()+", Height: " + image.getHeight();
                    } catch (IOException e) {
                        return"Unable to read image dimensions";
                    }
                })
                .orElse("Image not found");
    }

    @ShellMethod("Upload Photo")
    String uploadPhoto(String filename) throws IOException { //Upload Photo

        byte[] bytes = Files.readAllBytes(Paths.get(filename));

        return "Uploaded: " + photoService.upload(bytes);


    }
}
