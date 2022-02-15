package com.app.registro_personas.Tablas;

import android.content.Intent;

public class Personas {
    //Variables de datos para la base
    private Integer ID;
    private String Nommbres;
    private String Apellidos;
    private Integer Edad;
    private String Correo;
    private String Direccion;

    //contructor vacio
    public Personas(){
        //Vacío
    }

    //Constructor con parametros
    public void Personas(Integer id, String nombres,String apellidos, Integer edad, String correo, String direccion){
        this.ID = id;
        this.Nommbres = nombres;
        this.Apellidos = apellidos;
        this.Edad = edad;
        this.Correo = correo;
        this.Direccion = direccion;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNommbres() {
        return Nommbres;
    }

    public void setNommbres(String nommbres) {
        Nommbres = nommbres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer edad) {
        Edad = edad;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
}
