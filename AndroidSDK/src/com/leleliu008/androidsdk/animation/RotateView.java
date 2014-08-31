package com.leleliu008.androidsdk.animation;


import com.leleliu008.androidsdk.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 自定义旋转控件
 * @author leleliu008
 * @date 2013.04.26
 */
public class RotateView extends View {

	private static final String TAG = "RotateView";
	
	private static final long DEFAULT_SWEEP_TIME = 50;
	
	private static final int DEFAULT_SWEEP_DEGREE = 30;
    
    /**
     * 每隔多长时间一次矩阵变换
     */
    private long sweepTime;
    
    /**
     * 每次举证变换旋转多少度
     */
    private int sweepDegree;
    
	/**
	 * 旋转图片资源
	 */
	private Bitmap bitmap;
	
	/**
	 * 变换矩阵
	 */
	private Matrix matrix;
	
	/**
	 * 本控件的宽度
	 */
	private int width;
	
	/**
	 * 本控件的高度
	 */
    private int height;
    
    /**
     * 旋转动画停止的标志
     */
    private boolean stoped;
    
    
	public RotateView(Context context) {
		this(context, null);
	}

	public RotateView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.main_button_mic_waiting);
		bitmap = bitmapDrawable.getBitmap();
		matrix = new Matrix();
		
		setSweepTime(50);
		setSweepDegree(30);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
            height = heightSize;
            bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        } else {
        	width = bitmap.getWidth();
        	height = bitmap.getHeight();
        }
		setMeasuredDimension(width, height);		
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Log.d(TAG, "onDraw()");
		
		canvas.drawBitmap(bitmap, matrix, null);
	}
	
	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		if (bitmap != null) {
			bitmap.recycle();
		}
	}
	
	public final void setSweepTime(long sweepTime) {
		if (sweepTime <= 0) {
			this.sweepTime = DEFAULT_SWEEP_TIME;
		} else {
			this.sweepTime = sweepTime;
		}
	}
	
	public final void setSweepDegree(int sweepDegree) {
		if (sweepDegree <= 0) {
			this.sweepDegree = DEFAULT_SWEEP_DEGREE;
		} else {
			this.sweepDegree = sweepDegree;
		}
	}
	
	public final void start() {
		if (!stoped) {
			stop();
		}
		new Thread(runnable).start();
	}
	
	
	public final void stop() {
		stoped = true;
	}
	
	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			matrix.preRotate(sweepDegree, width / 2, height / 2);
			invalidate();
		}
	};

	private Runnable runnable = new Runnable() {
		
		@Override
		public void run() {
			while (!stoped) {
				try {
					Thread.sleep(sweepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Message.obtain(handler).sendToTarget();
			}
		}
	};
}
