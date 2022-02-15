package com.app.registro_personas.Configuraciones;

public class Transacciones {
    //Nombre de la base de datos
    public static final String DATA_BASE = "dbRegistro";
    //Nombre de la tabla para registra personas
    public static final String TABLA_PERSONAS = "tbPersonas";

    //Campos de tabla personas
    public static final String ID = "id";
    public static final String NOMBRES = "nombres";
    public static final String APELLIDOS = "apellidos";
    public static final String EDAD = "edad";
    public static final String CORREO = "correo";
    public static final String DIRECCION = "direccion";

    //Creación de la base de datos
    public static final String CREATE_TABLE_PERSONAS = "CREATE TABLE " + TABLA_PERSONAS +
                                                       "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                       "nombres TEXT, apellidos TEXT, edad INTEGER, correo TEXT, direccion TEXT)";

    //Eliminacion de la tabla de pesonas
    public static final String DROP_TABLE_PERSONAS = "DROP TABLE IF EXISTS " + TABLA_PERSONAS;

    //Eliminar un registro
    public static final String DELETE_REGISTRO = "DELETE FROM "+ TABLA_PERSONAS +" WHERE id = ";

    //Actualizar un Registro
    public static final String UPDATE_REGISTRO = "UPDATE " + TABLA_PERSONAS + " SET ";
}
