package com.example.insense.ui.fragments.Main.Clocks;

//Отвечает за прорисовку циферблата и интеракцию с ним

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.example.insense.application.App;
import com.example.insense.services.time.GlobalTimer;
import com.example.insense.ui.fragments.Main.Clocks.Parts.Clocks24H;
import com.example.insense.ui.fragments.Main.Clocks.Parts.Segment;
import com.example.insense.ui.fragments.Main.Clocks.Parts.Timer;

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
        if(App.getInstance().getGlobalTimer().getIsTimer()){
            if (App.getInstance().getGlobalTimer().getIsTimerRunning()){
                App.getInstance().getGlobalTimer().stopTimer();
                Log.i("TIMER", "STOPPED");
            }else{
                App.getInstance().getGlobalTimer().startTimer();
                Log.i("TIMER", "Started");
            }
        }

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

        Clocks24H clock24 = new Clocks24H();
        while (running) {
            Canvas canvas = surfaceHolder.lockCanvas();
            Timer timer = new Timer();
            if (canvas != null) {
                try {
                    if(App.getInstance().getGlobalTimer().getIsTimer()){
                        timer.print(canvas);
                    }else{
                    clock24.print(canvas);}
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}