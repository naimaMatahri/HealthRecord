package com.example.personalhealthrecord;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class HealthSummary extends AppCompatActivity {
    Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_summary);

        toolBar = (Toolbar) findViewById(R.id.healthSummary);
        toolBar.setTitle("Health Summary");


    }
}
