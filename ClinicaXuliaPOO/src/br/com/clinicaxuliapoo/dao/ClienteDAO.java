package br.com.clinicaxuliapoo.dao;

import br.com.clinicaxuliapoo.model.Cliente;
import br.com.clinicaxuliapoo.model.ModuloConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
        
public class ClienteDAO {
    private Connection connection;
    List<Cliente> clientes = new ArrayList<>();

    public ClienteDAO() {
    try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_vetclin_xulia", "root", "M!ch$#l,Sh##n<3");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Cliente> listarClientes(){
       String sql = "select * from tb_clientes";
       
        try {
            PreparedStatement psmt = connection.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            
            while(rs.next()){
                Cliente objCliente = new Cliente();
                
                objCliente.setCpf(rs.getString("cpf_cliente"));
                objCliente.setNome(rs.getString("nome_cliente"));
                objCliente.setEmail(rs.getString("email_cliente"));
                objCliente.setSenha(rs.getString("senha_cliente"));
                objCliente.setTelefone(rs.getString("telefone_cliente"));
                objCliente.setEndereco(rs.getString("endereco_cliente"));
                String dataNascStr = rs.getString("data_nascimento_cliente");
                if (dataNascStr != null) {
                    LocalDate data_nasc = LocalDate.parse(dataNascStr); // Converte a string para LocalDate
                    objCliente.setData_nasc(data_nasc);
                } else {
                    objCliente.setData_nasc(null);  // Caso a data seja nula no banco
                }                 
                clientes.add(objCliente);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro listar clientes:"+e);
        }
        
        return clientes;
    }
    
    public Cliente buscarClientePorCPF(String cpf) throws SQLException {
        String sql = "SELECT * FROM tb_clientes WHERE cpf_cliente = ?";
        try (Connection conn = ModuloConexao.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
                String dataNascStr = rs.getString("data_nascimento");
                if (dataNascStr != null) {
                    LocalDate data_nasc = LocalDate.parse(dataNascStr); // Converte a string para LocalDate
                    cliente.setData_nasc(data_nasc);
                } else {
                    cliente.setData_nasc(null);  // Caso a data seja nula no banco
                }                
                
                return cliente;
            }
        }
        return null;  // Retorna null se não encontrar o cliente
    }

    // Método para atualizar os dados do cliente
    public boolean atualizarCliente(Cliente cliente){
        String sql = "UPDATE tb_clientes SET nome_cliente = ?, email_cliente = ?, senha_cliente = ?, telefone_cliente = ?, endereco_cliente = ?, data_nascimento_cliente = ? WHERE cpf_cliente = ?";
        try (Connection conn = ModuloConexao.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getSenha());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEndereco());
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dataFormatada = cliente.getData_nasc().format(formatter);
            stmt.setString(6,dataFormatada);
            
            stmt.setString(7, cliente.getCpf());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        return true;
    }
    
    
}
