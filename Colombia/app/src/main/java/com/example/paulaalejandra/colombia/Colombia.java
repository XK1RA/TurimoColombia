package com.example.paulaalejandra.colombia;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Colombia extends AppCompatActivity {

    int [] imagenes={
            R.drawable.colombia,
            R.drawable.colombia1,
            R.drawable.colombia2,
            R.drawable.colombia3,
            R.drawable.colombia4
    };

    ManejadorGaleria manejadorGaleria;
    ManejadorGaleria mSectionsPagerAdapter;

    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colombia);


        //Galeria
        manejadorGaleria = new ManejadorGaleria(getSupportFragmentManager());


        mViewPager=(ViewPager)findViewById(R.id.pager);

        manejadorGaleria.agregarFragmentos(PlaceholderFragment.newInstance(imagenes[0]));
        manejadorGaleria.agregarFragmentos(PlaceholderFragment.newInstance(imagenes[1]));
        manejadorGaleria.agregarFragmentos(PlaceholderFragment.newInstance(imagenes[2]));
        manejadorGaleria.agregarFragmentos(PlaceholderFragment.newInstance(imagenes[3]));

        mViewPager.setAdapter(manejadorGaleria);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_colombia, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        switch (item.getItemId()){
            case R.id.sesion:
                Intent
                return true;
            case R.id.recomendados:
                return true;
            case R.id.departamentos:
                return true;
            case R.id.salir:
                finish();
                return true;


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class ManejadorGaleria extends FragmentPagerAdapter {
        List<Fragment> fragmentos;
        public ManejadorGaleria(FragmentManager fm) {

            super(fm);
            fragmentos =new ArrayList<Fragment>();
        }
        public void agregarFragmentos(Fragment xfragmentos){
            fragmentos.add(xfragmentos);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return fragmentos.get(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_IMAGE = "imagen";
        private int imagen;
        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int imagen) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_IMAGE, imagen);
            fragment.setArguments(args);
            fragment.setRetainInstance(true);
            return fragment;
        }
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            if(getArguments()!=null){
                imagen=getArguments().getInt(ARG_IMAGE);

            }
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_colombia, container, false);
            ImageView imagenView=(ImageView)rootView.findViewById(R.id.imageView2);
            imagenView.setImageResource(imagen);
            return rootView;
        }
    }

}
