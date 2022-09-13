package com.example.bolsaborrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Registrarme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarme);
    }

    public void onClick (View view){
        Intent miIntent = null;

        switch (view.getId()){
            case R.id.txtYa:
                miIntent = new Intent(Registrarme.this, InicioSesion.class);
                break;
            case R.id.txtYa1:
                miIntent = new Intent(Registrarme.this, InicioSesion.class);
                break;
        }
        startActivity(miIntent);
    }

    public void Mensaje(View view){

        Intent miIntent = null;
        Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show();
        switch (view.getId()){
            case R.id.btnRegistrar:
                miIntent = new Intent(Registrarme.this, InicioSesion.class);
                break;

        }
        startActivity(miIntent);
    }
}