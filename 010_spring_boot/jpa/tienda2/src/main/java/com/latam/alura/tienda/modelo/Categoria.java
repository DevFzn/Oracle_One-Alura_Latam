package com.latam.alura.tienda.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="categorias")
public class Categoria {
    
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
    //private String nombre;
    
    @EmbeddedId
    private CategoriaId categoriaId;
    
    public Categoria() {}

    public Categoria(String nombre) {
        this.categoriaId = new CategoriaId(nombre, "456");
    }
    
    public String getNombre() {
        return this.categoriaId.getNombre();
    }
    
    public void setNombre(String nombre) {
        this.categoriaId.setNombre(nombre);
    }
    
}