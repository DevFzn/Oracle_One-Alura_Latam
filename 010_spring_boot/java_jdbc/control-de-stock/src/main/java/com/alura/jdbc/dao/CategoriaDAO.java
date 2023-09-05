package com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.alura.jdbc.modelo.Categoria;
import com.alura.jdbc.modelo.Producto;

public class CategoriaDAO {
    private final Connection con;
    
    public CategoriaDAO(Connection conexion) {
        this.con = conexion; 
    }
    
    public void guardar(Categoria categoria) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO categoria(nombre) VALUES(?)",
                    Statement.RETURN_GENERATED_KEYS);
            try (statement) {
                ejecutaRegistro(categoria, statement);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void ejecutaRegistro(Categoria categoria, PreparedStatement statement)
            throws SQLException {
        statement.setString(1, categoria.getNombre());
        statement.execute();
        final ResultSet resultSet = statement.getGeneratedKeys();
        try (resultSet) {
            while (resultSet.next()) {
                categoria.setId(resultSet.getInt(1));
                System.out.println(String.format("Categoria agregada %s: ", categoria));
            }
        }
    }

    public List<Categoria> listar() {
        List<Categoria> resultado = new ArrayList<>();
        final String query = "SELECT ID, NOMBRE FROM categoria;";
        System.out.println(query);
        try {
            
            final PreparedStatement statement = con.prepareStatement(query);
            try (statement) {
                statement.execute();
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    Categoria fila = new Categoria(
                                            resultSet.getInt("ID"),
                                            resultSet.getString("NOMBRE")
                                        );
                    resultado.add(fila);
                }
                return resultado;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public int modificar(Categoria categoria) {
        try {
            final String query = "UPDATE categoria SET NOMBRE=? WHERE ID=?;";
            final PreparedStatement statement = con.prepareStatement(query);                    
            try (statement) {
                statement.setString(1, categoria.getNombre());
                statement.setInt(2, categoria.getId());
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
            final PreparedStatement statement = con.prepareStatement("DELETE FROM categoria WHERE ID=?;");
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

    public List<Categoria> listarConProductos() {
        List<Categoria> resultado = new ArrayList<>();
        final String query = "SELECT C.ID, C.NOMBRE, P.ID, P.NOMBRE, P.CANTIDAD FROM categoria C "
                + "INNER JOIN producto P ON C.ID = P.CATEGORIA_ID ";
        System.out.println(query);
        try {
            final PreparedStatement statement = con.prepareStatement(query);
            try (statement) {
                statement.execute();
                final ResultSet resultSet = statement.getResultSet();
                try (resultSet){
                    while (resultSet.next()) {
                        Integer categoriaId = resultSet.getInt("C.ID");
                        String categoriaNombre = resultSet.getString("C.NOMBRE");
                        var categoria = resultado
                                .stream()
                                .filter(cat -> cat.getId().equals(categoriaId))
                                .findAny().orElseGet(() -> {
                                        Categoria cat = new Categoria(categoriaId, categoriaNombre);
                                            resultado.add(cat);
                                        return cat;
                                    });
                        Producto producto = new Producto(resultSet.getInt("P.ID"),
                                                    resultSet.getString("P.NOMBRE"),
                                                    resultSet.getInt("P.CANTIDAD"));
                        categoria.agregar(producto);
                    }
                };
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

}
