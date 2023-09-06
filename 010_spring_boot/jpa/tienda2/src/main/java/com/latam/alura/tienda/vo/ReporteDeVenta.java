package com.latam.alura.tienda.vo;

import java.time.LocalDate;

public class ReporteDeVenta {
    private String nombreDelProducto;
    private Long cantidadDeProducto;
    private LocalDate fechaDeUltimaVenta;
    
    public ReporteDeVenta(String nombreDelProducto, Long cantidadDeProducto, LocalDate fechaDeUltimaVenta) {
        this.nombreDelProducto = nombreDelProducto;
        this.cantidadDeProducto = cantidadDeProducto;
        this.fechaDeUltimaVenta = fechaDeUltimaVenta;
    }

    public String getNombreDelProducto() {
        return nombreDelProducto;
    }

    public void setNombreDelProducto(String nombreDelProducto) {
        this.nombreDelProducto = nombreDelProducto;
    }

    public Long getCantidadDeProducto() {
        return cantidadDeProducto;
    }

    public void setCantidadDeProducto(Long cantidadDeProducto) {
        this.cantidadDeProducto = cantidadDeProducto;
    }

    public LocalDate getFechaDeUltimaVenta() {
        return fechaDeUltimaVenta;
    }

    public void setFechaDeUltimaVenta(LocalDate fechaDeUltimaVenta) {
        this.fechaDeUltimaVenta = fechaDeUltimaVenta;
    }

    @Override
    public String toString() {
        return "ReporteDeVenta [" + (nombreDelProducto != null ? "nombreDelProducto=" + nombreDelProducto + ", " : "")
                + (cantidadDeProducto != null ? "cantidadDeProducto=" + cantidadDeProducto + ", " : "")
                + (fechaDeUltimaVenta != null ? "fechaDeUltimaVenta=" + fechaDeUltimaVenta : "") + "]";
    }
    
    
    
}
