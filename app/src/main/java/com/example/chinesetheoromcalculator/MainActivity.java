package com.example.chinesetheoromcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.sql.ResultSet;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Calculator calculator = new Calculator();
    Results results = new Results();

    Button eq1Btn, eq2Btn, eq3Btn, calculateBtn, resetBtn;
    TextView eq1TV, eq2TV, eq3TV;
    TextView solutionTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eq1Btn = findViewById(R.id.eq1_btn);
        eq2Btn = findViewById(R.id.eq2_btn);
        eq3Btn = findViewById(R.id.eq3_btn);

        eq1Btn.setOnClickListener(this);
        eq2Btn.setOnClickListener(this);
        eq3Btn.setOnClickListener(this);

        eq1TV = findViewById(R.id.eq1_textview);
        eq2TV = findViewById(R.id.eq2_textview);
        eq3TV = findViewById(R.id.eq3_textview);

        resetBtn = findViewById(R.id.reset_btn);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eq1TV.setText("X ☰ A (MOD B)");
                eq2TV.setText("X ☰ A (MOD B)");
                eq3TV.setText("X ☰ A (MOD B)");

                calculator.reset();
                results.reset();

                solutionTV.setText("");
                resetBtn.setVisibility(View.GONE);
            }
        });

        solutionTV = findViewById(R.id.solution_textview);

        calculateBtn = findViewById(R.id.calculate_btn);
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                results = calculator.getResults();

                if (calculator.isValidResults) {
                    solutionTV.setText(
                            results.getaInfo() +
                                    System.lineSeparator() + results.getmSmallInfo() + System.lineSeparator() + results.getmInfo() +
                                    System.lineSeparator() + System.lineSeparator() + results.getmBigInfo() +
                                    System.lineSeparator() +
                                    System.lineSeparator() + results.getFirstCalc() +
                                    System.lineSeparator() + results.getSecCalc() +
                                    System.lineSeparator() + results.getThirdCalc() +
                                    System.lineSeparator() +
                                    System.lineSeparator() + results.getX0Info() +
                                    System.lineSeparator() +
                                    System.lineSeparator() + results.getFinalResult());

                    resetBtn.setVisibility(View.VISIBLE);
                }
                else {
                    Toast.makeText(MainActivity.this, "Invalid parameters. Try Again.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        openDialogAndGetInput(v);
    }

    private void openDialogAndGetInput(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View dialogView = getLayoutInflater().inflate(R.layout.select_number_dialog, null);

        final EditText aInputStr = dialogView.findViewById(R.id.a_input);
        final EditText bInputStr = dialogView.findViewById(R.id.b_input);

        builder.setView(dialogView).setPositiveButton("Enter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (!(aInputStr.getText().toString().matches("[0-9]+"))) {
                    return;
                }

                if (!(bInputStr.getText().toString().matches("[0-9]+"))) {
                    return;
                }

                int aInput = Integer.parseInt(aInputStr.getText().toString());
                int bInput = Integer.parseInt(bInputStr.getText().toString());

                updateValues(v, aInput, bInput, calculator);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.getWindow().getAttributes().windowAnimations = R.style.SlidingDialogAnimation;
        dialog.show();
    }

    private void updateValues(View v, int aInput, int bInput, Calculator calculator) {

        switch (((Button) v).getId()) {
            case R.id.eq1_btn:
                calculator.setA1(aInput);
                calculator.setM1(bInput);
                eq1TV.setText("X ☰ " + calculator.getA1() + " (MOD" + calculator.getM1() + ")");
                break;
            case R.id.eq2_btn:
                calculator.setA2(aInput);
                calculator.setM2(bInput);
                eq2TV.setText("X ☰ " + calculator.getA2() + " (MOD" + calculator.getM2() + ")");
                break;
            case R.id.eq3_btn:
                calculator.setA3(aInput);
                calculator.setM3(bInput);
                eq3TV.setText("X ☰ " + calculator.getA3() + " (MOD" + calculator.getM3() + ")");
                break;
        }
    }
}