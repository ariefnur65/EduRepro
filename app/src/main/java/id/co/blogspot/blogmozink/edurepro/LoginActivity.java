package id.co.blogspot.blogmozink.edurepro;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText inputUmur;
    Spinner inputKelamin;

    EditText inputNama;
    Button btnLanjut;
    Animation myAnim;
    final String QUIZ_AKU_USERNAME= "id.co.blogspot.blogmozink.aku.username";
    final String QUIZ_AKU_UMURUSER = "id.co.blogspot.blogmozink.aku.umur";
    ArrayAdapter<CharSequence> adapterUmur;
    ArrayAdapter<CharSequence> adapterKelamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputUmur = (EditText) findViewById(R.id.inputUmur);
        inputNama = (EditText) findViewById(R.id.inputNama);
        inputKelamin = (Spinner) findViewById(R.id.kelamin);


        btnLanjut = (Button) findViewById(R.id.btn_lanjut);

        myAnim = AnimationUtils.loadAnimation(this, R.anim.grind);

        // Create an ArrayAdapter using the string array and a default spinner layout
//        adapterUmur = ArrayAdapter.createFromResource(this,
//                R.array.pemilihan_umur, R.layout.spinner_dropdown_costum);
        adapterKelamin = ArrayAdapter.createFromResource(this,
                R.array.jenis, R.layout.spinner_dropdown_costum);
        // Specify the layout to use when the list of choices appears
//        adapterUmur.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterKelamin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
//        inputUmur.setAdapter(adapterUmur);
        inputKelamin.setAdapter(adapterKelamin);
        SharedPreferences userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String namaTersimpan = userData.getString(getString(R.string.QUIZ_AKU_USERNAME),"0");
        Integer umurTersimpan = userData.getInt(getString(R.string.QUIZ_AKU_UMURUSER), 0);

        if(!namaTersimpan.equals("0") && ! (umurTersimpan == 0)){
//            inputUmur.setSelection(umurTersimpan-10);
            inputNama.setText(namaTersimpan);
            inputUmur.setText(umurTersimpan.toString());

        }

        Boolean kelamin = userData.getBoolean(getString(R.string.QUIZ_AKU_KELAMINUSER),true);

        if(kelamin)
        {
            inputKelamin.setSelection(0);
        }
        else
        {
            inputKelamin.setSelection(1);
        }



    }



    public void lanjutClick(View v){
        btnLanjut.startAnimation(myAnim);

        if(inputNama.getText().toString().matches(".+") && inputUmur.getText().toString().matches("[0-9]+")) {
            Integer umurUser = Integer.parseInt(inputUmur.getText().toString());
            String namaUser = inputNama.getText().toString();

            SharedPreferences userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor = userData.edit();
//            Intent svc=new Intent(this, soundManager.class);

            boolean BGM = userData.getBoolean(getString(R.string.QUIZ_AKU_BGM), true);
            soundManager.start(getApplicationContext());



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


            editor.putInt(getString(R.string.QUIZ_AKU_UMURUSER), umurUser);
            editor.commit();
            editor.putString(getString(R.string.QUIZ_AKU_USERNAME), namaUser);
            editor.commit();

            if (inputKelamin.getSelectedItem().toString().equals("Laki-laki")) {
                editor.putBoolean(getString(R.string.QUIZ_AKU_KELAMINUSER), true);
            } else {
                editor.putBoolean(getString(R.string.QUIZ_AKU_KELAMINUSER), false);
            }
            editor.commit();


            Intent intent;
            intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Isi semua data diri anda",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onBackPressed() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);

    }
}
