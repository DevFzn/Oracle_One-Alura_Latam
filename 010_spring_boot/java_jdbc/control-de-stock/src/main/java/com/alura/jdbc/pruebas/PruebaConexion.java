package com.alura.jdbc.pruebas;

import java.sql.Connection;
import java.sql.SQLException;

import com.alura.jdbc.factory.ConnectionFactory;

public class PruebaConexion {

    public static void main(String[] args) throws SQLException {
        System.out.println("Intentando conexión con Connetion Factory");
        Connection con = new ConnectionFactory().recuperaConexion();
        System.out.println("Prueba OK, cerrando conexión");
        con.close();
    }

}
