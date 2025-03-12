package com.example.week8;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputFirstNumber = findViewById(R.id.inputFirstNumber);
        EditText inputSecondNumber = findViewById(R.id.inputSecondNumber);
        TextView textResult = findViewById(R.id.textResult);

        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);

        buttonPlus.setOnClickListener(v -> calculate(inputFirstNumber, inputSecondNumber, textResult, '+'));
        buttonMinus.setOnClickListener(v -> calculate(inputFirstNumber, inputSecondNumber, textResult, '-'));
        buttonMultiply.setOnClickListener(v -> calculate(inputFirstNumber, inputSecondNumber, textResult, '*'));
        buttonDivide.setOnClickListener(v -> calculate(inputFirstNumber, inputSecondNumber, textResult, '/'));
    }

    private void calculate(EditText firstInput, EditText secondInput, TextView resultView, char operator) {
        String first = firstInput.getText().toString().trim();
        String second = secondInput.getText().toString().trim();

        if (first.isEmpty() || second.isEmpty()) {
            resultView.setText(R.string.msg_enter_both_numbers);
            return;
        }

        double num1, num2;
        try {
            num1 = Double.parseDouble(first);
            num2 = Double.parseDouble(second);
        } catch (NumberFormatException e) {
            resultView.setText(R.string.msg_invalid_input);
            return;
        }

        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    resultView.setText(R.string.msg_divide_by_zero);
                    return;
                }
                result = num1 / num2;
                break;
            default:
                resultView.setText(R.string.msg_unknown_operation);
                return;
        }

        if (result == Math.floor(result)) {
            resultView.setText(String.valueOf((int) result));
        } else {
            resultView.setText(String.valueOf(result));
        }
    }
}