package com.alura.jdbc.pruebas;

import java.sql.Connection;
import java.sql.SQLException;

import com.alura.jdbc.factory.ConnectionFactory;

public class PruebaPoolDeConexiones {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        for (int i = 0; i < 20; i++) {
            @SuppressWarnings("unused")
            Connection con = connectionFactory.recuperaConexion();
            System.out.println("Abriendo conexión nro: "+(i+1));
        }
    }

}
