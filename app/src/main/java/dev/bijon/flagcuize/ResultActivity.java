package dev.bijon.flagcuize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewTotalCorrect, textViewTotalWrong, textViewTotalRate, textViewTotalEmpty;
    private Button buttonPlayAgain, buttonQuiteGame;
    int correct, wrong, empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewTotalCorrect = findViewById(R.id.textViewTotalCorrect);
        textViewTotalWrong = findViewById(R.id.textViewTotalWrong);
        textViewTotalRate = findViewById(R.id.textViewTotalRate);
        textViewTotalEmpty = findViewById(R.id.textViewTotalEmpty);

        buttonPlayAgain = findViewById(R.id.buttonPlayAgain);
        buttonQuiteGame = findViewById(R.id.buttonQuiteGame);

        correct = getIntent().getIntExtra("correct", 0);
        wrong = getIntent().getIntExtra("wrong", 0);
        empty = getIntent().getIntExtra("empty", 0);

        textViewTotalCorrect.setText("Total Correct Answer : " + correct);
        textViewTotalWrong.setText("Total Wrong Answer : " + wrong);
        textViewTotalEmpty.setText("Total Empty Answer : " + empty);
        textViewTotalRate.setText("Total Correct Answer : " + (correct * 10));

        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, QuizeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonQuiteGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentExit = new Intent(Intent.ACTION_MAIN);
                intentExit.addCategory(Intent.CATEGORY_HOME);
                intentExit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentExit);
                finish();
            }
        });
    }
}