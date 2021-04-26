package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextWeb, editTextLoca, editTextTxt;
    private Button btnWeb, btnLoca, btnTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeb = findViewById(R.id.editText_web);
        editTextLoca = findViewById(R.id.editText_location);
        editTextTxt = findViewById(R.id.editText_te);
    }

    public  void SendWeb(View view){
        String txt = editTextWeb.getText().toString();
        Uri url = Uri.parse(txt);
        Intent obj = new Intent(Intent.ACTION_VIEW, url);

        if (obj.resolveActivity(getPackageManager()) != null){
            startActivity(obj);
        }
        else{
            Log.d("Implicit Intents", "Error Message");
        }
    }

    public void SendLocation(View view){
        String txt = editTextLoca.getText().toString();
        Uri url = Uri.parse("geo:0,0?q=" +txt);
        Intent obj = new Intent(Intent.ACTION_VIEW,url);

        if (obj.resolveActivity(getPackageManager()) != null){
            startActivity(obj);
        }
        else{
            Log.d("Implicit Intents", "Error Message");
        }
    }

    public void ShareTxt(View view){
        String txt = editTextTxt.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();
    }

}