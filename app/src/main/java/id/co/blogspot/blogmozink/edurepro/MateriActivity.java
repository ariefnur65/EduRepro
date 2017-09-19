package id.co.blogspot.blogmozink.edurepro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.preference.PreferenceManager;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.LinkedList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MateriActivity extends AppCompatActivity {

    Animation myAnim;
    boolean spoiler11= false;
    public enum FragmentToLaunch {Materi1,Materi2,Materi3,Materi4,Materi5,Materi6,Materi7,Materi8,Materi9}
    LinkedList<Button> btnku = new LinkedList<>();
    SharedPreferences userData;
    LinkedList<Drawable> btnImages = new LinkedList<>();
    LinkedList<Drawable> btnImagesTutup = new LinkedList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);
        myAnim = AnimationUtils.loadAnimation(this,R.anim.grind);
        final Button btnMateri1 = (Button) findViewById(R.id.btnMateri1);
        final Button btnMateri2 = (Button) findViewById(R.id.btnMateri2);
        final Button btnMateri3 = (Button) findViewById(R.id.btnMateri3);
        final Button btnMateri4 = (Button) findViewById(R.id.btnMateri4);
        final Button btnMateri6 = (Button) findViewById(R.id.btnMateri6);
        final Button btnMateri7 = (Button) findViewById(R.id.btnMateri7);
        final Button btnMateri8 = (Button) findViewById(R.id.btnMateri8);
        final Button btnMateri9 = (Button) findViewById(R.id.btnMateri9);
        final Button btnMateri5 = (Button) findViewById(R.id.btnMateri5);
        intentInitialize = false;

        btnImages.add(ResourcesCompat.getDrawable(getResources(), R.drawable.btn1b, null));
        btnImages.add(ResourcesCompat.getDrawable(getResources(), R.drawable.btn2b, null));
        btnImages.add(ResourcesCompat.getDrawable(getResources(), R.drawable.btn3b, null));
        btnImages.add(ResourcesCompat.getDrawable(getResources(), R.drawable.btn4b, null));
        btnImages.add(ResourcesCompat.getDrawable(getResources(), R.drawable.btn5b, null));
        btnImages.add(ResourcesCompat.getDrawable(getResources(), R.drawable.btn6b, null));
        btnImages.add(ResourcesCompat.getDrawable(getResources(), R.drawable.btn7b, null));
        btnImages.add(ResourcesCompat.getDrawable(getResources(), R.drawable.btn8b, null));
        btnImages.add(ResourcesCompat.getDrawable(getResources(), R.drawable.btn9b, null));

        btnImagesTutup.add(ResourcesCompat.getDrawable(getResources(), R.drawable.btn1t, null));
        btnImagesTutup.add(ResourcesCompat.getDrawable(getResources(), R.drawable.btn2t, null));
        btnImagesTutup.add(ResourcesCompat.getDrawable(getResources(), R.drawable.btn3t, null));
        btnImagesTutup.add(ResourcesCompat.getDrawable(getResources(), R.drawable.btn4t, null));
        btnImagesTutup.add(ResourcesCompat.getDrawable(getResources(), R.drawable.btn5t, null));
        btnImagesTutup.add(ResourcesCompat.getDrawable(getResources(), R.drawable.btn6t, null));
        btnImagesTutup.add(ResourcesCompat.getDrawable(getResources(), R.drawable.btn7t, null));
        btnImagesTutup.add(ResourcesCompat.getDrawable(getResources(), R.drawable.btn8t, null));
        btnImagesTutup.add(ResourcesCompat.getDrawable(getResources(), R.drawable.btn9t, null));

        btnku.add(btnMateri1);
        btnku.add(btnMateri2);
        btnku.add(btnMateri3);
        btnku.add(btnMateri4);
        btnku.add(btnMateri5);
        btnku.add(btnMateri6);
        btnku.add(btnMateri7);
        btnku.add(btnMateri8);
        btnku.add(btnMateri9);

        checkLevel();


//        Onclick Listener lainnya
        btnMateri1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri1.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), layoutmateri1.class);
                intent.putExtra(getString(R.string.MateriFragment),FragmentToLaunch.Materi1);
                intentInitialize = true;

                startActivity(intent);
            }
        });

        btnMateri2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri2.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), layoutmateri1.class);
                intent.putExtra(getString(R.string.MateriFragment),FragmentToLaunch.Materi2);
                intentInitialize = true;
                startActivity(intent);

            }
        });

        btnMateri3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri3.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), layoutmateri1.class);
                intent.putExtra(getString(R.string.MateriFragment),FragmentToLaunch.Materi3);
                intentInitialize = true;

                startActivity(intent);

            }
        });

        btnMateri4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri4.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), layoutmateri1.class);
                intent.putExtra(getString(R.string.MateriFragment),FragmentToLaunch.Materi4);
                intentInitialize = true;
                startActivity(intent);
            }
        });

        btnMateri5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri5.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), layoutmateri1.class);
                intent.putExtra(getString(R.string.MateriFragment),FragmentToLaunch.Materi5);
                intentInitialize = true;
                startActivity(intent);
            }
        });

        btnMateri7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri7.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), layoutmateri1.class);
                intent.putExtra(getString(R.string.MateriFragment),FragmentToLaunch.Materi7);
                intentInitialize = true;
                startActivity(intent);
            }
        });

        btnMateri8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri8.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), layoutmateri1.class);
                intent.putExtra(getString(R.string.MateriFragment),FragmentToLaunch.Materi8);
                intentInitialize = true;
                startActivity(intent);
            }
        });

        btnMateri9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri9.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), layoutmateri1.class);
                intent.putExtra(getString(R.string.MateriFragment),FragmentToLaunch.Materi9);
                intentInitialize = true;
                startActivity(intent);
            }
        });

        btnMateri6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMateri6.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), layoutmateri1.class);
                intent.putExtra(getString(R.string.MateriFragment),FragmentToLaunch.Materi6);
                intentInitialize = true;
                startActivity(intent);
            }
        });

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    public void checkLevel()
    {   userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int levelku = userData.getInt(getString(R.string.QUIZ_AKU_LEVEL), 0);

        for(int p = 0; p < btnku.size(); p++)
        {
            if(p <= levelku){
                btnku.get(p).setBackground(btnImages.get(p));
                btnku.get(p).setEnabled(true);

            }
            else{
                btnku.get(p).setBackground(btnImagesTutup.get(p));
                btnku.get(p).setEnabled(false);
            }

        }

    }
    public void openMain(View v){
        v.startAnimation(myAnim);
        Intent intent;
        intent = new Intent(getApplicationContext(), MainActivity.class);
        intentInitialize = true;
        startActivity(intent);

    }


    public void openRef(View v){
        v.startAnimation(myAnim);
        Intent intent;
        intent = new Intent(getApplicationContext(), referensi.class);
        intentInitialize = true;
        startActivity(intent);
    }

    Boolean intentInitialize;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intentInitialize = true;
        startActivity(intent);
    }

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
