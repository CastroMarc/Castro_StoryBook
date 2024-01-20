package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Page12 extends AppCompatActivity {

    private static final int SWIPE_THRESHOLD = 100;
    private float x1, x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page12);

        findViewById(android.R.id.content).setOnTouchListener(this::handleSwipeEvent);
    }

    private void goBackToPage11() {
        startActivity(new Intent(this, Page11.class));
        finish();
    }
    private void goToPage13() {
        startActivity(new Intent(this, Page13.class));
        finish();
    }

    public void goToPage11(View v) {
        goBackToPage11();
    }
    public void goToPage13(View v) {
        startActivity(new Intent(this, Page13.class));
        finish();
    }

    private boolean handleSwipeEvent(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float deltaX = x2 - x1;

                if (Math.abs(deltaX) > SWIPE_THRESHOLD) {
                    if (deltaX > 0) {
                        Toast.makeText(this, "Back to Page 11", Toast.LENGTH_SHORT).show();
                        goBackToPage11();
                    } else {
                        Toast.makeText(this, "Page 13", Toast.LENGTH_SHORT).show();
                        goToPage13();
                    }
                }
                break;
        }
        return true;
    }
}
