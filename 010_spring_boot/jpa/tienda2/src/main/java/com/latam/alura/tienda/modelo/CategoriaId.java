package com.latam.alura.tienda.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class CategoriaId implements Serializable {
    
    private static final long serialVersionUID = -9006019453678383077L;
    private String nombre;
    private String password;
    
    public CategoriaId() {}

    public CategoriaId(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CategoriaId other = (CategoriaId) obj;
        return Objects.equals(nombre, other.nombre) && Objects.equals(password, other.password);
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
}
