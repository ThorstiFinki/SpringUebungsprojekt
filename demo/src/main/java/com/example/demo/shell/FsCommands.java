package com.example.demo.shell;

import com.example.demo.FileSystem;
import com.example.demo.configuration.Date4uProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.util.unit.DataSize;


@ShellComponent
public class FsCommands {


    private final FileSystem fs;
    private final Environment environment;
//    @Value("${com.example.demo.filesystem.minimum-free-disk-space:1000000}")
//    private long minimumFreeDiskSpace;


    private final Date4uProperties date4uProperties;


    @Autowired
    public FsCommands(FileSystem fs, Environment environment, Date4uProperties date4uProperties) {
        this.fs = fs;
        this.environment = environment;
        this.date4uProperties = date4uProperties;
    }

    @ShellMethod("Display required free disk space")
    public long minimumFreeDiskSpace() {

        return date4uProperties.getFilesystem().getMinimumFreeDiskSpace();
    }

    @ShellMethod("Display free disk space")
    public String freeDiskSpace() {
        return DataSize.ofBytes(fs.getFreedDiskSpace()).toGigabytes() + " GB";
    }

    @ShellMethod("Display User Home")
    public String userHome(){ //-user home
        return environment.getProperty("user.home");
    }

}
