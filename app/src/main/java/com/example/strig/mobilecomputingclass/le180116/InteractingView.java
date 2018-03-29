package com.example.strig.mobilecomputingclass.le180116;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.strig.mobilecomputingclass.R;

public class InteractingView extends View {
    private Bitmap b;
    private Paint p;
    private float x, y;

    public InteractingView(Context context) {
        super(context);
        b =  BitmapFactory.decodeResource(getResources(), R.drawable.finger);
    }

    public InteractingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        b =  BitmapFactory.decodeResource(getResources(), R.drawable.finger);
    }

    public InteractingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        b =  BitmapFactory.decodeResource(getResources(), R.drawable.finger);
    }


    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawCircle(this.x, this.y, 20, p);
        canvas.drawBitmap(b, this.x, this.y, null);
    }

    public void respondToTouch(float x, float y) {
        this.x = x;
        this.y = y;
        invalidate();
    }
}
