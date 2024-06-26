package com.example.demo;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileSystem {

    private final Path root = Paths.get(System.getProperty("user.home")).resolve("fs");

    public FileSystem() {
        if (!Files.isDirectory(root)) {
            try {
                Files.createDirectory(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public long getFreedDiskSpace(){
        return root.toFile().getFreeSpace();
    }

    public byte[] load (String filename) {
        try {
            return  Files.readAllBytes(root.resolve(filename));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

   public void store (String filename, byte[] bytes){
        try {
            Files.write(root.resolve(filename), bytes);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println("Das Programm wird beendet. Auf Wiedersehen!");
    }

}
