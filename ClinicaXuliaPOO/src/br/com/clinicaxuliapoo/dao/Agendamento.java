package br.com.clinicaxuliapoo.dao;

import br.com.clinicaxuliapoo.model.ModuloConexao;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Agendamento {
    
    private Connection conexao;
    int rowsAffected;
    List<String> nomePet = new ArrayList<>();

    
    public Agendamento(){
            try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_vetclin_xulia", "root", "M!ch$#l,Sh##n<3");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public boolean agendarConsulta(LocalDateTime dataHora, String idVeterinario, String idCliente, int idPet){
        String sql = "insert into tb_consultas(data_consulta, idVeterinario, idCliente, idPet, status) values (?,?,?,?,'Agendada')";
        
        conexao = ModuloConexao.conector();
       
        try {
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setObject(1, dataHora);
            pstm.setString(2, idVeterinario);
            pstm.setString(3,idCliente);
            pstm.setInt(4, idPet);
            
            rowsAffected = pstm.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro agendar consulta"+e);
        }
        return rowsAffected > 0;
    }
    
    public List<String> buscarPetPorNomeDono(String nomeDono){
        String sql = "select nome_pet from tb_pets join tb_clientes on idDono = cpf_cliente where nome_cliente = ?";
        
        conexao = ModuloConexao.conector();
        
        try {
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, nomeDono);
            
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                nomePet.add(rs.getString("nome_pet"));
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"busca pet por nome do dono:"+e);
        }
    
    return nomePet;
    }
    
    public String obterIdVetPorNome(String nomeVet){
        String sql = "select crmv from tb_veterinarios where nome_vet = ?";
        
        conexao = ModuloConexao.conector();
        
        try {
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1,nomeVet);
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()) {
                return rs.getString("crmv");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro buscar idvet por nome:"+e);
        }
        return null;
    }
    
    public int obterIdPetPorNome(String nomePet){
        String sql = "select idPet from tb_pets where nome_pet = ?";
        
        conexao = ModuloConexao.conector();
        
        try {
            PreparedStatement pstm = conexao.prepareStatement(sql);
            
            pstm.setString(1, nomePet);
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("idPet");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro buscar id pet por nome:"+e);
        }
        return -1;
    }
   
    public String obterIdDonoPorNome(String nomeDono){
        String sql = "select cpf_cliente from tb_clientes where nome_cliente = ?";
        
        conexao = ModuloConexao.conector();
        
        try {
            PreparedStatement psmt = conexao.prepareStatement(sql);
            
            psmt.setString(1,nomeDono);
            ResultSet rs = psmt.executeQuery();
            
            if (rs.next()) {
                return rs.getString("cpf_cliente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro buscar cliente por nome:"+e);
        }
        return  null;
    }
    
    
}
