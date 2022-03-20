package com.example.insense.ui.fragments.Main;

//Отвечает за прорисовку циферблата и интеракцию с ним

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;

public class DrawView extends SurfaceView implements SurfaceHolder.Callback {
    private DrawThread drawThread;
    public DrawView(Context context){
        super(context);
        getHolder().addCallback(this);
    }



    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        drawThread = new DrawThread(getContext(),getHolder());
        drawThread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        drawThread.requestStop();
    }





}
class DrawThread extends Thread {

    private SurfaceHolder surfaceHolder;



    private volatile boolean running = true;//флаг для остановки потока

    public DrawThread(Context context, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
    }

    public void requestStop() {
        running = false;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void run() {

        Paint digital_time_paint = new Paint();
        digital_time_paint.setARGB(255,7, 229, 245);
        digital_time_paint.setTextSize(70);

        Paint time_arc_paint = new Paint();
        time_arc_paint.setARGB(255,109, 55, 125);
        time_arc_paint.setStrokeWidth(20);
        time_arc_paint.setStyle(Paint.Style.STROKE);

        Paint circle_paint = new Paint();
        circle_paint.setARGB(255,7, 229, 245);
        circle_paint.setAntiAlias(true);


        final RectF oval = new RectF();

        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas();
            LocalDateTime date = LocalDateTime.now();
            int seconds = date.toLocalTime().toSecondOfDay();
            if (canvas != null) {
                try {
                    int radius = canvas.getHeight()/2-10;
                    int width = canvas.getHeight();
                    int height = canvas.getHeight();


                    oval.set((float)20,(float)20,(float)width-20,(float)height-20);
                    float start_angle =-90f;
                    float sweep_angle = (float)seconds/86400*360;

                    // заполнение фона
                    canvas.drawARGB(200,20, 0, 55);
                    // установка основного цвета
                    circle_paint.setARGB( 255,41, 225, 205);
                    // отрисовка дуги прошедшего суточного времени
                    canvas.drawArc(oval,start_angle,sweep_angle,false,time_arc_paint);
                    // отрисовка цифровых часов
                    canvas.drawText(date.getHour()+":"+date.getMinute()+":"+date.getSecond(),width/2-120,height/2+20,digital_time_paint);
                    // Отрисовка делений

                    for (int i = 1; i < 25; i++) {
                        double angle = Math.PI/12*(i-3);
                        int x = (int) (width/2+Math.cos(angle)*(radius-10));
                        int y = (int) (width/2+Math.sin(angle)*(radius-10));

                        canvas.drawCircle(x,y,5,circle_paint);
                    }
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}