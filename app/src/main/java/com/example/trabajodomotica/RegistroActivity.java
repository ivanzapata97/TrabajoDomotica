package com.example.trabajodomotica;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabajodomotica.DataBase.DataBase;

public class RegistroActivity extends AppCompatActivity {
    private EditText campoNombre,campoApellido,campoEmail,campoContraseña;
    private Button btnRegistrar;

    private View.OnClickListener registroListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DataBase db_domotica = new DataBase(RegistroActivity.this);

            SQLiteDatabase db = db_domotica.open();
            //INSERT INTO usuarios (id,nombre,apellido,email,contraseña) VALUES (null,'ivan','zapata','mail','password','rol');
            String insert = "INSERT INTO usuarios (_id,Nombre,Apellido,Email,Contraseña,Rol) VALUES (" + null + ", '" + campoNombre.getText().toString() + "', '" + campoApellido.getText().toString() + "','" + campoEmail.getText().toString() + "', '" + campoContraseña.getText().toString() + "',user )";
            String insertt= "INSERT INTO usuarios (_id,Nombre,Apellido,Email,Contraseña,Rol) VALUES ("+null+", '"+campoNombre.getText().toString()+"','"+campoApellido.getText().toString()+"','"+campoEmail.getText().toString()+"','"+campoContraseña.getText().toString()+"','user')";
            db.execSQL(insertt);
            db.close();
            Toast.makeText(getApplicationContext(), "Usuario Registrado", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        campoNombre = (EditText) findViewById(R.id.nombre);
        campoApellido = (EditText)  findViewById(R.id.apellido);
        campoEmail = (EditText) findViewById(R.id.email);
        campoContraseña =  (EditText) findViewById(R.id.contraseña);
        btnRegistrar = (Button) findViewById(R.id.btnRegistro);

        btnRegistrar.setOnClickListener(registroListener);
    }
    public void onClick(View view) {

    }
}
