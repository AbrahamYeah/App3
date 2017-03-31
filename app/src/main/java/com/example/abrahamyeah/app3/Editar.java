package com.example.abrahamyeah.app3;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class Editar extends AppCompatActivity implements View.OnClickListener{

    private EditText nombre,direccion,telefono;
    private DatePicker fecha;
    int mesI;
    Button btnEnviarEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        nombre = (EditText)findViewById(R.id.editNombreEditar);
        direccion = (EditText)findViewById(R.id.editDirecionEditar);
        telefono = (EditText)findViewById(R.id.editTelefonoEditar);
        fecha = (DatePicker) findViewById(R.id.Picker2Editar);
        btnEnviarEditar = (Button)findViewById(R.id.btnEnviarEditar);

        Intent evento = getIntent();
        Bundle extras = evento.getExtras();

            if (extras != null) {
                String extraNombre = (String) extras.get("nombre");
                String extraDireccion = (String) extras.get("direccion");
                String extraTelegono = (String) extras.get("telefono");
                String extraFecha = (String) extras.get("fecha");

                String diaS = extraFecha.substring(0, 1);
                String mesS = extraFecha.substring(4, 5);
                String anioS = extraFecha.substring(6,8);

                int diaI = Integer.parseInt(diaS);
                int n = Integer.parseInt(mesS);
                int anioI = Integer.parseInt(anioS);

                if (10 > n) {
                    mesS = extraFecha.substring(4, 4);

                } else {
                    mesS = extraFecha.substring(4, 5);

                }



                nombre.setText(extraNombre);
                direccion.setText(extraDireccion);
                telefono.setText(extraTelegono);
                fecha.updateDate(anioI, n, diaI);

            }

        btnEnviarEditar.setOnClickListener(this);

    }

    public String Fecha(int dia, int mes,int anio){
        return  dia+"/"+mes+"/"+anio;
    }
    @Override
    public void onClick(View v) {
        int anio = fecha.getYear();
        int mes = fecha.getMonth()+1;
        int dia = fecha.getDayOfMonth();

        String date = Fecha(dia,mes,anio);

        Intent evento;
        evento = new Intent(this,Datos.class);


        String passNombre = nombre.getText().toString();
        String passDireccion = direccion.getText().toString();
        String passTelefono = telefono.getText().toString();
        String passFecha = date;

        evento.putExtra("nombre",passNombre);
        evento.putExtra("direccion",passDireccion);
        evento.putExtra("telefono",passTelefono);
        evento.putExtra("fechaNac",passFecha);
        startActivity(evento);
    }
}
