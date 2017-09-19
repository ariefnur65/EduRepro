package id.co.blogspot.blogmozink.edurepro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class KuisAKU extends AppCompatActivity {
    Animation myAnim;

    TextView namaAkun;
    public TextView life;
    public TextView skore;
    public ImageView levelImage;

    LinkedList<Drawable> level = new LinkedList<Drawable>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_aku);
        intentInitialize = false;
        myAnim = AnimationUtils.loadAnimation(this,R.anim.grind);

        Intent intent = getIntent();
        menuKuisActivity.FragmentToLaunch fragmentToLaunch = (menuKuisActivity.FragmentToLaunch)
                intent.getSerializableExtra(getString(R.string.KuisFragment));
        namaAkun = (TextView) findViewById(R.id.akun);
        life = (TextView) findViewById(R.id.life);
        skore = (TextView) findViewById(R.id.score);

        levelImage  = (ImageView) findViewById(R.id.level);




        FragmentManager fragmentManager = getSupportFragmentManager();
        //Fragment transaction pakenya support.v4.app.fragmenttransaction
        FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
        cekProfil();
        switch (fragmentToLaunch){
            case Materi1:
                fragmentKuis1 fragMateri1 = new fragmentKuis1();
                fragmentTransaction.add(R.id.fragment_kuis, fragMateri1,"KUIS_1_FRAGMENT");
                break;
            case Materi2:
                fragmentKuis2 fragMateri2 = new fragmentKuis2();
                fragmentTransaction.add(R.id.fragment_kuis, fragMateri2,"KUIS_2_FRAGMENT");
                break;

            case Materi3:
                fragmentKuis3 fragMateri3 = new fragmentKuis3();
                fragmentTransaction.add(R.id.fragment_kuis, fragMateri3,"KUIS_3_FRAGMENT");
                break;

            case Materi4:
                fragmentKuis4 fragMateri4 = new fragmentKuis4();
                fragmentTransaction.add(R.id.fragment_kuis, fragMateri4,"KUIS_4_FRAGMENT");
                break;
            case Materi5:
                fragmentKuis5 fragMateri5 = new fragmentKuis5();
                fragmentTransaction.add(R.id.fragment_kuis, fragMateri5,"KUIS_5_FRAGMENT");
                break;
            case Materi6:
                fragmentKuis6 fragMateri6 = new fragmentKuis6();
                fragmentTransaction.add(R.id.fragment_kuis, fragMateri6,"KUIS_6_FRAGMENT");
                break;
            case Materi7:
                fragmentKuis7 fragMateri7 = new fragmentKuis7();
                fragmentTransaction.add(R.id.fragment_kuis, fragMateri7,"KUIS_7_FRAGMENT");
                break;
            case Materi8:
                fragmentKuis8 fragMateri8 = new fragmentKuis8();
                fragmentTransaction.add(R.id.fragment_kuis, fragMateri8,"KUIS_8_FRAGMENT");
                break;

            case Materi9:
                fragmentKuis9 fragMateri9 = new fragmentKuis9();
                fragmentTransaction.add(R.id.fragment_kuis, fragMateri9,"KUIS_9_FRAGMENT");
                break;



        }

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



    public void cekProfil(){
        SharedPreferences userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = userData.edit();
        Integer score = userData.getInt(getString(R.string.QUIZ_AKU_SCORE), 0);
        Integer nyawa = userData.getInt(getString(R.string.QUIZ_AKU_NYAWA), 0);
        int levelku = userData.getInt(getString(R.string.QUIZ_AKU_LEVEL), 0);
        String namaTersimpan = userData.getString(getString(R.string.QUIZ_AKU_USERNAME),"0");


        life.setText(nyawa.toString());
        skore.setText(score.toString());

        switch (levelku)
        {
            case 0:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level1kuisaku, null));
                break;
            case 1:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level2kuisaku, null));
                break;
            case 2:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level3kuisaku, null));
                break;
            case 3:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level4kuisaku, null));
                break;
            case 4:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level5kuisaku, null));
                break;
            case 5:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level6kuisaku, null));
                break;
            case 6:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level7kuisaku, null));
                break;
            case 7:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level8kuisaku, null));
                break;
            case 8:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.level9kuisaku, null));
                break;
            default:
                levelImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.leveldewa, null));
                break;
        }


//        levelImage.setImageDrawable(level.get(levelku));
        namaAkun.setText(namaTersimpan);


    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), menuKuisActivity.class);
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
