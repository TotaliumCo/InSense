package com.example.insense.repository.room.activityDB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import androidx.room.ColumnInfo;

import com.example.insense.models.ColorCanvas;
import com.example.insense.models.Date;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
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
    @ColumnInfo(name = "start date")
    public Date startDate;
    @ColumnInfo(name = "end date")
    public Date endDate;
    @ColumnInfo(name = "color")
    public ColorCanvas color;
}
