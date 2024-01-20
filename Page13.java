package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Page13 extends AppCompatActivity {

    private static final int SWIPE_THRESHOLD = 100;
    private float x1, x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page13);

        findViewById(android.R.id.content).setOnTouchListener(this::handleSwipeEvent);
    }

    private void goBackToPage12() {
        startActivity(new Intent(this, Page12.class));
        finish();
    }
    private void goToPage14() {
        startActivity(new Intent(this, Page14.class));
        finish();
    }

    public void goToPage12(View v) {
        goBackToPage12();
    }
    public void goToPage14(View v) {
        startActivity(new Intent(this, Page14.class));
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
                        Toast.makeText(this, "Back to Page 12", Toast.LENGTH_SHORT).show();
                        goBackToPage12();
                    } else {
                        Toast.makeText(this, "Page 14", Toast.LENGTH_SHORT).show();
                        goToPage14();
                    }
                }
                break;
        }
        return true;
    }
}
