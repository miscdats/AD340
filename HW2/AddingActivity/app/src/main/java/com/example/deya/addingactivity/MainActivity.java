package com.example.deya.addingactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final String TOTAL_COUNT = "total_count";
    private static final String TAG = "MAIN_ACTIVITY : ";
    private static final int RESULT_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            Log.d(TAG, "onCreate() Restoring previous state");
            /* restore state */
            Log.i(TAG, this.getLifecycle().getCurrentState().toString());
        } else {
            Log.d(TAG, "onCreate() No saved state available");
            /* initialize app */
        }
        setContentView(R.layout.activity_main);
    }

    /**
     * Switches text on screen.
     */
    public void switchIt (View view) {
        // get the text view.
        TextView texts = (TextView) findViewById(R.id.name);
        texts.setText(getString(R.string.interests));
    }

    /** Called when the user clicks the Send button */
    public void onClick(View button) {
        Log.i(TAG, "Button " + button.getId() + " clicked.");

        // grabs text from box
        EditText textIn = (EditText) findViewById(R.id.numberIn);
        String countString = textIn.getText().toString();
        // passes along
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(TOTAL_COUNT, countString);
        // start second activity
        startActivity(intent);
    }



}