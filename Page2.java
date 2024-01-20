package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Page2 extends AppCompatActivity {

    // Constant to define the swipe threshold for recognizing a swipe gesture
    private static final int SWIPE_THRESHOLD = 100;

    // Variables to store the x-coordinates of the touch events
    private float x1, x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        // Set a touch listener for the entire panel to handle swipe gestures
        findViewById(android.R.id.content).setOnTouchListener(this::handleSwipeEvent);
    }

    private void goBackToPage1() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    private void goToPage3() {
        startActivity(new Intent(this, Page3.class));
        finish();
    }
    public void goToPage1(View v) {
        goBackToPage1();
    }

    public void goToPage3(View v) {
        startActivity(new Intent(this, Page3.class));
        finish();
    }

    // Method to handle swipe events on the screen
    private boolean handleSwipeEvent(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // The x-coordinate of the starting point of the swipe
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                // The x-coordinate of the ending point of the swipe
                x2 = event.getX();

                // Calculate the horizontal distance of the swipe (deltaX)
                float deltaX = x2 - x1;

                // Checks if the swipe distance is greater than the defined threshold
                if (Math.abs(deltaX) > SWIPE_THRESHOLD) {
                    // Checks the direction of the swipe
                    if (deltaX > 0) {
                        // Display a toast message for swiping to the right
                        Toast.makeText(this, "Back to Home Page", Toast.LENGTH_SHORT).show();
                        goBackToPage1();
                    } else {
                        // Display a toast message for swiping to the left
                        Toast.makeText(this, "Page 3", Toast.LENGTH_SHORT).show();
                        goToPage3();
                    }
                }
                break;
        }
        // Return true to consume the touch event
        return true;
    }
}
