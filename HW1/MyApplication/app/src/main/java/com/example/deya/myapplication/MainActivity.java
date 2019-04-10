package com.example.deya.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
}
