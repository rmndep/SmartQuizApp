package com.smart.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nameInput = findViewById(R.id.nameInput);
        Spinner topicSpinner = findViewById(R.id.topicSpinner);
        Button startQuizBtn = findViewById(R.id.startQuizBtn);

        List<String> topics = new ArrayList<>();
        topics.add("Android");
        topics.add("Java");
        topics.add("Kotlin");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, topics);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        topicSpinner.setAdapter(adapter);

        startQuizBtn.setOnClickListener(v -> {
            String name = nameInput.getText().toString();
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
                return;
            }

            String topic = topicSpinner.getSelectedItem().toString();

            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("topic", topic);
            startActivity(intent);
        });
    }
}