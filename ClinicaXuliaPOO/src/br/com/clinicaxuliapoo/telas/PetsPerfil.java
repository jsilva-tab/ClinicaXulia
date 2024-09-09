package br.com.clinicaxuliapoo.telas;

import br.com.clinicaxuliapoo.dao.PetDAO;
import br.com.clinicaxuliapoo.model.Pet;
import java.sql.*;
import br.com.clinicaxuliapoo.model.ModuloConexao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class PetsPerfil extends javax.swing.JInternalFrame {

    /**
     * Creates new form PetsPerfil
     */
    
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public PetsPerfil() {
        super("Editar Pets",false,true,true,true);
        initComponents();
        conexao = ModuloConexao.conector();
        listarPets();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaVisuPets = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnCriarPet = new javax.swing.JButton();
        btnEditarPet = new javax.swing.JButton();
        btnExcluirPet = new javax.swing.JButton();
        btnPreencherCampos = new javax.swing.JButton();
        btnLimparCampos = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbxSexo = new javax.swing.JComboBox<>();
        txtCPF = new javax.swing.JFormattedTextField();
        txtIdPet = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEspecie = new javax.swing.JTextField();
        txtRaca = new javax.swing.JTextField();
        txtIdade = new javax.swing.JTextField();
        txtCampoBusca = new javax.swing.JTextField();

        setTitle("Perfil Pets");

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tabelaVisuPets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CPF", "NOME", "ESPÉCIE", "RAÇA", "IDADE", "SEXO"
            }
        ));
        jScrollPane4.setViewportView(tabelaVisuPets);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 204));
        jLabel1.setText("Dados do seu Pet");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel2.setText("Idade:");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel3.setText("Raça:");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel4.setText("Espécie:");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel5.setText("Nome:");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel6.setText("CPF:");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel7.setText("ID:");

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel8.setText("Sexo:");

        btnCriarPet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/criar.png"))); // NOI18N
        btnCriarPet.setToolTipText("Criar um novo Pet");
        btnCriarPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarPetActionPerformed(evt);
            }
        });

        btnEditarPet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/criar (1).png"))); // NOI18N
        btnEditarPet.setToolTipText("Edite seu Pet");
        btnEditarPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPetActionPerformed(evt);
            }
        });

        btnExcluirPet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/excluir.png"))); // NOI18N
        btnExcluirPet.setToolTipText("Excluir Pet");
        btnExcluirPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirPetActionPerformed(evt);
            }
        });

        btnPreencherCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/prancheta.png"))); // NOI18N
        btnPreencherCampos.setToolTipText("Preencher campos com dados do Pet");
        btnPreencherCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreencherCamposActionPerformed(evt);
            }
        });

        btnLimparCampos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/esfregao-de-chao.png"))); // NOI18N
        btnLimparCampos.setText("Limpar Campos");
        btnLimparCampos.setToolTipText("Limpe todos os campos de texto");
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/lupa.png"))); // NOI18N

        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F", "M" }));

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtIdPet.setEditable(false);

        txtCampoBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCampoBuscaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCampoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtIdPet, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(btnCriarPet, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(36, 36, 36)
                                            .addComponent(btnEditarPet, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(32, 32, 32)
                                            .addComponent(btnExcluirPet, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnPreencherCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIdPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparCampos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditarPet, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCriarPet, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirPet, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPreencherCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txtCampoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCriarPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarPetActionPerformed
        criarPet();
        listarPets();
        limparCampos();
    }//GEN-LAST:event_btnCriarPetActionPerformed

    private void btnPreencherCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreencherCamposActionPerformed
        carregarCampos();
    }//GEN-LAST:event_btnPreencherCamposActionPerformed

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void btnEditarPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPetActionPerformed
        editarPet();
        listarPets();
        limparCampos();
    }//GEN-LAST:event_btnEditarPetActionPerformed

    private void btnExcluirPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirPetActionPerformed
        excluirPet();
        listarPets();
        limparCampos();
    }//GEN-LAST:event_btnExcluirPetActionPerformed

    private void txtCampoBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCampoBuscaKeyReleased
        buscarPets();
    }//GEN-LAST:event_txtCampoBuscaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriarPet;
    private javax.swing.JButton btnEditarPet;
    private javax.swing.JButton btnExcluirPet;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JButton btnPreencherCampos;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tabelaVisuPets;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCampoBusca;
    private javax.swing.JTextField txtEspecie;
    private javax.swing.JTextField txtIdPet;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRaca;
    // End of variables declaration//GEN-END:variables
 
    
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

    
}
