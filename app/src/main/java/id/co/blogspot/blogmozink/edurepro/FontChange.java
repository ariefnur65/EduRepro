package id.co.blogspot.blogmozink.edurepro;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Axoriea-LPMX on 05/07/2017.
 */
public class FontChange extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("Fonts/ComicSans.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        //....
    }
}
