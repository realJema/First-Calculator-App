package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private double valueOne = Double.NaN;
    private double valueTwo;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;


//    decimalFormat = new DecimalFormat("#.#############");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DecimalFormat decimalFormat = new DecimalFormat("#.############");

//        Buttons

        final TextView info = (TextView) findViewById(R.id.infoTextView);
        final TextView screen = (TextView) findViewById(R.id.editText);
        Button _0 = (Button) findViewById(R.id.buttonZero);
        Button _1 = (Button) findViewById(R.id.buttonOne);
        Button _2 = (Button) findViewById(R.id.buttonTwo);
        Button _3 = (Button) findViewById(R.id.buttonThree);
        Button _4 = (Button) findViewById(R.id.buttonFour);
        Button _5 = (Button) findViewById(R.id.buttonFive);
        Button _6 = (Button) findViewById(R.id.buttonSix);
        Button _7 = (Button) findViewById(R.id.buttonSeven);
        Button _8 = (Button) findViewById(R.id.buttonEight);
        Button _9 = (Button) findViewById(R.id.buttonNine);
        Button _Dot = (Button) findViewById(R.id.buttonDot);

        Button _Add = (Button) findViewById(R.id.buttonAdd);
        Button _Subtract = (Button) findViewById(R.id.buttonSubtract);
        Button _Divide = (Button) findViewById(R.id.buttonDivide);
        Button _Multiply = (Button) findViewById(R.id.buttonMultiply);
        Button _Equal = (Button) findViewById(R.id.buttonEqual);
        Button _Clear = (Button) findViewById(R.id.buttonClear);


        // Click listeners
        _0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the code here
                screen.setText(screen.getText() + "0");
            }
        });
        _1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the code here
                screen.setText(screen.getText() + "1");
            }
        });
        _2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the code here
                screen.setText(screen.getText() + "2");
            }
        });
        _3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the code here
                screen.setText(screen.getText() + "3");
            }
        });
        _4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the code here
                screen.setText(screen.getText() + "4");
            }
        });
        _5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the code here
                screen.setText(screen.getText() + "5");
            }
        });
        _6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the code here
                screen.setText(screen.getText() + "6");
            }
        });
        _7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the code here
                screen.setText(screen.getText() + "7");
            }
        });
        _8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the code here
                screen.setText(screen.getText() + "8");
            }
        });
        _9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the code here
                screen.setText(screen.getText() + "9");
            }
        });
        _Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the code here
                screen.setText(screen.getText() + ".");
            }
        });




        _Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the code here
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                info.setText(decimalFormat.format(valueOne) + " + ");
                screen.setText(null);
            }
        });
        _Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the code here
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                info.setText(decimalFormat.format(valueOne) + " * ");
                screen.setText(null);
            }
        });
        _Subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the code here
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                info.setText(decimalFormat.format(valueOne) + " - ");
                screen.setText(null);
            }
        });
        _Divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the code here
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                info.setText(decimalFormat.format(valueOne) + " / ");
                screen.setText(null);
            }
        });
        _Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the code here
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                info.setText(decimalFormat.format(valueOne) + " + ");
                screen.setText(null);
            }
        });
        _Equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the code here
                computeCalculation();
                info.setText(info.getText().toString() + decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });
        _Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // handle the code here
                if(screen.getText().length() > 0) {
                    CharSequence currentText = screen.getText();
                    screen.setText(currentText.subSequence(0, currentText.length()-1)); // clears one character if screen is not empty
                }
                else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    info.setText("");
                    screen.setText("");
                }
            }
        });

    }

    private void computeCalculation(){

        final TextView info = (TextView) findViewById(R.id.infoTextView);
        final TextView screen = (TextView) findViewById(R.id.editText);
        if(!Double.isNaN(valueOne)){
            valueTwo = Double.parseDouble(screen.getText().toString());
            screen.setText(null);

            if(CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if(CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if(CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if(CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        }
        else {
            try {
                valueOne = Double.parseDouble(screen.getText().toString());
            }
            catch (Exception e){

            }
        }
    }


}