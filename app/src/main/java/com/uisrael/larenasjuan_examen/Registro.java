package com.uisrael.larenasjuan_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Registro extends AppCompatActivity {

    //Datos del usuario recibido
    TextView tvUsuario;
    Bundle usuarioRecibido;
    String recibirUsuario;

    //Datos del Calculo
    EditText etNombre;
    EditText etMontoInicial;

    TextView tvCalculo;
    TextView tvPagoMensual;

    //Varaibel de calculo Final
    double montoFinal;

    //Creando un ArrayList
    ArrayList al = new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        tvUsuario = findViewById(R.id.tvUsuario);


        //Recibiendo el usuario
        usuarioRecibido = getIntent().getExtras();
        recibirUsuario = usuarioRecibido.getString("usuarioEnviado");
        tvUsuario.setText("  "+recibirUsuario);



        //Datos del calculo
        etNombre = findViewById(R.id.etNombre);
        etMontoInicial = findViewById(R.id.etMontoInicial);
        tvPagoMensual = findViewById(R.id.tvPagoMensual);
        tvCalculo = findViewById(R.id.tvCalculo);
    }



    public void calcular(View v){

        double montoTotal = 1800;
        double montoInicial;
        double montoRestado;
        double montoDividido;
        double montoPorcentaje;


        montoInicial = Double.parseDouble(etMontoInicial.getText().toString());

        montoPorcentaje = montoTotal * 0.05;

        montoRestado = montoTotal - montoInicial;
        montoDividido = montoRestado / 3;

        montoFinal = montoDividido + montoPorcentaje;

        tvPagoMensual.setText("  "+montoDividido);
        tvCalculo.setText("  "+montoFinal);


    }



    public  void guardar(View v){

        String nombrePersona;

        nombrePersona = etNombre.getText().toString();


        //Almacenando nuestros datos en un Array

        //usuario
        al.add(recibirUsuario);
        //nombre de la persona
        al.add(nombrePersona);
        //montototal
        al.add(montoFinal);


        //Direccionando a la ventana Resumen
        Intent intentEnvio = new Intent(Registro.this, Encuesta.class);
        intentEnvio.putExtra("datosEnviados", al);
        startActivity(intentEnvio);

        Toast.makeText(this, "Elemento guardado con exito", Toast.LENGTH_LONG).show();
    }
}
