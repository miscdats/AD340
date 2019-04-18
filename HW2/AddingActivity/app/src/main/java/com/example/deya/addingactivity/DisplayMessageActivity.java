package com.example.deya.addingactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    private static final String TOTAL_COUNT = "total_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        showNumber();
    }

    public void showNumber() {
        TextView numView = (TextView) findViewById(R.id.answer_message);
        TextView headingView = (TextView) findViewById(R.id.takeThis);
        int count = getIntent().getIntExtra(TOTAL_COUNT, 0);
        count++;
        numView.setText(Integer.toString(count));
    }

}
