package com.alura.jdbc.pruebas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.alura.jdbc.factory.ConnectionFactory;

public class PruebaDelete {
    public static void main(String[] args) throws SQLException {
        Connection con = new ConnectionFactory().recuperaConexion();
        Statement stmnt = con.createStatement();
        stmnt.execute("DELETE FROM producto WHERE ID=99");
        System.out.println(stmnt.getUpdateCount());
    }
}
