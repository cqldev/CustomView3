package com.cql.customview3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class SkyView extends View {
    
    private Paint circlePaint;
    
    private Paint arcPaint;
    
    private Paint textPaint;
    
    private float sweepValue;
    
    private RectF mRectf;
    
    private int width;
    
    private int height;
    
    String showStr = "Android View";

    public SkyView(Context context) {
        this(context,null);
    }

    public SkyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SkyView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SkyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Log.d("cql","SkyView Construction...");
        circlePaint = new Paint();
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setColor(Color.GRAY);
        circlePaint.setAntiAlias(true);
        
        arcPaint = new Paint();
        arcPaint.setStyle(Paint.Style.STROKE);
        arcPaint.setStrokeWidth(60);
        arcPaint.setColor(Color.GRAY);
        arcPaint.setAntiAlias(true);
        
        textPaint = new Paint();
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(40);
        textPaint.setAntiAlias(true);
    }
    
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d("cql","onFinishInflate...");
    }
    
    @SuppressLint("DrawAllocation")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("cql","onMeasure...");
    }
    
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d("cql","onSizeChanged...");
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        mRectf = new RectF(
                (float)(width * 0.1),
                (float)(width * 0.1),
                (float)(width * 0.9),
                (float)(width * 0.9));
    }
    
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d("cql","onLayout...");
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        
        canvas.drawCircle(width/2, width/2, (float) (width * 0.5 / 2), circlePaint);
        
        /**
         * 第一个参数是此圆弧的外接矩形
         * 第二个参数是开始绘制的角度，绘制是顺时针的
         * 第三个参数是圆弧扫过的角度
         * 第四个参数是此圆弧是否经过圆心（即是扇形还是圆弧）
         */
        canvas.drawArc(mRectf, 270, sweepValue, false, arcPaint);
        canvas.drawText(showStr, 0, showStr.length(), width/2-textPaint.measureText(showStr)/2,
                width/2, textPaint);
        Log.d("cql","onDraw...");
        super.onDraw(canvas);
    }

    public void setSweepValue(float sweepValue){
        if(sweepValue != 0){
            this.sweepValue = sweepValue;
        }else{
            sweepValue = 25;
        }
//        this.invalidate();
    }
    
}
