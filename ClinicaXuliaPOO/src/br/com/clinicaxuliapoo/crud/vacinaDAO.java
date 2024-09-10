import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacinaDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/yourdatabase";
    private static final String DB_USER = "yourusername";
    private static final String DB_PASSWORD = "yourpassword";

    public void addVacina(Vacina vacina) throws SQLException {
        String query = "INSERT INTO vacina (nome, fabricante) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, vacina.getNome());
            stmt.setString(2, vacina.getFabricante());
            stmt.executeUpdate();
        }
    }

    public List<Vacina> getAllVacinas() throws SQLException {
        List<Vacina> vacinas = new ArrayList<>();
        String query = "SELECT * FROM vacina";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Vacina vacina = new Vacina();
                vacina.setId(rs.getInt("id"));
                vacina.setNome(rs.getString("nome"));
                vacina.setFabricante(rs.getString("fabricante"));
                vacinas.add(vacina);
            }
        }
        return vacinas;
    }

    public void updateVacina(Vacina vacina) throws SQLException {
        String query = "UPDATE vacina SET nome = ?, fabricante = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, vacina.getNome());
            stmt.setString(2, vacina.getFabricante());
            stmt.setInt(3, vacina.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteVacina(int id) throws SQLException {
        String query = "DELETE FROM vacina WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}