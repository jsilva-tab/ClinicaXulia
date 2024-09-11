import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class VeterinarioFrame extends JFrame {

    private JTextField nomeField;
    private JTextField especialidadeField;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton listButton;
    private JList<String> veterinarioList;
    private DefaultListModel<String> listModel;
    private VeterinarioDAO veterinarioDAO;

    public VeterinarioFrame() {
        veterinarioDAO = new VeterinarioDAO();

        // Configurar o JFrame
        setTitle("Gerenciar Veterinários");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar componentes
        nomeField = new JTextField(20);
        especialidadeField = new JTextField(20);
        addButton = new JButton("Adicionar");
        updateButton = new JButton("Atualizar");
        deleteButton = new JButton("Deletar");
        listButton = new JButton("Listar");
        listModel = new DefaultListModel<>();
        veterinarioList = new JList<>(listModel);

        // Adicionar componentes ao JFrame
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Especialidade:"));
        panel.add(especialidadeField);
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(listButton);
        panel.add(new JScrollPane(veterinarioList));
        add(panel);

        // Adicionar ActionListeners aos botões
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String especialidade = especialidadeField.getText();
                if (!nome.isEmpty() && !especialidade.isEmpty()) {
                    try {
                        veterinarioDAO.addVeterinario(new Veterinario(nome, especialidade));
                        updateVeterinarioList();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao adicionar veterinário: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = veterinarioList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String nome = nomeField.getText();
                    String especialidade = especialidadeField.getText();
                    if (!nome.isEmpty() && !especialidade.isEmpty()) {
                        try {
                            Veterinario veterinario = veterinarioDAO.getVeterinarios().get(selectedIndex);
                            veterinario.setNome(nome);
                            veterinario.setEspecialidade(especialidade);
                            veterinarioDAO.updateVeterinario(veterinario);
                            updateVeterinarioList();
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Erro ao atualizar veterinário: " + ex.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um veterinário para atualizar.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = veterinarioList.getSelectedIndex();
                if (selectedIndex != -1) {
                    try {
                        Veterinario veterinario = veterinarioDAO.getVeterinarios().get(selectedIndex);
                        veterinarioDAO.deleteVeterinario(veterinario);
                        updateVeterinarioList();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao deletar veterinário: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um veterinário para deletar.");
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateVeterinarioList();
            }
        });

        updateVeterinarioList();
    }

    private void updateVeterinarioList() {
        listModel.clear();
        try {
            List<Veterinario> veterinarios = veterinarioDAO.getVeterinarios();
            for (Veterinario veterinario : veterinarios) {
                listModel.addElement(veterinario.getNome() + " - " + veterinario.getEspecialidade());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar veterinários: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VeterinarioFrame().setVisible(true);
            }
        });
    }
}