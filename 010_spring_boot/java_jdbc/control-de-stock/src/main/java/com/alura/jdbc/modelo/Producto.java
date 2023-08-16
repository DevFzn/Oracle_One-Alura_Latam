package com.alura.jdbc.modelo;

public class Producto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer cantidad;
    private Integer categoriaId;
 
    public Producto(String nombre, String descripcion, Integer cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public Producto(Integer id, String nombre, String descripcion, Integer cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public Producto(Integer id, String nombre, String descripcion, Integer cantidad, Integer categoriaId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.categoriaId = categoriaId;
    }

    public Producto(Integer id, String nombre, Integer cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
    
    public int getCantidad() {
        return this.cantidad;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("{id: %d, nombre: %s, descripción: %s, cantidad: %d, categoria: %d}",
                this.id, this.nombre, this.descripcion, this.cantidad, this.categoriaId);
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Integer getCategoriaId() {
        return this.categoriaId;
    }

}
