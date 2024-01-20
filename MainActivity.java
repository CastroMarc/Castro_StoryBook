package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToPage2(View v) {
        // Create a new Intent to go to the target activity (Page2)
        Intent i = new Intent(this, Page2.class);
        // Start the activity from by the Intent
        startActivity(i);
        // Finish the current activity to ensure it is removed from the back stack
        finish();
    }

    @Override
    public void onBackPressed() {
        //Confirmation dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if the user clicked Yes the app will exit
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if the user clicked No it won't exit
                        dialog.dismiss();
                    }
                });
        // Show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
