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

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText edSleep_Hours;
    Button btn, btn2, btn3, btn1, btnokHr;
    TextView tv,txtSleepHr;
    private JsonUtils JsonUtils;

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

        // Read JSON data from the file
        JSONObject healthData = JsonUtils.loadJsonObjectFromAsset(this, "health_data.json");

        // Example: Display the first value of each parameter in TextViews
        TextView textViewBodyTemp = findViewById(R.id.textViewBodyTemp);
        TextView textViewLimbMovement = findViewById(R.id.textViewLimbMovement);
        TextView textViewSpo2 = findViewById(R.id.textViewSpo2);
//        TextView textViewSleepingHours = findViewById(R.id.textViewSleepingHours);
        TextView textViewHeartRate = findViewById(R.id.textViewHeartRate);
//        TextView textViewStressLevel = findViewById(R.id.textViewStressLevel);
//        TextView textViewFitness = findViewById(R.id.textViewFitness);

        try {
            JSONArray bodyTempArray = healthData.getJSONArray("body_temperature");
            JSONArray limbMovementArray = healthData.getJSONArray("limb_movement");
            JSONArray spo2Array = healthData.getJSONArray("Blood_oxygen");
            JSONArray sleepingHoursArray = healthData.getJSONArray("Sleeping_hours");
            JSONArray heartRateArray = healthData.getJSONArray("Heart_rate");
            JSONArray stressLevelArray = healthData.getJSONArray("Stress_level");
            JSONArray fitnessArray = healthData.getJSONArray("fitness");

            // Display the first values in TextViews
            if (bodyTempArray.length() > 0) {
                double bodyTemp = bodyTempArray.getDouble(0);
                textViewBodyTemp.setText("Body Temperature: " + bodyTemp + " °C");
            }
            if (limbMovementArray.length() > 0) {
                double limbMovement = limbMovementArray.getDouble(0);
                textViewLimbMovement.setText("Limb Movement: " + limbMovement);
            }
            if (spo2Array.length() > 0) {
                double spo2 = spo2Array.getDouble(0);
                textViewSpo2.setText("Spo2 Level: " + spo2 + " %");
            }
//            if (sleepingHoursArray.length() > 0) {
//                double sleepingHours = sleepingHoursArray.getDouble(0);
//                textViewSleepingHours.setText("Sleeping Hours: " + sleepingHours + " hrs");
//            }
            if (heartRateArray.length() > 0) {
                double heartRate = heartRateArray.getDouble(0);
                textViewHeartRate.setText("Heart Rate: " + heartRate + " bpm");
            }
//            if (stressLevelArray.length() > 0) {
//                int stressLevel = stressLevelArray.getInt(0);
//                textViewStressLevel.setText("Stress Level: " + stressLevel);
//            }
//            if (fitnessArray.length() > 0) {
//                double fitness = fitnessArray.getDouble(0);
//                textViewFitness.setText("Fitness Level: " + fitness);
//            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}