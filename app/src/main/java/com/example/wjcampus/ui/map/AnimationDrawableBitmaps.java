package com.example.wjcampus.ui.map;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.widget.ImageView;


import java.util.List;


public class AnimationDrawableBitmaps {
    private Bitmap[][] frames;
    private int currentIndex;


    private int currentFloor;
    private int duration;
    private Handler handler;
    private Runnable runnable;


    private ImageView imageView;


    public AnimationDrawableBitmaps(Bitmap[][] frames, int duration, int currentFloor) {
        this.currentFloor = currentFloor;
        this.duration = duration;


        this.frames = frames;


        handler = new Handler();
    }


    public void setImageView(ImageView newImageView) {
        this.imageView = newImageView;
    }


    public void setCurrentFloor(int currentFloor) {
        currentIndex = 0;
        this.currentFloor = currentFloor;
    }


    public void start() {
        currentIndex = 0;
        updateDrawable();
    }


    public void stop() {
        handler.removeCallbacks(runnable);
    }


    public void updateDrawable() {
        if (currentIndex < frames[currentFloor].length) {
            // Update your ImageView or any other view that displays the bitmap
            Canvas canvas = new Canvas();


            imageView.setImageBitmap(frames[currentFloor][currentIndex]);
            currentIndex++;
            if(currentIndex == frames[currentFloor].length) {
                currentIndex = 0;
            }
            handler.postDelayed(runnable, duration);
        }
    }


    public void setOnAnimationEndListener(Runnable onAnimationEndListener) {
        this.runnable = onAnimationEndListener;
    }
}