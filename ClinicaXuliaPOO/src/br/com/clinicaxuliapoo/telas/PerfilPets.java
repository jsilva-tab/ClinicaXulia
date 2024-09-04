package br.com.clinicaxuliapoo.telas;
import br.com.clinicaxuliapoo.dao.PetDAO;
import br.com.clinicaxuliapoo.model.Pet;
import java.sql.*;
import br.com.clinicaxuliapoo.model.ModuloConexao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author J. Silva
 */



public class PerfilPets extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastro
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    
    public PerfilPets() {
        initComponents();
        conexao = ModuloConexao.conector();
        listarPets();
    }
    
    private void voltarMenuCliente(){
        MenuCliente menCli = new MenuCliente();
        menCli.setVisible(true);
        this.dispose();
    }
    
    private void criarPet() {
        String nome_pet,especie,raca,sexo,cpf;
        int idade;
        
        cpf = txtCPF.getText();
        nome_pet = txtNome.getText();
        especie = txtEspecie.getText();
        raca = txtRaca.getText();
        idade = Integer.parseInt(txtIdade.getText());
        sexo = (String) cbxSexo.getSelectedItem();
        
        Pet objPet = new Pet();
        objPet.setIdDono(cpf);
        objPet.setNome_pet(nome_pet);
        objPet.setEspecie(especie);
        objPet.setRaca(raca);
        objPet.setIdade(idade);
        objPet.setSexo(sexo);
        
        PetDAO objPetDAO = new PetDAO();
        objPetDAO.criarPet(objPet);
        
    }

    private void editarPet() {
      int idPet, idade;
      String nome_pet, especie, raca, sexo;
      
      idPet = Integer.parseInt(txtIdPet.getText());
      nome_pet = txtNome.getText();
      especie = txtEspecie.getText();
      raca = txtRaca.getText();
      idade = Integer.parseInt(txtIdade.getText());
      sexo = (String) cbxSexo.getSelectedItem();
      
      Pet objPet = new Pet();
      objPet.setIdPet(idPet);
      objPet.setNome_pet(nome_pet);
      objPet.setEspecie(especie);
      objPet.setRaca(raca);
      objPet.setIdade(idade);
      objPet.setSexo(sexo);
      
      PetDAO objPetDAO = new PetDAO();
      objPetDAO.editarPet(objPet);
    }

    private void excluirPet() {
        int idPet;
        
        idPet = Integer.parseInt(txtIdPet.getText());
        
        Pet objPet = new Pet();
        objPet.setIdPet(idPet);
        
        PetDAO objPetDAO = new PetDAO();
        objPetDAO.excluirPet(objPet);
    }

    private void buscarPets() {
        String sql = "select * from tb_pets where nome_pet like ?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCampoBusca.getText()+"%");
            rs = pst.executeQuery();
            tabelaVisuPets.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    private void listarPets(){
        try {
            PetDAO objPetDAO = new PetDAO();
            
            DefaultTableModel model = (DefaultTableModel) tabelaVisuPets.getModel();
            model.setNumRows(0);
            
            ArrayList<Pet> lista = objPetDAO.pesquisarPets();
            
            for(int num=0; num<lista.size(); num++){
                model.addRow(new Object[]{
                    lista.get(num).getIdPet(),
                    lista.get(num).getIdDono(),
                    lista.get(num).getNome_pet(),
                    lista.get(num).getEspecie(),
                    lista.get(num).getRaca(),
                    lista.get(num).getIdade(),
                    lista.get(num).getSexo()
                });
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void carregarCampos(){
        int setar = tabelaVisuPets.getSelectedRow();
        
        txtIdPet.setText(tabelaVisuPets.getModel().getValueAt(setar, 0).toString());
        txtCPF.setText(tabelaVisuPets.getModel().getValueAt(setar,1).toString());
        txtNome.setText(tabelaVisuPets.getModel().getValueAt(setar,2).toString());
        txtEspecie.setText(tabelaVisuPets.getModel().getValueAt(setar,3).toString());
        txtRaca.setText(tabelaVisuPets.getModel().getValueAt(setar,4).toString());
        txtIdade.setText(tabelaVisuPets.getModel().getValueAt(setar,5).toString());
        cbxSexo.setSelectedItem(tabelaVisuPets.getModel().getValueAt(setar, 6).toString());
    }
    
    private void limparCampos(){
        txtIdPet.setText("");
        txtCPF.setText("");
        txtNome.setText("");
        txtEspecie.setText("");
        txtRaca.setText("");
        txtIdade.setText("");
        cbxSexo.setSelectedItem("");
        txtNome.requestFocus();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        retornarMenu = new javax.swing.JButton();
        botaoCriar = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaVisuPets = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEspecie = new javax.swing.JTextField();
        txtRaca = new javax.swing.JTextField();
        txtIdade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtIdPet = new javax.swing.JFormattedTextField();
        txtCampoBusca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        botaoCarregarCampos = new javax.swing.JButton();
        cbxSexo = new javax.swing.JComboBox<>();
        txtCPF = new javax.swing.JFormattedTextField();
        btnLimparCampos = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perfil Pets");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(880, 610));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 0, 204));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/icons8-pets-50.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        retornarMenu.setBackground(new java.awt.Color(153, 0, 204));
        retornarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/icons8-casa-30.png"))); // NOI18N
        retornarMenu.setToolTipText("Menu");
        retornarMenu.setBorder(null);
        retornarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retornarMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(retornarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(327, 327, 327)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(retornarMenu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        botaoCriar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/icons8-criar-64.png"))); // NOI18N
        botaoCriar.setToolTipText("Criar Novo Pet");
        botaoCriar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarActionPerformed(evt);
            }
        });

        botaoEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/icons8-editar-64.png"))); // NOI18N
        botaoEditar.setToolTipText("Editar Pet");
        botaoEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarActionPerformed(evt);
            }
        });

        botaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/icons8-lixo-64.png"))); // NOI18N
        botaoExcluir.setToolTipText("Excluir Pet");
        botaoExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        tabelaVisuPets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Dono", "Nome", "Especie", "Raça", "Idade", "Sexo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaVisuPets.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabelaVisuPets);
        if (tabelaVisuPets.getColumnModel().getColumnCount() > 0) {
            tabelaVisuPets.getColumnModel().getColumn(0).setPreferredWidth(30);
            tabelaVisuPets.getColumnModel().getColumn(1).setPreferredWidth(120);
            tabelaVisuPets.getColumnModel().getColumn(4).setPreferredWidth(120);
        }

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 26)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 153));
        jLabel9.setText("Dados do Seu Pet");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel4.setText("Nome:");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel5.setText("Espécie:");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel6.setText("Raça:");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel7.setText("Idade:");

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel8.setText("Sexo:");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdadeActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel10.setText("ID Dono:");

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel11.setText("ID:");

        txtIdPet.setEditable(false);

        txtCampoBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCampoBuscaKeyReleased(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/lupa.png"))); // NOI18N

        botaoCarregarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/forma.png"))); // NOI18N
        botaoCarregarCampos.setToolTipText("Preenche os campos de texto");
        botaoCarregarCampos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoCarregarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCarregarCamposActionPerformed(evt);
            }
        });

        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F", "M" }));

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnLimparCampos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/esfregao-de-chao.png"))); // NOI18N
        btnLimparCampos.setText("Limpar Campos");
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(6, 6, 6)
                        .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(6, 6, 6)
                        .addComponent(txtIdPet, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCPF))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(6, 6, 6)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoCriar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoCarregarCampos))
                            .addComponent(btnLimparCampos))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCampoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtCampoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtIdPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoCriar)
                            .addComponent(botaoEditar)
                            .addComponent(botaoExcluir)
                            .addComponent(botaoCarregarCampos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))))
        );

        setSize(new java.awt.Dimension(903, 585));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void retornarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retornarMenuActionPerformed
        voltarMenuCliente();
    }//GEN-LAST:event_retornarMenuActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void botaoCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarActionPerformed
       criarPet();
       listarPets();
       limparCampos();
    }//GEN-LAST:event_botaoCriarActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        editarPet();
        listarPets();
        limparCampos();
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        excluirPet();
        listarPets();
        limparCampos();
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void txtIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdadeActionPerformed

    private void txtCampoBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCampoBuscaKeyReleased
        buscarPets();
    }//GEN-LAST:event_txtCampoBuscaKeyReleased

    private void botaoCarregarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCarregarCamposActionPerformed
        carregarCampos();
    }//GEN-LAST:event_botaoCarregarCamposActionPerformed

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PerfilPets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerfilPets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerfilPets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerfilPets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerfilPets().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCarregarCampos;
    private javax.swing.JButton botaoCriar;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton retornarMenu;
    private javax.swing.JTable tabelaVisuPets;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCampoBusca;
    private javax.swing.JTextField txtEspecie;
    private javax.swing.JFormattedTextField txtIdPet;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRaca;
    // End of variables declaration//GEN-END:variables
}
