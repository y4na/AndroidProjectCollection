package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;

public class CalculatorExercise extends AppCompatActivity {
    private EditText equationEditText;
    private TextView resultTextView;
    private String equation = "";
    private double result = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        equationEditText = findViewById(R.id.equation);
        resultTextView = findViewById(R.id.result);

        // Set up button listeners
        setupButtonListeners();
    }

    private void setupButtonListeners() {
        // Number buttons
        Button button0 = findViewById(R.id.zero);
        Button button1 = findViewById(R.id.one);
        Button button2 = findViewById(R.id.two);
        Button button3 = findViewById(R.id.three);
        Button button4 = findViewById(R.id.four);
        Button button5 = findViewById(R.id.five);
        Button button6 = findViewById(R.id.six);
        Button button7 = findViewById(R.id.seven);
        Button button8 = findViewById(R.id.eight);
        Button button9 = findViewById(R.id.nine);

        button0.setOnClickListener(numberButtonListener);
        button1.setOnClickListener(numberButtonListener);
        button2.setOnClickListener(numberButtonListener);
        button3.setOnClickListener(numberButtonListener);
        button4.setOnClickListener(numberButtonListener);
        button5.setOnClickListener(numberButtonListener);
        button6.setOnClickListener(numberButtonListener);
        button7.setOnClickListener(numberButtonListener);
        button8.setOnClickListener(numberButtonListener);
        button9.setOnClickListener(numberButtonListener);

        // Operator buttons
        Button buttonPlus = findViewById(R.id.plus);
        Button buttonMinus = findViewById(R.id.minus);
        Button buttonMultiply = findViewById(R.id.multiplication);
        Button buttonDivide = findViewById(R.id.divide);
        Button buttonPercent = findViewById(R.id.percent);

        buttonPlus.setOnClickListener(operatorButtonListener);
        buttonMinus.setOnClickListener(operatorButtonListener);
        buttonMultiply.setOnClickListener(operatorButtonListener);
        buttonDivide.setOnClickListener(operatorButtonListener);
        buttonPercent.setOnClickListener(operatorButtonListener);

        // Equals button
        Button buttonEquals = findViewById(R.id.equals);
        buttonEquals.setOnClickListener(equalsButtonListener);

        // Clear button
        Button buttonClear = findViewById(R.id.clear);
        buttonClear.setOnClickListener(clearButtonListener);

        // Delete button
        Button buttonDelete = findViewById(R.id.delete);
        buttonDelete.setOnClickListener(deleteButtonListener);
    }

    private View.OnClickListener numberButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;
            equation += button.getText().toString();
            equationEditText.setText(equation);
        }
    };

    private View.OnClickListener operatorButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;
            String newOperator = button.getText().toString();
            String lastChar = equation.isEmpty() ? "" : equation.substring(equation.length() - 1);
            String secondToLastChar = equation.length() > 1 ? equation.substring(equation.length() - 2, equation.length() - 1) : "";

            if (evalOperator(lastChar)) {
                equation = equation.substring(0, equation.length() - 1) + newOperator;
            } else {
                equation += " " + newOperator + " ";
            }

            equationEditText.setText(equation);
        }
    };

    private boolean evalOperator(String character) {
        return character.equals("+") || character.equals("-") || character.equals("*") || character.equals("/");
    }

    private View.OnClickListener equalsButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try {
                result = evaluateEquation(equation);
                resultTextView.setText("= " + result);
            } catch (Exception e) {
                resultTextView.setText("Error");
            }
        }
    };

    private View.OnClickListener clearButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            equation = "";
            equationEditText.setText(equation);
            resultTextView.setText("= 0");
        }
    };

    private View.OnClickListener deleteButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!equation.isEmpty()) {
                equation = equation.substring(0, equation.length() - 1);
                equationEditText.setText(equation);
            }
        }
    };

    private double evaluateEquation(String equation) {
        String[] parts = equation.split(" ");
        Stack<Double> numStack = new Stack<>();
        Stack<String> opStack = new Stack<>();

        for (String part : parts) {
            if (isNumber(part)) {
                numStack.push(Double.parseDouble(part));
            } else if (isOperator(part)) {
                while (!opStack.isEmpty() && hasHigherPrecedence(opStack.peek(), part)) {
                    processOperation(numStack, opStack);
                }
                opStack.push(part);
            }
        }

        while (!opStack.isEmpty()) {
            processOperation(numStack, opStack);
        }

        return numStack.pop();
    }

    private boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("×") || s.equals("÷") || s.equals("%");
    }

    private boolean hasHigherPrecedence(String op1, String op2) {
        if (op1.equals("×") || op1.equals("÷")) {
            return true;
        } else if (op2.equals("×") || op2.equals("÷")) {
            return false;
        } else {
            return true;
        }
    }

    private void processOperation(Stack<Double> numStack, Stack<String> opStack) {
        double num2 = numStack.pop();
        double num1 = numStack.pop();
        String operator = opStack.pop();

        switch (operator) {
            case "+":
                numStack.push(num1 + num2);
                break;
            case "-":
                numStack.push(num1 - num2);
                break;
            case "×":
                numStack.push(num1 * num2);
                break;
            case "÷":
                numStack.push(num1 / num2);
                break;
            case "%":
                numStack.push(num1 % num2);
                break;
        }
    }
}