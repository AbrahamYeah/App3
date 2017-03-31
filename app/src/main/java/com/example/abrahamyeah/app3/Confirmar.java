package com.example.abrahamyeah.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Confirmar extends AppCompatActivity {
    TextView Nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);
        Nombre = (TextView)findViewById(R.id.textViewConfirmacion);

        Intent eveto = getIntent();
        Bundle extras = eveto.getExtras();

        if(extras != null){
            String extraNombre = (String)extras.get("nombre");

            Nombre.setText(extraNombre);

        }
    }
}
