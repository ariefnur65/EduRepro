package id.co.blogspot.blogmozink.edurepro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import org.w3c.dom.Text;

public class akunku extends AppCompatActivity {
    Animation myAnim;
    SharedPreferences userData;
    SharedPreferences.Editor editor;
    Integer score, nyawa, levelku;
    Integer umur;
    String namaTersimpan, kelamin;
    Boolean gender;
    TextView namaAkun, skor, hidup, jenisKelamin;
    Boolean bgm,sfx;
    View layout;
    View mainlayout;
    Button btn_reset;
    ImageView levelImage;
    PopupWindow popUpReset;
    LayoutInflater inflater;

    TextView teksOut;


    private Button yes,no;
    ViewGroup.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akunku);
        myAnim = AnimationUtils.loadAnimation(this,R.anim.grind);
        intentInitialize = false;

        inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        btn_reset = (Button) findViewById(R.id.btn_reset);
        userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        levelImage = (ImageView) findViewById(R.id.level);
        editor = userData.edit();
        score = userData.getInt(getString(R.string.QUIZ_AKU_SCORE), 0);
        nyawa = userData.getInt(getString(R.string.QUIZ_AKU_NYAWA), 0);
        levelku = userData.getInt(getString(R.string.QUIZ_AKU_LEVEL), 0);
        namaTersimpan = userData.getString(getString(R.string.QUIZ_AKU_USERNAME),"0");
        gender = userData.getBoolean(getString(R.string.QUIZ_AKU_KELAMINUSER),false);
        umur = userData.getInt(getString(R.string.QUIZ_AKU_UMURUSER), 0);

        bgm = userData.getBoolean(getString(R.string.QUIZ_AKU_BGM),false);
        sfx = userData.getBoolean(getString(R.string.QUIZ_AKU_SFX),false);

        if(gender == true)kelamin = "Laki-laki";
        else kelamin = "Perempuan";
        namaAkun = (TextView) findViewById(R.id.namaAkun);
        skor = (TextView) findViewById(R.id.skor);
        hidup = (TextView) findViewById(R.id.nyawa);
        jenisKelamin = (TextView) findViewById(R.id.kelamin) ;


        namaAkun.setText(namaTersimpan.toString());
        skor.setText(score.toString());
        hidup.setText(nyawa.toString());
        jenisKelamin.setText(kelamin);



        View fragmentPopup = inflater.inflate(R.layout.pop_up_reset, (ViewGroup) findViewById(R.id.akunkuL),false);
        teksOut = (TextView) fragmentPopup.findViewById(R.id.textOut);
        teksOut.setText("Reset data?");
        layoutParams = fragmentPopup.getLayoutParams();

        layout = inflater.inflate(R.layout.pop_up_reset,
                (ViewGroup) fragmentPopup.findViewById(R.id.popupanswer));
//        mainlayout = inflater.inflate(R.layout.activity_fragment_kuis1,
//                (ViewGroup) fragmentLayout.findViewById(R.id.kuis1));
        popUpReset = new PopupWindow(layout, layoutParams.width, layoutParams.height, true);
//        pw.showAtLocation(mainlayout, Gravity.CENTER, 0, 0);

        yes = fragmentPopup.findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                yes untuk reset
                Animation animated;
                animated = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.grind);
                yes.startAnimation(animated);


                editor.clear().commit();

                updateScore();
                popUpReset.dismiss();
            }
        });

        no = fragmentPopup.findViewById(R.id.no);

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                no
                Animation animated;
                animated = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.grind);
                no.startAnimation(animated);

                popUpReset.dismiss();
            }
        });


        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.startAnimation(myAnim);
                teksOut.setText("Reset data?");
                popUpReset.showAtLocation(findViewById(R.id.akunkuL), Gravity.CENTER, 0, 0);
            }
        });




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


    }




    @Override
    public void onBackPressed() {
        Intent intent;
        intent = new Intent(getApplicationContext(), MainActivity.class);
        intentInitialize = true;
        startActivity(intent);
    }

    public void openMain(View v){
        v.startAnimation(myAnim);
        Intent intent;
        intent = new Intent(getApplicationContext(), MainActivity.class);
        intentInitialize = true;
        startActivity(intent);

    }



    public void updateScore(){

        SharedPreferences userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = userData.edit();
//            Intent svc=new Intent(this, soundManager.class);

        boolean BGM = userData.getBoolean(getString(R.string.QUIZ_AKU_BGM), true);
//        soundManager.start(getApplicationContext());



        boolean sfxOn = userData.getBoolean(getString(R.string.QUIZ_AKU_SFX),true);
        if(sfxOn){
            editor.putBoolean(getString(R.string.QUIZ_AKU_SFX),true);
            editor.commit();
        }

        int score = userData.getInt(getString(R.string.QUIZ_AKU_SCORE), 0);
        if (score == 0) {
            editor.putInt(getString(R.string.QUIZ_AKU_SCORE), 0);
            editor.commit();
        }

        int nyawa = userData.getInt(getString(R.string.QUIZ_AKU_NYAWA), -1);
        if (nyawa == -1) {
            editor.putInt(getString(R.string.QUIZ_AKU_NYAWA), 7);
            editor.commit();
        }

        int level = userData.getInt(getString(R.string.QUIZ_AKU_LEVEL), 0);
        if (level == 0) {
            editor.putInt(getString(R.string.QUIZ_AKU_LEVEL), 0);
            editor.commit();
        }
        int SOAL = userData.getInt(getString(R.string.QUIZ_AKU_SOAL1), -1);
        editor.commit();
        if (SOAL == -1) {
            editor.putInt(getString(R.string.QUIZ_AKU_SOAL1), -1);
            editor.commit();
        }

        SOAL = userData.getInt(getString(R.string.QUIZ_AKU_SOAL2), -1);
        if (SOAL == 0) {
            editor.putInt(getString(R.string.QUIZ_AKU_SOAL2), -1);
            editor.commit();
        }

        SOAL = userData.getInt(getString(R.string.QUIZ_AKU_SOAL3), -1);
        if (SOAL == 0) {
            editor.putInt(getString(R.string.QUIZ_AKU_SOAL3), -1);
            editor.commit();
        }

        SOAL = userData.getInt(getString(R.string.QUIZ_AKU_SOAL4), -1);
        if (SOAL == 0) {
            editor.putInt(getString(R.string.QUIZ_AKU_SOAL4), -1);
            editor.commit();
        }

        SOAL = userData.getInt(getString(R.string.QUIZ_AKU_SOAL5), -1);
        if (SOAL == 0) {
            editor.putInt(getString(R.string.QUIZ_AKU_SOAL5), -1);
            editor.commit();
        }

        SOAL = userData.getInt(getString(R.string.QUIZ_AKU_SOAL6), -1);
        if (SOAL == 0) {
            editor.putInt(getString(R.string.QUIZ_AKU_SOAL6), -1);
            editor.commit();
        }

        SOAL = userData.getInt(getString(R.string.QUIZ_AKU_SOAL7), -1);
        if (SOAL == 0) {
            editor.putInt(getString(R.string.QUIZ_AKU_SOAL7), -1);
            editor.commit();
        }

        SOAL = userData.getInt(getString(R.string.QUIZ_AKU_SOAL8), -1);
        if (SOAL == 0) {
            editor.putInt(getString(R.string.QUIZ_AKU_SOAL8), -1);
            editor.commit();
        }

        SOAL = userData.getInt(getString(R.string.QUIZ_AKU_SOAL9), -1);
        if (SOAL == 0) {
            editor.putInt(getString(R.string.QUIZ_AKU_SOAL9), -1);
            editor.commit();
        }

        SOAL = userData.getInt(getString(R.string.QUIZ_AKU_PROGRESS), 0);
        if (SOAL == 0) {
            editor.putInt(getString(R.string.QUIZ_AKU_PROGRESS), 0);
            editor.commit();
        }

        SOAL = userData.getInt(getString(R.string.QUIZ_AKU_NOMITOSFAKTA), -1);
        if (SOAL == -1) {
            editor.putInt(getString(R.string.QUIZ_AKU_NOMITOSFAKTA), -1);
            editor.commit();
        }


        editor.putInt(getString(R.string.QUIZ_AKU_UMURUSER), umur);
        editor.commit();
        editor.putString(getString(R.string.QUIZ_AKU_USERNAME), namaTersimpan);
        editor.commit();

        if (gender) {
            editor.putBoolean(getString(R.string.QUIZ_AKU_KELAMINUSER), true);
        } else {
            editor.putBoolean(getString(R.string.QUIZ_AKU_KELAMINUSER), false);
        }
        editor.commit();

//        editor.putInt(getString(R.string.QUIZ_AKU_SCORE), this.score);
        editor.putInt(getString(R.string.QUIZ_AKU_NYAWA), 7);
        editor.putInt(getString(R.string.QUIZ_AKU_LEVEL), 0);
        editor.putString(getString(R.string.QUIZ_AKU_USERNAME), namaTersimpan);
        editor.putBoolean(getString(R.string.QUIZ_AKU_KELAMINUSER), gender);
        editor.putInt(getString(R.string.QUIZ_AKU_UMURUSER), umur);
        editor.putBoolean(getString(R.string.QUIZ_AKU_BGM), bgm);
        editor.putBoolean(getString(R.string.QUIZ_AKU_SFX), sfx);

        editor.commit();


        this.score = userData.getInt(getString(R.string.QUIZ_AKU_SCORE), 0);
        this.nyawa = userData.getInt(getString(R.string.QUIZ_AKU_NYAWA), 0);
        levelku = userData.getInt(getString(R.string.QUIZ_AKU_LEVEL), 0);
        namaTersimpan = userData.getString(getString(R.string.QUIZ_AKU_USERNAME),"0");
        gender = userData.getBoolean(getString(R.string.QUIZ_AKU_KELAMINUSER),false);
        umur = userData.getInt(getString(R.string.QUIZ_AKU_UMURUSER), 0);
        if(gender == true)kelamin = "Laki-laki";
        else kelamin = "Perempuan";

        namaAkun.setText(namaTersimpan.toString());
        skor.setText(this.score.toString());
        hidup.setText(this.nyawa.toString());
        jenisKelamin.setText(kelamin);


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
