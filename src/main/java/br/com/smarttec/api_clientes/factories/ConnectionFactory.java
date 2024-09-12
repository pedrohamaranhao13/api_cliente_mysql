package br.com.smarttec.api_clientes.factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String HOST = "jdbc:sqlserver://localhost:1433;databaseName=bd_api_clientes;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws Exception {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(HOST, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  // Mostra a pilha de exceções no console
            throw new RuntimeException("Driver não encontrado: " + e.getMessage(), e);
        } catch (SQLException e) {
            e.printStackTrace();  // Mostra a pilha de exceções no console
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }
}
