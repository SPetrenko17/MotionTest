package com.example.sergei.motiontest;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.provider.Settings;
import android.view.MotionEvent;

/**
 * Created by sergei on 22.12.17.
 */

public class Character {
    private float x,y;
    private int w,h,nFrames;
    private Rect frame ;

    Bitmap sprites;
    long prevTime;
    private long delay=100;
    Character(float x, float y, Bitmap sprites,int nFrames){
        this.x=x;
        this.y=y;
        this.sprites = sprites;
        this.w=sprites.getWidth()/nFrames;
        this.h=sprites.getHeight();
        this.frame = new Rect(0,0,w,h);
        prevTime= System.currentTimeMillis();
    }
    Paint p = new Paint();

     void draw(Canvas canvas){

         Rect frameTo = new Rect((int)(this.x-w/2),(int)(this.y-h/2),(int)(this.x+w/2),(int)(this.y+h/2));
                 canvas.drawBitmap(sprites,frame,frameTo,p);
    }
    void touch(MotionEvent event){
        this.x=event.getX();
        this.y=event.getY();
    }
    void update(){
        long nowTime= System.currentTimeMillis();
        if(nowTime-prevTime>=delay) {
            frame.left += w;
            frame.right += w;
            if (frame.right >= sprites.getWidth()) {
                frame.left = 0;
                frame.right = w;
            }
            prevTime=nowTime;// или новое время
            //по желанию можно менять и по высоте
        }//добавить скорости по х
    }
}
