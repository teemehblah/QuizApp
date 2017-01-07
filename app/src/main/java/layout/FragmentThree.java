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


public class FragmentThree extends Fragment
{

    RadioButton falseButton3;
    Button btn3, chtbtn3, skpbtn3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_three, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        falseButton3 = (RadioButton)getView().findViewById(R.id.falseButton3);
        btn3 = (Button)getView().findViewById(R.id.submitButton3);
        chtbtn3 = (Button)getView().findViewById(R.id.cheatButton3);
        skpbtn3 = (Button)getView().findViewById(R.id.skipButton3);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        btn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {

                SharedPreferences.Editor editor = app_preferences.edit();

                if (falseButton3.isChecked() && !cheated3() && !skipped3())
                {
                    editor.putInt("answer_value3", 1);
                }

                else
                {
                    editor.putInt("answer_value3", 0);
                }

                if (cheated3() || skipped3())
                {
                    Toast.makeText(getActivity(), "You have already either cheated for, or chosen to skip Q3. No points will be scored.", Toast.LENGTH_LONG).show();
                }

                editor.commit();

                Fragment fragment = new FragmentFour();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();

            }

        });

        chtbtn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                Toast.makeText(getActivity(), "The answer is - false!", Toast.LENGTH_SHORT).show();

                editor.putBoolean("cheat_value3", true);
                editor.commit();
            }

        });

        skpbtn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                editor.putBoolean("skip_value3", true);
                editor.commit();

                Fragment fragment = new FragmentFour();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();
            }

        });

    }

    private boolean cheated3()
    {
        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (app_preferences.getBoolean("cheat_value3", true))
        {
            return true;
        }

        else
        {
            return false;
        }

    }

    private boolean skipped3()
    {
        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (app_preferences.getBoolean("skip_value3", true))
        {
            return true;
        }

        else
        {
            return false;
        }
    }

}