package com.gcitcomplaint.voice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterAdmin extends AppCompatActivity {
    private TextInputLayout regUsername, regUserid, regEmail, regPassd;
    private Button btnAdd;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_admin);

        regUsername = findViewById(R.id.username);
        regUserid = findViewById(R.id.userID);
        regEmail = findViewById(R.id.email);
        regPassd = findViewById(R.id.password);
        btnAdd = findViewById(R.id.add_user);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateName() |!validatePassword() | !validateEmail() | !validateId()) {
                    return;
                }
                rootNode = FirebaseDatabase.getInstance();
                reference= rootNode.getReference().child("Admin");

                //Get All the values
                String name = regUsername.getEditText().getText().toString().trim();
                String email = regEmail.getEditText().getText().toString().trim();
                String id = regUserid.getEditText().getText().toString().trim();
                String password = regPassd.getEditText().getText().toString().trim();

                Admin admin = new Admin(name, email, id, password);
                reference.child(id).setValue(admin);
                Toast.makeText(RegisterAdmin.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                Intent obj = new Intent(RegisterAdmin.this, MainActivity.class);
                startActivity(obj);
            }
        });
//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                insertUserData();
//            }
//        });
//    }
//    private void insertUserData(){
//        String username = regUsername.toString().trim();
//        String ID = regUserid.toString().trim();
//        String userEmail = regEmail.toString().trim();
//        String password = regPassd.toString().trim();
//
//        if (username.isEmpty()) {
//            regUsername.setError("Name Required");
//            regUsername.requestFocus();
//            return;
//        }
//        if (ID.isEmpty()) {
//            regUserid.setError("ID required");
//            regUserid.requestFocus();
//            return;
//        }
//        if (password.isEmpty()) {
//            regPassd.setError("Password Required");
//            regPassd.requestFocus();
//            return;
//        }
//        if (password.length() < 6){
//            regPassd.setError("Password should be more than 6 characters");
//            regPassd.requestFocus();
//            return;
//        }
//        if (userEmail.isEmpty()){
//            regEmail.setError("Email required");
//            regEmail.requestFocus();
//            return;
//        }
////        if ( !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches() ){
////            regEmail.setError("Provide Valid Email");
////            regEmail.requestFocus();
////            return;
////        }
//        else {
//            Users usersObj = new Users(username, ID, userEmail, password);
//            voiceDbRef.push().setValue(usersObj);
//            voiceDbRef.child(ID).setValue(usersObj);
//            Toast.makeText(AddUser.this, "User added successfully", Toast.LENGTH_SHORT).show();
//        }
    }
    private boolean validateName(){
        String val = regUsername.getEditText().getText().toString().trim();
        if (val.isEmpty()){
            regUsername.setError("Field Cannot be empty");
            return false;
        }
        else{
            regUsername.setError(null);
            return true;
        }

    }
    private boolean validateId() {
        String val = regUserid.getEditText().getText().toString().trim();
        String noWhiteSpace = "\\A\\w{3,20}\\z";
        if (val.isEmpty()) {
            regUserid.setError("Field Cannot be empty");
            return false;
        } else if (!val.matches(noWhiteSpace)) {
            regUserid.setError("White Spaces are not allowed");
            return false;
        } else {
            regUserid.setError(null);
            regUsername.setErrorEnabled(false);
            return true;

        }
    }
    private boolean validateEmail(){
        String val = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            regEmail.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            regEmail.setError("Invalid email address");
            return false;
        } else {
            regEmail.setError(null);
            regEmail.setErrorEnabled(false);
            return true;
        }

    }
    private boolean validatePassword(){
        String val = regPassd.getEditText().getText().toString();
        String passwordVal = "^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                //"(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                //"(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        if (val.isEmpty()) {
            regPassd.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            regPassd.setError("Password is too weak");
            return false;
        } else {
            regPassd.setError(null);
            regPassd.setErrorEnabled(false);
            return true;
        }

    }
}