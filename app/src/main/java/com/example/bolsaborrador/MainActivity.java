package com.example.bolsaborrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView tv_Genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "bd", null, 1);
       // SQLiteDatabase bd = admin.getReadableDatabase();

       // Cursor consulta = bd.rawQuery("select * from Genders", null);
        //if (consulta.moveToFirst()){
          //  String temp_genero = consulta.getString(1);

           // tv_Genero.setText("Genero: " + temp_genero );
        }
       // bd.close();

   // }

    public void onClick (View view){
        Intent miIntent = null;

        switch (view.getId()){
            case R.id.btnIniciarSesion:
                miIntent = new Intent(MainActivity.this, InicioSesion.class);
                break;


            case R.id.btnRegistrarme:
                miIntent = new Intent(MainActivity.this, Registrarme.class);
                break;

        }
        startActivity(miIntent);
    }
}