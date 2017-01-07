package com.example.wongrachel.finalquizzapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class CompareActivity extends AppCompatActivity
{

    TextView current_score, high_score, low_score, previous_score, opponent_previous_score, opponent_high_score, opponent_low_score;
    int currentscore, highscore, lowscore, previousscore, opponentpreviousscore, opponenthighscore, opponentlowscore;
    private Button opponentEnterButton, compareBackButton;
    private EditText opponentEmail;
    private DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = app_preferences.edit();

        String currentuser = app_preferences.getString("current_user", null);

        current_score = (TextView)findViewById(R.id.current_score);
        currentscore = app_preferences.getInt(currentuser+"current_score", 0);
        current_score.setText(currentscore + "/8");

        high_score = (TextView)findViewById(R.id.high_score);
        highscore= app_preferences.getInt(currentuser+"high_score", 0);
        high_score.setText(highscore + "/8");

        if (currentscore < app_preferences.getInt(currentuser+"low_score", 0))
        {
            editor.putInt(currentuser+"low_score", currentscore);
        }
        low_score = (TextView)findViewById(R.id.low_score);
        lowscore= app_preferences.getInt(currentuser+"low_score", highscore);
        low_score.setText(lowscore + "/8");

        previous_score = (TextView)findViewById(R.id.previous_score);
        previousscore= app_preferences.getInt(currentuser+"previous_score", 0);
        previous_score.setText(previousscore + "/8");
        editor.putInt(currentuser+"previous_score", currentscore);

        editor.commit();

        db = new DbHelper(this);
        opponentEmail = (EditText) findViewById(R.id.enterComparisonEmail);

        opponentEnterButton = (Button) findViewById(R.id.opponentEnterButton);
        opponentEnterButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {

                String opponentemail = opponentEmail.getText().toString();

                if(!db.getUser2(opponentemail))
                {
                    Toast.makeText(getApplicationContext(), "Player Does Not Exist!", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    opponentpreviousscore = app_preferences.getInt(opponentemail+"previous_score", 0);
                    opponent_previous_score = (TextView) findViewById(R.id.opponentpreviousscore);
                    opponent_previous_score.setText(opponentpreviousscore + "/8");

                    opponenthighscore = app_preferences.getInt(opponentemail+"high_score", 0);
                    opponent_high_score = (TextView) findViewById(R.id.opponenthighscore);
                    opponent_high_score.setText(opponenthighscore + "/8");

                    opponentlowscore = app_preferences.getInt(opponentemail+"low_score", 0);
                    opponent_low_score = (TextView) findViewById(R.id.opponentlowscore);
                    opponent_low_score.setText(opponentlowscore + "/8");
                }
            }
        });

        compareBackButton = (Button) findViewById(R.id.compareBackButton);
        compareBackButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                startActivity(new Intent(CompareActivity.this, ScoreActivity.class));
            }
        });
    }

}