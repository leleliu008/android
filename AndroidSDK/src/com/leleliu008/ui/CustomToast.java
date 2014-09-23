package com.leleliu008.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 自定义Toast，可以自有控制要显示的时间
 * 
 * @author 792793182@qq.com
 * 
 */
public class CustomToast {
	/**
	 * 预定义两个持续时间，与系统的Toast保持一致
	 */
	public static final long LENGTH_SHORT = 2000;
	public static final long LENGTH_LONG = 3500;

	private long duration = LENGTH_SHORT;
	private WindowManager windowManager;
	private LinearLayout rootView;

	public CustomToast(Context context) {
		// 此处必须是ApplicationContext，因为Activity退出也可以显示
		context = context.getApplicationContext();

		windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		rootView = new LinearLayout(context);

		// 背景设置为圆角矩形
		float r = 10;
		float[] outerR = new float[] { r, r, r, r, r, r, r, r };
		RoundRectShape rr = new RoundRectShape(outerR, null, null);
		ShapeDrawable drawable = new ShapeDrawable(rr);
		drawable.getPaint().setColor(Color.RED);

		rootView.setBackgroundDrawable(drawable);
	}

	/**
	 * 
	 * @param context
	 *            上下文
	 * @param text
	 *            要显示的文本
	 * @param duration
	 *            显示时长，单位：毫秒
	 */
	public static CustomToast makeText(Context context, CharSequence text, long duration) {
		CustomToast toast = new CustomToast(context);

		toast.setDuration(duration);

		TextView textView = new TextView(context);
		textView.setPadding(20, 10, 20, 10);
		textView.setText(text);
		toast.setView(textView);

		return toast;
	}

	public static CustomToast makeText(Context context, int stringId, long duration)
			throws Resources.NotFoundException {
		return makeText(context, context.getResources().getText(stringId), duration);
	}

	/**
	 * 显示时长，单位：毫秒
	 */
	public void setDuration(long duration) {
		if (duration > 500) {
			this.duration = duration;
		}
	}

	/**
	 * 可以放入任何视图，不仅仅是文本
	 */
	public void setView(View view) {
		this.rootView.addView(view);
	}

	/**
	 * 
	 * @param gravity 
	 * 	@see Gravity.TOP
	 * 	@see Gravity.BOTTOM
	 * 	@see Gravity.LEFT
	 * 	@see Gravity.RIGHT
	 * 
	 * @param xOffset
	 * @param yOffset
	 */
	public void show(int gravity, int xOffset, int yOffset) {
		LayoutParams lp = getDefaultLayoutParams();
		lp.gravity = gravity;
		lp.x = xOffset;
		lp.y = yOffset;

		windowManager.addView(rootView, lp);

		handleDelayDismiss();
	}

	public void show() {
		show(Gravity.CENTER, 0, 0);
	}

	private WindowManager.LayoutParams getDefaultLayoutParams() {
		LayoutParams lp = new WindowManager.LayoutParams();
		lp.gravity = Gravity.CENTER;

		lp.dimAmount = 0f;
		lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
		lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
		lp.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND
				| WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
				| WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
				| WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
		lp.type = WindowManager.LayoutParams.TYPE_TOAST;
		// 此值必须设置为透明，否则圆角处会有黑色
		lp.format = PixelFormat.TRANSLUCENT;
		// 显示动画，此处必须是系统的样式资源
		lp.windowAnimations = android.R.style.Animation_Toast;
		return lp;
	}

	private void handleDelayDismiss() {
		new Handler().postDelayed(new Runnable() {

			public void run() {
				dismiss();
			}
		}, duration);
	}

	private void dismiss() {
		if (rootView != null) {
			if (rootView.getParent() != null) {
				windowManager.removeView(rootView);
			}
			rootView = null;
		}
	}
}
