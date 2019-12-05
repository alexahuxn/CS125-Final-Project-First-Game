package com.example.firstgame;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {

    private SurfaceHolder surfaceholder;

    private GameView gameView;

    private boolean running;

    private static Canvas canvas;

    private int targetFPS = 60;

    private double averageFPS;

    MainThread(SurfaceHolder setSurfaceHolder, GameView setGameView) {
        super();
        this.surfaceholder = setSurfaceHolder;
        this.gameView = setGameView;
    }

    public void setRunning(boolean ifRunning) {
        this.running = ifRunning;
    }

    @Override
    public void run() {
        while(running) {
            canvas = null;

            try {
                canvas = this.surfaceholder.lockCanvas();
                synchronized (surfaceholder) {
                    this.gameView.update();
                    this.gameView.draw(canvas);
                }
            } catch (Exception e) {
            } finally {
                if (canvas != null) {
                    try {
                        surfaceholder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
