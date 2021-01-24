package com.example.chinesetheoromcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.RoundingMode;
import java.sql.ResultSet;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Calculator calculator = new Calculator();
    Results results = new Results();

    Button eq1Btn, eq2Btn, eq3Btn, calculateBtn;
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

        solutionTV = findViewById(R.id.solution_textview);

        calculateBtn = findViewById(R.id.calculate_btn);
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: create Results class;
                //TODO: calculations should be in a different thread.
                //TODO: show results on UI.
                results = calculator.getResults();
                solutionTV.setText(results.getaInfo() + "\n" + results.getmSmallInfo() + "\n" + results.getmBigInfo() + "\n" + results.getFirstCalc() + "\n" + results.getSecCalc() + "\n" + results.getThirdCalc() + "\n" + results.getFinalResult());

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
        }).show();
    }

    private void updateValues(View v, int aInput, int bInput, Calculator calculator) {

        switch (((Button) v).getId()) {
            case R.id.eq1_btn:
                calculator.setA1(aInput);
                calculator.setM1(bInput);
                break;
            case R.id.eq2_btn:
                calculator.setA2(aInput);
                calculator.setM2(bInput);
                break;
            case R.id.eq3_btn:
                calculator.setA3(aInput);
                calculator.setM3(bInput);
                break;
        }
    }
}