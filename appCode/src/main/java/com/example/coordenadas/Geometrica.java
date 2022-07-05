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
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

public class Geometrica extends AppCompatActivity implements View.OnClickListener {
    EditText ed1,ed2,ed3;
    TextView rp;
    Button respuesta;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometrica);
        ed1 = (EditText)findViewById(R.id.ed1);
        ed2 = (EditText)findViewById(R.id.ed2);
        ed3 = (EditText)findViewById(R.id.ed3);
        rp = (TextView)findViewById(R.id.rp);
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
        float n1,n2,n3,r,teta,fi;
        String nUno,nDos,nTres;
        nUno = ed1.getText().toString();
        nDos = ed2.getText().toString();
        nTres = ed3.getText().toString();
        if(nUno.isEmpty() || nDos.isEmpty() || nTres.isEmpty()){
            Toast.makeText(this,"Tienes que llenar todos los campos",Toast.LENGTH_SHORT).show();
        }else {
            n1 = Float.parseFloat(nUno);
            n2 = Float.parseFloat(nDos);
            n3 = Float.parseFloat(nTres);
            r = (float)(Math.sqrt(Math.pow(n1,2)+Math.pow(n2,2)+Math.pow(n3,2)));
            teta = (float)(Math.atan((Math.sqrt(Math.pow(n1,2)+Math.pow(n2,2)))/(n3)));
            if(n3>0){
                fi =  (float)(Math.atan(n2/n1));
            }else{
                fi =  (float)(Math.atan(n2/n1)+Math.PI);
            }
            rp.setText("Las coordenadanas geometricas son:\nr = "+r+"\nθ = "+teta+"\nφ = "+fi);
        }


    }
}