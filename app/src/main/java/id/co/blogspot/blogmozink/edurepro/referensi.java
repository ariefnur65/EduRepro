package id.co.blogspot.blogmozink.edurepro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class referensi extends AppCompatActivity {
    Animation myAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_referensi);
        myAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.grind);

    }


    public void openMain(View v){
        v.startAnimation(myAnim);
        Intent intent;
        intent = new Intent(getApplicationContext(), MateriActivity.class);
        intentInitialize = true;
        startActivity(intent);

    }


    @Override
    public void onBackPressed() {
        Intent intent;
        intent = new Intent(getApplicationContext(), MateriActivity.class);
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
