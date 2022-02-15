package com.app.registro_personas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.registro_personas.Configuraciones.SQLiteConexion;
import com.app.registro_personas.Configuraciones.Transacciones;

public class MainActivity extends AppCompatActivity {

    //Variables Globales del registro
    EditText nombres, apellidos, edad, correo, direccion;
    Button registrar, consultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombres = (EditText) findViewById(R.id.regTxtNombres);
        apellidos = (EditText) findViewById(R.id.regTxtApellidos);
        edad = (EditText) findViewById(R.id.regTxtEdad);
        correo = (EditText) findViewById(R.id.regTxtCorreo);
        direccion = (EditText) findViewById(R.id.regTxtDireccion);

        registrar = (Button) findViewById(R.id.regBtnRegistar);
        consultar = (Button) findViewById(R.id.regBtnConsultar);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarPersona();
            }
        });

        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityConsulta();
            }
        });
    }

    public void RegistrarPersona(){
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.DATA_BASE, null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues datos = new ContentValues();
        datos.put(Transacciones.NOMBRES, nombres.getText().toString());
        datos.put(Transacciones.APELLIDOS, apellidos.getText().toString());
        datos.put(Transacciones.EDAD, edad.getText().toString());
        datos.put(Transacciones.CORREO, correo.getText().toString());
        datos.put(Transacciones.DIRECCION, direccion.getText().toString());

        Long resultado = db.insert(Transacciones.TABLA_PERSONAS,Transacciones.ID,datos);

        Toast.makeText(getApplicationContext(), "Registro con exito! Codigo: "+ resultado.toString(), Toast.LENGTH_SHORT).show();

        db.close();

        limpiar();
    }

    public void activityConsulta(){
        Intent info = new Intent(this,Consultar_Base_Activity.class);
        startActivity(info);
    }

    public void limpiar(){
        nombres.setText("");
        apellidos.setText("");
        edad.setText("");
        correo.setText("");
        direccion.setText("");
    }
}