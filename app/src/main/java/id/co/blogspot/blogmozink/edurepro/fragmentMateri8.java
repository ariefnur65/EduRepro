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

public class fragmentMateri8 extends Fragment implements View.OnClickListener {

    View fragmentLayout;
    LinearLayout spoilerLayout;
    public fragmentMateri8(){}



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.activity_fragment_materi8,container,false);

        Button spoiler1 = (Button) fragmentLayout.findViewById(R.id.spoiler8_1);
        Button spoiler2 = (Button) fragmentLayout.findViewById(R.id.spoiler8_2);
        Button spoiler3 = (Button) fragmentLayout.findViewById(R.id.spoiler8_3);
        Button spoiler4 = (Button) fragmentLayout.findViewById(R.id.spoiler8_4);
        Button spoiler5 = (Button) fragmentLayout.findViewById(R.id.spoiler8_5);
        Button spoiler6 = (Button) fragmentLayout.findViewById(R.id.spoiler8_6);
        Button spoiler7 = (Button) fragmentLayout.findViewById(R.id.spoiler8_7);
        Button spoiler8 = (Button) fragmentLayout.findViewById(R.id.spoiler8_8);
        Button spoiler9 = (Button) fragmentLayout.findViewById(R.id.spoiler8_9);
        Button spoiler10 = (Button) fragmentLayout.findViewById(R.id.spoiler8_10);


        spoiler1.setOnClickListener(this); // calling onClick() method
        spoiler2.setOnClickListener(this); // calling onClick() method
        spoiler3.setOnClickListener(this); // calling onClick() method
        spoiler4.setOnClickListener(this); // calling onClick() method
        spoiler5.setOnClickListener(this); // calling onClick() method
        spoiler6.setOnClickListener(this); // calling onClick() method
        spoiler7.setOnClickListener(this); // calling onClick() method
        spoiler8.setOnClickListener(this); // calling onClick() method
        spoiler9.setOnClickListener(this); // calling onClick() method
        spoiler10.setOnClickListener(this); // calling onClick() method




        return fragmentLayout;

    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.spoiler8_1:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout81);
                break;
            case R.id.spoiler8_2:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout82);
                break;
            case R.id.spoiler8_3:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout83);
                break;
            case R.id.spoiler8_4:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout84);
                break;
            case R.id.spoiler8_5:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout85);
                break;
            case R.id.spoiler8_6:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout86);
                break;
            case R.id.spoiler8_7:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout87);
                break;
            case R.id.spoiler8_8:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout88);
                break;
            case R.id.spoiler8_9:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout89);
                break;
            case R.id.spoiler8_10:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout810);
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
