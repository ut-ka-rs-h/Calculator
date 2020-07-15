package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private enum OPERATOR {
        PLUS, SUBTRACT, MULTIPLY, DIVIDE, EQUAL
    }

    private TextView txtCalculations, txtResult, clear, divide, multiply, add, subtract, back, equal1,
            n0, n1, n2, n3, n4, n5, n6, n7, n8, n9;

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

        clear = findViewById(R.id.clear);
        divide = findViewById(R.id.divide);
        multiply = findViewById(R.id.multiply);
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        back = findViewById(R.id.back);
        equal1 = findViewById(R.id.equal);
        n0 = findViewById(R.id.n0);
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        n7 = findViewById(R.id.n7);
        n8 = findViewById(R.id.n8);
        n9 = findViewById(R.id.n9);

        clear.setOnClickListener(this);
        back.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        equal1.setOnClickListener(this);
        n0.setOnClickListener(this);
        n1.setOnClickListener(this);
        n2.setOnClickListener(this);
        n3.setOnClickListener(this);
        n4.setOnClickListener(this);
        n5.setOnClickListener(this);
        n6.setOnClickListener(this);
        n7.setOnClickListener(this);
        n8.setOnClickListener(this);
        n9.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

//            for (int i = 0; i < 10; i++) {
//                case R.id.
//
//            }
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

                break;
            case R.id.percent:

                break;
            case R.id.decimal:

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
        if (currentOperator != null && currentNumber != ""){
            stringNumberAtRight = currentNumber;
            currentNumber = "";

            switch (currentOperator){
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
            }
            stringNumberAtLeft = String.valueOf(calculationResult);
            txtResult.setText(stringNumberAtLeft);
            calculationsString = stringNumberAtLeft;
        }
        else {
            stringNumberAtLeft = currentNumber;
            currentNumber = "";
        }
        currentOperator = tappedOperator;
    }
}