package br.com.clinicaxuliapoo.dao;

import br.com.clinicaxuliapoo.model.ModuloConexao;
import br.com.clinicaxuliapoo.model.Veterinario;
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
                
                String dataNascStr = rs.getString("data_nascimento_vet");
                if (dataNascStr != null) {
                    LocalDate data_nasc = LocalDate.parse(dataNascStr); 
                    objVet.setData_nascimento(data_nasc);
                } else {
                    objVet.setData_nascimento(null);  
                }  
                
                objVet.setDisponibilidade(rs.getBoolean("disponibilidade"));
                objVet.setSalario(rs.getFloat("salario"));
                
                lista.add(objVet);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro listar:"+e);
        }
        
        return lista;
    }
    
    public boolean cadastrarVeterinario(Veterinario veterinario) throws SQLException {
        String sql = "INSERT INTO tb_veterinarios (crmv, nome_vet, email_vet, senha_vet, telefone_vet, endereco_vet, cpf_vet, data_nascimento_vet, disponibilidade, salario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ModuloConexao.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, veterinario.getCrmv());
            stmt.setString(2, veterinario.getNome());
            stmt.setString(3, veterinario.getEmail());
            stmt.setString(4, veterinario.getSenha());
            stmt.setString(5, veterinario.getTelefone());
            stmt.setString(6, veterinario.getEndereco());
            stmt.setString(7, veterinario.getCpf());
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dataFormatada = veterinario.getData_nascimento().format(formatter);
            stmt.setString(8, dataFormatada);
            
            stmt.setBoolean(9, veterinario.isDisponibilidade());
            stmt.setDouble(10, veterinario.getSalario());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    
    public boolean alterarVeterinario(Veterinario veterinario) throws SQLException {
        String sql = "UPDATE tb_veterinarios SET nome_vet=?, email_vet=?, senha_vet=?, telefone_vet=?, endereco_vet=?, data_nascimento_vet=?, disponibilidade=?, salario=? WHERE crmv=?";
        try (Connection conn = ModuloConexao.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, veterinario.getNome());
            stmt.setString(2, veterinario.getEmail());
            stmt.setString(3, veterinario.getSenha());
            stmt.setString(4, veterinario.getTelefone());
            stmt.setString(5, veterinario.getEndereco());
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dataFormatada = veterinario.getData_nascimento().format(formatter);
            stmt.setString(6,dataFormatada);
            
            stmt.setBoolean(7, veterinario.isDisponibilidade());
            stmt.setDouble(8, veterinario.getSalario());
            stmt.setString(9, veterinario.getCrmv());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public boolean excluirVeterinario(String crmv) {
        String sql = "DELETE FROM tb_veterinarios WHERE crmv = ?";
        try (Connection conn = ModuloConexao.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, crmv);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        return true;
    }


    
}
