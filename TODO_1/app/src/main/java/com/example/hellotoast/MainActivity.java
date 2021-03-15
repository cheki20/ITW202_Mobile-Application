package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View v) {
        String mssg = "Hello Toast!";
        Toast t = Toast.makeText(this, mssg, Toast.LENGTH_SHORT);
        t.show();
    }
    @SuppressLint("SetTextI18n")
    public void count(View v) {
        c++;
        TextView text = (TextView)findViewById(R.id.txt);
        text.setText(""+c);

    }
}
