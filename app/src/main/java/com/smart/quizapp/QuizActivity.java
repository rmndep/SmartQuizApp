package com.smart.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    TextView questionText, timerText;
    RadioGroup options;
    RadioButton op1, op2, op3, op4;
    Button nextBtn;
    ProgressBar progressBar;

    ArrayList<Question> questions;
    ArrayList<Integer> userAnswers = new ArrayList<>();
    int index = 0;
    int score = 0;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionText = findViewById(R.id.questionText);
        timerText = findViewById(R.id.timerText);
        options = findViewById(R.id.optionsGroup);
        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);
        op3 = findViewById(R.id.op3);
        op4 = findViewById(R.id.op4);
        nextBtn = findViewById(R.id.nextBtn);
        progressBar = findViewById(R.id.progressBar);

        String topic = getIntent().getStringExtra("topic");
        questions = QuizData.getQuestions(topic);
        progressBar.setMax(questions.size());

        loadQuestion();

        nextBtn.setOnClickListener(v -> {
            checkAnswer();
            index++;
            if (index < questions.size()) {
                loadQuestion();
            } else {
                Intent intent = new Intent(this, ResultActivity.class);
                String name = getIntent().getStringExtra("name");
                intent.putExtra("name", name);
                intent.putExtra("score", score);
                intent.putExtra("total", questions.size());
                intent.putExtra("userAnswers", userAnswers);
                startActivity(intent);
                finish();
            }
        });
    }

    void loadQuestion() {
        options.clearCheck();
        Question q = questions.get(index);
        questionText.setText(q.question);
        op1.setText(q.option1);
        op2.setText(q.option2);
        op3.setText(q.option3);
        op4.setText(q.option4);
        progressBar.setProgress(index + 1);
        startTimer();
    }

    void checkAnswer() {
        int selected = options.indexOfChild(findViewById(options.getCheckedRadioButtonId())) + 1;
        userAnswers.add(selected);
        if (selected == questions.get(index).correctAnswer) {
            score++;
        }
    }

    void startTimer() {
        if (timer != null) timer.cancel();
        timer = new CountDownTimer(10000, 1000) {
            public void onTick(long millis) {
                timerText.setText("Time: " + millis / 1000);
            }
            public void onFinish() {
                nextBtn.performClick();
            }
        }.start();
    }
}