package com.example.insense.repository.room.categoryDB;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.TypeConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CategoriesConventer {
    @RequiresApi(api = Build.VERSION_CODES.N)
    @TypeConverter
    public String fromCategory(List<String> category) {
        return category.stream().collect(Collectors.joining(","));
    }

    @TypeConverter
    public List<String> toCategory(String data) {
        return Arrays.asList(data.split(","));
    }
}
/* class Converter_categ {

    @TypeConverter
    public Long dateToTimestamp(Date date) {
        if (date == null) {
            return null;
        } else {
            return date.getTime();
        }
    }

}*/
