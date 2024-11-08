package com.example.fitness_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Main extends AppCompatActivity {



    Spinner exerciseSpinner;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        exerciseSpinner = findViewById(R.id.Spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.exercise_options, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        exerciseSpinner.setAdapter(adapter);

        exerciseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                openTimerActivity(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTimerActivity(-1);
            }
        });
    }

    private void openTimerActivity(int exerciseIndex) {
        Intent intent = new Intent(Main.this, Timer.class);

        intent.putExtra("EXERCISE_INDEX", exerciseIndex);
        startActivity(intent);
    }
}