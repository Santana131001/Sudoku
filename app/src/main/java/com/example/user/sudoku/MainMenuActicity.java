package com.example.user.sudoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActicity extends AppCompatActivity {
    Button buttonExit, buttonInstruction, buttonNewGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        buttonExit = findViewById(R.id.buttonExit);
        buttonInstruction = findViewById(R.id.buttonInstructions);
        buttonNewGame = findViewById(R.id.buttonNewGame);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        buttonInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMenuActicity.this,InstructionActivity.class);
                startActivity(i);
            }
        });
        buttonNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMenuActicity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
