package layout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.wongrachel.finalquizzapp.R;
import com.example.wongrachel.finalquizzapp.ScoreActivity;

public class FragmentEight extends Fragment
{

    RadioButton falseButton8;
    Button btn8, chtbtn8, skpbtn8;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_eight, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        falseButton8 = (RadioButton) getView().findViewById(R.id.falseButton8);
        chtbtn8 = (Button) getView().findViewById(R.id.cheatButton8);
        btn8 = (Button) getView().findViewById(R.id.submitButton8);
        skpbtn8 = (Button) getView().findViewById(R.id.skipButton8);

        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                if (falseButton8.isChecked() && !cheated8() && !skipped8())
                {
                    editor.putInt("answer_value8", 1);
                }

                else
                {
                    editor.putInt("answer_value8", 0);
                }

                if (cheated8() || skipped8())
                {
                    Toast.makeText(getActivity(), "You have already either cheated for, or chosen to skip Q8. No points will be scored.", Toast.LENGTH_LONG).show();
                }

                editor.commit();

                Intent i = new Intent(getActivity(), ScoreActivity.class);
                startActivity(i);

            }

        });

        chtbtn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                Toast.makeText(getActivity(), "The answer is - false!", Toast.LENGTH_SHORT).show();

                editor.putBoolean("cheat_value8", true);
                editor.commit();
            }

        });

        skpbtn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SharedPreferences.Editor editor = app_preferences.edit();

                editor.putBoolean("skip_value8", true);
                editor.commit();

                Intent i = new Intent(getActivity(), ScoreActivity.class);
                startActivity(i);
            }

        });

    }

    private boolean cheated8()
    {
        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (app_preferences.getBoolean("cheat_value8", true))
        {
            return true;
        }

        else
        {
            return false;
        }

    }

    private boolean skipped8()
    {
        final SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        if (app_preferences.getBoolean("skip_value8", true))
        {
            return true;
        }

        else
        {
            return false;
        }
    }

}

