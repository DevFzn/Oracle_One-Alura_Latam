package com.alura.jdbc.factory;

import java.sql.Connection;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
    
    private final static String driver = "jdbc:mysql://";
    private final static String dbaddr = "192.168.0.8:3306/";
    private final static String params = "?useTimeZone=true&serverTimeZone=UTC";
    private final static String dbname = "control_de_stock";
    private final static String dburl  = driver+dbaddr+dbname+params;
    private final static String dbuser = "alura";
    private final static String dbpass = "alura";
    
    private DataSource datasource;
    
    public ConnectionFactory() {
        var pooledDataSource = new ComboPooledDataSource();
        pooledDataSource.setJdbcUrl(dburl);
        pooledDataSource.setUser(dbuser);
        pooledDataSource.setPassword(dbpass);
        pooledDataSource.setMaxPoolSize(10);
        this.datasource = pooledDataSource;
    }
    
    public Connection recuperaConexion() {
        //return DriverManager.getConnection(dburl, dbuser, dbpass);
        try {
            return this.datasource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
