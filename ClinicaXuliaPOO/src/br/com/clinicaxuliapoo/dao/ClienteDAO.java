package br.com.clinicaxuliapoo.dao;

import br.com.clinicaxuliapoo.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para criar um novo cliente (Create)
    public void criarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO tb_clientes (cpf_cliente, nome_cliente, email_cliente, senha_cliente, telefone_cliente, endereco_cliente, data_nascimento_cliente) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cliente.getCpf());
        statement.setString(2, cliente.getNome());
        statement.setString(3, cliente.getEmail());
        statement.setString(4, cliente.getSenha());
        statement.setString(5, cliente.getTelefone());
        statement.setString(6, cliente.getEndereco());
        statement.setString(7,cliente.getData_nasc());
        statement.executeUpdate();
    }

    // Método para buscar um cliente pelo CPF (Read)
    public Cliente buscarCliente(String cpf) throws SQLException {
        String sql = "SELECT * FROM tb_clientes WHERE cpf_cliente = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cpf);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            Cliente cliente = new Cliente();
            cliente.setCpf(resultSet.getString("cpf_cliente"));
            cliente.setNome(resultSet.getString("nome_cliente"));
            cliente.setEmail(resultSet.getString("email_cliente"));
            cliente.setSenha(resultSet.getString("senha_cliente"));
            cliente.setTelefone(resultSet.getString("telefone_cliente"));
            cliente.setEndereco(resultSet.getString("endereco_cliente"));
            cliente.setData_nasc(resultSet.getString("data_nascimento_cliente"));
            return cliente;
        } else {
            return null;
        }
    }

    // Método para atualizar os dados de um cliente (Update)
    public void atualizarCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE tb_clientes SET nome_cliente = ?, email_cliente = ?, senha_cliente = ?, telefone_cliente = ?, endereco_cliente = ?, data_nascimento_cliente = ? WHERE cpf_cliente = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getEmail());
        statement.setString(3, cliente.getSenha());
        statement.setString(4, cliente.getTelefone());
        statement.setString(5, cliente.getEndereco());
        statement.setString(6, cliente.getData_nasc());
        statement.setString(7, cliente.getCpf());
        statement.executeUpdate();
    }

    // Método para excluir um cliente pelo CPF (Delete)
    public void deletarCliente(String cpf) throws SQLException {
        String sql = "DELETE FROM tb_clientes WHERE cpf_cliente = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cpf);
        statement.executeUpdate();
    }

    // Método para listar todos os clientes
    public List<Cliente> listarClientes() throws SQLException {
        String sql = "SELECT * FROM tb_clientes";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Cliente> clientes = new ArrayList<>();

        while (resultSet.next()) {
            Cliente cliente = new Cliente();
            cliente.setCpf(resultSet.getString("cpf_cliente"));
            cliente.setNome(resultSet.getString("nome_cliente"));
            cliente.setEmail(resultSet.getString("email_cliente"));
            cliente.setSenha(resultSet.getString("senha_cliente"));
            cliente.setTelefone(resultSet.getString("telefone_cliente"));
            cliente.setEndereco(resultSet.getString("endereco_cliente"));
            cliente.setData_nasc(resultSet.getString("data_nascimento_cliente"));
            clientes.add(cliente);
        }
        return clientes;
    }
}
