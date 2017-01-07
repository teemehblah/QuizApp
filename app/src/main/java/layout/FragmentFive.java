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


public class FragmentFive extends Fragment
{

    RadioButton falseButton5;
    Button btn5, chtbtn5, skpbtn5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_five, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        falseButton5 = (RadioButton) getView().findViewById(R.id.falseButton5);
        btn5 = (Button) getView().findViewById(R.id.submitButton5);
        chtbtn5 = (Button) getView().findViewById(R.id.cheatButton5);
        skpbtn5 = (Button) getView().findViewById(R.id.skipButton5);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                if (falseButton5.isChecked() && !cheated5() && !skipped5())
                {
                    editor.putInt("answer_value5", 1);
                }

                else
                {
                    editor.putInt("answer_value5", 0);
                }

                if (cheated5() || skipped5())
                {
                    Toast.makeText(getActivity(), "You have already either cheated for, or chosen to skip Q5. No points will be scored.", Toast.LENGTH_LONG).show();
                }

                editor.commit();

                Fragment fragment = new FragmentSix();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();

            }

        });

        chtbtn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                Toast.makeText(getActivity(), "The answer is - false!", Toast.LENGTH_SHORT).show();

                editor.putBoolean("cheat_value5", true);
                editor.commit();
            }

        });

        skpbtn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                editor.putBoolean("skip_value5", true);
                editor.commit();

                Fragment fragment = new FragmentSix();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();
            }

        });

    }

    private boolean cheated5()
    {
        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (app_preferences.getBoolean("cheat_value5", true))
        {
            return true;
        }

        else
        {
            return false;
        }

    }

    private boolean skipped5()
    {
        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (app_preferences.getBoolean("skip_value5", true))
        {
            return true;
        }

        else
        {
            return false;
        }
    }
}
