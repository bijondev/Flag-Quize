package dev.bijon.flagcuize;

import androidx.appcompat.app.AppCompatActivity;

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
                questions++;
                loadQuestions();
            }
        });
    }

    public void loadQuestions() {
        int question = questions + 1;
        textViewQuestion.setText("Question : " + question);
        correctFlag = questionsList.get(questions);

        Log.d("Flagname", correctFlag.getFlag_image());

//        imageViewFlag.setImageResource(
//                getResources().getIdentifier(correctFlag.getFlag_name(), "drawable", getPackageName())
//        );
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


//        textViewQuestion.setText("Question : "+questions);
//        textViewQuestion.setText("Question : "+questions);
//        textViewQuestion.setText("Question : "+questions);
    }
}