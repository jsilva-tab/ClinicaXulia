package br.com.clinicaxuliapoo.dao;

import java.sql.*;
import java.util.ArrayList;
import br.com.clinicaxuliapoo.model.Pet;
import javax.swing.JOptionPane;
import br.com.clinicaxuliapoo.model.ModuloConexao;

public class PetDAO {

    private Connection conexao;
    ArrayList<Pet> lista = new ArrayList<>();


    public PetDAO() {
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_vetclin_xulia", "root", "M!ch$#l,Sh##n<3");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarPet(Pet objpet){
        String sql = "insert into tb_pets (idDono,nome_pet, especie_pet, raca_pet, idade_pet, sexo_pet) values (?,?,?,?,?,?)";
        
        conexao = ModuloConexao.conector();
        
        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, objpet.getIdDono());
            pst.setString(2,objpet.getNome_pet());
            pst.setString(3,objpet.getEspecie());
            pst.setString(4, objpet.getRaca());
            pst.setInt(5,objpet.getIdade());
            pst.setString(6, objpet.getSexo());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Pet criado com sucesso!");
            pst.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro criar pet:"+e);
        }
    }
    
    public void editarPet(Pet objPet){
        String sql = "update tb_pets set nome_pet = ?, especie_pet = ?, raca_pet = ?, idade_pet = ?, sexo_pet = ? where idPet = ?";
        
        conexao = ModuloConexao.conector();
        
        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, objPet.getNome_pet());
            pst.setString(2, objPet.getEspecie());
            pst.setString(3, objPet.getRaca());
            pst.setInt(4, objPet.getIdade());
            pst.setString(5, objPet.getSexo());
            pst.setInt(6, objPet.getIdPet());
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Pet alterado com sucesso!");
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao editar pet:"+e);
        }
    }
    
    public void excluirPet(Pet objPet){
        String sql = "delete from tb_pets where idPet = ?";
        
        conexao = ModuloConexao.conector();
        
        
        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1,objPet.getIdPet());
            pst.execute();
            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Pet excluir:"+e);
        }
    }
    
    public ArrayList<Pet> pesquisarPets(){ 
            String sql = "select * from tb_pets";
            
            try {
                PreparedStatement pst = conexao.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                
                while(rs.next()){
                    Pet pet = new Pet();
                    pet.setIdPet(rs.getInt("idPet"));
                    pet.setIdDono(rs.getString("idDono"));
                    pet.setNome_pet(rs.getString("nome_pet"));
                    pet.setEspecie(rs.getString("especie_pet"));
                    pet.setRaca(rs.getString("raca_pet"));
                    pet.setIdade(rs.getInt("idade_pet"));
                    pet.setSexo(rs.getString("sexo_pet"));
                    
                    lista.add(pet);
                }
                
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Pesquisar pet:"+e);
            }
            
            return lista;
        }


}