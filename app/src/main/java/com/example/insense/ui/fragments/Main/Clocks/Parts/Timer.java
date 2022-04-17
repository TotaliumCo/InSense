package com.example.insense.ui.fragments.Main.Clocks.Parts;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.insense.application.App;
import com.example.insense.services.time.GlobalTimer;
import java.time.format.DateTimeFormatter;

public class Timer {
    GlobalTimer globalTimer = App.getInstance().getGlobalTimer();
    Canvas canvas;
    Paint digital_time_paint = new Paint();
    Paint time_arc_paint = new Paint();
    Paint circle_paint = new Paint();
    final RectF oval = new RectF();
    public Timer(){
        digital_time_paint.setARGB(255,7, 229, 245);
        digital_time_paint.setTextSize(70);
        time_arc_paint.setARGB(255,109, 100, 125);
        time_arc_paint.setStrokeWidth(40);
        time_arc_paint.setStyle(Paint.Style.STROKE);

        circle_paint.setARGB(255,7, 229, 245);
        circle_paint.setAntiAlias(true);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void print(Canvas canvas){
        this.canvas = canvas;
        int startTime = globalTimer.getStartTime();
        int seconds =(int) globalTimer.getLeftTimeInMillis();

        int radius = canvas.getHeight()/2-10;
        int width = canvas.getHeight();
        int height = canvas.getHeight();

        oval.set((float)30,(float)30,(float)width-30,(float)height-30);
        float start_angle =-90f;
        float sweep_angle = (float)seconds/startTime*360;



        // заполнение фона
        canvas.drawARGB(200,20, 0, 55);
        // установка основного цвета
        circle_paint.setARGB( 255,41, 225, 205);

        // отрисовка дуги прошедшего суточного времени
        canvas.drawArc(oval,start_angle,sweep_angle,false,time_arc_paint);
        // отрисовка цифровых часов
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm:ss");
        canvas.drawText(String.valueOf(seconds/1000/60)+":"+String.valueOf(seconds/1000%60), width/2-50,height/2+25,digital_time_paint);

    }
}
