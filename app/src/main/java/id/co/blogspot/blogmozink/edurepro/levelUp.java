package id.co.blogspot.blogmozink.edurepro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class levelUp extends AppCompatActivity {
    SharedPreferences userData;

    TextView life, score;
    ImageView levelImage;

    LinkedList<Drawable> level = new LinkedList<Drawable>();

    Animation myanim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_up);

        life = (TextView) findViewById(R.id.life);
        score = (TextView) findViewById(R.id.score);
        levelImage = (ImageView) findViewById(R.id.level);
        intentInitialize = false;


        myanim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.grind);

        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.level1kuisaku, null));
        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.level2kuisaku, null));
        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.level3kuisaku, null));
        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.level4kuisaku, null));
        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.level5kuisaku, null));
        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.level6kuisaku, null));
        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.level7kuisaku, null));
        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.level8kuisaku, null));
        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.level9kuisaku, null));
        level.add(ResourcesCompat.getDrawable(getResources(), R.drawable.leveldewa, null));


        userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Integer nyawa = userData.getInt(getString(R.string.QUIZ_AKU_NYAWA), 0);
        Integer skor = userData.getInt(getString(R.string.QUIZ_AKU_SCORE), 0);
        Integer levelText = userData.getInt(getString(R.string.QUIZ_AKU_LEVEL),0);


        life.setText(nyawa.toString());
        score.setText(skor.toString());

        levelImage.setImageDrawable(level.get(levelText));

        final Button lanjut = (Button) findViewById(R.id.btn_lanjut);
        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lanjut.startAnimation(myanim);
                Intent intent;
                intent = new Intent(getApplicationContext(), MateriActivity.class);
                intentInitialize = true;

                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {

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
