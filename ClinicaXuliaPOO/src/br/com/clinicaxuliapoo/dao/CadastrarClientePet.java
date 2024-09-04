package br.com.clinicaxuliapoo.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.clinicaxuliapoo.model.Cliente;
import br.com.clinicaxuliapoo.model.Pet;

public class CadastrarClientePet {
    
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_vetclin_xulia", "root", "M!ch$#l,Sh##n<3");
    }
    
    public void inserirCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO tb_clientes (cpf_cliente, nome_cliente, email_cliente, senha_cliente, telefone_cliente, endereco_cliente, data_nascimento_cliente) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexao = getConnection();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getCpf());
            pstmt.setString(2, cliente.getNome());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getSenha());
            pstmt.setString(5, cliente.getTelefone());
            pstmt.setString(6, cliente.getEndereco());
            pstmt.setString(7, cliente.getData_nasc());

            pstmt.executeUpdate();
        }
    }
    
    public void inserirPet(Pet pet) throws SQLException {
        String sql = "INSERT INTO tb_pets (idDono, nome_pet, especie_pet, raca_pet, idade_pet, sexo_pet) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, pet.getIdDono());
            pstmt.setString(2,pet.getNome_pet());
            pstmt.setString(3, pet.getEspecie());
            pstmt.setString(4, pet.getRaca());
            pstmt.setInt(5, pet.getIdade());
            pstmt.setString(6, pet.getSexo());
            pstmt.executeUpdate();
        }
    }

    // Método para cadastrar usuário e pet juntos
    public void cadastrarClienteEPet(Cliente cliente, Pet pet) {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false); // Inicia transação

            inserirCliente(cliente); // Insere o usuário
            inserirPet(pet);         // Insere o pet associado

            conn.commit(); // Comita a transação
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback(); // Desfaz a transação em caso de erro
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
