package com.example.helmine.sharedprefsexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Activity2 extends ActionBarActivity {

    TextView usernameTextView, passwordTextView;

    public static final String DEFAULT = "not available";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        usernameTextView = (TextView)findViewById(R.id.retrUsername);
        passwordTextView = (TextView)findViewById(R.id.retrPassword);

    }

    public void retrieve (View view){

        SharedPreferences sharedPrefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String username = sharedPrefs.getString("username", DEFAULT);
        String password = sharedPrefs.getString("password", DEFAULT);

        if (username.equals(DEFAULT)||password.equals(DEFAULT))
        {
            Toast.makeText(this, "No data found", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Data retrieve success", Toast.LENGTH_LONG).show();
            usernameTextView.setText(username);
            passwordTextView.setText(password);
        }
    }

    public void backtoActivity1(View view){
        Toast.makeText(this, "backtoActivity1", Toast.LENGTH_LONG).show();
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
