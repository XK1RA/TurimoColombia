package com.example.paulaalejandra.clases;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Camara extends AppCompatActivity  {
    Button btn;
    ImageView img;
    final static int cons=0;
    Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        btn=(Button)findViewById(R.id.capturar);
        findViewById(R.id.capturar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,cons);
            }
        });

        img=(ImageView)findViewById(R.id.imagen);
    }

    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==AppCompatActivity.RESULT_OK){
            Bundle ext=data.getExtras();
            bmp=(Bitmap)ext.get("data");
            img.setImageBitmap(bmp);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_camara, menu);
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
