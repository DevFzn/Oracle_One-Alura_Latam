package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.alura.jdbc.modelo.Producto;

public class ProductoDAO {
    private final Connection con;
    
    public ProductoDAO(Connection conexion) {
        this.con = conexion; 
    }
    
    public void guardar(Producto producto) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO producto(nombre, descripcion, cantidad, categoria_id) VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            try (statement) {
                ejecutaRegistro(producto, statement);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void ejecutaRegistro(Producto producto, PreparedStatement statement)
            throws SQLException {
        statement.setString(1, producto.getNombre());
        statement.setString(2, producto.getDescripcion());
        statement.setInt(3, producto.getCantidad()); 
        statement.setInt(4, producto.getCategoriaId()); 
        statement.execute();
        final ResultSet resultSet = statement.getGeneratedKeys();
        try (resultSet) {
            while (resultSet.next()) {
                producto.setId(resultSet.getInt(1));
                System.out.println(String.format("Producto insertado %s: ", producto));
            }
        }
    }

    public List<Producto> listar() {
        List<Producto> resultado = new ArrayList<>();
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD, CATEGORIA_ID FROM producto;");
            try (statement) {
                statement.execute();
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    Producto fila = new Producto(
                                            resultSet.getInt("ID"),
                                            resultSet.getString("NOMBRE"),
                                            resultSet.getString("DESCRIPCION"),
                                            resultSet.getInt("CANTIDAD"),
                                            resultSet.getInt("CATEGORIA_ID")
                                        );
                    resultado.add(fila);
                }
                return resultado;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int modificar(Producto producto) {
        String query = "UPDATE producto SET NOMBRE=?, DESCRIPCION=?, CANTIDAD=? ";
        if (producto.getCategoriaId() != null) {
            query += ", CATEGORIA_ID=? WHERE ID=?;";
        } else {
            query += " WHERE ID=?;";
        }

        try {
            final PreparedStatement statement = con.prepareStatement(query);                    
            try (statement) {
                statement.setString(1, producto.getNombre());
                statement.setString(2, producto.getDescripcion());
                statement.setInt(3, producto.getCantidad());
                if (producto.getCategoriaId() != null) {
                    statement.setInt(4, producto.getCategoriaId());
                    statement.setInt(5, producto.getId());
                } else {
                    statement.setInt(4, producto.getId());
                }
                //System.out.println(statement.toString());
                statement.execute();
                int resultado = statement.getUpdateCount();
                return resultado;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int eliminar(Integer id) {
        try {
            final PreparedStatement statement = con.prepareStatement("DELETE FROM producto WHERE ID=?;");
            try (statement) {
                statement.setInt(1, id);
                statement.execute();
                int resultado = statement.getUpdateCount();
                return resultado;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Producto> listar(Integer id) {
        List<Producto> resultado = new ArrayList<>();
        final String query = "SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD, CATEGORIA_ID FROM producto WHERE categoria_id=?;";
        //System.out.println(query);
        try {
            final PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, id);
            try (statement) {
                statement.execute();
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    Producto fila = new Producto(
                                            resultSet.getInt("ID"),
                                            resultSet.getString("NOMBRE"),
                                            resultSet.getString("DESCRIPCION"),
                                            resultSet.getInt("CANTIDAD"),
                                            resultSet.getInt("CATEGORIA_ID")
                                        );
                    resultado.add(fila);
                }
                return resultado;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
