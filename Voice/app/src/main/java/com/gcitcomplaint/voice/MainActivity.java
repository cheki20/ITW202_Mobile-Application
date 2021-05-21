package com.gcitcomplaint.voice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout txt_username, txt_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_username = findViewById(R.id.username);
        txt_password = findViewById(R.id.password);
        btn_login = (Button)findViewById(R.id.button_login);
    }
    private Boolean validateUsername() {
        String val = txt_username.getEditText().getText().toString();
        if (val.isEmpty()) {
            txt_username.setError("Field cannot be empty");
            return false;
        } else {
            txt_username.setError(null);
            txt_username.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validatePassword() {
        String val = txt_password.getEditText().getText().toString();
        if (val.isEmpty()) {
            txt_password.setError("Field cannot be empty");
            return false;
        } else {
            txt_password.setError(null);
            txt_password.setErrorEnabled(false);
            return true;
        }
    }
    public void loginUser(View view) {
        //Validate Login Info
        int countNo = txt_username.getEditText().length();
        if (!validateUsername() | !validatePassword()) {
            return;
        } else if (countNo == 8){
            isUser();
        }
        else if (countNo == 3){
            isAdmin();
        }
        else if (countNo == 11){
            isServiceProvider();
        }
    }
    private void isUser() {
        final String userEnteredUsername = txt_username.getEditText().getText().toString().trim();
        final String userEnteredPassword = txt_password.getEditText().getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");

        Query checkUser = reference.orderByChild("id").equalTo(userEnteredUsername);


        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    txt_username.setError(null);
                    txt_username.setEnabled(false);

                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);
                    if (passwordFromDB.equals(userEnteredPassword)){
                        txt_username.setError(null);
                        txt_username.setEnabled(false);
                        String nameFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
                        String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);
                        String idFromDB = dataSnapshot.child(userEnteredUsername).child("id").getValue(String.class);
                        Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("id", idFromDB);
                        intent.putExtra("password", passwordFromDB);
                        startActivity(intent);
                    }
                    else {
                        txt_password.setError("Wrong Password!");
                        txt_password.requestFocus();
                    }
                }
                else{
                    txt_username.setError("No user exists");
                    txt_username.requestFocus();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void isAdmin() {
        final String userEnteredUsername = txt_username.getEditText().getText().toString().trim();
        final String userEnteredPassword = txt_password.getEditText().getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Admin");

        Query checkUser = reference.orderByChild("id").equalTo(userEnteredUsername);


        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    txt_username.setError(null);
                    txt_username.setEnabled(false);

                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);
                    if (passwordFromDB.equals(userEnteredPassword)){
                        txt_username.setError(null);
                        txt_username.setEnabled(false);
                        String nameFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
                        String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);
                        String idFromDB = dataSnapshot.child(userEnteredUsername).child("id").getValue(String.class);
                        Intent intent = new Intent(getApplicationContext(), AdminDashboard.class);
                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("id", idFromDB);
                        intent.putExtra("password", passwordFromDB);
                        startActivity(intent);
                    }
                    else {
                        txt_password.setError("Wrong Password!");
                        txt_password.requestFocus();
                    }
                }
                else{
                    txt_username.setError("No user exists");
                    txt_username.requestFocus();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void isServiceProvider(){
        final String userEnteredUsername = txt_username.getEditText().getText().toString().trim();
        final String userEnteredPassword = txt_password.getEditText().getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("ServiceProviders");

        Query checkUser = reference.orderByChild("id").equalTo(userEnteredUsername);


        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    txt_username.setError(null);
                    txt_username.setEnabled(false);

                    String passwordFromDB = dataSnapshot.child(userEnteredUsername).child("password").getValue(String.class);
                    if (passwordFromDB.equals(userEnteredPassword)){
                        txt_username.setError(null);
                        txt_username.setEnabled(false);
                        String nameFromDB = dataSnapshot.child(userEnteredUsername).child("name").getValue(String.class);
                        String emailFromDB = dataSnapshot.child(userEnteredUsername).child("email").getValue(String.class);
                        String idFromDB = dataSnapshot.child(userEnteredUsername).child("id").getValue(String.class);
                        String roleFromDB = dataSnapshot.child(userEnteredUsername).child("role").getValue(String.class);
                        Intent intent = new Intent(getApplicationContext(), ServiceProviderDashboard.class);
                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("id", idFromDB);
                        intent.putExtra("password", passwordFromDB);
                        intent.putExtra("role", roleFromDB);
                        startActivity(intent);
                    }
                    else {
                        txt_password.setError("Wrong Password!");
                        txt_password.requestFocus();
                    }
                }
                else{
                    txt_username.setError("No user exists");
                    txt_username.requestFocus();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void Register(View view){
        Intent obj = new Intent(MainActivity.this, RegisterAdmin.class);
        startActivity(obj);
        finish();
    }
}
