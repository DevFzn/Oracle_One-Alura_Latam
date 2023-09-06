package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;

import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.dao.ClienteDao;
import com.latam.alura.tienda.dao.PedidoDao;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Cliente;
import com.latam.alura.tienda.modelo.ItemsPedido;
import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;
import com.latam.alura.tienda.vo.ReporteDeVenta;

public class RegistroDePedido {

    public static void main(String[] args) {
        RegistrarPedido();
        
        EntityManager em = JPAUtils.getEntityManager();
        
        ProductoDao productoDao = new ProductoDao(em);
        Producto producto = productoDao.consultaPorId(1L);
        
        ClienteDao clienteDao = new ClienteDao(em);
        Cliente cliente = new Cliente("Juan","mnwenic");
        
        PedidoDao pedidoDao = new PedidoDao(em);
        Pedido pedido = new Pedido(cliente);
        pedido.agregarItems(new ItemsPedido(5,producto, pedido));
        
        em.getTransaction().begin();
        clienteDao.guardar(cliente);
        
        pedidoDao.guardar(pedido);
        em.getTransaction().commit();
        BigDecimal valorTotal = pedidoDao.valorTotalVendido();
        System.out.println("Valor total del pedido: "+valorTotal);
        Double valorPromedio = pedidoDao.valorPromedioVendido();
        System.out.println("Valor promedio del pedido: "+valorPromedio);
        List<Object[]> reporte = pedidoDao.ReporteVentas();
        for (Object[] objects : reporte) {
            System.out.print(objects[0] +", ");
            System.out.print(objects[1] +", ");
            System.out.println(objects[2]);
        }
        
        List<ReporteDeVenta> reporteVo = pedidoDao.ReporteVentasVO();
        reporteVo.forEach(System.out::println);
    }

    public static void RegistrarPedido() {
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
