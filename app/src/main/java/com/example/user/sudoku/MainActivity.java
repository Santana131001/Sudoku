package com.example.user.sudoku;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.user.sudoku.board.Board;
import com.example.user.sudoku.system.SolverChecker;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    GridView gridview;
    AssetManager assetManager;
    Button instructionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assetManager = getAssets();
        gridview = findViewById(R.id.gridView);

        try {
            InputStream inputStream = assetManager.open("easy_1.in");
            gridview.setAdapter(new Board(this, inputStream));
        } catch (IOException e) {
        }

        instructionButton = findViewById(R.id.instructionButton);
        instructionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,InstructionActivity.class);
                startActivity(i);
            }
        });
    }

    public void solvePuzzle(View view) {
        Board board = (Board) gridview.getAdapter();
        SolverChecker solverChecker = new SolverChecker();
        solverChecker.solve(0, 0, board.grid2d);
        int x = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextView textView = (TextView) gridview.getChildAt(x);
                textView.setText(String.valueOf(board.grid2d[i][j]));
                x++;
            }
        }

        checkSolution(view);
    }

    public void checkSolution(View view) {
        boolean win = true;

        int[] userArray = new int[81];
        int[] solvedArray = new int[81];

        Board board = (Board) gridview.getAdapter();

        for (int i = 0; i < 81; i++) {
            EditText textView = (EditText) gridview.getChildAt(i);
            String text = String.valueOf(textView.getText());
            if (text.equals("")){
                userArray[i] = 0;
            } else {
                userArray[i] = Integer.valueOf(text);
            }
        }

        SolverChecker solverChecker = new SolverChecker();

        solverChecker.solve(0, 0, board.grid2d);
        int x = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                solvedArray[x] = board.grid2d[i][j];
                x++;
            }
        }

        for (int i = 0; i < 81; i++) {
            EditText textView = (EditText) gridview.getChildAt(i);

            if(textView.isEnabled()) {
                if (solvedArray[i] != userArray[i]) {
                    textView.setTextColor(Color.RED);
                    win = false;
                } else {
                    textView.setTextColor(Color.BLACK);
                }
            }
        }


        if(win) {
            Toast.makeText(view.getContext(), "You won, congratulation",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(view.getContext(), "There are a mistake",
                    Toast.LENGTH_LONG).show();
        }
    }
}
