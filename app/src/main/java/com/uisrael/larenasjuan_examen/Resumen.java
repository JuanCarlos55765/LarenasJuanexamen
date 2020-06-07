package com.uisrael.larenasjuan_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Resumen extends AppCompatActivity {

    //Datos finales recibidos
    Bundle datosRecibidos;

    //Usuario
    TextView tvUsuario;
    TextView tvNombre;
    TextView tvTotal;

    //Encuesta
    TextView tvRText;
    TextView tvRCheck;
    TextView tvRRadio;


    ArrayList<String> recibirDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        tvUsuario = findViewById(R.id.tvUsuario);
        tvNombre = findViewById(R.id.tvNombre);
        tvTotal = findViewById(R.id.tvTotal);

        tvRText = findViewById(R.id.tvRText);
        tvRCheck = findViewById(R.id.tvRCheck);
        tvRRadio = findViewById(R.id.tvRRadio);


        //Recibiendo los datos
        datosRecibidos = getIntent().getExtras();
        recibirDatos = datosRecibidos.getStringArrayList("datosEnviados");
        Object[] datos = recibirDatos.toArray();


        //Usuario
        tvUsuario.setText("  "+datos[0].toString());
        //Nombre
        tvNombre.setText("  "+datos[1].toString());
        //Total
        tvTotal.setText("  "+datos[2].toString());

        //Toast.makeText(this, "dato: "+datos[4].toString(), Toast.LENGTH_LONG).show();

        //Encuesta
        //Respuesta de Text
        tvRText.setText(datos[3].toString());
        //Respuesta de Checkbox
        tvRCheck.setText(datos[4].toString());
        //Respuesta de Radioboton
        tvRRadio.setText(datos[5].toString());


    }
}
