package dev.bijon.flagcuize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewTotalCorrect, textViewTotalWrong, textViewTotalRate;
    private Button buttonPlayAgain, buttonQuiteGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewTotalCorrect = findViewById(R.id.textViewTotalCorrect);
        textViewTotalWrong = findViewById(R.id.textViewTotalWrong);
        textViewTotalRate = findViewById(R.id.textViewTotalRate);

        buttonPlayAgain = findViewById(R.id.buttonPlayAgain);
        buttonQuiteGame = findViewById(R.id.buttonQuiteGame);

        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        buttonQuiteGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}