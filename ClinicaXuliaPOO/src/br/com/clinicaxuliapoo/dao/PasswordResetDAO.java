package br.com.clinicaxuliapoo.dao;

import br.com.clinicaxuliapoo.model.ModuloConexao;
import java.sql.*;

public class PasswordResetDAO {

    // Cria um registro de recuperação de senha (PIN) no banco de dados
    public void criarPasswordReset(String idUser, String pincode, Timestamp expirationTime) {
        String sql = "INSERT INTO password_reset (idUser, pincode, expiration_time) VALUES (?, ?, ?) "
                   + "ON DUPLICATE KEY UPDATE pincode = VALUES(pincode), expiration_time = VALUES(expiration_time)";

        try (Connection conn = ModuloConexao.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idUser);
            stmt.setString(2, pincode);
            stmt.setTimestamp(3, expirationTime);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Verifica se o PIN está correto e se ainda não expirou
    public boolean verificarPin(String idUser, String pincode) {
        String sql = "SELECT pincode, expiration_time FROM password_reset WHERE idUser = ?";

        try (Connection conn = ModuloConexao.conector();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idUser);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedPincode = rs.getString("pincode");
                Timestamp expirationTime = rs.getTimestamp("expiration_time");

                // Verifica se o PIN está correto e se ainda não expirou
                if (storedPincode.equals(pincode) && expirationTime.after(new Timestamp(System.currentTimeMillis()))) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
}