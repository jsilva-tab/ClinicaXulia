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
                    LocalDate data_nasc = LocalDate.parse(dataNascStr); 
                    objCliente.setData_nasc(data_nasc);
                } else {
                    objCliente.setData_nasc(null);  
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
                    LocalDate data_nasc = LocalDate.parse(dataNascStr); 
                    cliente.setData_nasc(data_nasc);
                } else {
                    cliente.setData_nasc(null);  
                }                
                
                return cliente;
            }
        }
        return null; 
    }

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
    
    public void cadastrarCliente(Cliente cliente){
        String sql = "insert into tb_clientes (cpf_cliente, nome_cliente, email_cliente, senha_cliente, telefone_cliente, endereco_cliente, data_nascimento_cliente) values (?,?,?,?,?,?,?)";
        
        try {
            connection = ModuloConexao.conector();
            PreparedStatement psmt = connection.prepareStatement(sql);
            
            psmt.setString(1,cliente.getCpf());
            psmt.setString(2, cliente.getNome());
            psmt.setString(3, cliente.getEmail());
            psmt.setString(4,cliente.getSenha());
            psmt.setString(5,cliente.getTelefone());
            psmt.setString(6, cliente.getEndereco());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dataFormatada = cliente.getData_nasc().format(formatter);
            psmt.setString(7, dataFormatada);
            
            psmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro criar cliente:"+e);
        }
    }
    
    public void excluirCliente(String cpfCliente){
        String sql = "delete from tb_clientes where cpf_cliente = ?";
        
        try {
            connection = ModuloConexao.conector();
            PreparedStatement psmt = connection.prepareStatement(sql);
            
            psmt.setString(1,cpfCliente);
            
            psmt.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente: " + e.getMessage());
        }
    }

    public Cliente buscarPorEmail(String email) {
        Cliente cliente = null;
        String sql = "SELECT * FROM tb_clientes WHERE email_cliente = ?";

        try (Connection conn = ModuloConexao.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
                String dataNascStr = rs.getString("data_nascimento");
                if (dataNascStr != null) {
                    LocalDate data_nasc = LocalDate.parse(dataNascStr); 
                    cliente.setData_nasc(data_nasc);
                } else {
                    cliente.setData_nasc(null); 
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return cliente;
    }

    public void atualizarSenha(Cliente cliente) {
        String sql = "UPDATE tb_clientes SET senha_cliente = ? WHERE email_cliente = ?";

        try (Connection conn = ModuloConexao.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cliente.getSenha());
            stmt.setString(2, cliente.getEmail());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean cpfExiste(String cpf){
        String sql = "select count(*) from tb_clientes where cpf_cliente = ?";
        
        try {
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setString(1,cpf);
            ResultSet rs = psmt.executeQuery();
            
            if(rs.next()){
                return rs.getInt(1)>0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
}

