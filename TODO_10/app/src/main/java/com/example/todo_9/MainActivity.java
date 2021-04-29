package com.example.todo_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText1,editText2;
    private Calculator calculator;
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editTextText1);
        editText2 = findViewById(R.id.editText2);
        calculator = new Calculator();
        txtView = findViewById(R.id.textView);
    }
    public void Add(View view){
        String val1 = editText1.getText().toString();
        String val2 = editText2.getText().toString();

        double result = calculator.Add(Double.valueOf(val1),Double.valueOf(val2));
        txtView.setText(String.valueOf(result));
        Log.d("Debugging", "Hello Debugging");
    }

    public void Sub(View view){
        String val1 = editText1.getText().toString();
        String val2 = editText2.getText().toString();

        double result = calculator.Subtract(Double.valueOf(val1),Double.valueOf(val2));
        txtView.setText(String.valueOf(result));
        Log.d("Debugging", "Hello Debugging");

    }
    public void Mul(View view){
        String val1 = editText1.getText().toString();
        String val2 = editText2.getText().toString();

        double result = calculator.Multiply(Double.valueOf(val1),Double.valueOf(val2));
        txtView.setText(String.valueOf(result));
        Log.d("Debugging", "Hello Debugging");

    }
    public void Div(View view){
        String val1 = editText1.getText().toString();
        String val2 = editText2.getText().toString();

        double result = calculator.Divide(Double.valueOf(val1),Double.valueOf(val2));
        txtView.setText(String.valueOf(result));
        Log.d("Debugging", "Hello Debugging");

    }
}