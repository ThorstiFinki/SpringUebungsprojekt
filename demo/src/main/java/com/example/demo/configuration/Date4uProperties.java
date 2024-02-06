package com.example.demo.configuration;

import com.example.demo.FileSystem;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties ("com.example.demo")
public class Date4uProperties {

    public static class Filesystem {

        /**
         * Required minimum free disk space for locale filesystem.
         */
        private long minimumFreeDiskSpace;

        public long getMinimumFreeDiskSpace() {
            return minimumFreeDiskSpace;
        }

        public void setMinimumFreeDiskSpace(long minimumFreeDiskSpace) {
            this.minimumFreeDiskSpace = minimumFreeDiskSpace;
        }

    }

    private Filesystem filesystem;

    public Filesystem getFilesystem() {
        return filesystem;
    }

    public void setFilesystem(Filesystem filesystem) {
        this.filesystem = filesystem;
    }





}
