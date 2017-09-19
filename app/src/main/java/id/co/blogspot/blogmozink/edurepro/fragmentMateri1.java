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

public class fragmentMateri1 extends Fragment {
    View fragmentLayout;

    public fragmentMateri1(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.activity_fragment_materi1,container,false);


        Button spoiler11 = (Button) fragmentLayout.findViewById(R.id.spoiler1_1);

        spoiler11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout11)  ;

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
