package com.uisrael.larenasjuan_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Encuesta extends AppCompatActivity {

    //Datos de registro recibidos
    Bundle datosRecibidos;
    ArrayList<String> recibirDatos;


    //Datos del Usuario
    TextView tvUsuario;
    String nombre;
    String total;



    //Elemtos de la encuesta

    //Text
    EditText etCentro;

    //Checkbox
    CheckBox cbFutbol;
    CheckBox cbNatacion;
    CheckBox cbBaloncesto;

    //RadioButton
    RadioButton rbSi;
    RadioButton rbNo;

    //Arreglo final que pasa datos
    ArrayList alf = new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        tvUsuario = findViewById(R.id.tvUsuario);


        //Recibiendo los datos
        datosRecibidos = getIntent().getExtras();
        recibirDatos = datosRecibidos.getStringArrayList("datosEnviados");
        Object[] datos = recibirDatos.toArray();


        //Usuario
        tvUsuario.setText("  "+datos[0].toString());
        //Nombre
        nombre = datos[1].toString();
        //Total
        total = datos[2].toString();




        //Componentes de la encuesta

        //Componentes de Text
        etCentro = findViewById(R.id.etCentro);

        //Componentes de Checkbox
        cbFutbol = findViewById(R.id.cbFutbol);
        cbNatacion = findViewById(R.id.cbNatacion);
        cbBaloncesto = findViewById(R.id.cbBaloncesto);

        //Componentes de RadioButton
        rbSi = findViewById(R.id.rbSi);
        rbNo = findViewById(R.id.rbNo);


    }





    public void enviar(View v){

        //Pasando todos los datos
        alf.add(tvUsuario.getText().toString());
        alf.add(nombre);
        alf.add(total);

        //Funcionalidad para el Text
        alf.add(etCentro.getText().toString());


        //Funcionalidad para Checkbox
        if(cbFutbol.isChecked() == true){
            alf.add(cbFutbol.getText().toString());
        }else if (cbNatacion.isChecked() == true){
            alf.add(cbNatacion.getText().toString());
        }else if (cbBaloncesto.isChecked() == true){
            alf.add(cbBaloncesto.getText().toString());
        }


        //Funcionalidad para RadioButton
        if(rbSi.isChecked() == true){
            alf.add(rbSi.getText().toString());
        }else {
            alf.add(rbNo.getText().toString());
        }



        Intent intentEnvio = new Intent(Encuesta.this, Resumen.class);
        intentEnvio.putExtra("datosEnviados", alf) ;
        startActivity(intentEnvio);

    }
}
