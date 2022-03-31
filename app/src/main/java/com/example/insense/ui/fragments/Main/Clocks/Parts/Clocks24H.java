package com.example.insense.ui.fragments.Main.Clocks.Parts;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.insense.application.App;
import com.example.insense.repository.room.Activity;
import com.example.insense.repository.room.AppDB;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Clocks24H {

    AppDB dataBase = App.getInstance().getDatabase();
    Canvas canvas;
    Paint digital_time_paint = new Paint();
    Paint time_arc_paint = new Paint();
    Paint circle_paint = new Paint();
    final RectF oval = new RectF();
    Segment segment0 = new Segment(dataBase.userDao().loadByName("Early walking with the dog"));
    Segment segment1 = new Segment(dataBase.userDao().loadByName("Breakfast"));

    public Clocks24H(){
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
        segment0.print(canvas);
        segment1.print(canvas);
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

