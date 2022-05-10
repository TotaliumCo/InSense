package com.example.insense.ui.fragments.Main.Clocks.Parts;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.insense.repository.room.activityDB.Activity;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Segment{

    private long start;
    private long finish;
    Canvas canvas;
    private RectF oval ;
    private Paint paint ;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Segment(Activity activity
    ){

        start = activity.startDate.getHour() * 60 * 60 + activity.startDate.getMinute() * 60
                + activity.startDate.getSecond();
        finish = activity.endDate.getHour() * 60 * 60 + activity.endDate.getMinute() * 60
                + activity.endDate.getSecond();
        paint = new Paint();
        paint.setARGB(activity.color.getAl(), activity.color.getRed(), activity.color.getGreen(), activity.color.getBlue());
        paint.setStrokeCap(Paint.Cap.ROUND);

    }

    public void print(Canvas canvas){
        this.canvas = canvas;
        int radius = canvas.getHeight()/2-10;
        int width = canvas.getHeight();
        int height = canvas.getHeight();
        oval = new RectF();
        oval.set((float)70,(float)70,(float)width-70,(float)height-70);


        float start_angle =(float)start/86400*360-90f;
        float sweep_angle =(float)(finish-start)/86400*360;


        canvas.drawArc(oval,start_angle,sweep_angle,true,paint);

    }
}
