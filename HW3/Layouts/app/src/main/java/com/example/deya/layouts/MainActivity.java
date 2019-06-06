package com.example.deya.layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MAIN_ACTIVITY : ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, " has started.");
        setContentView(R.layout.activity_main);

        // button click listener
        Button moviesBtn = findViewById(R.id.button);
        moviesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // button has listener to send intents show movie list
                Log.i(TAG, " has intentions.");
                Intent intent = new Intent(getApplicationContext(), DisplayInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    public void toasted(View view) {
        Log.i(TAG, view + " has toasted.");

        switch (view.getId()) {
            case R.id.button1:
                Toast.makeText(this, getString(R.string.toasting),
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.button2:
                Toast.makeText(this, getString(R.string.toasting2),
                        Toast.LENGTH_SHORT).show();
                break;

            case R.id.button3:
                Toast.makeText(this, getString(R.string.toasting1),
                        Toast.LENGTH_LONG).show();
                break;
        }

    }

}
