package br.com.smarttec.api_clientes.repositories;

import br.com.smarttec.api_clientes.entities.Cliente;
import br.com.smarttec.api_clientes.factories.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

        statement.close();
    }

    public void update(Cliente cliente) throws Exception {
        //  TODO
    }

    public void delete(Cliente cliente) throws Exception {
        //  TODO
    }

    public List<Cliente> findAll() throws Exception {
        //TODO
        return null;
    }

    public Cliente findById(Integer idCliente) throws Exception {
        //  TODO
        return null;
    }
}
