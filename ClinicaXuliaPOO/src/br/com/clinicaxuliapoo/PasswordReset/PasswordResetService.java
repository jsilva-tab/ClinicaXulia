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
            EmailSender emailSender = new EmailSender();
            emailSender.sendEmail(userEmail,"Password Reset","Your pin code is:"+pincode);
        }
    }

    private String generatePincode() {
        Random random = new Random();
        int pincode = 100000 + random.nextInt(900000); // Gera um pincode de 6 dígitos
        return String.valueOf(pincode);
    }

    public class EmailSender {

    private final String host = "smtp.gmail.com";
    private final int port = 587;
    private final String username = "julia.vieira61@aluno.ifce.edu.br";
    private final String password = "M4r1n4!2010";

    public void sendEmail(String to, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", String.valueOf(port));
        props.put("mail.smtp.ssl.enable", "false");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("Email sent successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

    public static void main(String[] args) {
        PasswordResetService service = new PasswordResetService(); // Instancia o serviço
        EmailSender emailSender = service.new EmailSender(); // Cria instância da classe interna
        emailSender.sendEmail("jsv2367@gmail.com", "Test Subject", "This is a test email.");
    }
    
}