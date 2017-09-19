package id.co.blogspot.blogmozink.edurepro;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class fragmentMateri7  extends Fragment implements View.OnClickListener {

    View fragmentLayout;
    LinearLayout spoilerLayout;
    public fragmentMateri7(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.activity_fragment_materi7,container,false);
        Button spoiler1 = (Button) fragmentLayout.findViewById(R.id.spoiler7_1);
        Button spoiler11 = (Button) fragmentLayout.findViewById(R.id.spoiler75_1);
        Button spoiler12 = (Button) fragmentLayout.findViewById(R.id.spoiler75_2);
        Button spoiler13 = (Button) fragmentLayout.findViewById(R.id.spoiler75_3);
        Button spoiler2 = (Button) fragmentLayout.findViewById(R.id.spoiler7_2);
        Button spoiler3 = (Button) fragmentLayout.findViewById(R.id.spoiler7_3);
        Button spoiler4 = (Button) fragmentLayout.findViewById(R.id.spoiler7_4);
        Button spoiler5 = (Button) fragmentLayout.findViewById(R.id.spoiler7_5);
        Button spoiler6 = (Button) fragmentLayout.findViewById(R.id.spoiler7_6);


        spoiler1.setOnClickListener(this); // calling onClick() method
        spoiler2.setOnClickListener(this); // calling onClick() method
        spoiler3.setOnClickListener(this); // calling onClick() method
        spoiler4.setOnClickListener(this); // calling onClick() method
        spoiler5.setOnClickListener(this); // calling onClick() method
        spoiler6.setOnClickListener(this); // calling onClick() method

        spoiler11.setOnClickListener(this); // calling onClick() method
        spoiler12.setOnClickListener(this); // calling onClick() method
        spoiler13.setOnClickListener(this); // calling onClick() method


        return fragmentLayout;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.spoiler7_1:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout71);
                break;
            case R.id.spoiler75_1:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout75_1);
                break;
            case R.id.spoiler75_2:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout75_2);
                break;
            case R.id.spoiler75_3:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout75_3);
                break;
            case R.id.spoiler7_2:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout72);
                break;
            case R.id.spoiler7_3:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout73);
                break;
            case R.id.spoiler7_4:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout74);
                break;
            case R.id.spoiler7_5:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout75);
                break;
            case R.id.spoiler7_6:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout76);
                break;

        }


        if(spoilerLayout.getVisibility() == View.VISIBLE){
            spoilerLayout.setVisibility(View.GONE);
        }
        else
        {
            spoilerLayout.setVisibility(View.VISIBLE);
        }
    }
}