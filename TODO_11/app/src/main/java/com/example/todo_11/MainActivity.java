package com.example.todo_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String[] colourArray = {"purple_200","purple_500","purple_700","teal_200",
            "teal_700","black","blue","pink","green","orange","yellow","purple","red","green1"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    public void ChangeColour(View view) {
        Random random = new Random();
        String colorName = colourArray[random.nextInt(14)];

        int colorRName = getResources().getIdentifier(colorName,"color",getApplicationContext().getPackageName());
        int colorRes = ContextCompat.getColor(this, colorRName);
        textView.setTextColor(colorRes);
    }
}