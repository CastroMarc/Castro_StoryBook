package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Page4 extends AppCompatActivity {

    private static final int SWIPE_THRESHOLD = 100;
    private float x1, x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);

        findViewById(android.R.id.content).setOnTouchListener(this::handleSwipeEvent);
    }

    private void goBackToPage3() {
        startActivity(new Intent(this, Page3.class));
        finish();
    }
    private void goToPage5() {
        startActivity(new Intent(this, Page5.class));
        finish();
    }

    public void goToPage3(View v) {
        goBackToPage3();
    }
    public void goToPage5(View v) {
        startActivity(new Intent(this, Page5.class));
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
                        Toast.makeText(this, "Back to Page 3", Toast.LENGTH_SHORT).show();
                        goBackToPage3();
                    } else {
                        Toast.makeText(this, "Page 5", Toast.LENGTH_SHORT).show();
                        goToPage5();
                    }
                }
                break;
        }
        return true;
    }
}
