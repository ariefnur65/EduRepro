package id.co.blogspot.blogmozink.edurepro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class fragmentKuis5 extends Fragment implements View.OnClickListener {
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


//    Another gambar

    Button btnA2, btnB2, btnC2, btnD2;
    LinkedList<Button> buttonk2 = new LinkedList<Button>();
    ImageButton btnexit2, btnnext2, btnexplain2;
    private ImageView bpw2;
    private PopupWindow pw2;
    View layout2;

    View denganGambar;
    View tanpaGambar;

    JustifyTextView soal2;
    TextView restNumber2;
    TextView currentNumber2;
    ImageView penjelasan2;
    String[] jenisSoal;
    ViewGroup.LayoutParams layoutParams2;
    ImageView soalImage;


    LinkedList<Drawable> imageSoal = new LinkedList<>();

    LinkedList<Drawable> imageJawaban = new LinkedList<>();

    public fragmentKuis5(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.activity_fragment_kuis5,container,false);
        btnA = fragmentLayout.findViewById(R.id.A);
        btnB = fragmentLayout.findViewById(R.id.B);
        btnC = fragmentLayout.findViewById(R.id.C);
        btnD = fragmentLayout.findViewById(R.id.D);
        btnA2 = fragmentLayout.findViewById(R.id.A2);
        btnB2 = fragmentLayout.findViewById(R.id.B2);
        btnC2 = fragmentLayout.findViewById(R.id.C2);
        btnD2 = fragmentLayout.findViewById(R.id.D2);
        btnexit = fragmentLayout.findViewById(R.id.exit);
        btnnext = fragmentLayout.findViewById(R.id.next);
        btnexplain = fragmentLayout.findViewById(R.id.explain);

        denganGambar = fragmentLayout.findViewById(R.id.denganGambar);
        tanpaGambar = fragmentLayout.findViewById(R.id.tanpaGambar);



        btnexit2 = fragmentLayout.findViewById(R.id.exit2);
        btnnext2 = fragmentLayout.findViewById(R.id.next2);
        btnexplain2 = fragmentLayout.findViewById(R.id.explain2);


        soalImage = fragmentLayout.findViewById(R.id.soalImage);

        View kuisku = inflater.inflate(R.layout.activity_kuis_aku,container, false);

        life = (TextView) kuisku.findViewById(R.id.life);
        skore = (TextView) kuisku.findViewById(R.id.score);


        buttonk2.add(btnA2);
        buttonk2.add(btnB2);
        buttonk2.add(btnC2);
        buttonk2.add(btnD2);

        buttonk.add(btnA);
        buttonk.add(btnB);
        buttonk.add(btnC);
        buttonk.add(btnD);

        soalString = getResources().getStringArray(R.array.soal5);
        pilihan = getResources().getStringArray(R.array.pilihan5);
        jumlahpilhan = getResources().getIntArray(R.array.jumlahpilihan5);
        jawabankuis = getResources().getStringArray(R.array.penjelasanjawaban5);
        jawabanPiliihanKuis = getResources().getIntArray(R.array.jawabankuis5);
        jenisSoal = getResources().getStringArray(R.array.jenisSoal5);

        soal2 = fragmentLayout.findViewById(R.id.soal2);
        soal = fragmentLayout.findViewById(R.id.soal);

        restNumber = fragmentLayout.findViewById(R.id.rest);
        currentNumber = fragmentLayout.findViewById(R.id.current);

        restNumber2 = fragmentLayout.findViewById(R.id.rest2);
        currentNumber2 = fragmentLayout.findViewById(R.id.current2);

        restNumb = 6;//Ganti ini sesuai jumlah soal
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

        btnA2.setOnClickListener(this);
        btnB2.setOnClickListener(this);
        btnC2.setOnClickListener(this);
        btnD2.setOnClickListener(this);

        btnexit2.setOnClickListener(this);
        btnnext2.setOnClickListener(this);
        btnexplain2.setOnClickListener(this);

        View fragmentPopup = inflater.inflate(R.layout.popup_penjelasan,container,false);
        View fragmentPopup2 = inflater.inflate(R.layout.popup_gambar,container,false);

        penjelasan2 = fragmentPopup2.findViewById(R.id.imagePenjelasan);
        layoutParams2 = fragmentPopup2.getLayoutParams();

        penjelasan = fragmentPopup.findViewById(R.id.teksPenjelasan);
        layoutParams = fragmentPopup.getLayoutParams();

        layout = inflater.inflate(R.layout.popup_penjelasan,
                (ViewGroup) fragmentPopup.findViewById(R.id.popupanswer));
        layout2 = inflater.inflate(R.layout.popup_gambar,
                (ViewGroup) fragmentPopup2.findViewById(R.id.popupanswer));
//        mainlayout = inflater.inflate(R.layout.activity_fragment_kuis1,
//                (ViewGroup) fragmentLayout.findViewById(R.id.kuis1));
        pw = new PopupWindow(layout, layoutParams.width, layoutParams.height, true);
        pw2 = new PopupWindow(layout2, layoutParams2.width, layoutParams2.height, true);
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



        bpw2 = fragmentPopup2.findViewById(R.id.close);
        bpw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animated;
                animated = AnimationUtils.loadAnimation(getContext(),R.anim.grind);
                bpw2.startAnimation(animated);

                pw2.dismiss();
            }
        });





        userData = PreferenceManager.getDefaultSharedPreferences(getContext());
        editor = userData.edit();
        score = userData.getInt(getString(R.string.QUIZ_AKU_SCORE), 0);
        nyawa = userData.getInt(getString(R.string.QUIZ_AKU_NYAWA), 0);
        levelku = userData.getInt(getString(R.string.QUIZ_AKU_LEVEL), 0);
        namaTersimpan = userData.getString(getString(R.string.QUIZ_AKU_USERNAME),"0");
        soalDikerjakan = userData.getInt(getString(R.string.QUIZ_AKU_SOAL5),-1);
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


        denganGambar.setVisibility(View.GONE);
        tanpaGambar.setVisibility(View.GONE);
        btnexit2.setAlpha(1f);
        btnexit2.setEnabled(true);

        btnnext.setEnabled(false);
        btnexplain.setEnabled(false);
        btnnext.setAlpha(0.5f);
        btnexplain.setAlpha(0.5f);

        btnnext2.setEnabled(false);
        btnexplain2.setEnabled(false);
        btnnext2.setAlpha(0.5f);
        btnexplain2.setAlpha(0.5f);
        for (int i =0; i < buttonk.size();i++)
        {
            buttonk.get(i).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan1, null));
            buttonk.get(i).setEnabled(true);

        }

        for (int i =0; i < buttonk2.size();i++)
        {
            buttonk2.get(i).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan1, null));
            buttonk2.get(i).setEnabled(true);

        }

    }


    public void changeIsiKuis(Integer nomor){


        cleanButton();

        Integer nomored;
        if(nomor==restNumb) nomored = nomor -1;
        else nomored = nomor;


        if(jenisSoal[nomored].equals("Gambar"))
        {

            if(nyawa!=0 || nomor == restNumb){
                if(nomor>=restNumb){
                    if(levelku <5)
                    {
                        levelku = 5;
                        updateNilai();
                        Intent intent;
                        intent = new Intent(getContext(), levelUp.class);
                        startActivity(intent);
                    }else {
                        Intent intent;
                        intent = new Intent(getContext(), menuKuisActivity.class);
                        startActivity(intent);
                    }
                    return;
                }
                denganGambar.setVisibility(View.VISIBLE);
                tanpaGambar.setVisibility(View.GONE);

                btnexit2.setEnabled(true);
                btnexit2.setAlpha(1f);

//                imageSoal.add(ResourcesCompat.getDrawable(getResources(), R.drawable.gambarkuis2, null));
//                imageSoal.add(ResourcesCompat.getDrawable(getResources(), R.drawable.gambarkuis3, null));


//                imageJawaban.add(ResourcesCompat.getDrawable(getResources(), R.drawable.gambarkuis1, null));
//                imageJawaban.add(ResourcesCompat.getDrawable(getResources(), R.drawable.gambarkuis4, null));

//        Memasukan Soal
                soal2.setText(soalString[nomor]);
                switch (nomor)
                {
                    case 0:
                        soalImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.gambarkuis2, null));

                        break;

                    case 1:
                        soalImage.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.gambarkuis3, null));

                        break;

                }
//        Memasukan rest
                restNumber2.setText(restNumb.toString());
//        Current
                Integer current = nomor +1;
                currentNumber2.setText(current.toString());

                soal2.setText(soalString[nomor]);
                switch (nomor)
                {
                    case 0:
                        penjelasan2.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.gambarkuis1, null));

                        break;

                    case 1:
                        penjelasan2.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.gambarkuis4, null));

                        break;

                }
//                penjelasan2.setImageDrawable(imageJawaban.get(nomor));

//                penjelasan.setText(jawabankuis[nomor]);
//        Memasukan Pilhan

                int x =0;
//            x = selectorpilihan(nomor) - 1;

                for(int p =0; p < nomor; p++){
                    x += jumlahpilhan[p];
                }

                Integer u = x;

                for(int i = 0 ; i < jumlahpilhan[nomor];i++){
                    int pilih = i + x;

                    for (int t =0; t < buttonk2.size();t++)
                    {
                        buttonk2.get(t).setEnabled(true);
                        buttonk2.get(t).setAlpha(1f);

                    }
                    buttonk2.get(i).setText(pilihan[pilih]);


                }


            }else {
                Toast.makeText(getContext(), "Nyawa Habis, Tambah nyawa dengan kuis Mitos/Fakta", Toast.LENGTH_SHORT).show();

                Intent intent;
                intent = new Intent(getContext(), menuKuisActivity.class);
                startActivity(intent);
            }
        }
        else
        {
            if(nyawa!=0 || nomor == restNumb){
            if(nomor>=restNumb){
                if(levelku <5)
                {
                    levelku = 5;
                    updateNilai();
                    Intent intent;
                    intent = new Intent(getContext(), levelUp.class);
                    startActivity(intent);
                }else {
                    Intent intent;
                    intent = new Intent(getContext(), menuKuisActivity.class);
                    startActivity(intent);
                }
                return;
            }
            tanpaGambar.setVisibility(View.VISIBLE);
                denganGambar.setVisibility(View.GONE);

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

                        break;


                }

            }


        }else {
            Toast.makeText(getContext(), "Nyawa Habis, Tambah nyawa dengan kuis Mitos/Fakta", Toast.LENGTH_SHORT).show();

            Intent intent;
            intent = new Intent(getContext(), menuKuisActivity.class);
            startActivity(intent);
        }}


    }


// Checker


    public void checker(int jawaban, int nomor){
// jika soal ini telah di kerjakan maka gk akan dpt nilai

        int jawabanBenar = jawabanPiliihanKuis[nomor];
        Integer nomored;
        if(nomor==restNumb) nomored = nomor -1;
        else nomored = nomor;

        if(jenisSoal[nomor].equals("Gambar"))
        {


            if(jawaban == jawabanBenar){
                buttonk2.get(jawaban).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan2, null));
                if(nomor > soalDikerjakan){score+=10; soalDikerjakan++;} //blm di kerjakan dpt nilai soal di kerjakan + 1
                else if(nomor<=soalDikerjakan){}

                updateNilai();
                btnnext2.setEnabled(true);
                btnexplain2.setEnabled(true);
                btnnext2.setAlpha(1f);
                btnexplain2.setAlpha(1f);
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
                pw2.showAtLocation(fragmentLayout.findViewById(R.id.kuis5), Gravity.CENTER, 0, 0);

                buttonk2.get(jawaban).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan3, null));
                buttonk2.get(jawabanBenar).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bgpilihan2, null));

                btnnext2.setEnabled(true);
                btnexplain2.setEnabled(true);
                btnnext2.setAlpha(1f);
                btnexplain2.setAlpha(1f);
            }
            btnexplain2.setEnabled(true);
            btnexplain2.setAlpha(1f);
            btnexit2.setEnabled(false);
            btnexit2.setAlpha(0.5f);
            for (int i =0; i < buttonk2.size();i++)
            {
                buttonk2.get(i).setEnabled(false);
            }


        }
        else{


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

                pw.showAtLocation(fragmentLayout.findViewById(R.id.kuis5), Gravity.CENTER, 0, 0);

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
        }

//        Jika jawaban benar maka Button akan berganti warna menjadi emas



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
                pw.showAtLocation(fragmentLayout.findViewById(R.id.kuis5), Gravity.CENTER, 0, 0);
                btnnext.setEnabled(true);
                btnexplain.setEnabled(true);
                btnnext.setAlpha(1f);
                btnexplain.setAlpha(1f);
                break;

            case R.id.A2:
                btnA2.startAnimation(myAnim);
                checker(0,currentNumb);
                break;
            case R.id.B2:
                btnB2.startAnimation(myAnim);
                checker(1,currentNumb);

                break;
            case R.id.C2:
                btnC2.startAnimation(myAnim);
                checker(2,currentNumb);

                break;
            case R.id.D2:
                btnD2.startAnimation(myAnim);
                checker(3,currentNumb);

                break;
            case R.id.exit2:
                btnexit2.startAnimation(myAnim);
                Intent intent2 = new Intent(getContext(), MainActivity.class);
                startActivity(intent2);

                break;
            case R.id.next2:
                btnnext2.startAnimation(myAnim);
                currentNumb++;
                changeIsiKuis(currentNumb);
                break;
            case R.id.explain2:
                btnexplain2.startAnimation(myAnim);
                pw2.showAtLocation(fragmentLayout.findViewById(R.id.kuis5), Gravity.CENTER, 0, 0);
                btnnext2.setEnabled(true);
                btnexplain2.setEnabled(true);
                btnnext2.setAlpha(1f);
                btnexplain2.setAlpha(1f);
                break;

        }
    }

    public void updateNilai(){

        if(nyawa < 0) nyawa = 0;

        editor.putInt(getString(R.string.QUIZ_AKU_SCORE), score);
        editor.putInt(getString(R.string.QUIZ_AKU_NYAWA), nyawa);
        editor.putInt(getString(R.string.QUIZ_AKU_LEVEL), levelku);
        editor.putInt(getString(R.string.QUIZ_AKU_SOAL5), soalDikerjakan);

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
