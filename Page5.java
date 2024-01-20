package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Page5 extends AppCompatActivity {

    private static final int SWIPE_THRESHOLD = 100;
    private float x1, x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);

        findViewById(android.R.id.content).setOnTouchListener(this::handleSwipeEvent);
    }

    private void goBackToPage4() {
        startActivity(new Intent(this, Page4.class));
        finish();
    }
    private void goToPage6() {
        startActivity(new Intent(this, Page6.class));
        finish();
    }

    public void goToPage4(View v) {
        goBackToPage4();
    }
    public void goToPage6(View v) {
        startActivity(new Intent(this, Page6.class));
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
                        Toast.makeText(this, "Back to Page 4", Toast.LENGTH_SHORT).show();
                        goBackToPage4();
                    } else {
                        Toast.makeText(this, "Page 6", Toast.LENGTH_SHORT).show();
                        goToPage6();
                    }
                }
                break;
        }
        return true;
    }
}
