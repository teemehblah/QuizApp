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


public class FragmentFour extends Fragment
{

    RadioButton trueButton4;
    Button btn4, chtbtn4, skpbtn4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_four, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        trueButton4 = (RadioButton) getView().findViewById(R.id.trueButton4);
        btn4 = (Button) getView().findViewById(R.id.submitButton4);
        chtbtn4 = (Button) getView().findViewById(R.id.cheatButton4);
        skpbtn4 = (Button) getView().findViewById(R.id.skipButton4);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                if (trueButton4.isChecked() && !cheated4() && !skipped4())
                {
                    editor.putInt("answer_value4", 1);
                }

                else
                {
                    editor.putInt("answer_value4", 0);
                }

                if (cheated4() || skipped4())
                {
                    Toast.makeText(getActivity(), "You have already either cheated for, or chosen to skip Q4. No points will be scored.", Toast.LENGTH_LONG).show();
                }

                editor.commit();

                Fragment fragment = new FragmentFive();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();

            }

        });

        chtbtn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                Toast.makeText(getActivity(), "The answer is - true!", Toast.LENGTH_SHORT).show();

                editor.putBoolean("cheat_value4", true);
                editor.commit();
            }

        });

        skpbtn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                editor.putBoolean("skip_value4", true);
                editor.commit();

                Fragment fragment = new FragmentFive();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();
            }

        });

    }

    private boolean cheated4()
    {
        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (app_preferences.getBoolean("cheat_value4", true))
        {
            return true;
        }

        else
        {
            return false;
        }

    }

    private boolean skipped4()
    {
        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (app_preferences.getBoolean("skip_value4", true))
        {
            return true;
        }

        else
        {
            return false;
        }
    }
}

