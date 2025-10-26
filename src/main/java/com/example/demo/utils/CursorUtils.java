package com.example.demo.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CursorUtils {
    public static boolean isValidCursor(String cursor) {
        if(cursor == null  || cursor.isEmpty()){
            return false;
        }

        try{
            LocalDateTime.parse(cursor);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public static LocalDateTime parseCursor(String cursor){
        if(!isValidCursor(cursor)){
            throw new IllegalArgumentException("Invalid Cursor");
        }

        return LocalDateTime.parse(cursor);
    }
}
