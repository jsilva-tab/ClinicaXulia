package br.com.clinicaxuliapoo.dao;

import br.com.clinicaxuliapoo.model.Carteira;
import br.com.clinicaxuliapoo.model.ModuloConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;


public class CarteiraDAO {
    
    private Connection conexao;
    ArrayList<Carteira> listaCart = new ArrayList<>();

    
    public CarteiraDAO(){
            try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_vetclin_xulia", "root", "M!ch$#l,Sh##n<3");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Carteira> pesquisarCarteira(){
        String sql =  "SELECT p.idPet, p.nome_pet, v.nome_vac AS nome_vac, va.data_aplicacao " +
                     "FROM tb_pets p " +
                     "JOIN tb_vacinas_aplicadas va ON p.idPet = va.idPet " +
                     "JOIN tb_vacinas v ON va.idVacina = v.idVacina";
        
        conexao = ModuloConexao.conector();
        
        try {
            PreparedStatement psmt = conexao.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            
            while(rs.next()){
                Carteira carteira = new Carteira();
                
                carteira.setIdPet(rs.getInt("idPet"));
                carteira.setNomePet(rs.getString("nome_pet"));
                carteira.setNomeVacina(rs.getString("nome_vac"));
                carteira.setDataAplicacao(rs.getDate("data_aplicacao").toLocalDate());
                
                listaCart.add(carteira);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro pesquisar carteira:"+e);
        }
        
        return listaCart;
    }
    
    
}
