package com.example.paulaalejandra.clases;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Departamentos extends AppCompatActivity {


    String [] ImagePrinc={"meta","huila","toliama","Cundinamarca"};
    android.widget.ListView ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamentos);

        ListView Lista=(ListView)findViewById (R.id.listView2);
        ArrayAdapter adapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1,ImagePrinc);
        Lista.setAdapter(adapter);
        Lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valor="en el momento se encuentra en mantenimiento este boton";
                Toast.makeText(getApplicationContext(), valor, Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_departamentos, menu);
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
}
