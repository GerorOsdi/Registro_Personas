package com.app.registro_personas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.registro_personas.Configuraciones.SQLiteConexion;
import com.app.registro_personas.Configuraciones.Transacciones;

public class Consulta_Registro extends AppCompatActivity {

    EditText txtId, txtNombre, txtApellidos, txtEdad, txtCorreo, txtDireccion;
    Button btnEliminar, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_registro);

        txtId = (EditText) findViewById(R.id.consTxtId);
        txtNombre = (EditText) findViewById(R.id.consTxtNombres);
        txtApellidos = (EditText) findViewById(R.id.consTxtApellidos);
        txtEdad = (EditText) findViewById(R.id.consTxtEdad);
        txtCorreo = (EditText) findViewById(R.id.consTxtCorreo);
        txtDireccion = (EditText) findViewById(R.id.consTxtDireccion);

        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        txtId.setText(String.valueOf(getIntent().getExtras().getInt("id")));
        txtNombre.setText(getIntent().getExtras().getString("nombres"));
        txtApellidos.setText(getIntent().getExtras().getString("apellidos"));
        txtEdad.setText(String.valueOf(getIntent().getExtras().getInt("edad")));
        txtCorreo.setText(getIntent().getExtras().getString("correo"));
        txtDireccion.setText(getIntent().getExtras().getString("direccion"));

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EliminarRegistro(txtId.getText().toString());
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateRegistro(txtId.getText().toString(),txtNombre.getText().toString(),txtApellidos.getText().toString(),
                               txtEdad.getText().toString(),txtCorreo.getText().toString(),txtDireccion.getText().toString());
            }
        });
    }

    public void EliminarRegistro(String id){
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.DATA_BASE, null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        db.execSQL(Transacciones.DELETE_REGISTRO+id);
        db.close();

        Intent intent = new Intent(this,Consultar_Base_Activity.class);
        startActivity(intent);

    }

    public void UpdateRegistro(String id,String nombre, String apellidos, String edad, String correo, String direccion){
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.DATA_BASE, null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues datos = new ContentValues();
        datos.put("nombres",nombre);
        datos.put("apellidos",apellidos);
        datos.put("edad",edad);
        datos.put("correo",correo);
        datos.put("direccion",direccion);

        int resultado = db.update(Transacciones.TABLA_PERSONAS,datos,"id=?",new String[]{id});
        db.close();
        Intent intent = new Intent(this,Consultar_Base_Activity.class);
        startActivity(intent);
    }
}