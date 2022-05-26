package com.example.insense.repository.room.activityDB;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.TypeConverter;


import com.example.insense.models.ColorCanvas;

import java.time.LocalDateTime;

public class ActivityConverters {
    @TypeConverter
    public static ColorCanvas fromColor(String value) {

        String[] parts = value.split(" ");
        int part1 = Integer.parseInt(parts[0]); // 004
        int part2 = Integer.parseInt(parts[1]); // 034556
        int part3 = Integer.parseInt(parts[2]);
        int part4 = Integer.parseInt(parts[3]);
        return new ColorCanvas(part1, part2, part3, part4);
    }
    @TypeConverter
    public static String colorToColorstapt(ColorCanvas color) {
        return Integer.toString(color.getAl())+" "+Integer.toString(color.getRed())+" "+
                Integer.toString(color.getGreen())+" "+Integer.toString(color.getBlue());
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @TypeConverter
    public static LocalDateTime toDate(String dateString) {
        if (dateString == null) {
            return null;
        } else {
            return LocalDateTime.parse(dateString);
        }
    }

    @TypeConverter
    public static String toDateString(LocalDateTime date) {
        if (date == null) {
            return null;
        } else {
            return date.toString();
        }
    }

}
