package megaslot.game.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Alier on 17.11.2018.
 */
/*
* Этот класс отвечает за рисование
*
* */
public class Draw extends View {
    Paint mPaint = new Paint();
    Path mPath = new Path();

    public Draw(Context context) {
        super(context);
    }

    public Draw(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Draw(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Draw(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void init() {
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(12);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);
    }
    private float mPrevX;
    private float mPrevY;

    /*
    * Эта функция для обработки касания экрана
    */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(x, y);
                mPrevX = x;
                mPrevY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.quadTo(mPrevX, mPrevY, (x + mPrevX) / 2, (y + mPrevY) / 2);
                mPrevX = x;
                mPrevY = y;
                break;
            case MotionEvent.ACTION_UP:
                mPath.lineTo(x, y);
                break;
        }
        invalidate();
        return true;
    }

    public void clear() {
        mPath.reset();
        invalidate();
    }
}
