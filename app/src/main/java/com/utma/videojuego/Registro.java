package com.utma.videojuego;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Registro extends Activity {
    private TextView irLogin;
    private Button btnRegister;
    private EditText inputUserName;
    private EditText inputPassword;
    private ArrayList<String> miArreglo;
    private ArrayAdapter<String> adaptador1;
    private ListView listView;
    private SharedPreferences prefe1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        inputUserName = (EditText) findViewById(R.id.txtUserName);
        inputPassword = (EditText) findViewById(R.id.txtPass);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        irLogin = (TextView) findViewById(R.id.link_to_login);
        listView = (ListView) findViewById(R.id.lv1);
        miArreglo =new ArrayList<String>();
        //leerSharedPreferences();
        adaptador1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, miArreglo);
        listView.setAdapter(adaptador1);
        irLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Registro.this, Login.class);
                i.putExtra("miArreglo",miArreglo);
                startActivity(i);
            }
        });

    }
    /*private void leerSharedPreferences() {
        prefe1=getSharedPreferences("datos", Context.MODE_PRIVATE);
        Map<String,?> claves = prefe1.getAll();
        for(Map.Entry<String,?> ele : claves.entrySet()){
            miArreglo.add(ele.getKey()+" : " +ele.getValue().toString());
        }

    }*/

    public void agregar(View v) {
        prefe1 = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        //miArreglo.add(inputUserName.getText().toString()+" : "+inputPassword.getText().toString());
        //adaptador1.notifyDataSetChanged();
        miArreglo.add(inputUserName.getText().toString());
        adaptador1.notifyDataSetChanged();
        SharedPreferences.Editor elemento=prefe1.edit();
        elemento.putString("usuario", inputUserName.getText().toString());
        //elemento.putString(inputUserName.getText().toString(),inputPassword.getText().toString());
        elemento.commit();
        inputUserName.setText("");
        inputPassword.setText("");

    }

}
