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

public class fragmentMateri6  extends Fragment implements View.OnClickListener {

    View fragmentLayout;
    LinearLayout spoilerLayout;
    public fragmentMateri6(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.activity_fragment_materi6,container,false);
        Button spoiler1 = (Button) fragmentLayout.findViewById(R.id.spoiler6_1);
        Button spoiler11 = (Button) fragmentLayout.findViewById(R.id.spoiler61_1);
        Button spoiler12 = (Button) fragmentLayout.findViewById(R.id.spoiler61_2);
        Button spoiler13 = (Button) fragmentLayout.findViewById(R.id.spoiler61_3);
        Button spoiler2 = (Button) fragmentLayout.findViewById(R.id.spoiler6_2);
        Button spoiler3 = (Button) fragmentLayout.findViewById(R.id.spoiler6_3);
        Button spoiler4 = (Button) fragmentLayout.findViewById(R.id.spoiler6_4);
        Button spoiler5 = (Button) fragmentLayout.findViewById(R.id.spoiler6_5);
        Button spoiler6 = (Button) fragmentLayout.findViewById(R.id.spoiler6_6);
        Button spoiler7 = (Button) fragmentLayout.findViewById(R.id.spoiler6_7);


        spoiler1.setOnClickListener(this); // calling onClick() method
        spoiler2.setOnClickListener(this); // calling onClick() method
        spoiler3.setOnClickListener(this); // calling onClick() method
        spoiler4.setOnClickListener(this); // calling onClick() method
        spoiler5.setOnClickListener(this); // calling onClick() method
        spoiler6.setOnClickListener(this); // calling onClick() method
        spoiler7.setOnClickListener(this); // calling onClick() method

        spoiler11.setOnClickListener(this); // calling onClick() method
        spoiler12.setOnClickListener(this); // calling onClick() method
        spoiler13.setOnClickListener(this); // calling onClick() method

        return fragmentLayout;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.spoiler6_1:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout61);
                break;
            case R.id.spoiler61_1:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout61_1);
                break;
            case R.id.spoiler61_2:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout61_2);
                break;
            case R.id.spoiler61_3:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout61_3);
                break;
            case R.id.spoiler6_2:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout62);
                break;
            case R.id.spoiler6_3:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout63);
                break;
            case R.id.spoiler6_4:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout64);
                break;
            case R.id.spoiler6_5:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout65);
                break;
            case R.id.spoiler6_6:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout66);
                break;
            case R.id.spoiler6_7:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout67);
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
