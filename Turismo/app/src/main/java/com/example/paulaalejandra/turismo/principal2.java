package com.example.paulaalejandra.turismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class principal2 extends AppCompatActivity {
    String [] titulo=new String[]{"RESEÑA","MUNICIPIOS","ACTIVIDADES","LUGARES","COMENTARIOS"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal2);
        ListView lista=(ListView)findViewById(R.id.listaprincipal);
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, titulo);

        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
               // Toast.makeText(getApplicationContext(), "posicion " + (i + 1) + titulo[i], Toast.LENGTH_SHORT).show();
                switch (i) {
                    case 0 :
                        Intent in = new Intent(getApplicationContext(), resena.class);
                        startActivity(in);
                        break;
                    case 1 :
                        Intent ii = new Intent(getApplicationContext(), municipios2_1.class);
                        startActivity(ii);
                        break;
                    case 2 :
                        Intent iii = new Intent(getApplicationContext(), actividades.class);
                        startActivity(iii);
                        break;
                    case 3 :
                        Intent iv = new Intent(getApplicationContext(), lugares.class);
                        startActivity(iv);
                        break;
                    case 4 :
                        Intent v = new Intent(getApplicationContext(), comentarios.class);
                        startActivity(v);
                        break;
                    default:
                     //   Toast.makeText(getApplicationContext(), "no funciona", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal2, menu);
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
