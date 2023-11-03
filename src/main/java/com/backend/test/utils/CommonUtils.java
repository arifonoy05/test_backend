package com.backend.test.utils;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class CommonUtils {

    public static Timestamp currentTimeInMillisToTimestamp(){
        Instant instant = Instant.now();
        return Timestamp.from(instant);
    }

}
