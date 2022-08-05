package com.utma.videojuego;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends Activity {
    private TextView lblGotoRegister, registerErrorMsg;
    private Button btnLogin;
    private EditText inputFullName, inputPassword;
    private ArrayList<String> miArreglo;
    private ArrayAdapter<String> adaptador1;
    private ListView listView;
    private SharedPreferences prefe1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ArrayList<String> listaUsuarios = (ArrayList<String>) getIntent().getSerializableExtra("miArreglo");
        inputFullName = (EditText) findViewById(R.id.txtUser);
        inputPassword = (EditText) findViewById(R.id.txtPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        lblGotoRegister = (TextView) findViewById(R.id.link_to_register);
        registerErrorMsg = (TextView) findViewById(R.id.register_error);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = inputFullName.getText().toString();
                String clave = inputPassword.getText().toString();
                if(listaUsuarios.contains(usuario)){
                    Intent i = new Intent(Login.this, Juego.class);
                    i.putExtra("usuario", inputFullName.getText().toString());
                    startActivity(i);
                }else{
                    Toast t = Toast.makeText(Login.this, "USUARIO NO ENCONTRADO",Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
        lblGotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Registro.class);
                startActivity(i);
            }
        });
    }

}
