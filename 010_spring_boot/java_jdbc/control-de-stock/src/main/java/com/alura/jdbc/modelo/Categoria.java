package com.alura.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private Integer id;
    private String nombre;
    private List<Producto> productos;

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }
    
    @Override
    public String toString() {
        return this.getNombre();
    }

    public void agregar(Producto producto) {
        if (this.productos == null) {
            this.productos = new ArrayList<>();
        }
        this.productos.add(producto);
    }

    public List<Producto> getProductos() {
        return this.productos;
    }
}
