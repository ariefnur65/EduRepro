package id.co.blogspot.blogmozink.edurepro;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class videoPembelajaran extends AppCompatActivity  {
    Animation myAnim;
    VideoView vidNarkoba, vidPacaran, vidMenstruasi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myAnim = AnimationUtils.loadAnimation(this,R.anim.grind);
        setContentView(R.layout.activity_video_pembelajaran);

        vidNarkoba = (VideoView)
                findViewById(R.id.vidNarkoba);

        vidPacaran = (VideoView)
                findViewById(R.id.vidPacaran);

        vidMenstruasi = (VideoView)
                findViewById(R.id.vidMenstruasi);


        final Button btnNarkoba = (Button) findViewById(R.id.btnNarkoba);

        final Button btnPacaran = (Button) findViewById(R.id.btnPacaran);

        final Button btnMenstruasi = (Button) findViewById(R.id.btnMenstruasi);

        String pathNarkoba = "android.resource://" + getPackageName() + "/" + R.raw.narkoba;
        String pathPacaran = "android.resource://" + getPackageName() + "/" + R.raw.pacaran;
        String pathMenstruasi = "android.resource://" + getPackageName() + "/" + R.raw.menstruasi;

        vidNarkoba.setVideoURI(Uri.parse(pathNarkoba));
        vidPacaran.setVideoURI(Uri.parse(pathPacaran));
        vidMenstruasi.setVideoURI(Uri.parse(pathMenstruasi));

        MediaController mediaControllerPacar = new
                MediaController(this);
        mediaControllerPacar.setAnchorView(vidPacaran);
        vidPacaran.setMediaController(mediaControllerPacar);

        MediaController mediaControllerNarkob = new
                MediaController(this);
        mediaControllerNarkob.setAnchorView(vidNarkoba);
        vidNarkoba.setMediaController(mediaControllerNarkob);


        MediaController mediaControllerMenstruasi = new
                MediaController(this);
        mediaControllerMenstruasi.setAnchorView(vidMenstruasi);
        vidMenstruasi.setMediaController(mediaControllerMenstruasi);

        btnNarkoba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vidNarkoba.getVisibility() == View.VISIBLE)
                {
                    vidNarkoba.setVisibility(View.GONE);
                    soundManager.resume();

                }
                else {
                    vidNarkoba.setVisibility(View.VISIBLE);
                    soundManager.pause();

                }
                vidPacaran.setVisibility(View.GONE);
                vidMenstruasi.setVisibility(View.GONE);

            }
        });


        btnPacaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vidNarkoba.setVisibility(View.GONE);
                if(vidPacaran.getVisibility() == View.VISIBLE)
                {
                    vidPacaran.setVisibility(View.GONE);
                    soundManager.resume();

                }
                else {
                    vidPacaran.setVisibility(View.VISIBLE);
                    soundManager.pause();

                }
                vidMenstruasi.setVisibility(View.GONE);

            }
        });

        btnMenstruasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                vidNarkoba.setVisibility(View.GONE);
                vidPacaran.setVisibility(View.GONE);
                if(vidMenstruasi.getVisibility() == View.VISIBLE)
                {
                    vidMenstruasi.setVisibility(View.GONE);
                    soundManager.resume();

                }
                else {
                    vidMenstruasi.setVisibility(View.VISIBLE);
                    soundManager.pause();

                }

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


