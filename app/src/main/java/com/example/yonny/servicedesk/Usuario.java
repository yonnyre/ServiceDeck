package com.example.yonny.servicedesk;

import java.util.UUID;

/**
 * Created by Yonny on 25/09/2017.
 */

public class Usuario
{
    String username;
    String password;
    String nombre;
    String rol;
    String id;

    public Usuario() {
        super();
    }

    public Usuario(String username, String password, String nombre, String rol) {
        id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nombre='" + nombre + '\'' +
                ", rol='" + rol + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
