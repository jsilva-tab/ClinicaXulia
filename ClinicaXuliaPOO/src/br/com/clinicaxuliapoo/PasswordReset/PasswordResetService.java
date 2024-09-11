import java.sql.*;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;

public class PasswordResetService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_vetclin_xulia";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "M!ch$#L,Sh##n<3";

    public void sendPasswordResetEmail(String userEmail) throws SQLException, MessagingException {
        String pincode = generatePincode();
        Timestamp expirationTime = new Timestamp(System.currentTimeMillis() + 3600 * 1000); // 1 hour from now

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO password_reset (idUser, pincode, expiration_time) VALUES ((SELECT cpf_cliente FROM tb_clientes WHERE email_cliente = ?), ?, ?) ON DUPLICATE KEY UPDATE pincode = VALUES(pincode), expiration_time = VALUES(expiration_time)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, userEmail);
                stmt.setString(2, pincode);
                stmt.setTimestamp(3, expirationTime);
                stmt.executeUpdate();
            }
            sendEmail(userEmail, pincode);
        }
    }

    private String generatePincode() {
        Random random = new Random();
        int pincode = 100000 + random.nextInt(900000); // Gera um pincode de 6 dígitos
        return String.valueOf(pincode);
    }

    private void sendEmail(String userEmail, String pincode) throws MessagingException {
        String host = "smtp.gmail.com";
        final String user = "julia.vieira61@aluno.ifce.edu.br";
        final String password = "M4r1n4!2010";

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