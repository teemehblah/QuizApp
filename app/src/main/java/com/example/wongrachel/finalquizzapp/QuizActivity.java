package com.example.wongrachel.finalquizzapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import layout.FragmentOne;
import layout.FragmentTwo;
import layout.FragmentThree;
import layout.FragmentFour;
import layout.FragmentFive;
import layout.FragmentSix;
import layout.FragmentSeven;
import layout.FragmentEight;


public class QuizActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        resetQuiz();
    }

    public void ChangeFragment(View view)
    {
        Fragment frag;

        if (view == findViewById(R.id.q1button))
        {
            frag = new FragmentOne();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, frag);
            ft.commit();
        }

        if (view == findViewById(R.id.q2button))
        {
            frag = new FragmentTwo();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, frag);
            ft.commit();
        }

        if (view == findViewById(R.id.q3button))
        {
            frag = new FragmentThree();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, frag);
            ft.commit();
        }

        if (view == findViewById(R.id.q4button))
        {
            frag = new FragmentFour();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, frag);
            ft.commit();
        }

        if (view == findViewById(R.id.q5button))
        {
            frag = new FragmentFive();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, frag);
            ft.commit();
        }

        if (view == findViewById(R.id.q6button))
        {
            frag = new FragmentSix();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, frag);
            ft.commit();
        }

        if (view == findViewById(R.id.q7button))
        {
            frag = new FragmentSeven();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, frag);
            ft.commit();
        }

        if (view == findViewById(R.id.q8button))
        {
            frag = new FragmentEight();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, frag);
            ft.commit();
        }

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

}
