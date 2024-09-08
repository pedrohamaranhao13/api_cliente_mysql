package br.com.smarttec.api_clientes.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String HOST = "jdbc:sqlserver://localhost:1433;databaseName=bd_api_clientes;";
    private static final String USER = "sa";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws Exception {

        Class.forName(DRIVER);
        return DriverManager.getConnection(HOST, USER, PASSWORD);
    }
}
