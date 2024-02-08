package dev.bijon.flagcuize;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashSet;

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
    private ArrayList<FlagsModel> wrongOptionList;
    HashSet<FlagsModel> mixOptions = new HashSet<>();
    ArrayList<FlagsModel> options = new ArrayList<>();

    boolean buttonControl = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quize);

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

        loadQuestions();

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerControll(buttonA);
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerControll(buttonB);
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerControll(buttonC);
            }
        });

        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answerControll(buttonD);
            }
        });

        imageViewNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questions++;

                if (!buttonControl && questions < 10) {
                    empty++;
                    textViewEmpty.setText("Empty : " + empty);
                    loadQuestions();
                }
                else if (buttonControl && questions < 10) {
                    buttonA.setClickable(true);
                    buttonB.setClickable(true);
                    buttonC.setClickable(true);
                    buttonD.setClickable(true);

                    int color = ContextCompat.getColor(view.getContext(), R.color.colorPrimaryDark);


                    buttonA.setBackgroundColor(color);
                    buttonB.setBackgroundColor(color);
                    buttonC.setBackgroundColor(color);
                    buttonD.setBackgroundColor(color);
                    loadQuestions();
                }
                if (!buttonControl && questions == 10) {
                    empty++;
                    Intent intent = new Intent(QuizeActivity.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    intent.putExtra("empty", empty);
                    startActivity(intent);
                    finish();
                }
                else if( buttonControl && questions == 10){
                    Intent intent = new Intent(QuizeActivity.this, ResultActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    intent.putExtra("empty", empty);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    public void loadQuestions() {
        int question = questions + 1;
        textViewQuestion.setText("Question : " + question);
        correctFlag = questionsList.get(questions);

        Log.d("Flagname", correctFlag.getFlag_image());

        int resourceId = getResources().getIdentifier(correctFlag.getFlag_image(), "drawable", getPackageName());
        Log.d("Debug", "Resource ID: " + resourceId);
        imageViewFlag.setImageResource(resourceId);

        wrongOptionList = new FlagsDAO().getRandomQuizeThreeOptions(fdatabase, correctFlag.getFlag_id());

        mixOptions.clear();
        mixOptions.add(correctFlag);
        mixOptions.add(wrongOptionList.get(0));
        mixOptions.add(wrongOptionList.get(1));
        mixOptions.add(wrongOptionList.get(2));

        options.clear();
        for (FlagsModel flg : mixOptions) {
            options.add(flg);
        }

        buttonA.setText(options.get(0).getFlag_name());
        buttonB.setText(options.get(1).getFlag_name());
        buttonC.setText(options.get(2).getFlag_name());
        buttonD.setText(options.get(3).getFlag_name());
        buttonControl = false;
    }

    public void answerControll(Button button) {
        String buttonText = button.getText().toString();
        String correctAnswer = correctFlag.getFlag_name();

        if (buttonText.equals(correctAnswer)) {
            correct++;
            button.setBackgroundColor(Color.GREEN);
        } else {
            wrong++;
            button.setBackgroundColor(Color.RED);

            if (buttonA.getText().toString().equals(correctAnswer)) {
                buttonA.setBackgroundColor(Color.GREEN);
            }
            if (buttonB.getText().toString().equals(correctAnswer)) {
                buttonB.setBackgroundColor(Color.GREEN);
            }
            if (buttonC.getText().toString().equals(correctAnswer)) {
                buttonC.setBackgroundColor(Color.GREEN);
            }
            if (buttonD.getText().toString().equals(correctAnswer)) {
                buttonD.setBackgroundColor(Color.GREEN);
            }
        }
        buttonA.setClickable(false);
        buttonB.setClickable(false);
        buttonC.setClickable(false);
        buttonD.setClickable(false);

        textViewCorrect.setText("Correct : " + correct);
        textViewWrong.setText("Wrong : " + wrong);

        buttonControl = true;
    }
}