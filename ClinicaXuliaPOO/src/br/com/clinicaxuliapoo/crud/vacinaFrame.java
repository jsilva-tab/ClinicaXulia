import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class VacinaFrame extends JFrame {

    private JTextField nomeField;
    private JTextField fabricanteField;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton listButton;
    private JList<String> vacinaList;
    private DefaultListModel<String> listModel;
    private VacinaDAO vacinaDAO;

    public VacinaFrame() {
        vacinaDAO = new VacinaDAO();

        // Configurar o JFrame
        setTitle("Gerenciar Vacinas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar componentes
        nomeField = new JTextField(20);
        fabricanteField = new JTextField(20);
        addButton = new JButton("Adicionar");
        updateButton = new JButton("Atualizar");
        deleteButton = new JButton("Deletar");
        listButton = new JButton("Listar");
        listModel = new DefaultListModel<>();
        vacinaList = new JList<>(listModel);

        // Adicionar componentes ao JFrame
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Fabricante:"));
        panel.add(fabricanteField);
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(listButton);
        panel.add(new JScrollPane(vacinaList));
        add(panel);

        // Adicionar ActionListeners aos botões
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String fabricante = fabricanteField.getText();
                if (!nome.isEmpty() && !fabricante.isEmpty()) {
                    try {
                        vacinaDAO.addVacina(new Vacina(nome, fabricante));
                        updateVacinaList();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao adicionar vacina: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = vacinaList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String nome = nomeField.getText();
                    String fabricante = fabricanteField.getText();
                    if (!nome.isEmpty() && !fabricante.isEmpty()) {
                        try {
                            Vacina vacina = vacinaDAO.getVacinas().get(selectedIndex);
                            vacina.setNome(nome);
                            vacina.setFabricante(fabricante);
                            vacinaDAO.updateVacina(vacina);
                            updateVacinaList();
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Erro ao atualizar vacina: " + ex.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma vacina para atualizar.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = vacinaList.getSelectedIndex();
                if (selectedIndex != -1) {
                    try {
                        Vacina vacina = vacinaDAO.getVacinas().get(selectedIndex);
                        vacinaDAO.deleteVacina(vacina);
                        updateVacinaList();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao deletar vacina: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma vacina para deletar.");
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateVacinaList();
            }
        });

        updateVacinaList();
    }

    private void updateVacinaList() {
        listModel.clear();
        try {
            List<Vacina> vacinas = vacinaDAO.getVacinas();
            for (Vacina vacina : vacinas) {
                listModel.addElement(vacina.getNome() + " - " + vacina.getFabricante());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar vacinas: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VacinaFrame().setVisible(true);
            }
        });
    }
}