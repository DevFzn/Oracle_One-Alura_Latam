package com.latam.alura.tienda.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="items_pedido")
public class ItemsPedido {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Integer cantidad;
    private BigDecimal precio_unitario;
    @ManyToOne
    private Producto producto;
    @ManyToOne
    private Pedido pedido;
    
    public ItemsPedido() {}
    
    public ItemsPedido(Integer cantidad, Producto producto, Pedido pedido) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.pedido = pedido;
        this.precio_unitario = producto.getPrecio();
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(BigDecimal precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return this.precio_unitario.multiply(new BigDecimal(this.cantidad));
    }
    
}
