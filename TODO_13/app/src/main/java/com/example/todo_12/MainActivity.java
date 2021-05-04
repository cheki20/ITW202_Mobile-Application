package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.todo_12";
    String mssg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void Donut(View view) {
        mssg = getString(R.string.donut_order);
        displayToast(mssg);
    }

    public void IceCream(View view) {
        mssg = getString(R.string.iceCream_order);
        displayToast(mssg);    }

    public void Froyo(View view) {
        mssg = getString(R.string.froyo_order);
        displayToast(mssg);    }

    public void call(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(EXTRA_MESSAGE, mssg);
        startActivity(intent);

    }
}