package com.example.wongrachel.finalquizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity

{
    private Button logoutButton, startNewQuizButton;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new Session(this);

        if (!session.loggedin())
        {
            logout();
        }

        logoutButton = (Button) findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                logout();
            }
        });

        startNewQuizButton = (Button) findViewById(R.id.startNewQuizButton);
        startNewQuizButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startNewQuiz();
            }
        });

    }

    private void startNewQuiz()
    {
        startActivity(new Intent(MainActivity.this, QuizActivity.class));
    }

    private void logout()
    {
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}