package com.example.wongrachel.finalquizzapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener

{

    private Button login, register;
    private EditText enterEmail, enterPassword;
    private DbHelper db;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DbHelper(this);
        session = new Session(this);
        login = (Button) findViewById(R.id.loginButton);
        register = (Button) findViewById(R.id.registerButton);
        enterEmail = (EditText) findViewById(R.id.enterEmail);
        enterPassword = (EditText) findViewById(R.id.enterPassword);
        login.setOnClickListener(this);
        register.setOnClickListener(this);

        if(session.loggedin())
        {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.loginButton:
                login();
                break;

            case R.id.registerButton:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;

            default:

        }
    }

    private void login()
    {
        String email = enterEmail.getText().toString();
        String password = enterPassword.getText().toString();

        if(db.getUser(email,password))
        {
            session.setLoggedin(true);
            startActivity(new Intent(LoginActivity.this, MainActivity.class));

            final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = app_preferences.edit();
            editor.putString("current_user", enterEmail.getText().toString());
            editor.commit();

            finish();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Wrong Email/Password!", Toast.LENGTH_SHORT).show();
        }
    }

}
