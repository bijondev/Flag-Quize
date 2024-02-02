package dev.bijon.flagcuize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;

import java.util.ArrayList;

public class QuizeActivity extends AppCompatActivity {

    private TextView textViewQuestion, textViewCorrect, textViewEmpty, textViewWrong;
    private ImageView imageViewFlag, imageViewNext;
    private Button buttonA, buttonB, buttonC, buttonD;
    private FlagsDatabase fdatabase;
    private ArrayList<FlagsModel> questionsList;
    int correct = 0;
    int wrong = 0;
    int empty = 0;
    int questions = 0;
    private FlagsModel correctFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quize);

        loadQuestions();

        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewCorrect = findViewById(R.id.textViewCorrect);
        textViewEmpty = findViewById(R.id.textViewEmpty);
        textViewWrong = findViewById(R.id.textViewWrong);

        imageViewFlag = findViewById(R.id.imageViewFlag);
        imageViewNext = findViewById(R.id.imageViewNext);

        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);

        fdatabase = new FlagsDatabase(QuizeActivity.this);
        questionsList = new FlagsDAO().getRandomQuizeTenQuistions(fdatabase);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        imageViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void loadQuestions(){
        textViewQuestion.setText("Question : "+questionsList);
        correctFlag = questionsList.get(questions);
        textViewQuestion.setText("Question : "+questions);
        textViewQuestion.setText("Question : "+questions);
        textViewQuestion.setText("Question : "+questions);
    }
}