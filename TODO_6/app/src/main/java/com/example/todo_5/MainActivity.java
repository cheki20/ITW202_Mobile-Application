package com.example.todo_5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_message = "com.example.todo_4";
    private EditText send_Message;

    private static final String LOG_TAG = MainActivity2.class.getSimpleName();

    public static final int TEXT_REQUEST = 1;
    private TextView reply_header;
    private TextView reply_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send_Message = findViewById(R.id.txt_send);
        reply_header =findViewById(R.id.textView1);
        reply_message = findViewById(R.id.display_reply);

        Log.d(LOG_TAG, "onCreate");

        //For saving the displaying the activity instance
        if (savedInstanceState != null){
            boolean isVisible = savedInstanceState.getBoolean("reply_state");
            if (isVisible){
                reply_header.setVisibility(View.VISIBLE);
                reply_message.setText(savedInstanceState.getString("reply_state_ message"));
                reply_message.setVisibility(View.VISIBLE);
            }
        }
    }
    public void Send(View v) {
        Intent obj = new Intent(this,MainActivity2.class);
        String mssg = send_Message.getText().toString();
        obj.putExtra(EXTRA_message, mssg);
        startActivityForResult(obj, TEXT_REQUEST);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String final_mssg = data.getStringExtra(MainActivity2.EXTRA_replyMessage);
                reply_header.setVisibility(View.VISIBLE);
                reply_message.setText(final_mssg);
                reply_message.setVisibility(View.VISIBLE);
            }
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    //method to
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (reply_header.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_state", true);
            outState.putString("reply_state_ message", reply_message.getText().toString());
        }
    }
}