package com.gcitcomplaint.voice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class User_Profile extends AppCompatActivity {
    private TextView txt_name, txt_id, txt_email, txt_password;
    private ImageView img_pro, img_id, img_email, img_passd;

    private FirebaseDatabase database;
    private DatabaseReference mdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__profile);
        txt_name = findViewById(R.id.textView_name);
        txt_id = findViewById(R.id.textView_id);
        txt_email = findViewById(R.id.textView_email);
        txt_password = findViewById(R.id.textView_password);
        img_id = findViewById(R.id.image_id);
        img_email = findViewById(R.id.image_email);
        img_passd = findViewById(R.id.image_pssd);

        //To get the data from firebase
        showAllData();
    }

    private void showAllData() {
        Intent intent = getIntent();
        String user_id = intent.getStringExtra("id");
        String user_name = intent.getStringExtra("name");
        String user_email = intent.getStringExtra("email");
        String user_password = intent.getStringExtra("password");

        txt_name.setText(user_name);
        txt_id.setText(user_id);
        txt_email.setText(user_email);
        txt_password.setText(user_password);
    }
}