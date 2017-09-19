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

public class fragmentMateri4 extends Fragment {

    View fragmentLayout;
    public fragmentMateri4(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.activity_fragment_materi4,container,false);
        Button spoiler41 = (Button) fragmentLayout.findViewById(R.id.spoiler4_1);
        Button spoiler42 = (Button) fragmentLayout.findViewById(R.id.spoiler4_2);
        Button spoiler43 = (Button) fragmentLayout.findViewById(R.id.spoiler4_3);
        Button spoiler44 = (Button) fragmentLayout.findViewById(R.id.spoiler4_4);
        Button spoiler45 = (Button) fragmentLayout.findViewById(R.id.spoiler4_5);
        Button spoiler461 = (Button) fragmentLayout.findViewById(R.id.spoiler41_1);
        Button spoiler462 = (Button) fragmentLayout.findViewById(R.id.spoiler41_2);
        Button spoiler463 = (Button) fragmentLayout.findViewById(R.id.spoiler41_3);
        Button spoiler464 = (Button) fragmentLayout.findViewById(R.id.spoiler41_4);
        Button spoiler465 = (Button) fragmentLayout.findViewById(R.id.spoiler41_5);
        Button spoiler466 = (Button) fragmentLayout.findViewById(R.id.spoiler41_6);
        Button spoiler467 = (Button) fragmentLayout.findViewById(R.id.spoiler41_7);


        spoiler41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout41)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout42)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout43)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout44)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout46)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler461.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout41_1)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });
        spoiler462.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout41_2)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });
        spoiler463.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout41_3)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });
        spoiler464.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout41_4)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });
        spoiler465.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout41_5)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });
        spoiler466.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout41_6)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });


        spoiler467.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout41_7)  ;

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