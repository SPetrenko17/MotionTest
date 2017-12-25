package com.example.sergei.motiontest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MyView myView;
    Bitmap pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final float Y=350;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = (MyView)findViewById(R.id.myView);
        pic= BitmapFactory.decodeResource(getResources(),R.drawable.spritestrip);
    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Character player = new Character(myView.getWidth()/2,myView.getHeight()/2,pic,6);
        myView.addCharacter(player);
    }
}
