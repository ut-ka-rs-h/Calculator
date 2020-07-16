package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private enum OPERATOR {
        PLUS, SUBTRACT, MULTIPLY, DIVIDE, PERCENTAGE, EQUAL
    }

    private TextView txtCalculations, txtResult;

    private String currentNumber, stringNumberAtLeft, stringNumberAtRight, calculationsString;

    private OPERATOR currentOperator;
    private int calculationResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "";
        calculationResult = 0;
        calculationsString = "";

        txtResult = findViewById(R.id.txtResult);
        txtCalculations = findViewById(R.id.txtCalculations);

        findViewById(R.id.clear).setOnClickListener(this);
        findViewById(R.id.divide).setOnClickListener(this);
        findViewById(R.id.multiply).setOnClickListener(this);
        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.subtract).setOnClickListener(this);
        findViewById(R.id.back).setOnClickListener(this);
        findViewById(R.id.equal).setOnClickListener(this);
        findViewById(R.id.decimal).setOnClickListener(this);
        findViewById(R.id.n0).setOnClickListener(this);
        findViewById(R.id.n1).setOnClickListener(this);
        findViewById(R.id.n2).setOnClickListener(this);
        findViewById(R.id.n3).setOnClickListener(this);
        findViewById(R.id.n4).setOnClickListener(this);
        findViewById(R.id.n5).setOnClickListener(this);
        findViewById(R.id.n6).setOnClickListener(this);
        findViewById(R.id.n7).setOnClickListener(this);
        findViewById(R.id.n8).setOnClickListener(this);
        findViewById(R.id.n9).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.n0:
                numberIsTapped(0);
                break;
            case R.id.n1:
                numberIsTapped(1);
                break;
            case R.id.n2:
                numberIsTapped(2);
                break;
            case R.id.n3:
                numberIsTapped(3);
                break;
            case R.id.n4:
                numberIsTapped(4);
                break;
            case R.id.n5:
                numberIsTapped(5);
                break;
            case R.id.n6:
                numberIsTapped(6);
                break;
            case R.id.n7:
                numberIsTapped(7);
                break;
            case R.id.n8:
                numberIsTapped(8);
                break;
            case R.id.n9:
                numberIsTapped(9);
                break;
            case R.id.clear:
                txtCalculations.setText("");
                txtResult.setText("");
                currentNumber = "";
                stringNumberAtRight = "";
                stringNumberAtLeft = "";
                calculationsString = "";
                currentOperator = null;
                break;
            case R.id.add:
                operatorIsTapped(OPERATOR.PLUS);
                calculationsString += " + ";
                break;
            case R.id.subtract:
                operatorIsTapped(OPERATOR.SUBTRACT);
                calculationsString += " - ";
                break;
            case R.id.divide:
                operatorIsTapped(OPERATOR.DIVIDE);
                calculationsString += " / ";
                break;
            case R.id.multiply:
                operatorIsTapped(OPERATOR.MULTIPLY);
                calculationsString += " * ";
                break;
            case R.id.back:
                Toast.makeText(this, "currently not functioning \n coming soon..." , Toast.LENGTH_SHORT).show();
                break;
            case R.id.percent:
                operatorIsTapped(OPERATOR.PERCENTAGE);
                break;
            case R.id.decimal:
                Toast.makeText(this, "currently not functioning \n coming soon...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.equal:
                operatorIsTapped(OPERATOR.EQUAL);
                break;

        }
        txtCalculations.setText(calculationsString);
    }

    private void numberIsTapped(int tappedNumber){
        currentNumber = currentNumber + tappedNumber;
        txtCalculations.setText(currentNumber);

        calculationsString = currentNumber;
        txtCalculations.setText(calculationsString);
    }

    private void operatorIsTapped(OPERATOR tappedOperator){
        if (currentOperator != null) {
            if (!currentNumber.equals("")) {
                stringNumberAtRight = currentNumber;
                currentNumber = "";
                try {

                    switch (currentOperator) {

                        case PLUS:
                            calculationResult = Integer.parseInt(stringNumberAtLeft) + Integer.parseInt(stringNumberAtRight);
                            break;
                        case SUBTRACT:
                            calculationResult = Integer.parseInt(stringNumberAtLeft) - Integer.parseInt(stringNumberAtRight);
                            break;
                        case MULTIPLY:
                            calculationResult = Integer.parseInt(stringNumberAtLeft) * Integer.parseInt(stringNumberAtRight);
                            break;
                        case DIVIDE:
                            calculationResult = Integer.parseInt(stringNumberAtLeft) / Integer.parseInt(stringNumberAtRight);
                            break;
                        case PERCENTAGE:
                            calculationResult = Integer.parseInt(stringNumberAtLeft) % Integer.parseInt(stringNumberAtRight);
                            break;
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                stringNumberAtLeft = String.valueOf(calculationResult);
                txtResult.setText(stringNumberAtLeft);
                calculationsString = stringNumberAtLeft;
            }
        }
        else {
            stringNumberAtLeft = currentNumber;
            currentNumber = "";
        }
        currentOperator = tappedOperator;
    }
}