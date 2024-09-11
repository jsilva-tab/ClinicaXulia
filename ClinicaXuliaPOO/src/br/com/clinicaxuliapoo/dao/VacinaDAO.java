package br.com.clinicaxuliapoo.dao;

import br.com.clinicaxuliapoo.model.ModuloConexao;
import br.com.clinicaxuliapoo.model.Vacina;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VacinaDAO {
    
    private Connection conexao;
    ArrayList<Vacina> vacinas = new ArrayList<>();
    
    public VacinaDAO(){
            try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_vetclin_xulia", "root", "M!ch$#l,Sh##n<3");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<String> listarVacina(){
        List<String> vacinas = new ArrayList<>();
        String sql = "select nome_vac from tb_vacinas";
        
        conexao = ModuloConexao.conector();
        
        try {
            PreparedStatement psmt = conexao.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            
            while(rs.next()){
                vacinas.add(rs.getString("nome_vac"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro listar vacina dao:"+e);
        }
        
        return vacinas;
    }
    
    public boolean marcarVacina(int idPet, String nomeVac, LocalDate dataVacina, String hora){
        String sql = "insert into tb_vacinas_aplicadas (idPet, idVacina, data_aplicacao,status) values (?,(select idVacina from tb_vacinas where nome_vac = ?), ?,?)";
        
        try {
            PreparedStatement psmt = conexao.prepareStatement(sql);
            
            psmt.setInt(1,idPet);
            psmt.setString(2,nomeVac);
            psmt.setString(3, dataVacina + " " + hora);
            psmt.setString(4,"pendente");
            int rowsAffected = psmt.executeUpdate();
            
            return rowsAffected > 0;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro marcar vacina:"+e);
            return false;
        }

    }
    
    public ArrayList<Vacina> listagemVacinas(){
        String sql = "select * from tb_vacinas";
        
        try {
            PreparedStatement psmt = conexao.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            
            while(rs.next()){
                Vacina v = new Vacina();
                
                v.setIdVacina(rs.getInt("idVacina"));
                v.setNome_vac(rs.getString("nome_vac"));
                v.setLote(rs.getString("lote"));
                
                String dataVacStr = rs.getString("validade");
                if (dataVacStr != null) {
                    LocalDate data_validade = LocalDate.parse(dataVacStr); 
                    v.setValidade(data_validade);
                } else {
                    v.setValidade(null); 
                }
                
                v.setFabricante(rs.getString("fabricante"));
                v.setDescricao(rs.getString("descricao"));
                
                vacinas.add(v);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro listar vacinas"+e);
        }
        
        return vacinas;
    }
    
    public boolean editarVacina(Vacina vacina){
        String sql = "update tb_vacinas set nome_vac = ?, lote = ?, validade = ?, fabricante = ?, descricao = ? where idVacina = ?";
        
        try {
            conexao = ModuloConexao.conector();
            PreparedStatement psmt = conexao.prepareStatement(sql);
            
            psmt.setString(1,vacina.getNome_vac());
            psmt.setString(2, vacina.getLote());
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dataFormatada = vacina.getValidade().format(formatter);
            psmt.setString(3,dataFormatada);
            
            psmt.setString(4,vacina.getFabricante());
            psmt.setString(5,vacina.getDescricao());
            psmt.setInt(6, vacina.getIdVacina());
            
            int rowsAffected = psmt.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro editar vacina:"+e);
        }
        
        return true;
    }
    
    public void cadastrarVacina(Vacina vacina){
        String sql = "insert into tb_vacinas (nome_vac, lote, validade, fabricante, descricao) values (?,?,?,?,?)";
        
        try {
            conexao = ModuloConexao.conector();
            PreparedStatement psmt = conexao.prepareStatement(sql);
            
            psmt.setString(1, vacina.getNome_vac());
            psmt.setString(2, vacina.getLote());
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dataFormatada = vacina.getValidade().format(formatter);
            psmt.setString(3, dataFormatada);
            
            psmt.setString(4,vacina.getFabricante());
            psmt.setString(5, vacina.getDescricao());
            
            psmt.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro cadastrar vacina:"+e);
        }
        
    }
    
    public void excluirVacina(int idVacina){
        String sql = "delete from tb_vacinas where idVacina = ?";
        
        try {
            conexao = ModuloConexao.conector();
            PreparedStatement psmt = conexao.prepareStatement(sql);
            
            psmt.setInt(1, idVacina);
            
            psmt.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro excluir vacina:"+ e);
        }
    }
    
    
}
