package br.com.clinicaxuliapoo.dao;

import br.com.clinicaxuliapoo.model.Veterinario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VeterinarioDAO {
    private Connection connection;
    List<Veterinario> lista = new ArrayList();


    public VeterinarioDAO() {
       try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_vetclin_xulia", "root", "M!ch$#l,Sh##n<3");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Veterinario> listarVeterinarios(){
        String sql = "select * from tb_veterinarios";
        
        try {
            
            PreparedStatement psmt = connection.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            
            while(rs.next()){
                Veterinario objVet = new Veterinario();
                
                objVet.setCrmv(rs.getString("crmv"));
                objVet.setNome(rs.getString("nome_vet"));
                objVet.setEmail(rs.getString("email_vet"));
                objVet.setSenha(rs.getString("senha_vet"));
                objVet.setTelefone(rs.getString("telefone_vet"));
                objVet.setEndereco(rs.getString("endereco_vet"));
                objVet.setCpf(rs.getString("cpf_vet"));
                objVet.setData_nascimento(rs.getDate("data_nascimento_vet"));
                objVet.setDisponibilidade(rs.getBoolean("disponibilidade"));
                objVet.setSalario(rs.getFloat("salario"));
                
                lista.add(objVet);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro listar:"+e);
        }
        
        return lista;
    }
}
