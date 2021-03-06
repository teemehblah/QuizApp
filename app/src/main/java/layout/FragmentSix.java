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


public class FragmentSix extends Fragment
{

    RadioButton trueButton6;
    Button btn6, chtbtn6, skpbtn6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_six, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        trueButton6 = (RadioButton) getView().findViewById(R.id.trueButton6);
        btn6 = (Button) getView().findViewById(R.id.submitButton6);
        chtbtn6 = (Button) getView().findViewById(R.id.cheatButton6);
        skpbtn6 = (Button) getView().findViewById(R.id.skipButton6);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                if (trueButton6.isChecked() && !cheated6() && !skipped6())
                {
                    editor.putInt("answer_value6", 1);
                }

                else
                {
                    editor.putInt("answer_value6", 0);
                }

                if (cheated6() || skipped6())
                {
                    Toast.makeText(getActivity(), "You have already either cheated for, or chosen to skip Q6. No points will be scored.", Toast.LENGTH_LONG).show();
                }

                editor.commit();

                Fragment fragment = new FragmentSeven();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();

            }

        });

        chtbtn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                Toast.makeText(getActivity(), "The answer is - true!", Toast.LENGTH_SHORT).show();

                editor.putBoolean("cheat_value6", true);
                editor.commit();
            }

        });

        skpbtn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                editor.putBoolean("skip_value6", true);
                editor.commit();

                Fragment fragment = new FragmentSeven();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();
            }

        });

    }

    private boolean cheated6()
    {
        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (app_preferences.getBoolean("cheat_value6", true))
        {
            return true;
        }

        else
        {
            return false;
        }

    }

    private boolean skipped6()
    {
        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (app_preferences.getBoolean("skip_value6", true))
        {
            return true;
        }

        else
        {
            return false;
        }
    }
}