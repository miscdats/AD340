package com.example.deya.addingactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

    private static final String TAG = "DISPLAY_ACTIVITY : ";

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        Log.i(TAG, " started.");

        // intent passed in
        Intent intent = getIntent();
        // grabs string passed in from main activity
        String countString = intent.getStringExtra(MainActivity.TOTAL_COUNT);

        setContentView(R.layout.activity_display_message);
        TextView numView = (TextView) findViewById(R.id.answer_message);
        // adds 1 to number
        int count = plusOne(countString);
        String message = count + "";
        // display number
        numView.setText(message);
        Log.i(TAG, " finished.");
    }


    private int plusOne(String userNumber) {
        Log.i(TAG, " adding.");
        // gets user string into int and adds up one
        return Integer.parseInt(userNumber) + 1;
    }

}
