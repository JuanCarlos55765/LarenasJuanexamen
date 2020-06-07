package com.uisrael.larenasjuan_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText etUsuario;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
    }

    public void Validar(View v){

        String usuario;
        String password;

        usuario = etUsuario.getText().toString();
        password = etPassword.getText().toString();


        if(usuario.equals("estudiante2020") && password.equals("uisrael2020")){

            //Direccionando a la ventana Registro
            Intent intentEnvio = new Intent(Login.this, Registro.class);
            intentEnvio.putExtra("usuarioEnviado", usuario);
            startActivity(intentEnvio);

            Toast.makeText(this, "Usuario y Password correctos", Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(this, "Usuario y Password incorrectos", Toast.LENGTH_LONG).show();

        }
    }
}
