package id.co.blogspot.blogmozink.edurepro;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class fragmentMateri5 extends Fragment {

    View fragmentLayout;
    View layout;
    View mainlayout;
    ViewGroup.LayoutParams layoutParams;

    private PopupWindow pw;
    private PopupWindow pw2;

    private PopupWindow pw3;
    private PopupWindow pw4;

    private ImageView bpw,bpw2,bpw3,bpw4;

    public fragmentMateri5(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLayout = inflater.inflate(R.layout.activity_fragment_materi5,container,false);
        View fragmentPopup = inflater.inflate(R.layout.fragment_organ_dalam_pria,container,false);
        layoutParams = fragmentPopup.getLayoutParams();

        layout = inflater.inflate(R.layout.fragment_organ_dalam_pria,
                (ViewGroup) fragmentPopup.findViewById(R.id.organdalamlayout));
        mainlayout = inflater.inflate(R.layout.activity_fragment_materi5,
                (ViewGroup) fragmentLayout.findViewById(R.id.fragmentMateri5));
        pw = new PopupWindow(layout, layoutParams.width, layoutParams.height, true);
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


        fragmentPopup = inflater.inflate(R.layout.fragment_organ_luar_pria,container,false);
        layoutParams = fragmentPopup.getLayoutParams();

        layout = inflater.inflate(R.layout.fragment_organ_luar_pria,
                (ViewGroup) fragmentPopup.findViewById(R.id.organluarlayout));

        pw2 = new PopupWindow(layout, layoutParams.width, layoutParams.height, true);
        bpw2 = fragmentPopup.findViewById(R.id.close);
        bpw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animated;
                animated = AnimationUtils.loadAnimation(getContext(),R.anim.grind);
                bpw2.startAnimation(animated);

                pw2.dismiss();
            }
        });


        fragmentPopup = inflater.inflate(R.layout.fragment_organ_luar_wanita,container,false);
        layoutParams = fragmentPopup.getLayoutParams();

        layout = inflater.inflate(R.layout.fragment_organ_luar_wanita,
                (ViewGroup) fragmentPopup.findViewById(R.id.organluarlayout));
        pw3 = new PopupWindow(layout, layoutParams.width, layoutParams.height, true);
        bpw3 = fragmentPopup.findViewById(R.id.close);
        bpw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animated;
                animated = AnimationUtils.loadAnimation(getContext(),R.anim.grind);
                bpw3.startAnimation(animated);

                pw3.dismiss();
            }
        });

        fragmentPopup = inflater.inflate(R.layout.fragment_organ_dalam_wanita,container,false);
        layoutParams = fragmentPopup.getLayoutParams();

        layout = inflater.inflate(R.layout.fragment_organ_dalam_wanita,
                (ViewGroup) fragmentPopup.findViewById(R.id.organdalamlayout));
        pw4 = new PopupWindow(layout, layoutParams.width, layoutParams.height, true);
        bpw4 = fragmentPopup.findViewById(R.id.close);
        bpw4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animated;
                animated = AnimationUtils.loadAnimation(getContext(),R.anim.grind);
                bpw4.startAnimation(animated);

                pw4.dismiss();
            }
        });





        // display the popup in the center
//

        ImageView gambarDalamPria = (ImageView) fragmentLayout.findViewById(R.id.gambarPriaDalam);
        ImageView gambarLuarPria = (ImageView) fragmentLayout.findViewById(R.id.gambarPriaLuar);
        ImageView gambarDalamWanita = (ImageView) fragmentLayout.findViewById(R.id.gambarWanitaDalam);
        ImageView gambarLuarWanita = (ImageView) fragmentLayout.findViewById(R.id.gambarWanitaLuar);



        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.pria, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        String imageType = options.outMimeType;

        gambarDalamPria.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.pria, 238, 200));
        BitmapFactory.decodeResource(getResources(), R.drawable.tabelperubahanremaja, options);
         imageHeight = options.outHeight;
         imageWidth = options.outWidth;
         imageType = options.outMimeType;


        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.pria_priia, options);
         imageHeight = options.outHeight;
         imageWidth = options.outWidth;
         imageType = options.outMimeType;
        gambarLuarPria.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.pria_priia, 238, 200));


        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.wanita_wanita, options);
        imageHeight = options.outHeight;
        imageWidth = options.outWidth;
        imageType = options.outMimeType;
        gambarLuarWanita.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.wanita_wanita, 238, 200));

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.lwanita_organ_repro_wanita, options);
        imageHeight = options.outHeight;
        imageWidth = options.outWidth;
        imageType = options.outMimeType;
        gambarDalamWanita.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.drawable.lwanita_organ_repro_wanita, 238, 200));





        Button spoiler1 = (Button) fragmentLayout.findViewById(R.id.spoiler5_1);
        Button spoiler2 = (Button) fragmentLayout.findViewById(R.id.spoiler5_2);
        Button spoiler3 = (Button) fragmentLayout.findViewById(R.id.spoiler5_3);

        final LinearLayout gambarPriaLuar = (LinearLayout) fragmentLayout.findViewById(R.id.penjelasan51);
        final LinearLayout gambarPriaDalam = (LinearLayout) fragmentLayout.findViewById(R.id.penjelasan52);
        final LinearLayout gambarWanitaaLuar = (LinearLayout) fragmentLayout.findViewById(R.id.penjelasan53);
        final LinearLayout gambarWanitaDalam = (LinearLayout) fragmentLayout.findViewById(R.id.penjelasan54);


        gambarPriaLuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animated;
                animated = AnimationUtils.loadAnimation(getContext(),R.anim.grind);
                gambarPriaLuar.startAnimation(animated);

                pw2.showAtLocation(mainlayout, Gravity.CENTER, 0, 0);



            }
        });

        gambarPriaDalam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animated;
                animated = AnimationUtils.loadAnimation(getContext(),R.anim.grind);
                gambarPriaDalam.startAnimation(animated);

                pw.showAtLocation(mainlayout, Gravity.CENTER, 0, 0);



            }
        });


        gambarWanitaaLuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animated;
                animated = AnimationUtils.loadAnimation(getContext(),R.anim.grind);
                gambarWanitaaLuar.startAnimation(animated);

                pw3.showAtLocation(mainlayout, Gravity.CENTER, 0, 0);



            }
        });

        gambarWanitaDalam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animated;
                animated = AnimationUtils.loadAnimation(getContext(),R.anim.grind);
                gambarWanitaDalam.startAnimation(animated);

                pw4.showAtLocation(mainlayout, Gravity.CENTER, 0, 0);



            }
        });


        spoiler1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout51)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout52)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });

        spoiler3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout spoilerLayout = (LinearLayout) fragmentLayout.findViewById(R.id.spoiler_layout53)  ;

                if(spoilerLayout.getVisibility() == View.VISIBLE){
                    spoilerLayout.setVisibility(View.GONE);
                }
                else
                {
                    spoilerLayout.setVisibility(View.VISIBLE);
                }
            }

        });




        return fragmentLayout;

    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }


    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

}