package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTextView = findViewById(R.id.textView);

        Intent obj = getIntent();
        String mssg = obj.getStringExtra(MainActivity.EXTRA_MESSAGE);
        mTextView.setText(mssg);

        Spinner spinner = findViewById(R.id.label_spinner);
        if(spinner!=null){
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.label_array, R.layout.support_simple_spinner_dropdown_item);
        if (spinner != null){
            spinner.setAdapter(adapter);
        }
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void onRadioClick(View view) {
        boolean isChecked = ((RadioButton)view).isChecked();

        switch (view.getId()) {
            case R.id.radioButton:
                displayToast(getString(R.string.sameDay));
                break;

            case R.id.radioButton1:
                displayToast(getString(R.string.nextDay));
                break;

            case R.id.radioButton2:
                displayToast(getString(R.string.pickUp));
                break;

            default:
                break;

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String nMessage = parent.getItemAtPosition(position).toString();
        displayToast(nMessage);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //
    }


}