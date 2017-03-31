package com.example.abrahamyeah.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
     EditText Nombre, Telefono, Direccion;
     Button btnEnviar;
     DatePicker FecharNac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se inicializan todos los edittext que reciben datos, y el boton que espera el evento
        Nombre = (EditText) findViewById(R.id.editNombre);
        Direccion = (EditText)findViewById(R.id.editDirecion);
        Telefono = (EditText)findViewById(R.id.editTelefono);
        FecharNac = (DatePicker)findViewById(R.id.Picker1);
        btnEnviar = (Button)findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(this);

    }

    public String Fecha(int dia, int mes,int anio){
        return  dia+"/"+mes+"/"+anio;
    }

    @Override
    public void onClick(View v) {


        int anio = FecharNac.getYear();
        int mes = FecharNac.getMonth()+1;
        int dia = FecharNac.getDayOfMonth();

        String date = Fecha(dia,mes,anio);

        Intent evento;
        evento = new Intent(this,Datos.class);


        String passNombre = Nombre.getText().toString();
        String passDireccion = Direccion.getText().toString();
        String passTelefono = Telefono.getText().toString();
        String passFecha = date;

        evento.putExtra("nombre",passNombre);
        evento.putExtra("direccion",passDireccion);
        evento.putExtra("telefono",passTelefono);
        evento.putExtra("fechaNac",passFecha);
    startActivity(evento);
    }
}
