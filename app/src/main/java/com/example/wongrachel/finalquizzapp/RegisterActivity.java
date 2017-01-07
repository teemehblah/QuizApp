package com.example.wongrachel.finalquizzapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener

{

    private Button reg;
    private TextView tvLogin;
    private EditText enterEmail, enterPassword;
    private DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DbHelper(this);
        reg = (Button) findViewById(R.id.registerButton);
        tvLogin = (TextView) findViewById(R.id.tvLogin);
        enterEmail = (EditText) findViewById(R.id.enterEmail);
        enterPassword = (EditText) findViewById(R.id.enterPassword);
        reg.setOnClickListener(this);
        tvLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.registerButton:
                register();
                break;

            case R.id.tvLogin:
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
                break;

            default:

        }
    }

    private void register()
    {
        String email = enterEmail.getText().toString();
        String password = enterPassword.getText().toString();

        if(email.isEmpty() || password.isEmpty())
        {
            displayToast("Email/Password Field Empty!");
        }
        else if(db.getUser2(email))
        {
            displayToast("User Already Registered!");
        }
        else
        {
            db.addUser(email,password);
            displayToast("User Registered!");
            finish();
        }
    }

    private void displayToast(String message)
    {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}