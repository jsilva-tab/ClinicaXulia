package br.com.clinicaxuliapoo.dao;

import br.com.clinicaxuliapoo.model.ModuloConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.*;
import java.time.LocalDate;

public class VacinaDAO {
    
    private Connection conexao;
    
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
    
    public void marcarVacina(int idPet, String nomeVac, LocalDate dataVacina, String hora){
        String sql = "insert into tb_vacinas_aplicadas (idPet, idVacina, data_hora) values (?,(select idVacina from tb_vacinas where nome_vac = ?), ?)";
        
        try {
            PreparedStatement psmt = conexao.prepareStatement(sql);
            
            psmt.setInt(1,idPet);
            psmt.setString(2,nomeVac);
            psmt.setString(3, dataVacina + " " + hora);
            psmt.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro marcar vacina:"+e);
        }
    }
    
    
}
