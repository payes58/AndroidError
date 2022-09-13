package com.example.bolsaborrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Recuperacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperacion);
    }

    public void MensajeAdmin(View view){
        Intent miIntent = null;
        Toast.makeText(this, "Notificación enviada al Administrador", Toast.LENGTH_SHORT).show();
        switch (view.getId()){
            case R.id.btnAdmin:
                miIntent = new Intent(Recuperacion.this, InicioSesion.class);
                break;
        }
        startActivity(miIntent);
    }

    public void MensajeCorreo(View view){
        Intent miIntent = null;
        Toast.makeText(this, "Correo enviado", Toast.LENGTH_SHORT).show();
        switch (view.getId()){
            case R.id.btnCorreo:
                miIntent = new Intent(Recuperacion.this, InicioSesion.class);
        }
        startActivity(miIntent);
    }
}