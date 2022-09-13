package com.example.bolsaborrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class InicioSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
    }

    public void onClick (View view){
        Intent miIntent = null;

        switch (view.getId()){
            case R.id.txtOlvide:
                miIntent = new Intent(InicioSesion.this, Recuperacion.class);
                break;


            case R.id.lblRegis:
                miIntent = new Intent(InicioSesion.this, Registrarme.class);
                break;
            case R.id.lblRegis2:
                miIntent = new Intent(InicioSesion.this, Registrarme.class);
                break;

        }
        startActivity(miIntent);
    }

    public void Mensaje(View view){

        Intent miIntent = null;
        Toast.makeText(this, "Sesión Iniciada", Toast.LENGTH_SHORT).show();
        switch (view.getId()){
            case R.id.btnIngresar1:
                miIntent = new Intent(InicioSesion.this, Desplegable.class);
                break;

        }
        startActivity(miIntent);
    }
}