package com.kevinkadakas.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PreGame extends AppCompatActivity {

    Button StartGame, back;
    EditText fName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_game);
        StartGame = findViewById(R.id.button3);
        fName = findViewById(R.id.editText);

        back = findViewById(R.id.button32);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(PreGame.this, StartActivity.class);
                startActivity(back);
                finish();
            }
        });

        StartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fName.getText().toString().length() <= 15 && !(fName.getText().toString().isEmpty())) {
                    Intent lvl1 = new Intent(PreGame.this, lvl1.class);
                    lvl1.putExtra("name", fName.getText().toString());
                    startActivity(lvl1);
                    finish();
                } else if (fName.getText().toString().length() >= 15) {
                    Toast.makeText(PreGame.this, "Nimi ei tohi olla pikem kui 15 karakterit!", Toast.LENGTH_LONG).show();
                } else if (fName.getText().toString().isEmpty()) {
                    Toast.makeText(PreGame.this, "Nimi peab olema sisestatud!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
