package com.example.wongrachel.finalquizzapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import layout.FragmentEightExplanation;
import layout.FragmentFiveExplanation;
import layout.FragmentFourExplanation;
import layout.FragmentOneExplanation;
import layout.FragmentSevenExplanation;
import layout.FragmentSixExplanation;
import layout.FragmentThreeExplanation;
import layout.FragmentTwoExplanation;


public class ScoreActivity extends AppCompatActivity
{

    TextView q1_score, q2_score, q3_score, q4_score, q5_score, q6_score, q7_score, q8_score, final_score;
    int finalscore;
    private Button endQuizButton, seeScoresButton;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        initControls();

        seeScoresButton = (Button) findViewById(R.id.seeScoresButton);
        seeScoresButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                startActivity(new Intent(ScoreActivity.this, CompareActivity.class));
            }
        });

        endQuizButton = (Button) findViewById(R.id.endQuizButton);
        endQuizButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                finish();
                resetQuiz();
                startActivity(new Intent(ScoreActivity.this, MainActivity.class));
            }
        });

    }

    public void onStart()
    {
        super.onStart();
    }

    public void initControls()
    {
        q1_score = (TextView)findViewById(R.id.q1_score);
        q2_score = (TextView)findViewById(R.id.q2_score);
        q3_score = (TextView)findViewById(R.id.q3_score);
        q4_score = (TextView)findViewById(R.id.q4_score);
        q5_score = (TextView)findViewById(R.id.q5_score);
        q6_score = (TextView)findViewById(R.id.q6_score);
        q7_score = (TextView)findViewById(R.id.q7_score);
        q8_score = (TextView)findViewById(R.id.q8_score);

        final_score = (TextView)findViewById(R.id.final_score);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);

        int q1answer = app_preferences.getInt("answer_value", 0);
        int q2answer = app_preferences.getInt("answer_value2", 0);
        int q3answer = app_preferences.getInt("answer_value3", 0);
        int q4answer = app_preferences.getInt("answer_value4", 0);
        int q5answer = app_preferences.getInt("answer_value5", 0);
        int q6answer = app_preferences.getInt("answer_value6", 0);
        int q7answer = app_preferences.getInt("answer_value7", 0);
        int q8answer = app_preferences.getInt("answer_value8", 0);

        if (q1answer == 1)
        {
            q1_score.setText("Correct");
        }
        else if (app_preferences.getBoolean("cheat_value", true))
        {
            q1_score.setText("Cheated");
        }
        else if (app_preferences.getBoolean("skip_value", true))
        {
            q1_score.setText("Skipped");
        }
        else
        {
            q1_score.setText("Incorrect");
        }

        if (q2answer == 1)
        {
            q2_score.setText("Correct");
        }
        else if (app_preferences.getBoolean("cheat_value2", true))
        {
            q2_score.setText("Cheated");
        }
        else if (app_preferences.getBoolean("skip_value2", true))
        {
            q2_score.setText("Skipped");
        }
        else
        {
            q2_score.setText("Incorrect");
        }

        if (q3answer == 1)
        {
            q3_score.setText("Correct");
        }
        else if (app_preferences.getBoolean("cheat_value3", true))
        {
            q3_score.setText("Cheated");
        }
        else if (app_preferences.getBoolean("skip_value3", true))
        {
            q3_score.setText("Skipped");
        }
        else
        {
            q3_score.setText("Incorrect");
        }

        if (q4answer == 1)
        {
            q4_score.setText("Correct");
        }
        else if (app_preferences.getBoolean("cheat_value4", true))
        {
            q4_score.setText("Cheated");
        }
        else if (app_preferences.getBoolean("skip_value4", true))
        {
            q4_score.setText("Skipped");
        }
        else
        {
            q4_score.setText("Incorrect");
        }

        if (q5answer == 1)
        {
            q5_score.setText("Correct");
        }
        else if (app_preferences.getBoolean("cheat_value5", true))
        {
            q5_score.setText("Cheated");
        }
        else if (app_preferences.getBoolean("skip_value5", true))
        {
            q5_score.setText("Skipped");
        }
        else
        {
            q5_score.setText("Incorrect");
        }

        if (q6answer == 1)
        {
            q6_score.setText("Correct");
        }
        else if (app_preferences.getBoolean("cheat_value6", true))
        {
            q6_score.setText("Cheated");
        }
        else if (app_preferences.getBoolean("skip_value6", true))
        {
            q6_score.setText("Skipped");
        }
        else
        {
            q6_score.setText("Incorrect");
        }

        if (q7answer == 1)
        {
            q7_score.setText("Correct");
        }
        else if (app_preferences.getBoolean("cheat_value7", true))
        {
            q7_score.setText("Cheated");
        }
        else if (app_preferences.getBoolean("skip_value7", true))
        {
            q7_score.setText("Skipped");
        }
        else
        {
            q7_score.setText("Incorrect");
        }

        if (q8answer == 1)
        {
            q8_score.setText("Correct");
        }
        else if (app_preferences.getBoolean("cheat_value8", true))
        {
            q8_score.setText("Cheated");
        }
        else if (app_preferences.getBoolean("skip_value8", true))
        {
            q8_score.setText("Skipped");
        }
        else
        {
            q8_score.setText("Incorrect");
        }

        finalscore = q1answer + q2answer + q3answer + q4answer + q5answer + q6answer + q7answer + q8answer;

        final_score.setText(finalscore + "/8");

        SharedPreferences.Editor editor = app_preferences.edit();

        String currentuser = app_preferences.getString("current_user", null);

        editor.putInt(currentuser+"current_score", finalscore);

        int currentuser_highscore = app_preferences.getInt(currentuser+"high_score", 0);
        if (finalscore > currentuser_highscore)
        {
            editor.putInt(currentuser+"high_score", finalscore);
        }

        int currentuser_lowscore = app_preferences.getInt(currentuser+"low_score", finalscore);
        if (finalscore <= currentuser_lowscore) {
            editor.putInt(currentuser+"low_score", finalscore);
        }

        editor.commit();

    }

    private void resetQuiz()
    {
        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = app_preferences.edit();

        editor.putInt("answer_value", 0);
        editor.putInt("answer_value2", 0);
        editor.putInt("answer_value3", 0);
        editor.putInt("answer_value4", 0);
        editor.putInt("answer_value5", 0);
        editor.putInt("answer_value6", 0);
        editor.putInt("answer_value7", 0);
        editor.putInt("answer_value8", 0);

        editor.putBoolean("cheat_value", false);
        editor.putBoolean("cheat_value2", false);
        editor.putBoolean("cheat_value3", false);
        editor.putBoolean("cheat_value4", false);
        editor.putBoolean("cheat_value5", false);
        editor.putBoolean("cheat_value6", false);
        editor.putBoolean("cheat_value7", false);
        editor.putBoolean("cheat_value8", false);

        editor.putBoolean("skip_value", false);
        editor.putBoolean("skip_value2", false);
        editor.putBoolean("skip_value3", false);
        editor.putBoolean("skip_value4", false);
        editor.putBoolean("skip_value5", false);
        editor.putBoolean("skip_value6", false);
        editor.putBoolean("skip_value7", false);
        editor.putBoolean("skip_value8", false);

        editor.commit();

    }

    public void ChangeFragment(View view)
    {
        Fragment exp;

        if (view == findViewById(R.id.q1explainbtn))
        {
            exp = new FragmentOneExplanation();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, exp);
            ft.commit();
        }

        if (view == findViewById(R.id.q2explainbtn))
        {
            exp = new FragmentTwoExplanation();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, exp);
            ft.commit();
        }

        if (view == findViewById(R.id.q3explainbtn))
        {
            exp = new FragmentThreeExplanation();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, exp);
            ft.commit();
        }

        if (view == findViewById(R.id.q4explainbtn))
        {
            exp = new FragmentFourExplanation();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, exp);
            ft.commit();
        }

        if (view == findViewById(R.id.q5explainbtn))
        {
            exp = new FragmentFiveExplanation();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, exp);
            ft.commit();
        }

        if (view == findViewById(R.id.q6explainbtn))
        {
            exp = new FragmentSixExplanation();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, exp);
            ft.commit();
        }

        if (view == findViewById(R.id.q7explainbtn))
        {
            exp = new FragmentSevenExplanation();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, exp);
            ft.commit();
        }

        if (view == findViewById(R.id.q8explainbtn))
        {
            exp = new FragmentEightExplanation();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, exp);
            ft.commit();
        }

    }

}