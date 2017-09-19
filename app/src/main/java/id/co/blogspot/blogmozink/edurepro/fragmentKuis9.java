package id.co.blogspot.blogmozink.edurepro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
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

public class fragmentKuis9 extends Fragment implements View.OnClickListener {
    View fragmentLayout;
    Animation myAnim;
    View layout;
    View mainlayout;
    Button btnA, btnB, btnC, btnD;
    LinkedList<Button> buttonk = new LinkedList<Button>();

    ImageButton btnexit, btnnext, btnexplain;
    private ImageView bpw;
    private PopupWindow pw;
    ViewGroup.LayoutParams layoutParams;

    JustifyTextView soal;
    TextView restNumber;
    TextView currentNumber;
    TextView penjelasan;

    String[] pilihan;
    String[] jawabankuis;
    int[] jumlahpilhan;
    String[] soalString;
    int[] jawabanPiliihanKuis;

    Integer restNumb;
    Integer currentNumb;
    SharedPreferences userData;

    int soalDikerjakan;
    SharedPreferences.Editor editor;

    Integer score ;
    Integer nyawa ;
    int levelku;
    String namaTersimpan ;
    public TextView life;
    public TextView skore;


    public fragmentKuis9(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.activity_fragment_kuis9,container,false);




        btnA = fragmentLayout.findViewById(R.id.A);
        btnB = fragmentLayout.findViewById(R.id.B);
        btnC = fragmentLayout.findViewById(R.id.C);
        btnD = fragmentLayout.findViewById(R.id.D);


        btnexit = fragmentLayout.findViewById(R.id.exit);
        btnnext = fragmentLayout.findViewById(R.id.next);
        btnexplain = fragmentLayout.findViewById(R.id.explain);

        View kuisku = inflater.inflate(R.layout.activity_kuis_aku,container, false);

        life = (TextView) kuisku.findViewById(R.id.life);
        skore = (TextView) kuisku.findViewById(R.id.score);


        buttonk.add(btnA);
        buttonk.add(btnB);
        buttonk.add(btnC);
        buttonk.add(btnD);

        soalString = getResources().getStringArray(R.array.soal9);
        pilihan = getResources().getStringArray(R.array.pilihan9);
        jumlahpilhan = getResources().getIntArray(R.array.jumlahpilihan9);
        jawabankuis = getResources().getStringArray(R.array.penjelasanjawaban9);
        jawabanPiliihanKuis = getResources().getIntArray(R.array.jawabankuis9);
        soal = fragmentLayout.findViewById(R.id.soal);
        restNumber = fragmentLayout.findViewById(R.id.rest);
        currentNumber = fragmentLayout.findViewById(R.id.current);

        restNumb = 3;//Ganti ini sesuai jumlah soal
        currentNumb =0;

        myAnim = AnimationUtils.loadAnimation(getContext(),R.anim.grind);


//        Button spoiler11 = (Button) fragmentLayout.findViewById(R.id.spoiler1_1);
        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);

        btnexit.setOnClickListener(this);
        btnnext.setOnClickListener(this);
        btnexplain.setOnClickListener(this);

        View fragmentPopup = inflater.inflate(R.layout.popup_penjelasan,container,false);

        penjelasan = fragmentPopup.findViewById(R.id.teksPenjelasan);
        layoutParams = fragmentPopup.getLayoutParams();

        layout = inflater.inflate(R.layout.popup_penjelasan,
                (ViewGroup) fragmentPopup.findViewById(R.id.popupanswer));
//        mainlayout = inflater.inflate(R.layout.activity_fragment_kuis1,
//                (ViewGroup) fragmentLayout.findViewById(R.id.kuis1));
        pw = new PopupWindow(layout, layoutParams.width, layoutParams.height, true);
//        pw.showAtLocation(mainlayout, Gravity.CENTER, 0, 0);

        bpw = fragmentPopup.findViewById(R.id.close);
        bpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animated;
                animated = AnimationUtils.loadAnimation(getContext(),R.anim.grind);
                bpw.startAnimation(animated);

                pw.dismiss();
            }
        });




        userData = PreferenceManager.getDefaultSharedPreferences(getContext());
        editor = userData.edit();
        score = userData.getInt(getString(R.string.QUIZ_AKU_SCORE), 0);
        nyawa = userData.getInt(getString(R.string.QUIZ_AKU_NYAWA), 0);
        levelku = userData.getInt(getString(R.string.QUIZ_AKU_LEVEL), 0);
        namaTersimpan = userData.getString(getString(R.string.QUIZ_AKU_USERNAME),"0");
        soalDikerjakan = userData.getInt(getString(R.string.QUIZ_AKU_SOAL9),-1);
        int nomorSoalterakhir = soalDikerjakan +1;
        if(nomorSoalterakhir<restNumb)
        {
            currentNumb = nomorSoalterakhir;
        }else {currentNumb=0;}

        changeIsiKuis(currentNumb);



        return fragmentLayout;
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


    public void changeIsiKuis(Integer nomor){


        cleanButton();


        if(nyawa!=0 || nomor == restNumb){
            if(nomor>=restNumb){
                if(levelku <9)
                {
                    levelku = 9;
                    updateNilai();
                    Intent intent;
                    intent = new Intent(getContext(), levelSelesai.class);
                    startActivity(intent);
                }else {
                    Intent intent;
                    intent = new Intent(getContext(), menuKuisActivity.class);
                    startActivity(intent);
                }
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
            penjelasan.setText(jawabankuis[nomor]);
//        Memasukan Pilhan

            int x =0;
//            x = selectorpilihan(nomor) - 1;

            for(int p =0; p < nomor; p++){
                x += jumlahpilhan[p];
            }

            Integer u = x;

            for(int i = 0 ; i < jumlahpilhan[nomor];i++){
                int pilih = i + x;
                switch (jumlahpilhan[nomor]){

                    case 3:
                        for (int t =0; t < buttonk.size();t++)
                        {
                            buttonk.get(t).setEnabled(true);
                            buttonk.get(t).setAlpha(1f);

                        }
                        buttonk.get(i).setText(pilihan[pilih]);
                        buttonk.get(3).setEnabled(false);
                        buttonk.get(3).setAlpha(0f);
                        break;
                    case 4:
                        for (int t =0; t < buttonk.size();t++)
                        {
                            buttonk.get(t).setEnabled(true);
                            buttonk.get(t).setAlpha(1f);

                        }


                        buttonk.get(i).setText(pilihan[pilih]);
                        break;
                    case 5:
                        for (int t =0; t < buttonk.size();t++)
                        {
                            buttonk.get(t).setEnabled(true);
                            buttonk.get(t).setAlpha(1f);

                        }
                        buttonk.get(i).setText(pilihan[pilih]);

                        break;


                }

            }


        }else {
            Toast.makeText(getContext(), "Nyawa Habis, Tambah nyawa dengan kuis Mitos/Fakta", Toast.LENGTH_SHORT).show();

            Intent intent;
            intent = new Intent(getContext(), menuKuisActivity.class);
            startActivity(intent);
        }
    }


// Checker


    public void checker(int jawaban, int nomor){
// jika soal ini telah di kerjakan maka gk akan dpt nilai

//        Jika jawaban benar maka Button akan berganti warna menjadi emas
        int jawabanBenar = jawabanPiliihanKuis[nomor];

        if(jawaban == jawabanBenar){
            buttonk.get(jawaban).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan2, null));
            if(nomor > soalDikerjakan){score+=10; soalDikerjakan++;} //blm di kerjakan dpt nilai soal di kerjakan + 1
            else if(nomor<=soalDikerjakan){}

            updateNilai();
            btnnext.setEnabled(true);
            btnexplain.setEnabled(true);
            btnnext.setAlpha(1f);
            btnexplain.setAlpha(1f);
            playMenang();
        }
        else {

            if(nyawa!=0){
                if(nomor > soalDikerjakan){
                    nyawa-=1;
                    soalDikerjakan++;

                } //blm di kerjakan maka nyawanya jadi 0
                else if(nomor<=soalDikerjakan){}
            }

            updateNilai();

            playKalah();
            buttonk.get(jawaban).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan3, null));
            buttonk.get(jawabanBenar).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan2, null));
            pw.showAtLocation(fragmentLayout.findViewById(R.id.kuis9), Gravity.CENTER, 0, 0);

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
            case R.id.C:
                btnC.startAnimation(myAnim);
                checker(2,currentNumb);

                break;
            case R.id.D:
                btnD.startAnimation(myAnim);
                checker(3,currentNumb);

                break;

            case R.id.exit:
                btnexit.startAnimation(myAnim);
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);

                break;
            case R.id.next:
                btnnext.startAnimation(myAnim);
                currentNumb++;
                changeIsiKuis(currentNumb);
                break;
            case R.id.explain:
                btnexplain.startAnimation(myAnim);
                pw.showAtLocation(fragmentLayout.findViewById(R.id.kuis9), Gravity.CENTER, 0, 0);
                btnnext.setEnabled(true);
                btnexplain.setEnabled(true);
                btnnext.setAlpha(1f);
                btnexplain.setAlpha(1f);
                break;

        }
    }

    public void updateNilai(){

        if(nyawa < 0) nyawa = 0;

        editor.putInt(getString(R.string.QUIZ_AKU_SCORE), score);
        editor.putInt(getString(R.string.QUIZ_AKU_NYAWA), nyawa);
        editor.putInt(getString(R.string.QUIZ_AKU_LEVEL), levelku);
        editor.putInt(getString(R.string.QUIZ_AKU_SOAL9), soalDikerjakan);

//        Integer leve = levelku;

//        Integer soaldi = soalDikerjakan;
//        Toast.makeText(getContext(), nyawa.toString(),Toast.LENGTH_SHORT).show();
//        Toast.makeText(getContext(), soaldi.toString(),Toast.LENGTH_SHORT).show();

        editor.commit();

        ((KuisAKU) getActivity()).cekProfil();



    }
    public void playMenang()
    {
        MediaPlayer menang;
        menang = MediaPlayer.create(getContext(), R.raw.menang);
        menang.setVolume(100,100);
        menang.setLooping(false);
        boolean sfxOn = userData.getBoolean(getString(R.string.QUIZ_AKU_SFX), true);
        if(sfxOn) menang.start();
    }

    public void playKalah()
    {
        MediaPlayer menang;
        menang = MediaPlayer.create(getContext(), R.raw.kalah);
        menang.setVolume(100,100);
        menang.setLooping(false);
        boolean sfxOn = userData.getBoolean(getString(R.string.QUIZ_AKU_SFX), true);
        if(sfxOn) menang.start();
    }
}