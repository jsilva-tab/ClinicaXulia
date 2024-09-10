import java.sql.*;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;

public class PasswordResetService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/yourdatabase";
    private static final String DB_USER = "yourusername";
    private static final String DB_PASSWORD = "yourpassword";

    public void sendPasswordResetEmail(String userEmail) {
        String pincode = generatePincode();
        Timestamp expirationTime = new Timestamp(System.currentTimeMillis() + 3600 * 1000); // 1 hour from now

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO password_reset (user_id, pincode, expiration_time) VALUES ((SELECT id FROM users WHERE email = ?), ?, ?) ON DUPLICATE KEY UPDATE pincode = VALUES(pincode), expiration_time = VALUES(expiration_time)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, userEmail);
                stmt.setString(2, pincode);
                stmt.setTimestamp(3, expirationTime);
                stmt.executeUpdate();
            }
            sendEmail(userEmail, pincode);
        } catch (SQLException e) {
            e.printStackTrace();
            // Adicione tratamento de exceções apropriado
        } catch (MessagingException e) {
            e.printStackTrace();
            // Adicione tratamento de exceções apropriado
        }
    }

    private String generatePincode() {
        Random random = new Random();
        int pincode = 100000 + random.nextInt(900000); // Gera um pincode de 6 dígitos
        return String.valueOf(pincode);
    }

    private void sendEmail(String userEmail, String pincode) throws MessagingException {
        String host = "smtp.example.com";
        final String user = "your-email@example.com";
        final String password = "your-email-password";

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(user));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
        message.setSubject("Password Reset");
        message.setText("Your password reset pincode is: " + pincode);

        Transport.send(message);
    }
}