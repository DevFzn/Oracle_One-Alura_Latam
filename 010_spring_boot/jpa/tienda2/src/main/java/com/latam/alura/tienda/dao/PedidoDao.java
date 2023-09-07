package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.vo.ReporteDeVenta;

public class PedidoDao {
    
    private EntityManager em;

    public PedidoDao(EntityManager em) {
        this.em = em;
    }
 
    public void guardar(Pedido pedido) {
        this.em.persist(pedido);
    }
    
    public void actualizar(Pedido pedido) {
        this.em.merge(pedido);
    }

    public void remover(Pedido pedido) {
        pedido = this.em.merge(pedido);
        this.em.remove(pedido);
    }
    
    public Pedido consultaPorId(Long id) {
        return em.find(Pedido.class, id);
    }
    
    public List<Pedido> consultarTodos() {
        String jpql = "SELECT P FROM Pedido AS P";
        return em.createQuery(jpql, Pedido.class).getResultList(); 
    }
    
    public List<Pedido> consultaPorNombre(String nombre) {
        String jpql = "SELECT P FROM Pedido AS P WHERE P.nombre=:nombre";
        return em.createQuery(jpql, Pedido.class).setParameter("nombre", nombre).getResultList();
    }

    public List<Pedido> consultaPorNombreDeCategoria(String nombre) {
        String jpql = "SELECT P FROM Pedido AS P WHERE P.categoria.nombre=:nombre";
        return em.createQuery(jpql, Pedido.class).setParameter("nombre", nombre).getResultList();
    }
    
    public BigDecimal consultaPrecioPorNombreDePedido(String nombre) {
        String jpql = "SELECT P.precio FROM Pedido AS P WHERE P.nombre=:nombre";
        return em.createQuery(jpql, BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
    }
    
    public BigDecimal valorTotalVendido() {
        String jpql = "SELECT SUM(P.valorTotal) FROM Pedido P";
        return em.createQuery(jpql, BigDecimal.class).getSingleResult();
    }

    public Double valorPromedioVendido() {
        String jpql = "SELECT AVG(P.valorTotal) FROM Pedido P";
        return em.createQuery(jpql, Double.class).getSingleResult();
    }
    
    public List<Object[]> ReporteVentas() {
        String jpql = "SELECT producto.nombre, SUM(item.cantidad), MAX(pedido.fecha)"
                + " FROM Pedido pedido"
                + " JOIN pedido.items item"
                + " JOIN item.producto producto"
                + " GROUP BY producto.nombre"
                + " ORDER BY item.cantidad DESC";
        return em.createQuery(jpql, Object[].class).getResultList();
    }

    public List<ReporteDeVenta> ReporteVentasVO() {
        String jpql = "SELECT new com.latam.alura.tienda.vo.ReporteDeVenta("
                + "producto.nombre, SUM(item.cantidad), MAX(pedido.fecha))"
                + " FROM Pedido pedido"
                + " JOIN pedido.items item"
                + " JOIN item.producto producto"
                + " GROUP BY producto.nombre"
                + " ORDER BY item.cantidad DESC";
        return em.createQuery(jpql, ReporteDeVenta.class).getResultList();
    }
    
    public Pedido ConsultarPedidoConCliente(Long id) {
        String jpql = "SELECT P FROM Pedido P JOIN FETCH P.cliente WHERE P.id=:id";
        return em.createQuery(jpql, Pedido.class).setParameter("id", id).getSingleResult();
    }
    
}
