package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;

import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.CategoriaId;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

    public static void main(String[] args) {
        RegistrarProducto();
        EntityManager em = JPAUtils.getEntityManager();
        ProductoDao productoDao = new ProductoDao(em);
        Producto producto = productoDao.consultaPorId(1L);
        System.out.println(producto.getNombre());
        
        List<Producto> productos = productoDao.consultarTodos();
        productos.forEach(producto_ -> System.out.println(producto_.getDescripcion()));
        
        CategoriaDao categoriaDao = new CategoriaDao(em);
        List<Categoria> categorias = categoriaDao.consultarTodos();
        categorias.forEach(categoria_ -> System.out.println(categoria_.getNombre()));
        
        List<Producto> productos_por_nombre = productoDao.consultaPorNombre("Samsung");
        productos_por_nombre.forEach(producto_ -> System.out.println(producto_.getDescripcion()));
        
        //List<Producto> productos_por_nombre_categoria = productoDao.consultaPorNombreDeCategoria("Celulares");
        //productos_por_nombre_categoria.forEach(producto_ -> System.out.println(producto_.getDescripcion()));
        
        BigDecimal precio_producto = productoDao.consultaPrecioPorNombreDeProducto("Samsung");
        System.out.println(precio_producto);
        
        Categoria find = em.find(Categoria.class, new CategoriaId("Celulares", "456"));
        System.out.println(find.getNombre());        
    }

    public static void RegistrarProducto() {
        Categoria celulares = new Categoria("Celulares");
        Producto celular = new Producto("Samsung", "Teléfono usado", new BigDecimal("1000"), celulares);
        EntityManager em = JPAUtils.getEntityManager();
        ProductoDao productoDao = new ProductoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        
        em.getTransaction().begin();
        categoriaDao.guardar(celulares);
        productoDao.guardar(celular);
        em.getTransaction().commit();
        em.close();
    }

}
