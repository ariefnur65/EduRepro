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

public class fragmentMateri9 extends Fragment implements View.OnClickListener {

    View fragmentLayout;
    LinearLayout spoilerLayout;
    public fragmentMateri9(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.activity_fragment_materi9,container,false);


        Button spoiler1 = (Button) fragmentLayout.findViewById(R.id.spoiler9_1);
        Button spoiler11 = (Button) fragmentLayout.findViewById(R.id.spoiler91_1);
        Button spoiler12 = (Button) fragmentLayout.findViewById(R.id.spoiler91_2);
        Button spoiler13 = (Button) fragmentLayout.findViewById(R.id.spoiler91_3);
        Button spoiler14 = (Button) fragmentLayout.findViewById(R.id.spoiler91_4);
        Button spoiler15 = (Button) fragmentLayout.findViewById(R.id.spoiler91_5);
        Button spoiler16 = (Button) fragmentLayout.findViewById(R.id.spoiler91_6);
        Button spoiler17 = (Button) fragmentLayout.findViewById(R.id.spoiler91_7);
        Button spoiler18 = (Button) fragmentLayout.findViewById(R.id.spoiler91_8);
        Button spoiler19 = (Button) fragmentLayout.findViewById(R.id.spoiler91_9);
        Button spoiler110 = (Button) fragmentLayout.findViewById(R.id.spoiler91_10);
        Button spoiler111 = (Button) fragmentLayout.findViewById(R.id.spoiler91_11);

        Button spoiler2 = (Button) fragmentLayout.findViewById(R.id.spoiler9_2);
        Button spoiler21 = (Button) fragmentLayout.findViewById(R.id.spoiler92_1);
        Button spoiler22 = (Button) fragmentLayout.findViewById(R.id.spoiler92_2);
        Button spoiler23 = (Button) fragmentLayout.findViewById(R.id.spoiler92_3);
        Button spoiler24 = (Button) fragmentLayout.findViewById(R.id.spoiler92_4);

        Button spoiler3 = (Button) fragmentLayout.findViewById(R.id.spoiler9_3);
        Button spoiler31 = (Button) fragmentLayout.findViewById(R.id.spoiler93_1);
        Button spoiler32 = (Button) fragmentLayout.findViewById(R.id.spoiler93_2);
        Button spoiler33 = (Button) fragmentLayout.findViewById(R.id.spoiler93_3);
        Button spoiler34 = (Button) fragmentLayout.findViewById(R.id.spoiler93_4);

        Button spoiler4 = (Button) fragmentLayout.findViewById(R.id.spoiler9_4);

        Button spoiler5 = (Button) fragmentLayout.findViewById(R.id.spoiler9_5);
        Button spoiler51 = (Button) fragmentLayout.findViewById(R.id.spoiler95_1);
        Button spoiler52 = (Button) fragmentLayout.findViewById(R.id.spoiler95_2);
        Button spoiler53 = (Button) fragmentLayout.findViewById(R.id.spoiler95_3);




        spoiler1.setOnClickListener(this); // calling onClick() method
        spoiler11.setOnClickListener(this);
        spoiler12.setOnClickListener(this);
        spoiler13.setOnClickListener(this);
        spoiler14.setOnClickListener(this);
        spoiler15.setOnClickListener(this);
        spoiler16.setOnClickListener(this);
        spoiler17.setOnClickListener(this);
        spoiler18.setOnClickListener(this);
        spoiler19.setOnClickListener(this);
        spoiler110.setOnClickListener(this);
        spoiler111.setOnClickListener(this);

        spoiler2.setOnClickListener(this); // calling onClick() method
        spoiler21.setOnClickListener(this);
        spoiler22.setOnClickListener(this);
        spoiler23.setOnClickListener(this);
        spoiler24.setOnClickListener(this);


        spoiler3.setOnClickListener(this); // calling onClick() method
        spoiler31.setOnClickListener(this);
        spoiler32.setOnClickListener(this);
        spoiler33.setOnClickListener(this);
        spoiler34.setOnClickListener(this);

        spoiler4.setOnClickListener(this); // calling onClick() method

        spoiler5.setOnClickListener(this); // calling onClick() method
        spoiler51.setOnClickListener(this);
        spoiler52.setOnClickListener(this);
        spoiler53.setOnClickListener(this);

        return fragmentLayout;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.spoiler9_1:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout91);
                break;
            case R.id.spoiler91_1:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout91_1);
                break;
            case R.id.spoiler91_2:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout91_2);
                break;
            case R.id.spoiler91_3:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout91_3);
                break;
            case R.id.spoiler91_4:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout91_4);
                break;
            case R.id.spoiler91_5:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout91_5);
                break;
            case R.id.spoiler91_6:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout91_6);
                break;
            case R.id.spoiler91_7:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout91_7);
                break;
            case R.id.spoiler91_8:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout91_8);
                break;
            case R.id.spoiler91_9:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout91_9);
                break;
            case R.id.spoiler91_10:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout91_10);
                break;
            case R.id.spoiler91_11:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout91_11);
                break;

            case R.id.spoiler9_2:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout92);
                break;
            case R.id.spoiler92_1:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout92_1);
                break;
            case R.id.spoiler92_2:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout92_2);
                break;
            case R.id.spoiler92_3:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout92_3);
                break;
            case R.id.spoiler92_4:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout92_4);
                break;

            case R.id.spoiler9_3:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout95);
                break;
            case R.id.spoiler93_1:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout93_1);
                break;
            case R.id.spoiler93_2:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout93_2);
                break;
            case R.id.spoiler93_3:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout93_3);
                break;
            case R.id.spoiler93_4:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout93_4);
                break;

            case R.id.spoiler9_4:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout94_1);
                break;

            case R.id.spoiler9_5:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout95);
                break;
            case R.id.spoiler95_1:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout95_1);
                break;
            case R.id.spoiler95_2:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout95_2);
                break;
            case R.id.spoiler95_3:
                spoilerLayout = fragmentLayout.findViewById(R.id.spoiler_layout95_3);
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
