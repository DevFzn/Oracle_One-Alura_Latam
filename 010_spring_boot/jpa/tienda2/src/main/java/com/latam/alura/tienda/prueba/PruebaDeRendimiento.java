package com.latam.alura.tienda.prueba;

import java.io.FileNotFoundException;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.PedidoDao;
import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.utils.JPAUtils;

public class PruebaDeRendimiento {

    public static void main(String[] args) throws FileNotFoundException {

        LoadRecords.cargarRegistros();
        EntityManager em = JPAUtils.getEntityManager();
        
        //Pedido pedido = em.find(Pedido.class, 3l);
        PedidoDao pedidoDao = new PedidoDao(em);
        Pedido pedidoConCliente = pedidoDao.ConsultarPedidoConCliente(2l);
        
        em.close();
        //System.out.println(pedido.getFecha());
        //System.out.println(pedido.getItems().size());
        //System.out.println(pedido.getCliente().getNombre());

        System.out.println(pedidoConCliente.getCliente().getNombre());
    }

}
