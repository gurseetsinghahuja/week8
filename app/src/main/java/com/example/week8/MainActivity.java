package com.example.week8;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText inputFirstNumber, inputSecondNumber;
    Button buttonPlus, buttonMinus, buttonMultiply, buttonDivide;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linking UI elements with Java code
        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        textResult = findViewById(R.id.textResult);

        // Set click listeners for buttons
        buttonPlus.setOnClickListener(view -> calculate('+'));
        buttonMinus.setOnClickListener(view -> calculate('-'));
        buttonMultiply.setOnClickListener(view -> calculate('*'));
        buttonDivide.setOnClickListener(view -> calculate('/'));
    }

    private void calculate(char operator) {
        // Get user input from text fields
        String num1Str = inputFirstNumber.getText().toString();
        String num2Str = inputSecondNumber.getText().toString();

        // Check if fields are empty
        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            textResult.setText("Enter both numbers");
            return;
        }

        // Convert input to double
        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);
        double result = 0;

        // Perform calculations
        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    textResult.setText("Cannot divide by zero");
                    return;
                }
                break;
        }

        // Display result
        textResult.setText("Result: " + result);
    }
}
