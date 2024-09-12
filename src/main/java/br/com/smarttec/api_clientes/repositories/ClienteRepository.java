package br.com.smarttec.api_clientes.repositories;

import br.com.smarttec.api_clientes.entities.Cliente;
import br.com.smarttec.api_clientes.factories.ConnectionFactory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    public void create(Cliente cliente) throws Exception {

        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement statement = connection.prepareStatement("INSERT INTO CLIENTE(nome, email, cpf, telefone, observacoes) VALUES(?,?,?,?,?)");
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getEmail());
        statement.setString(3, cliente.getCpf());
        statement.setString(4, cliente.getTelefone());
        statement.setString(5, cliente.getObservacoes());
        statement.execute();

        connection.close();
    }

    public void update(Cliente cliente) throws Exception {
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement statement = connection.prepareStatement("UPDATE CLIENTE SET nome=?, email=?, cpf=?, telefone=?, observacoes=? WHERE idcliente=?");
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getEmail());
        statement.setString(3, cliente.getCpf());
        statement.setString(4, cliente.getTelefone());
        statement.setString(5, cliente.getObservacoes());
        statement.setInt(6, cliente.getIdCliente());
        statement.execute();

        connection.close();
    }

    public void delete(Cliente cliente) throws Exception {

        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement statement = connection.prepareStatement("DELETE FROM CLIENTE WHERE idcliente=?");
        statement.setInt(1, cliente.getIdCliente());
        statement.execute();

        connection.close();
    }

    public List<Cliente> findAll() throws Exception {

        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM CLIENTE");
        ResultSet resultSet = statement.executeQuery();

        List<Cliente> lista = new ArrayList<Cliente>();

        while(resultSet.next()) {

            Cliente cliente = new Cliente();
            cliente.setIdCliente(resultSet.getInt("idcliente"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setCpf(resultSet.getString("cpf"));
            cliente.setTelefone(resultSet.getString("telefone"));
            cliente.setObservacoes(resultSet.getString("observacoes"));

            lista.add(cliente);
        }

        connection.close();
        return lista;
    }

    public Cliente findById(Integer idCliente) throws Exception {

        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM CLIENTE WHERE idcliente=?");
        statement.setInt(1, idCliente);
        ResultSet resultSet = statement.executeQuery();

        Cliente cliente = null;

        if(resultSet.next()) {

            cliente = new Cliente();

            cliente.setIdCliente(resultSet.getInt("idcliente"));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setCpf(resultSet.getString("cpf"));
            cliente.setTelefone(resultSet.getString("telefone"));
            cliente.setObservacoes(resultSet.getString("observacoes"));
        }

        connection.close();
        return cliente;
    }
}
