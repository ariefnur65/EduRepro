package id.co.blogspot.blogmozink.edurepro;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class fragmentMateri2 extends Fragment {
    View fragmentLayout;
    public fragmentMateri2(){}

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

         fragmentLayout = inflater.inflate(R.layout.activity_fragment_materi2,container,false);
        Button spoiler21 = (Button) fragmentLayout.findViewById(R.id.spoiler2_1);
        Button spoiler211 = (Button) fragmentLayout.findViewById(R.id.spoiler2_11);
        Button spoiler212 = (Button) fragmentLayout.findViewById(R.id.spoiler2_12);
        Button spoiler213 = (Button) fragmentLayout.findViewById(R.id.spoiler2_13);
        Button spoiler214 = (Button) fragmentLayout.findViewById(R.id.spoiler2_14);

        spoiler211.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout211)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });
        spoiler212.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout212)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });
        spoiler213.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout213)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });
        spoiler214.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout214)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });



        spoiler21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout21)  ;

                    if(spoilerLayout.getVisibility() == View.VISIBLE){
                        spoilerLayout.setVisibility(View.GONE);
                    }
                    else
                    {
                        spoilerLayout.setVisibility(View.VISIBLE);
                    }
                }

        });
        Button spoiler22 = (Button) fragmentLayout.findViewById(R.id.spoiler2_2);
        spoiler22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout22)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });


        Button spoiler23 = (Button) fragmentLayout.findViewById(R.id.spoiler2_3);

        spoiler23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout23)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });
        return fragmentLayout;
    }

}
