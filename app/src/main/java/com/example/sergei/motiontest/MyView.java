package com.example.sergei.motiontest;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by sergei on 22.12.17.
 */

public class MyView extends View {
    private ArrayList<Character> objects = new ArrayList();
    public MyView(Context context) {
        super(context);
    }
    public MyView(Context context, AttributeSet attrs){
        super(context,attrs);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Character character : objects){
            character.draw(canvas);
            character.update();
        }
        invalidate();

    }
    void addCharacter(Character character){
        objects.add(character);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        for (Character character : objects){
            character.touch(event);
        }
        return super.onTouchEvent(event);

    }
}
