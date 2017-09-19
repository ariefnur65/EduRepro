package id.co.blogspot.blogmozink.edurepro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

import me.biubiubiu.justifytext.library.JustifyTextView;

public class mitosfaktakuis extends AppCompatActivity implements View.OnClickListener {
    public ImageView levelImage;
    LinkedList<Drawable> level = new LinkedList<>();
    LinkedList<Drawable> progressLife = new LinkedList<>();
    ImageView progress;
    Integer stepProgress;
    Button btnA, btnB;
    TextView nyawa, nama;
    Animation myAnim;
    View layout;
    View mainlayout;
    LayoutInflater inflater;

    int hidup;
    LinkedList<Button> buttonk = new LinkedList<Button>();

    ImageButton btnexit, btnnext, btnexplain;
    private ImageView bpw;
    private PopupWindow pw;
    ViewGroup.LayoutParams layoutParams;

    JustifyTextView soal;
    TextView restNumber;
    TextView currentNumber;
    TextView penjelasan;
    int[] jawabankuis;
    String[] soalString;
    String[] penjelasanJawaban;

    Integer restNumb;
    Integer currentNumb;
    SharedPreferences userData;

    int soalDikerjakan;
    SharedPreferences.Editor editor;
    Integer life ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitosfaktakuis);


        userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = userData.edit();

        progress = (ImageView) findViewById(R.id.progress);
        levelImage  = (ImageView) findViewById(R.id.level);
        nyawa = (TextView) findViewById(R.id.life);
        nama = (TextView) findViewById(R.id.akun);


        btnA = (Button) findViewById(R.id.A);
        btnB = (Button) findViewById(R.id.B);
        btnexit = (ImageButton) findViewById(R.id.exit);
        btnnext = (ImageButton)  findViewById(R.id.next);
        btnexplain = (ImageButton) findViewById(R.id.explain);

        inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        intentInitialize = false;


        buttonk.add(btnA);
        buttonk.add(btnB);
        penjelasanJawaban = getResources().getStringArray(R.array.jawabanSoalMitos);
        soalString = getResources().getStringArray(R.array.soalMitos);
        jawabankuis = getResources().getIntArray(R.array.jawabanMitos);
        soal = (JustifyTextView) findViewById(R.id.soal);
        restNumber = (TextView) findViewById(R.id.rest);
        currentNumber = (TextView) findViewById(R.id.current);

        restNumb = 20;//Ganti ini sesuai jumlah soal
        currentNumb = 0;
        myAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.grind);

        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);

        btnexit.setOnClickListener(this);
        btnnext.setOnClickListener(this);
        btnexplain.setOnClickListener(this);


        View fragmentPopup = inflater.inflate(R.layout.popup_penjelasan, (ViewGroup) findViewById(R.id.container), false);

        this.penjelasan = fragmentPopup.findViewById(R.id.teksPenjelasan);
        layoutParams = fragmentPopup.getLayoutParams();

        layout = inflater.inflate(R.layout.popup_penjelasan,
                (ViewGroup) fragmentPopup.findViewById(R.id.popupanswer));
        pw = new PopupWindow(layout, layoutParams.width, layoutParams.height, true);
        bpw = fragmentPopup.findViewById(R.id.close);
        bpw.setAlpha(1f);
        bpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animated;
                animated = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.grind);
                bpw.startAnimation(animated);
                pw.dismiss();
            }
        });

        progressLife.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tambahan0, null));
        progressLife.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tambahan1, null));
        progressLife.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tambahan2, null));
        progressLife.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tambahan3, null));
        progressLife.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tambahan4, null));
        progressLife.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tambahan5, null));

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

        hidup = userData.getInt(getString(R.string.QUIZ_AKU_NYAWA), 0);
        soalDikerjakan = userData.getInt(getString(R.string.QUIZ_AKU_NOMITOSFAKTA),-1);
        stepProgress = userData.getInt(getString(R.string.QUIZ_AKU_PROGRESS), 0);

        Integer soalku = soalDikerjakan;
//        Toast.makeText(getApplicationContext(),soalku.toString(),Toast.LENGTH_LONG).show();
        int nomorSoalterakhir = soalDikerjakan +1;
        if(nomorSoalterakhir<restNumb)
        {
            currentNumb = nomorSoalterakhir;
        }else {
            Intent intent;
            intent = new Intent(getApplicationContext(), mitosAtauFakta.class);
            Toast.makeText(getApplicationContext(), "Soal Mitos atau fakta sudah habis", Toast.LENGTH_LONG).show();
            intentInitialize = true;
            startActivity(intent);

        }

        updateNilai(hidup, soalDikerjakan, stepProgress);
        changeIsiKuis(currentNumb);


    }


    public void changeIsiKuis(Integer nomor){




        cleanButton();
        if(nomor>=restNumb){

                Intent intent;
                intent = new Intent(getApplicationContext(), MainActivity.class);
            intentInitialize = true;
            startActivity(intent);

            return;
        }
            btnexit.setEnabled(true);
            btnexit.setAlpha(1f);
//        Memasukan Soal
            soal.setText(soalString[nomor]);
//        Memasukan rest
            restNumber.setText(restNumb.toString());
//        Current
            Integer current = nomor +1;
            currentNumber.setText(current.toString());
            penjelasan.setText(penjelasanJawaban[nomor]);
//        Memasukan Pilhan

//            x = selectorpilihan(nomor) - 1;




    }

    public void cleanButton(){

        btnexit.setAlpha(1f);
        btnexit.setEnabled(true);



        btnnext.setEnabled(false);
        btnexplain.setEnabled(false);
        btnnext.setAlpha(0.5f);
        btnexplain.setAlpha(0.5f);
        for (int i =0; i < buttonk.size();i++)
        {
            buttonk.get(i).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan1, null));
            buttonk.get(i).setEnabled(true);

        }

    }



    public void checker(int jawaban, int nomor){
// jika soal ini telah di kerjakan maka gk akan dpt nilai


//        Jika jawaban benar maka Button akan berganti warna menjadi emas
        Integer jawabanBenar = jawabankuis[nomor];
        Integer j = jawaban;
//        Toast.makeText(getApplicationContext(), jawabanBenar.toString() + "=" +j.toString(), Toast.LENGTH_LONG).show();

        if(jawaban == jawabanBenar){
            buttonk.get(jawaban).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan2, null));
            stepProgress++;
            Integer step = stepProgress;
            soalDikerjakan++;
//            Toast.makeText(getApplicationContext(), step.toString(), Toast.LENGTH_LONG).show();

            if(stepProgress>=5){hidup ++; stepProgress = 0;}
            updateNilai(hidup,soalDikerjakan,stepProgress);

            playMenang();
            btnnext.setEnabled(true);
            btnexplain.setEnabled(true);
            btnnext.setAlpha(1f);
            btnexplain.setAlpha(1f);

        }
        else {


            playKalah();
            soalDikerjakan++;

//            Toast.makeText(getApplicationContext(), "Salah", Toast.LENGTH_LONG).show();

            buttonk.get(jawaban).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan3, null));
            buttonk.get(jawabanBenar).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan2, null));
            updateNilai(hidup,soalDikerjakan,stepProgress);
            pw.showAtLocation(findViewById(R.id.containerMitos), Gravity.CENTER, 0, 0);
            btnnext.setEnabled(true);
            btnexplain.setEnabled(true);
            btnnext.setAlpha(1f);
            btnexplain.setAlpha(1f);


        }

        btnexplain.setEnabled(true);
        btnexplain.setAlpha(1f);
        btnexit.setEnabled(false);
        btnexit.setAlpha(0.5f);

        for (int i =0; i < buttonk.size();i++)
        {
            buttonk.get(i).setEnabled(false);
        }

//        Jika salah maka yang benar di ganti warna, dan yang dipilih berganti warna menjadi abu2
    }


    public void updateNilai(Integer hidup, Integer soalDikerjakan, Integer stepProgress){


        editor.putInt(getString(R.string.QUIZ_AKU_NYAWA), hidup);
        editor.putInt(getString(R.string.QUIZ_AKU_NOMITOSFAKTA), soalDikerjakan);
        editor.putInt(getString(R.string.QUIZ_AKU_PROGRESS),stepProgress );
        editor.commit();

        Integer nyawa = userData.getInt(getString(R.string.QUIZ_AKU_NYAWA), 0);
        String namaAkun = userData.getString(getString(R.string.QUIZ_AKU_USERNAME),"0");
        int levelku = userData.getInt(getString(R.string.QUIZ_AKU_LEVEL), 0);
        Integer progress = userData.getInt(getString(R.string.QUIZ_AKU_PROGRESS), 0);

//        Toast.makeText(getApplicationContext(), progress.toString(), Toast.LENGTH_LONG).show();
        this.progress.setImageDrawable(progressLife.get(progress));

        this.nyawa.setText(nyawa.toString());
        this.nama.setText(namaAkun);

        levelImage.setImageDrawable(level.get(levelku));

//        Integer leve = levelku;

//        Integer soaldi = soalDikerjakan;
//        Toast.makeText(getContext(), nyawa.toString(),Toast.LENGTH_SHORT).show();
//        Toast.makeText(getContext(), soaldi.toString(),Toast.LENGTH_SHORT).show();





    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.A:
                btnA.startAnimation(myAnim);
                checker(0,currentNumb);
                break;
            case R.id.B:
                btnB.startAnimation(myAnim);
                checker(1,currentNumb);

                break;
            case R.id.exit:
                btnexit.startAnimation(myAnim);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intentInitialize = true;
                startActivity(intent);

                break;
            case R.id.next:
                btnnext.startAnimation(myAnim);
                currentNumb++;
                changeIsiKuis(currentNumb);
                break;
            case R.id.explain:
                btnexplain.startAnimation(myAnim);
                pw.showAtLocation(findViewById(R.id.containerMitos), Gravity.CENTER, 0, 0);
                btnnext.setEnabled(true);
                btnexplain.setEnabled(true);
                btnnext.setAlpha(1f);
                btnexplain.setAlpha(1f);
                break;

        }

    }

    public void playMenang()
    {
        MediaPlayer menang;
        menang = MediaPlayer.create(getApplicationContext(), R.raw.menang);
        menang.setVolume(100,100);
        menang.setLooping(false);
        boolean sfxOn = userData.getBoolean(getString(R.string.QUIZ_AKU_SFX), true);
        if(sfxOn) menang.start();
    }

    public void playKalah()
    {
        MediaPlayer menang;
        menang = MediaPlayer.create(getApplicationContext(), R.raw.kalah);
        menang.setVolume(100,100);
        menang.setLooping(false);
        boolean sfxOn = userData.getBoolean(getString(R.string.QUIZ_AKU_SFX), true);
        if(sfxOn) menang.start();
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
