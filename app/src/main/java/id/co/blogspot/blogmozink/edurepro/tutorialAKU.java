package id.co.blogspot.blogmozink.edurepro;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class tutorialAKU extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_aku);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        LinkedList<Drawable> imageTutorial = new LinkedList<>();

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {



        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tutorial_aku, container, false);
            ImageView slideTutorial= (ImageView) rootView.findViewById(R.id.tutorialImage);
//
//            imageTutorial.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial, null));
//            imageTutorial.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial1, null));
//            imageTutorial.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial2, null));
//            imageTutorial.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial3, null));
//            imageTutorial.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial4, null));
//
//
//            imageTutorial.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial5, null));
//            imageTutorial.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial6, null));
//            imageTutorial.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial7, null));
//            imageTutorial.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial8, null));
//            imageTutorial.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial9, null));
//
//
//            imageTutorial.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial10, null));
//            imageTutorial.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial11, null));
//            imageTutorial.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial12, null));
//            imageTutorial.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial13, null));
//            imageTutorial.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial14, null));
//
//            imageTutorial.add(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial15, null));
//



            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            String isiArg = getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER));

            switch (getArguments().getInt(ARG_SECTION_NUMBER))
            {
                case 0:
                    slideTutorial.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial, null));
                    break;
                case 1:
                    slideTutorial.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial1, null));
                    break;
                case 2:
                    slideTutorial.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial2, null));
                    break;
                case 3:
                    slideTutorial.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial3, null));
                    break;
                case 4:
                    slideTutorial.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial4, null));
                    break;


                case 5:
                    slideTutorial.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial5, null));
                    break;
                case 6:
                    slideTutorial.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial6, null));
                    break;
                case 7:
                    slideTutorial.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial7, null));
                    break;
                case 8:
                    slideTutorial.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial8, null));
                    break;
                case 9:
                    slideTutorial.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial9, null));
                    break;


                case 10:
                    slideTutorial.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial10, null));
                    break;
                case 11:
                    slideTutorial.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial11, null));
                    break;
                case 12:
                    slideTutorial.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial12, null));
                    break;
                case 13:
                    slideTutorial.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial13, null));
                    break;
                case 14:
                    slideTutorial.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial14, null));
                    break;

                case 15:
                    slideTutorial.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial15, null));
                    break;

                case 16:
                    slideTutorial.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial16, null));
                    break;
                case 17:
                    slideTutorial.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.tutorial17, null));
                    break;

                default:
                    Intent intent;
                    intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                    break;
            }
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            // Show 16 total pages.
            return 19;
        }



        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent;
        intent = new Intent(getApplicationContext(), MainActivity.class);
        intentInitialize = true;
        if(!intentInitialize){
            soundManager.pause();
        }
        startActivity(intent);
    }


     Boolean intentInitialize;

    @Override
    protected  void onResume() {
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
