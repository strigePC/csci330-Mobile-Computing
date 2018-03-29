package com.example.strig.mobilecomputingclass.le180329;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;


public class NUWallpaperService extends WallpaperService {
    @Override
    public WallpaperService.Engine onCreateEngine() {
        return new NUWallpaperEngine();
    }

    private class NUWallpaperEngine extends Engine {
        private final Handler handler = new Handler();
        private final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                draw();
            }

        };

        private Paint paint = new Paint();
        private int width;
        int height;
        private boolean visible = true;

        private float u = 0.0f;
        private float v = 0.0f;
        private double t = 0.0;
        private double f = Math.PI * .08;


        public NUWallpaperEngine() {
            paint.setAntiAlias(true);
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeWidth(10f);
            handler.post(runnable);
        }

        @Override
        public void onVisibilityChanged(boolean visible) {
            this.visible = visible;
            if (visible) {
                handler.post(runnable);
            } else {
                handler.removeCallbacks(runnable);
            }
        }

        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);
            this.visible = false;
            handler.removeCallbacks(runnable);
        }

        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format,
                                     int width, int height) {
            this.width = width;
            this.height = height;
            super.onSurfaceChanged(holder, format, width, height);
        }

        private void draw() {
            SurfaceHolder holder = getSurfaceHolder();
            Canvas canvas = null;
            try {
                canvas = holder.lockCanvas();
                if (canvas != null) {
                    canvas.drawColor(Color.GREEN);

                    float x = (float)(150.0 * Math.cos(f * t) + width * .5);
                    float y = (float)(150.0 * Math.sin(f * t) + height * .5);

                    t = t + 1.0;

                    canvas.drawCircle(x, y, 50.0f, paint);
                }
            } finally {
                if (canvas != null)
                    holder.unlockCanvasAndPost(canvas);
            }
            handler.removeCallbacks(runnable);
            if (visible) {
                handler.postDelayed(runnable, 100);
            }
        }

    }
}

