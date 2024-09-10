import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordResetFrame extends JFrame {

    private JTextField emailField;
    private JButton resetButton;
    private PasswordResetService passwordResetService;

    public PasswordResetFrame() {
        passwordResetService = new PasswordResetService();

        // Configurar o JFrame
        setTitle("Esquecer Senha");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar componentes
        emailField = new JTextField(20);
        resetButton = new JButton("Esquecer Senha");

        // Adicionar componentes ao JFrame
        JPanel panel = new JPanel();
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(resetButton);
        add(panel);

        // Adicionar ActionListener ao botão
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                if (email != null && !email.isEmpty()) {
                    passwordResetService.sendPasswordResetEmail(email);
                    JOptionPane.showMessageDialog(null, "Email de redefinição de senha enviado.");
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um email válido.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PasswordResetFrame().setVisible(true);
            }
        });
    }
}

/* Considerações Finais
Validação de Entrada: Certifique-se de validar a entrada do usuário para garantir que um e-mail válido seja fornecido.
Tratamento de Exceções: Adicione tratamento de exceções apropriado para lidar com possíveis erros durante o envio do e-mail e a conexão com o banco de dados.
Segurança: Mova as credenciais do banco de dados e do e-mail para variáveis de ambiente ou um arquivo de configuração seguro.
Depois de seguir esses passos, você terá uma interface gráfica funcional para a funcionalidade de "esquecer senha" usando JFrame e JButton. */