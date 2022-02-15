package com.app.registro_personas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.app.registro_personas.Configuraciones.SQLiteConexion;
import com.app.registro_personas.Configuraciones.Transacciones;
import com.app.registro_personas.Tablas.Personas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Currency;

public class Consultar_Base_Activity extends AppCompatActivity {


    //Variables Globales
    SQLiteConexion conexion;
    ListView lsvPersonas;
    ArrayList<Personas> listaPersonas;
    ArrayList<String> arrayPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_base);

        conexion = new SQLiteConexion(this, Transacciones.DATA_BASE, null,1);
        lsvPersonas = (ListView) findViewById(R.id.lvMostrarPersonas);

        ObtenerBasePersonas();

        //Declaración de un ArrayAdapter para llenar el ListView
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayPersonas);
        lsvPersonas.setAdapter(adapter);

        lsvPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                consultarRegistro(i);
            }
        });
    }

    public void ObtenerBasePersonas(){
        SQLiteDatabase db = conexion.getWritableDatabase();
        Personas lista_Pers = null;
        listaPersonas = new ArrayList<Personas>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Transacciones.TABLA_PERSONAS, null);

        while(cursor.moveToNext()){
            lista_Pers = new Personas();
            lista_Pers.setID(cursor.getInt(0));
            lista_Pers.setNommbres(cursor.getString(1));
            lista_Pers.setApellidos(cursor.getString(2));
            lista_Pers.setEdad(cursor.getInt(3));
            lista_Pers.setCorreo(cursor.getString(4));
            lista_Pers.setDireccion(cursor.getString(5));

            listaPersonas.add(lista_Pers);
        }

        cursor.close();

        llenarListView();
    }

    public void llenarListView(){
        arrayPersonas = new ArrayList<String>();

        for (int i=0; i < listaPersonas.size(); i++){
            arrayPersonas.add(listaPersonas.get(i).getID() + " | " + listaPersonas.get(i).getNommbres() +" | ");
        }
    }

    public void consultarRegistro(int i){
        Personas dat = listaPersonas.get(i);

        Intent push = new Intent(this,Consulta_Registro.class);

        push.putExtra("id",dat.getID());
        push.putExtra("nombres",dat.getNommbres());
        push.putExtra("apellidos",dat.getApellidos());
        push.putExtra("edad",dat.getEdad());
        push.putExtra("correo",dat.getCorreo());
        push.putExtra("direccion",dat.getDireccion());

        startActivity(push);
    }
}