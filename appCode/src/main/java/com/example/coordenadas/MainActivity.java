package com.example.coordenadas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Math;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText ed1,ed2,ed3;
    TextView rp;
    Button respuesta;
    RadioButton rb1,rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText)findViewById(R.id.ed1);
        ed2 = (EditText)findViewById(R.id.ed2);
        ed3 = (EditText)findViewById(R.id.ed3);
        rp = (TextView)findViewById(R.id.rp);
        rb1 = (RadioButton)findViewById(R.id.rb_grados);
        rb2 = (RadioButton)findViewById(R.id.rb_radian);
        respuesta = (Button)findViewById(R.id.button2);
        respuesta.setOnClickListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu){
            getMenuInflater().inflate(R.menu.men,menu);
            return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.men1){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }else if(id == R.id.men2){
            Intent intent=new Intent(this,Geometrica.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View view) {
        float n1,n2,n3,x,y,z;
        String nUno,nDos,nTres;
        nUno = ed1.getText().toString();
        nDos = ed2.getText().toString();
        nTres = ed3.getText().toString();
        if(nUno.isEmpty() || nDos.isEmpty() || nTres.isEmpty() || rb1.isChecked()==false && rb2.isChecked()==false){
                Toast.makeText(this,"Tienes que llenar todos los campos",Toast.LENGTH_SHORT).show();
        }else {
            n1 = Float.parseFloat(nUno);
            n2 = Float.parseFloat(nDos);
            n3 = Float.parseFloat(nTres);
            if(rb1.isChecked()==true){
                n2 = (float) (n2*(Math.PI/180.0));
                n3 = (float) (n3*(Math.PI/180.0));
                x = (float) (n1 * Math.cos(n2) * Math.sin(n3));
                y = (float) (n1 * Math.sin(n2) * Math.sin(n3));
                z = (float) (n1 * Math.cos(n3));
                rp.setText("Las coordenadas cartesianas son:\nx = " + x + "\ny = " + y + "\nz = " + z);
            }else if(rb2.isChecked()==true) {
                x = (float) (n1 * Math.cos(n2) * Math.sin(n3));
                y = (float) (n1 * Math.sin(n2) * Math.sin(n3));
                z = (float) (n1 * Math.cos(n3));
                rp.setText("Las coordenadas cartesianas son:\nx = " + x + "\ny = " + y + "\nz = " + z);
            }
        }
    }
}