package br.com.clinicaxuliapoo.dao;

import br.com.clinicaxuliapoo.model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                objCliente.setData_nasc(rs.getString("data_nascimento_cliente"));
                
                clientes.add(objCliente);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro listar clientes:"+e);
        }
        
        return clientes;
    }
    
    
}
