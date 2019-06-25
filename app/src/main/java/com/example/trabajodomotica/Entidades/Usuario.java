package com.example.trabajodomotica.Entidades;

public class Usuario {
    private int _id;
    private String Nombre;
    private String apellido;
    private String Email;
    private String Contraseña;
    private String Rol;

    public Usuario(String nombre, String apellido, String email, String contraseña) {
        Nombre = nombre;
        this.apellido = apellido;
        Email = email;
        Contraseña = contraseña;
    }

    public int get_id() {
        return _id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return Email;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }
}
