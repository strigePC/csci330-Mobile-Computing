package com.example.strig.mobilecomputingclass.le180123_Sensors;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.SensorEvent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.strig.mobilecomputingclass.R;

public class AccView extends View {

    final private float alpha = 0.2f;
    private Paint p;
    private float x;
    private float y;

    private float max = 13;

    private float x_center = this.getResources().getDisplayMetrics().widthPixels / 2;
    private float y_center = this.getResources().getDisplayMetrics().heightPixels / 2;

    public AccView(Context context) {
        super(context);
        p = new Paint(R.color.colorPrimary);
    }

    public AccView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        p = new Paint(R.color.colorPrimary);
    }

    public AccView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        p = new Paint(R.color.colorPrimary);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(this.x, this.y, 20, p);
    }

    public void setDisplacement(SensorEvent sensorEvent) {
        float new_x = (x_center + x_center * sensorEvent.values[0] / max);
        float new_y = (y_center + y_center * sensorEvent.values[1] / max);

        this.x = alpha * new_x + (1 - alpha) * this.x;
        this.y = alpha * new_y + (1 - alpha) * this.y;

        invalidate();
    }
}
