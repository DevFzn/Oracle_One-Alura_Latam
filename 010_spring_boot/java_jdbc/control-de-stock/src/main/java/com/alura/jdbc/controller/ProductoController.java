package com.alura.jdbc.controller;

import java.util.List;

import com.alura.jdbc.dao.ProductoDAO;
import com.alura.jdbc.factory.ConnectionFactory;
import com.alura.jdbc.modelo.Categoria;
import com.alura.jdbc.modelo.Producto;

public class ProductoController {
    
    private ProductoDAO productoDAO;

    public ProductoController() {
        this.productoDAO = new ProductoDAO(new ConnectionFactory().recuperaConexion());
    }

    public int modificar(Producto producto) {
        return productoDAO.modificar(producto);
    }

    public int eliminar(Integer id) {
        return productoDAO.eliminar(id);
    }

    public List<Producto> listar() {
        return productoDAO.listar();
    }

    public List<Producto> listar(Categoria categoria) {
        return productoDAO.listar(categoria.getId());
    }

    public void guardar(Producto producto, Integer categoriaId) {
        producto.setCategoriaId(categoriaId);
        productoDAO.guardar(producto);
    }


}
