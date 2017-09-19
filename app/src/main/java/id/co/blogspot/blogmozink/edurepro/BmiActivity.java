package id.co.blogspot.blogmozink.edurepro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.inputmethodservice.Keyboard;
import android.preference.PreferenceManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;



import java.io.StringBufferInputStream;

public class BmiActivity extends AppCompatActivity {
    Integer umurTersimpan;
    Boolean apakahCowo;
    Animation myAnim;

    boolean isClicked =false;

    PopupWindow popUpWindow;
    LayoutParams layoutParams;
    ConstraintLayout mainLayout;
    LinearLayout containerLayout;
    TextView tvMsg;
    private PopupWindow pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        SharedPreferences userData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String namaTersimpan = userData.getString(getString(R.string.QUIZ_AKU_USERNAME),"0");
        umurTersimpan = userData.getInt(getString(R.string.QUIZ_AKU_UMURUSER), 0);
        myAnim = AnimationUtils.loadAnimation(this,R.anim.grind);
        apakahCowo = userData.getBoolean(getString(R.string.QUIZ_AKU_KELAMINUSER), false);
//        Toast.makeText(getApplicationContext(), "Umur Saya: "+umurTersimpan.toString() + "Kelamin: "+ apakahCowo, Toast.LENGTH_LONG).show();

        intentInitialize = false;
    }



    public void openMain(View v){
        v.startAnimation(myAnim);

//
//        LayoutInflater inflater = (LayoutInflater) BmiActivity.this
//                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        View layout = inflater.inflate(R.layout.fragment_organ_dalam_pria,
//                (ViewGroup) findViewById(R.id.organdalamlayout));
//        View mainlayout = inflater.inflate(R.layout.activity_bmi,
//                (ViewGroup) findViewById(R.id.bmiConvert));
//
//
//        pw = new PopupWindow(layout, 600, 900, true);
//        // display the popup in the center
//        pw.showAtLocation(mainlayout, Gravity.CENTER, 0, 0);
        Intent intent;
        intent = new Intent(getApplicationContext(), MainActivity.class);
        intentInitialize = true;
        startActivity(intent);

    }
    public void menghitungBMI(View v){
        v.startAnimation(myAnim);
        EditText inputBerat = (EditText) findViewById(R.id.inputBerat);
        EditText inputTinggi = (EditText) findViewById(R.id.inputTinggi);
        EditText imtOutput = (EditText) findViewById(R.id.outputKet);
        TextView saranOutput = (TextView) findViewById(R.id.outputSaran);

        if(inputBerat.getText().toString().matches("[0-9]+") && inputTinggi.getText().toString().matches("[0-9]+")){
            Double berat = Double.parseDouble(inputBerat.getText().toString());
            Double tinggi = Double.parseDouble(inputTinggi.getText().toString());
            tinggi = tinggi /100;
            Double IMT = berat/(Math.pow(tinggi,2));
            String BMI = penentuanStatus(IMT,umurTersimpan,apakahCowo);
            imtOutput.setText(BMI);
            if(BMI.equals("Kurus")){
                saranOutput.setText( getText(R.string.bmi_kurus));
            }
            else if(BMI.equals("Normal")){
                saranOutput.setText(getText(R.string.bmi_normal));
            }
            else if (BMI.equals("Gemuk")){
                saranOutput.setText(getText(R.string.bmi_gemuk));
            }
            else {
                saranOutput.setText(getText(R.string.bmi_gemuk));
            }

            //Force Close the soft keyboard
            inputTinggi.clearFocus();
            View view = this.getCurrentFocus();
            if(view !=null){
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
//            Toast.makeText(getApplicationContext(), "Umur Saya: "+umurTersimpan.toString(), Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(this.getApplicationContext(),"Isi berat badan dan atau tinggi anda.", Toast.LENGTH_SHORT).show();
        }

    }

    private String penentuanStatus (Double nilaiBMI, int umur, boolean kelamin){
        String hasil;
        Double batasKurus;
        Double batasGemuk;
        if(kelamin)//Lakilaki
        {
            switch (umur){
                case 10:
                    batasKurus = 13.7;
                    batasGemuk = 21.4;
                    break;
                case 11:
                    batasKurus = 14.1;
                    batasGemuk = 22.5;
                    break;
                case 12:
                    batasKurus = 14.5;
                    batasGemuk = 23.8;
                    break;
                case 13:
                    batasKurus = 14.9;
                    batasGemuk = 23.8;
                    break;
                case 14:
                    batasKurus = 15.5;
                    batasGemuk = 24.8;
                    break;
                case 15:
                    batasKurus = 16d;
                    batasGemuk = 27d;
                    break;
                case 16:
                    batasKurus = 16.5;
                    batasGemuk = 27.9;
                    break;
                case 17:
                    batasKurus = 16.9;
                    batasGemuk = 28.6;
                    break;
                case 18:
                    batasKurus = 17.3;
                    batasGemuk = 30.0;
                    break;
                default:
                    batasKurus = 17d;
                    batasGemuk = 25d;
                    break;
            }
        }
        else//Perempuan
        {switch (umur){
            case 10:
                batasKurus = 13.5;
                batasGemuk = 22.6;
                break;
            case 11:
                batasKurus = 13.9;
                batasGemuk = 23.7;
                break;
            case 12:
                batasKurus = 14.4;
                batasGemuk = 24.9;
                break;
            case 13:
                batasKurus = 14.9;
                batasGemuk = 26.2;
                break;
            case 14:
                batasKurus = 15.5;
                batasGemuk = 27.3;
                break;
            case 15:
                batasKurus = 15.9;
                batasGemuk = 28.2;
                break;
            case 16:
                batasKurus = 16.2;
                batasGemuk = 28.9;
                break;
            case 17:
                batasKurus = 16.4;
                batasGemuk = 29.3;
                break;
            case 18:
                batasKurus = 16.4;
                batasGemuk = 29.5;
                break;
            default:
                batasKurus = 17d;
                batasGemuk = 24d;
                break;
        }}
        if(nilaiBMI > batasKurus && nilaiBMI<batasGemuk){
            hasil = "Normal";
        }
        else if(nilaiBMI<=batasKurus){
            hasil = "Kurus";
        }
        else if(nilaiBMI >= batasGemuk && nilaiBMI <= 30){
            hasil = "Gemuk";
        }
        else if (nilaiBMI > 30){
            hasil = "Obesitas";
        }
        else {
            hasil = "Obesitas";
        }
        return hasil;
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
