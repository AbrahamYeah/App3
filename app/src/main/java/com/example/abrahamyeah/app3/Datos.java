package com.example.abrahamyeah.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Datos extends AppCompatActivity implements View.OnClickListener{

    private TextView Nombre,Direccion,Telefono,FechaNac;
    private Button editar,confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        Nombre = (TextView)findViewById(R.id.TextoNombreUser);
        Direccion = (TextView)findViewById(R.id.TextoDireccionUser);
        Telefono = (TextView)findViewById(R.id.TextoTelefonoUser);
        FechaNac = (TextView)findViewById(R.id.TextoFechaUser);
        editar = (Button)findViewById(R.id.modificar);
        confirmar = (Button)findViewById(R.id.Confirmar);

        Intent entrada = getIntent();
        Bundle extras = entrada.getExtras();

        if (extras != null){
            String extraNombre = (String)extras.get("nombre");
            String extraDireccion = (String)extras.get("direccion");
            String extrasTelefono = (String)extras.get("telefono");
            String extrasFecha = (String)extras.get("fechaNac");

            Nombre.setText(extraNombre);
            Direccion.setText(extraDireccion);
            Telefono.setText(extrasTelefono);
            FechaNac.setText(extrasFecha);
        }
        editar.setOnClickListener(this);
        confirmar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == editar){
            Intent evento;
            evento = new Intent(this,Editar.class);
            String nombre = Nombre.getText().toString();
            String direccion = Direccion.getText().toString();
            String telefono = Telefono.getText().toString();
            String fecha = FechaNac.getText().toString();

            evento.putExtra("nombre",nombre);
            evento.putExtra("direccion",direccion);
            evento.putExtra("telefono",telefono);
            evento.putExtra("fecha",fecha);

            startActivity(evento);

        }else if(v == confirmar){
            Intent evento;
            evento = new Intent(this,Confirmar.class);
            String passUser = Nombre.getText().toString();

            evento.putExtra("nombre",passUser);
            startActivity(evento);
        }

    }
}
