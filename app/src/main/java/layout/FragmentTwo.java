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


public class FragmentTwo extends Fragment
{

    RadioButton falseButton2;
    Button btn2, chtbtn2, skpbtn2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_two, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        falseButton2 = (RadioButton)getView().findViewById(R.id.falseButton2);
        chtbtn2 = (Button)getView().findViewById(R.id.cheatButton2);
        btn2 = (Button)getView().findViewById(R.id.submitButton2);
        skpbtn2 = (Button)getView().findViewById(R.id.skipButton2);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                if (falseButton2.isChecked() && !cheated2() && !skipped2())
                {
                    editor.putInt("answer_value2", 1);
                }

                else
                {
                    editor.putInt("answer_value2", 0);
                }

                if (cheated2() || skipped2())
                {
                    Toast.makeText(getActivity(), "You have already either cheated for, or chosen to skip Q2. No points will be scored.", Toast.LENGTH_LONG).show();
                }

                editor.commit();

                Fragment fragment = new FragmentThree();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();

            }

        });

        chtbtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                Toast.makeText(getActivity(), "The answer is - false!", Toast.LENGTH_SHORT).show();

                editor.putBoolean("cheat_value2", true);
                editor.commit();
            }

        });

        skpbtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                editor.putBoolean("skip_value2", true);
                editor.commit();

                Fragment fragment = new FragmentThree();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();
            }

        });

    }

    private boolean cheated2()
    {
        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (app_preferences.getBoolean("cheat_value2", true))
        {
            return true;
        }

        else
        {
            return false;
        }

    }

    private boolean skipped2()
    {
        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (app_preferences.getBoolean("skip_value2", true))
        {
            return true;
        }

        else
        {
            return false;
        }
    }

}










