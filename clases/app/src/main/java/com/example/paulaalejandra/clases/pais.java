package com.example.paulaalejandra.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class pais extends AppCompatActivity {

    int [] imagenes={
            R.drawable.colombia,
            R.drawable.colombia1,
            R.drawable.colombia2,
            R.drawable.colombia3,
            R.drawable.colombia4
    };
    String [] ImagePrinc={"DEPARTAMENTOS","FESTIVIDADES","RANKING","CAMARA"
    };
    ManejadorGaleria manejadorGaleria;
    ListView ListView;
    ViewPager mViewPager;
    ManejadorGaleria mSectionsPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais);

        //Lista
       ListView Lista=(ListView)findViewById (R.id.listView2);
        ArrayAdapter adapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1,ImagePrinc);
        Lista.setAdapter(adapter);
        Lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent i=new Intent(getApplicationContext(), Departamentos.class);
                        startActivity(i);
                        break;
                    case 1:
                        String valor="en el momento se encuentra en mantenimiento este boton";
                        Toast.makeText(getApplicationContext(),valor,Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Intent iii=new Intent(getApplicationContext(), Ranking.class);
                        startActivity(iii);
                        break;
                    case 3:
                        Intent iv=new Intent(getApplicationContext(), Camara.class);
                        startActivity(iv);
                        break;
                }
            }
        });
        //Galeria
        manejadorGaleria = new ManejadorGaleria(getSupportFragmentManager());


        mViewPager=(ViewPager)findViewById(R.id.Pager);

        manejadorGaleria.agregarFragmentos(PlaceholderFragment.newInstance(imagenes[0]));
        manejadorGaleria.agregarFragmentos(PlaceholderFragment.newInstance(imagenes[1]));
        manejadorGaleria.agregarFragmentos(PlaceholderFragment.newInstance(imagenes[2]));
        manejadorGaleria.agregarFragmentos(PlaceholderFragment.newInstance(imagenes[3]));

        mViewPager.setAdapter(manejadorGaleria);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pais, menu);
        return true;
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
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class ManejadorGaleria extends FragmentPagerAdapter {

        List<Fragment> fragmentos;

        public ManejadorGaleria(FragmentManager fm) {

            super(fm);
            fragmentos = new ArrayList<Fragment>();
        }
        public void agregarFragmentos (Fragment xfragmentos){
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

            return fragmentos.size();
        }

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_IMAGE = "imagen";
        private int imagen;

        public static PlaceholderFragment newInstance(int imagen) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_IMAGE, imagen);
            fragment.setArguments(args);
            fragment.setRetainInstance(true);
            return fragment;
        }

        @Override
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
            View rootView = inflater.inflate(R.layout.fragment_pais, container, false);

            ImageView imagenView=(ImageView)rootView.findViewById(R.id.imageView2);
            imagenView.setImageResource(imagen);
            return rootView;
        }
    }
}
