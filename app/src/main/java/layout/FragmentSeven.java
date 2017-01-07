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

public class FragmentSeven extends Fragment
{

    RadioButton falseButton7;
    Button btn7, chtbtn7, skpbtn7;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_seven, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        falseButton7 = (RadioButton) getView().findViewById(R.id.falseButton7);
        chtbtn7 = (Button) getView().findViewById(R.id.cheatButton7);
        btn7 = (Button) getView().findViewById(R.id.submitButton7);
        skpbtn7 = (Button) getView().findViewById(R.id.skipButton7);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                if (falseButton7.isChecked() && !cheated7() && !skipped7())
                {
                    editor.putInt("answer_value7", 1);
                }

                else
                {
                    editor.putInt("answer_value7", 0);
                }

                if (cheated7() || skipped7())
                {
                    Toast.makeText(getActivity(), "You have already either cheated for, or chosen to skip Q7. No points will be scored.", Toast.LENGTH_LONG).show();
                }


                editor.commit();

                Fragment fragment = new FragmentEight();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();

            }

        });

        chtbtn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                Toast.makeText(getActivity(), "The answer is - false!", Toast.LENGTH_SHORT).show();

                editor.putBoolean("cheat_value7", true);
                editor.commit();
            }

        });

        skpbtn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                editor.putBoolean("skip_value7", true);
                editor.commit();

                Fragment fragment = new FragmentEight();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_place, fragment);
                ft.commit();
            }

        });

    }

    private boolean cheated7()
    {
        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (app_preferences.getBoolean("cheat_value7", true))
        {
            return true;
        }

        else
        {
            return false;
        }

    }

    private boolean skipped7()
    {
        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (app_preferences.getBoolean("skip_value7", true))
        {
            return true;
        }

        else
        {
            return false;
        }
    }

}