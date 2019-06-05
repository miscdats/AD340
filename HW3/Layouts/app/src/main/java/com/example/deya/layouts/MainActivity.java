package com.example.deya.layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showInfo(View view) {
        Intent intent = new Intent(this, DisplayInfoActivity.class);
        startActivity(intent);
    }

    public void toasted(View view) {
        Toast.makeText(this, getString(R.string.toasting), Toast.LENGTH_LONG).show();
    }
}
