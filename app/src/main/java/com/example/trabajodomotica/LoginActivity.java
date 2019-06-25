package com.example.trabajodomotica;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trabajodomotica.DataBase.DataBase;
import com.example.trabajodomotica.Entidades.Usuario;

public class LoginActivity extends AppCompatActivity {
    private EditText Email,Contraseña;
    private Button Login,Registro;

    private DataBase db;

    View.OnClickListener RegistroListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(LoginActivity.this,RegistroActivity.class);
            startActivity(intent);
        }
    };
    View.OnClickListener LoginListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Verificar();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db=new DataBase(LoginActivity.this);

        Email = (EditText)findViewById(R.id.Email);
        Contraseña = (EditText)findViewById(R.id.Contraseña);
        Login = (Button)findViewById(R.id.Login);
        Registro = (Button) findViewById(R.id.Registrarse);

        Registro.setOnClickListener(RegistroListener);
        Login.setOnClickListener(LoginListener);

    }
    public void Verificar(){
        SQLiteDatabase db_consulta = db.read();
        String [] parametros = {Email.getText().toString()};
        String [] campos = {"_id,Nombre,Apellido,Email,Contraseña,Rol"};

        //SELECT * FROM usuarios WHERE Email = 'example@';

        try {
            //consulta para sacar un usuario
            Cursor cursor = db_consulta.query("usuarios",campos,"Email=?",parametros,null,null,null);
            cursor.moveToFirst();
            //creo un usuario con los datos de la bd
            Usuario usuario = new Usuario(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
            usuario.set_id(cursor.getInt(0));
            usuario.setRol(cursor.getString(5));

            String contraseña_usuario = usuario.getContraseña();
            String contraseña_ingresada = Contraseña.getText().toString();
            if(contraseña_usuario.equals(contraseña_ingresada)){
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(),"Contraseña incorrecta",Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Usuario no registrado",Toast.LENGTH_SHORT).show();
        }




    }
}