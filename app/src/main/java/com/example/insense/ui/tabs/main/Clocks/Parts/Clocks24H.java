package com.example.insense.ui.tabs.main.Clocks.Parts;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.insense.application.App;
import com.example.insense.models.Date;
import com.example.insense.repository.ActivityRepository;
import com.example.insense.repository.room.activityDB.Activity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Clocks24H {

    Canvas canvas;
    ActivityRepository repository = App.getInstance().getActivityRepository();
    Paint digital_time_paint = new Paint();
    Paint time_arc_paint = new Paint();
    Paint circle_paint = new Paint();
    final RectF oval = new RectF();
    ArrayList<Segment> segments = new ArrayList<>();

    java.util.Date realTime = new java.util.Date(System.currentTimeMillis());

    public Clocks24H(){
        digital_time_paint.setARGB(255,7, 229, 245);
        digital_time_paint.setTextSize(70);
        time_arc_paint.setARGB(255,109, 100, 125);
        time_arc_paint.setStrokeWidth(40);
        time_arc_paint.setStyle(Paint.Style.STROKE);

        circle_paint.setARGB(255,7, 229, 245);
        circle_paint.setAntiAlias(true);
        for (Activity act: repository.ActivitiesFromTo(new Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,0,0),
                new Date(Calendar.YEAR,Calendar.DAY_OF_YEAR+1,0,0,0)))
        {
            Log.i("ACT", String.valueOf(act.startDate.getSecs()));
            segments.add(new Segment(act));
        }
        Log.i("SEG", "Clocks24H: "+segments.toString());
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void print(Canvas canvas){
        this.canvas = canvas;
        LocalDateTime date = LocalDateTime.now();
        int seconds = date.toLocalTime().toSecondOfDay();

        int radius = canvas.getHeight()/2-10;
        int width = canvas.getHeight();
        int height = canvas.getHeight();

        oval.set((float)30,(float)30,(float)width-30,(float)height-30);
        float start_angle =-90f;
        float sweep_angle = (float)seconds/86400*360;



        // заполнение фона
        canvas.drawARGB(200,20, 0, 55);
        // установка основного цвета
        circle_paint.setARGB( 255,41, 225, 205);
        for (Segment seg: segments )
        {
            seg.print(canvas);
        }

        // отрисовка дуги прошедшего суточного времени
        canvas.drawArc(oval,start_angle,sweep_angle,false,time_arc_paint);
        // отрисовка цифровых часов
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        canvas.drawText(dtf.format(now), width/2-130,height/2+40,digital_time_paint);
        // Отрисовка делений

        for (int i = 1; i < 25; i++) {
            double angle = Math.PI/12*(i-3);
            int x = (int) (width/2+Math.cos(angle)*(radius-20));
            int y = (int) (width/2+Math.sin(angle)*(radius-20));
            canvas.drawCircle(x,y,10,circle_paint);
        }
    }
}

