package com.leleliu008.androidsdk.shape;

import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;

/**
 * 
 * @author 792793182@qq.com 2014 Oct 4, 2014
 *
 */
public class ShapeTest {
	
	public static ShapeDrawable getRectShape() {
		RectShape rectShape = new RectShape();
		ShapeDrawable shapeDrawable = new ShapeDrawable(rectShape);
		shapeDrawable.getPaint().setColor(Color.RED);
		return shapeDrawable;
	}
	
	public static ShapeDrawable getRoundRectShape() {
		float[] r = {10, 10 ,10 ,10 ,10, 10 ,10, 10};
		RoundRectShape rectShape = new RoundRectShape(r, null, null);
		ShapeDrawable shapeDrawable = new ShapeDrawable(rectShape);
		shapeDrawable.getPaint().setColor(Color.RED);
		return shapeDrawable;
	}
	
	public static ShapeDrawable getOvalShape() {
		OvalShape ovalShape = new OvalShape();
		ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
		shapeDrawable.getPaint().setColor(Color.RED);
		return shapeDrawable;
	}
	
	public static ShapeDrawable getArcShape() {
		ArcShape arcShape = new ArcShape(0, 90);
		ShapeDrawable shapeDrawable = new ShapeDrawable(arcShape);
		shapeDrawable.getPaint().setColor(Color.RED);
		return shapeDrawable;
	}
	
}
