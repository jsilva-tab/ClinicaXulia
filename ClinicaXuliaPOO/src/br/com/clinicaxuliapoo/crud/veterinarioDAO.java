import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeterinarioDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/yourdatabase";
    private static final String DB_USER = "yourusername";
    private static final String DB_PASSWORD = "yourpassword";

    public void addVeterinario(Veterinario veterinario) throws SQLException {
        String query = "INSERT INTO veterinario (nome, especialidade) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, veterinario.getNome());
            stmt.setString(2, veterinario.getEspecialidade());
            stmt.executeUpdate();
        }
    }

    public List<Veterinario> getAllVeterinarios() throws SQLException {
        List<Veterinario> veterinarios = new ArrayList<>();
        String query = "SELECT * FROM veterinario";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Veterinario veterinario = new Veterinario();
                veterinario.setId(rs.getInt("id"));
                veterinario.setNome(rs.getString("nome"));
                veterinario.setEspecialidade(rs.getString("especialidade"));
                veterinarios.add(veterinario);
            }
        }
        return veterinarios;
    }

    public void updateVeterinario(Veterinario veterinario) throws SQLException {
        String query = "UPDATE veterinario SET nome = ?, especialidade = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, veterinario.getNome());
            stmt.setString(2, veterinario.getEspecialidade());
            stmt.setInt(3, veterinario.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteVeterinario(int id) throws SQLException {
        String query = "DELETE FROM veterinario WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}