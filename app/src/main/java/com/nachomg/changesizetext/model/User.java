package com.nachomg.changesizetext.model;

import java.io.Serializable;

/**
 * Clase que guarda la información del login del usuario.
 * Implementa la interfaz Serializable porque está contenida en la clase Message, que es
 * también Serizalizable y se recoge con un Intent.
 */
public class User implements Serializable {
    private String name;
    private String email;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
