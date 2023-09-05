package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;

import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
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
        
        List<Producto> productos_por_nombre_categoria = productoDao.consultaPorNombreDeCategoria("Celulares");
        productos_por_nombre_categoria.forEach(producto_ -> System.out.println(producto_.getDescripcion()));
        
        BigDecimal precio_producto = productoDao.consultaPrecioPorNombreDeProducto("Samsung");
        System.out.println(precio_producto);
        /*
        Categoria celulares = new Categoria("Celulares");
        //Producto celular = new Producto("Samsung", "Teléfono usado", new BigDecimal("1000"), Categoria.CELULARES);
        Producto celular = new Producto("Samsung", "Teléfono usado", new BigDecimal("1000"), celulares);
        //celular.setNombre("Samsung");
        //celular.setDescripcion("Teléfono usado");
        //celular.setPrecio(new BigDecimal("1000"));
        
        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
        //EntityManager em = factory.createEntityManager();
        EntityManager em = JPAUtils.getEntityManager();
        
        ProductoDao productoDao = new ProductoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        
        em.getTransaction().begin();
        categoriaDao.guardar(celulares);
        productoDao.guardar(celular);
        //em.persist(celular);
        //em.getTransaction().commit();
        em.flush();
        em.clear();
        //em.close();
        */
        
        // Acciones por aula
        //em.getTransaction().begin();
        
        //V1
        /*
        em.getTransaction().begin();
        em.persist(celulares);
        celulares.setNombre("LAPTOPS");
        em.getTransaction().commit();
        em.close();
        celulares.setNombre("PANTALLAS");
        */
        
        //V2
        /*
        em.persist(celulares);
        celulares.setNombre("LAPTOPS");
        em.flush();
        em.clear();
        
        celulares = em.merge(celulares);
        celulares.setNombre("PANTALLAS");
        em.flush();
        em.remove(celulares);
        */
        
        //V3
        /*
        em.persist(celulares);
        celulares.setNombre("LAPTOPS");
        em.flush();
        em.clear();
        
        celulares = em.merge(celulares);
        celulares.setNombre("PANTALLAS");
        em.flush();
        //em.clear();
        em.remove(celulares);
        em.flush();
        */
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
