package id.co.blogspot.blogmozink.edurepro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class mitosAtauFakta extends AppCompatActivity {
    Animation myAnim;
    Button mulai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitos_atau_fakta);
        mulai = (Button) findViewById(R.id.mulaimitos);
        myAnim = AnimationUtils.loadAnimation(this,R.anim.grind);

        mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mulai.startAnimation(myAnim);
                Intent intent;
                intent = new Intent(getApplicationContext(), mitosfaktakuis.class);
                intentInitialize = true;
                startActivity(intent);

            }
        });

    }

    public void openMain(View v){
        v.startAnimation(myAnim);
        Intent intent;
        intent = new Intent(getApplicationContext(), MainActivity.class);
        intentInitialize = true;
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        Intent intent;
        intent = new Intent(getApplicationContext(), MainActivity.class);
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
