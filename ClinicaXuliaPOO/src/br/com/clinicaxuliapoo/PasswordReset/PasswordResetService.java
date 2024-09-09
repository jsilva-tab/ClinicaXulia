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
        }
    }

    private String generatePincode() {
        Random random = new Random();
        int pincode = 100000 + random.nextInt(900000);
        return String.valueOf(pincode);
    }

    private void sendEmail(String to, String pincode) {
        String from = "your-email@example.com";
        String host = "smtp.example.com";
        final String username = "your-email@example.com";
        final String password = "your-email-password";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Password Reset Request");
            message.setText("Your password reset code is: " + pincode);

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}