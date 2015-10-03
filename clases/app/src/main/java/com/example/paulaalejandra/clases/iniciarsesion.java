package com.example.paulaalejandra.clases;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class iniciarsesion extends AppCompatActivity {
    EditText Name, Password;
    Button Ingresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarsesion);

        Name=(EditText)findViewById(R.id.NAME);
        Password =(EditText) findViewById(R.id.CONTRASEÑA);
        findViewById(R.id.IS).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString();
                String pssw = Password.getText().toString();
                if (name.equalsIgnoreCase("Moviles") && pssw.equalsIgnoreCase("1234")) {
                    startActivity(new Intent(iniciarsesion.this, pais.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Usuario o Contraseña incorrectas", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_iniciarsesion, menu);
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
