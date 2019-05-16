package com.taupier.deya.toomuchtuna;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static void launch(Class<MainActivity> mainActivityClass) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        TextView plateView = (TextView) findViewById(R.id.plated);
        EditText scoopIn = (EditText) findViewById(R.id.scoop_in);
        String scoopQty = scoopIn.getText().toString();
        Spinner scoopTypes = (Spinner) findViewById(R.id.scoop_type);
        String scoopType = String.valueOf(scoopTypes.getSelectedItem());
        EditText eatIn = (EditText) findViewById(R.id.eat_in);
        String eatQty = eatIn.getText().toString();

        if (scoopQty != "" && eatQty != "" && !scoopType.equals("Nothing")) {
            Plate plate = new Plate(scoopQty, eatQty, scoopType);
            displayPlate(plateView, plate);
        } else {
            Toast.makeText(this,
                    "Can't do something with nothing.\nWhere's the tuna?",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void displayPlate(TextView textview, Plate plate) {
        textview.setText(plate.getPlate());
    }

}
