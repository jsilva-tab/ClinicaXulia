import br.com.clinicaxuliapoo.model.Adm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

package br.com.clinicaxuliapoo.dao;

public class AdmDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/clinicadb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public void save(Adm adm) {
        String sql = "INSERT INTO adm (name, email) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, adm.getName());
            stmt.setString(2, adm.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Adm adm) {
        String sql = "UPDATE adm SET name = ?, email = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, adm.getName());
            stmt.setString(2, adm.getEmail());
            stmt.setInt(3, adm.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(Adm adm) {
        String sql = "DELETE FROM adm WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, adm.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Adm findById(int id) {
        String sql = "SELECT * FROM adm WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Adm adm = new Adm();
                adm.setId(rs.getInt("id"));
                adm.setName(rs.getString("name"));
                adm.setEmail(rs.getString("email"));
                return adm;
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}