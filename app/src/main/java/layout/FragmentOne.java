package layout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.wongrachel.finalquizzapp.R;

public class FragmentOne extends Fragment
{
    RadioButton falseButton1;
    Button btn1, chtbtn1, skpbtn1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_one, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        falseButton1 = (RadioButton) getView().findViewById(R.id.falseButton1);
        chtbtn1 = (Button) getView().findViewById(R.id.cheatButton1);
        btn1 = (Button) getView().findViewById(R.id.submitButton1);
        skpbtn1 = (Button) getView().findViewById(R.id.skipButton1);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                if (falseButton1.isChecked() && !cheated1() && !skipped1())
                {
                    editor.putInt("answer_value", 1);
                }

                else
                {
                    editor.putInt("answer_value", 0);
                }

                if (cheated1() || skipped1())
                {
                    Toast.makeText(getActivity(), "You have already either cheated for, or chosen to skip Q1. No points will be scored.", Toast.LENGTH_LONG).show();
                }

                editor.commit();

                Fragment fragment = new FragmentTwo();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();

            }

        });

        chtbtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                Toast.makeText(getActivity(), "The answer is - false!", Toast.LENGTH_SHORT).show();

                editor.putBoolean("cheat_value", true);
                editor.commit();
            }

        });

        skpbtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                editor.putBoolean("skip_value", true);
                editor.commit();

                Fragment fragment = new FragmentTwo();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();
            }

        });

    }

    private boolean cheated1()
    {
        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (app_preferences.getBoolean("cheat_value", true))
        {
            return true;
        }

        else
        {
            return false;
        }

    }

    private boolean skipped1()
    {
        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (app_preferences.getBoolean("skip_value", true))
        {
            return true;
        }

        else
        {
            return false;
        }
    }

}



