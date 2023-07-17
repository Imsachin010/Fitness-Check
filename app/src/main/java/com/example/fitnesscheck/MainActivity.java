package com.example.fitnesscheck;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edSleep_Hours;
    Button btn, btn2, btn3, btn1, btnokHr;
    TextView tv,txtSleepHr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = findViewById(R.id.spo2);
        btn1 = findViewById(R.id.heartrate);
        btn2 = findViewById(R.id.temperature);
        btn3 = findViewById(R.id.movement);
        edSleep_Hours = findViewById(R.id.edSleep_Hours);
        txtSleepHr = findViewById(R.id.txtSleepHr);
        btnokHr = findViewById(R.id.okHr);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"Showing the results", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, spO2.class));
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"Showing the results", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Heartrate.class));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"Showing the results", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, temperature.class));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"Showing the results", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, movement.class));
            }
        });

         btnokHr.setOnClickListener(v -> {
             String SleepHr = edSleep_Hours.getText().toString();
             txtSleepHr.setText(SleepHr+" hours");
         });

    }
}