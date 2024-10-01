package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CalculatorApp"; // Tag for logging
    private EditText num1, num2;
    private TextView result;
    private Button add, subtract, multiply, divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.ADD);
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.SUBTRACT);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.MULTIPLY);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(Operation.DIVIDE);
            }
        });
    }

    private void performOperation(Operation operation) {
        try {
            double n1 = Double.parseDouble(num1.getText().toString());
            double n2 = Double.parseDouble(num2.getText().toString());
            double resultValue = 0;

            switch (operation) {
                case ADD:
                    resultValue = n1 + n2;
                    Log.d(TAG, "Adding: " + n1 + " + " + n2 + " = " + resultValue);
                    break;
                case SUBTRACT:
                    resultValue = n1 - n2;
                    Log.d(TAG, "Subtracting: " + n1 + " - " + n2 + " = " + resultValue);
                    break;
                case MULTIPLY:
                    resultValue = n1 * n2;
                    Log.d(TAG, "Multiplying: " + n1 + " * " + n2 + " = " + resultValue);
                    break;
                case DIVIDE:
                    if (n2 != 0) {
                        resultValue = n1 / n2;
                        Log.d(TAG, "Dividing: " + n1 + " / " + n2 + " = " + resultValue);
                    } else {
                        Log.e(TAG, "Division by zero attempted.");
                        result.setText("Error: Division by zero");
                        return;
                    }
                    break;
            }

            result.setText(String.valueOf(resultValue));
        } catch (NumberFormatException e) {
            Log.e(TAG, "Invalid input: " + e.getMessage());
            result.setText("Error: Invalid input");
        }
    }

    private enum Operation {
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }
}