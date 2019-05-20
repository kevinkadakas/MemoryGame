package com.kevinkadakas.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    Button LeaderBoard, StartGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        LeaderBoard = findViewById(R.id.button2);
        StartGame = findViewById(R.id.button);

        StartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startGame = new Intent(StartActivity.this, PreGame.class);
                startActivity(startGame);
                finish();
            }
        });

        LeaderBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leaderBoard = new Intent(StartActivity.this, LeaderBoard.class);
                startActivity(leaderBoard);
                finish();
            }
        });
    }
}
