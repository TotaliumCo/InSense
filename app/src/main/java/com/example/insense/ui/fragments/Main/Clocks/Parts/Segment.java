package com.example.insense.ui.fragments.Main.Clocks.Parts;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.insense.repository.room.Activity;

public class Segment{

    private long start;
    private long finish;
    Canvas canvas;
    private RectF oval ;
    private Paint paint ;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Segment(Activity activity
    ){
        Log.i("ACTINSEGM", String.valueOf(activity));
        start = activity.startHour*60*60 +activity.startMinute*60+activity.startSec;
        finish =  activity.endHour*60*60 +activity.endMinute*60+activity.endSec;
        paint = new Paint();
        Log.i("ACTINSEGM", String.valueOf(finish)+String.valueOf(start));
        paint.setARGB(activity.al,activity.red,activity.green,activity.blue);
        Log.i("ACTINSEGM", String.valueOf(activity.al)+String.valueOf(activity.blue)+String.valueOf(activity.green)+String.valueOf(activity.red));
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
