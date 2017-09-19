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

public class fragmentMateri3 extends Fragment {

    View fragmentLayout;
    public fragmentMateri3(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.activity_fragment_materi3,container,false);
        Button spoiler31 = (Button) fragmentLayout.findViewById(R.id.spoiler3_1);
        Button spoiler32 = (Button) fragmentLayout.findViewById(R.id.spoiler3_2);
        Button spoiler33 = (Button) fragmentLayout.findViewById(R.id.spoiler3_3);
        Button spoiler34 = (Button) fragmentLayout.findViewById(R.id.spoiler3_4);
        Button spoiler35 = (Button) fragmentLayout.findViewById(R.id.spoiler3_5);
        Button spoiler36 = (Button) fragmentLayout.findViewById(R.id.spoiler3_6);

        spoiler31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout31)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout32)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout33)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout34)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout35)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout36)  ;

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
