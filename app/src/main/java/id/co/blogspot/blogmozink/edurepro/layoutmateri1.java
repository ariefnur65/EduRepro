package id.co.blogspot.blogmozink.edurepro;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class layoutmateri1 extends AppCompatActivity {
    Animation myAnim;
    Intent bukaKuis;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layoutmateri1);

        myAnim = AnimationUtils.loadAnimation(this,R.anim.grind);
        intentInitialize = false;

        Intent intent = getIntent();
        MateriActivity.FragmentToLaunch fragmentToLaunch = (MateriActivity.FragmentToLaunch)
                intent.getSerializableExtra(getString(R.string.MateriFragment));

        Button mulaiKuis = (Button) findViewById(R.id.mainKuis);

        FragmentManager fragmentManager = getSupportFragmentManager();
        //Fragment transaction pakenya support.v4.app.fragmenttransaction
        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
        switch (fragmentToLaunch){
            case Materi1:
                fragmentMateri1 fragMateri1 = new fragmentMateri1();
                fragmentTransaction.add(R.id.fragment_container, fragMateri1,"MATERI_1_FRAGMENT");
                bukaKuis = new Intent(getApplicationContext(), KuisAKU.class);
                bukaKuis.putExtra(getString(R.string.KuisFragment), menuKuisActivity.FragmentToLaunch.Materi1);
                break;
            case Materi2:
                fragmentMateri2 fragMateri2 = new fragmentMateri2();
                fragmentTransaction.add(R.id.fragment_container, fragMateri2,"MATERI_2_FRAGMENT");
                bukaKuis = new Intent(getApplicationContext(), KuisAKU.class);
                bukaKuis.putExtra(getString(R.string.KuisFragment), menuKuisActivity.FragmentToLaunch.Materi2);
                break;

            case Materi3:
                fragmentMateri3 fragMateri3 = new fragmentMateri3();
                fragmentTransaction.add(R.id.fragment_container, fragMateri3,"MATERI_3_FRAGMENT");
                bukaKuis = new Intent(getApplicationContext(), KuisAKU.class);
                bukaKuis.putExtra(getString(R.string.KuisFragment), menuKuisActivity.FragmentToLaunch.Materi3);
                break;
            case Materi4:
                fragmentMateri4 fragMateri4 = new fragmentMateri4();
                fragmentTransaction.add(R.id.fragment_container, fragMateri4,"MATERI_4_FRAGMENT");
                bukaKuis = new Intent(getApplicationContext(), KuisAKU.class);
                bukaKuis.putExtra(getString(R.string.KuisFragment), menuKuisActivity.FragmentToLaunch.Materi4);
                break;
            case Materi5:
                fragmentMateri5 fragMateri5 = new fragmentMateri5();
                fragmentTransaction.add(R.id.fragment_container, fragMateri5,"MATERI_5_FRAGMENT");
                bukaKuis = new Intent(getApplicationContext(), KuisAKU.class);
                bukaKuis.putExtra(getString(R.string.KuisFragment), menuKuisActivity.FragmentToLaunch.Materi5);
                break;
            case Materi6:
                fragmentMateri6 fragMateri6 = new fragmentMateri6();
                fragmentTransaction.add(R.id.fragment_container, fragMateri6,"MATERI_6_FRAGMENT");
                bukaKuis = new Intent(getApplicationContext(), KuisAKU.class);
                bukaKuis.putExtra(getString(R.string.KuisFragment), menuKuisActivity.FragmentToLaunch.Materi6);
                break;
            case Materi7:
                fragmentMateri7 fragMateri7 = new fragmentMateri7();
                fragmentTransaction.add(R.id.fragment_container, fragMateri7,"MATERI_7_FRAGMENT");
                bukaKuis = new Intent(getApplicationContext(), KuisAKU.class);
                bukaKuis.putExtra(getString(R.string.KuisFragment), menuKuisActivity.FragmentToLaunch.Materi7);
                break;
            case Materi8:
                fragmentMateri8 fragMateri8 = new fragmentMateri8();
                fragmentTransaction.add(R.id.fragment_container, fragMateri8,"MATERI_8_FRAGMENT");
                bukaKuis = new Intent(getApplicationContext(), KuisAKU.class);
                bukaKuis.putExtra(getString(R.string.KuisFragment), menuKuisActivity.FragmentToLaunch.Materi8);
                break;

            case Materi9:
                fragmentMateri9 fragMateri9 = new fragmentMateri9();
                fragmentTransaction.add(R.id.fragment_container, fragMateri9,"MATERI_9_FRAGMENT");
                bukaKuis = new Intent(getApplicationContext(), KuisAKU.class);
                bukaKuis.putExtra(getString(R.string.KuisFragment), menuKuisActivity.FragmentToLaunch.Materi9);
                break;

        }

        mulaiKuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentInitialize = true;
                startActivity(bukaKuis);
                view.startAnimation(myAnim);
            }
        });

        fragmentTransaction.commit();
        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout


//        if (findViewById(R.id.fragment_container) != null) {
//
//            // However, if we're being restored from a previous state,
//            // then we don't need to do anything and should return or else
//            // we could end up with overlapping fragments.
//            if (savedInstanceState != null) {
//                return;
//            }
//
//            // Create a new Fragment to be placed in the activity layout
//            fragmentMateri2 firstFragment = new fragmentMateri2();
//
//            // In case this activity was started with special instructions from an
//            // Intent, pass the Intent's extras to the fragment as arguments
//            firstFragment.setArguments(getIntent().getExtras());
//
//            // Add the fragment to the 'fragment_container' FrameLayout
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.fragment_container, firstFragment).commit();
//        }
    }

    public void openMain(View v){
        v.startAnimation(myAnim);
        Intent intent;
        intent = new Intent(getApplicationContext(), MateriActivity.class);
        intentInitialize = true;
        startActivity(intent);

    }
    public void homeMain (View v){
        v.startAnimation(myAnim);
        Intent intent;
        intent = new Intent(getApplicationContext(), MainActivity.class);
        intentInitialize = true;
        startActivity(intent);

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MateriActivity.class);
        intentInitialize = true;
        startActivity(intent);
    }

    Boolean intentInitialize;

    @Override
    protected void onResume() {
        soundManager.resume();
        intentInitialize = false;
        super.onResume();

    }

    @Override
    protected void onPause() {
        if(!intentInitialize){
            soundManager.pause();
        }

        super.onPause();
    }

}
