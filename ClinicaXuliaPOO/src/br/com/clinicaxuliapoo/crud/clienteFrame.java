import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ClienteFrame extends JFrame {
    private JTextField nomeField;
    private JTextField emailField;
    private JTextField telefoneField;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton listButton;
    private JList<String> clienteList;
    private DefaultListModel<String> listModel;
    private ClienteDAO clienteDAO;

    public ClienteFrame() {
        clienteDAO = new ClienteDAO();

        // Configurar o JFrame
        setTitle("Gerenciar Clientes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar componentes
        nomeField = new JTextField(20);
        emailField = new JTextField(20);
        telefoneField = new JTextField(20);
        addButton = new JButton("Adicionar");
        updateButton = new JButton("Atualizar");
        deleteButton = new JButton("Deletar");
        listButton = new JButton("Listar");
        listModel = new DefaultListModel<>();
        clienteList = new JList<>(listModel);

        // Adicionar componentes ao JFrame
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Telefone:"));
        panel.add(telefoneField);
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(listButton);
        panel.add(new JScrollPane(clienteList));
        add(panel);

        // Adicionar ActionListeners aos botões
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String email = emailField.getText();
                String telefone = telefoneField.getText();
                if (!nome.isEmpty() && !email.isEmpty() && !telefone.isEmpty()) {
                    try {
                        clienteDAO.addCliente(new Cliente(nome, email, telefone));
                        updateClienteList();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao adicionar cliente: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = clienteList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String nome = nomeField.getText();
                    String email = emailField.getText();
                    String telefone = telefoneField.getText();
                    if (!nome.isEmpty() && !email.isEmpty() && !telefone.isEmpty()) {
                        try {
                            Cliente cliente = clienteDAO.getClientes().get(selectedIndex);
                            cliente.setNome(nome);
                            cliente.setEmail(email);
                            cliente.setTelefone(telefone);
                            clienteDAO.updateCliente(cliente);
                            updateClienteList();
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente: " + ex.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um cliente para atualizar.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = clienteList.getSelectedIndex();
                if (selectedIndex != -1) {
                    try {
                        Cliente cliente = clienteDAO.getClientes().get(selectedIndex);
                        clienteDAO.deleteCliente(cliente);
                        updateClienteList();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao deletar cliente: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um cliente para deletar.");
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateClienteList();
            }
        });

        updateClienteList();
    }

    private void updateClienteList() {
        listModel.clear();
        try {
            List<Cliente> clientes = clienteDAO.getClientes();
            for (Cliente cliente : clientes) {
                listModel.addElement(cliente.getNome() + " - " + cliente.getEmail() + " - " + cliente.getTelefone());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClienteFrame().setVisible(true);
            }
        });
    }
}