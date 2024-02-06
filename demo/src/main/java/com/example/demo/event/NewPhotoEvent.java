package com.example.demo.event;

import java.time.OffsetDateTime;

public record NewPhotoEvent(String name, OffsetDateTime dateTime) {

}
