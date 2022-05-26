package com.example.insense.repository.room.activityDB;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import androidx.room.ColumnInfo;
import androidx.room.TypeConverters;

import com.example.insense.models.ColorCanvas;

import java.time.LocalDateTime;

@Entity
public class Activity {
    @PrimaryKey(autoGenerate = true)
    public long uid;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "occupation")
    public String occupation;
    @ColumnInfo(name = "description")
    public String description;
    @TypeConverters({ActivityConverters.class})
    public LocalDateTime startDate;
    @TypeConverters({ActivityConverters.class})
    public LocalDateTime endDate;
    @ColumnInfo(name = "color")
    public ColorCanvas color;
    @ColumnInfo(name = "status")
    public String status = "not completed";

}
