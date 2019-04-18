package com.example.deya.addingactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String TOTAL_COUNT = "total_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        TextView showCountTextView = (TextView) findViewById(R.id.numberIn);
        String countString = showCountTextView.getText().toString();
        int count = Integer.parseInt(countString);
        intent.putExtra(TOTAL_COUNT, countString);
        startActivity(intent);
    }

}