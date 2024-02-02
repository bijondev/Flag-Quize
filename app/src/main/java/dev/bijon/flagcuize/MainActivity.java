package dev.bijon.flagcuize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonStartGame;
    private TextView textWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        copyDatabase();

        buttonStartGame = findViewById(R.id.buttonStartGame);
        textWelcome = findViewById(R.id.textWelcome);

        buttonStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuizeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void copyDatabase() {
        try {
            DatabaseCopyHelper helper = new DatabaseCopyHelper(MainActivity.this);
            helper.createDataBase();
            helper.openDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}