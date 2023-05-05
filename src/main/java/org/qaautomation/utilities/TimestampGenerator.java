package org.qaautomation.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampGenerator {

    public static String getTimestamp(String pattern){
        //create pattern dtf according to parameters i.e. "yyyy-MM-dd_HH-mm-ss"
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);

        //get local time
        LocalDateTime localTime = LocalDateTime.now();

        //return formatter timestamp
        return dtf.format(localTime);
    }
}
