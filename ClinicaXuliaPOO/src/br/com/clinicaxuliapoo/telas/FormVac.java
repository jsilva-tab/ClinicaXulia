package br.com.clinicaxuliapoo.telas;

import br.com.clinicaxuliapoo.dao.VacinaDAO;
import br.com.clinicaxuliapoo.model.ModuloConexao;
import br.com.clinicaxuliapoo.model.Vacina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class FormVac extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public FormVac() {
        super("Formulário Vacinas",false,true,false,true);
        initComponents();
        conexao = ModuloConexao.conector();
        listagemVacinas();
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaVisuVacinas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdVac = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLote = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtValidade = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFabricante = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        btnCriar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCarregarCampos = new javax.swing.JButton();
        btnLimparCampos = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtCampoBusca = new javax.swing.JTextField();

        tabelaVisuVacinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID ", "Nome", "Lote", "Validade", "Fabricante", "Descrição", "Criação"
            }
        ));
        jScrollPane2.setViewportView(tabelaVisuVacinas);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 204));
        jLabel1.setText("Vacinas");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        jLabel2.setText("ID:");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        jLabel3.setText("Nome:");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        jLabel4.setText("Lote:");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        jLabel5.setText("Validade:");

        try {
            txtValidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        jLabel6.setText("Fabricante:");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        jLabel7.setText("Descrição:");

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane4.setViewportView(txtDescricao);

        btnCriar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/criar.png"))); // NOI18N
        btnCriar.setToolTipText("Cadastrar");
        btnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/criar (1).png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/excluir.png"))); // NOI18N
        btnExcluir.setToolTipText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCarregarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/prancheta.png"))); // NOI18N
        btnCarregarCampos.setToolTipText("Carregar Campos");
        btnCarregarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarCamposActionPerformed(evt);
            }
        });

        btnLimparCampos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/esfregao-de-chao.png"))); // NOI18N
        btnLimparCampos.setText("Limpar Campos");
        btnLimparCampos.setToolTipText("");
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/lupa.png"))); // NOI18N

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtIdVac, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel7)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCampoBusca)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCriar)
                        .addGap(43, 43, 43)
                        .addComponent(btnEditar)
                        .addGap(46, 46, 46)
                        .addComponent(btnExcluir)
                        .addGap(40, 40, 40)
                        .addComponent(btnCarregarCampos)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimparCampos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdVac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditar)
                            .addComponent(btnCriar)
                            .addComponent(btnExcluir)
                            .addComponent(btnCarregarCampos)))
                    .addComponent(btnLimparCampos))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txtCampoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed
        cadastrarVacina();
        listagemVacinas();
        limparCampos();
    }//GEN-LAST:event_btnCriarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editarVacina();
        listagemVacinas();
        limparCampos();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirVacina();
        listagemVacinas();
        limparCampos();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCarregarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregarCamposActionPerformed
        carregarCampos();
    }//GEN-LAST:event_btnCarregarCamposActionPerformed

    private void txtCampoBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCampoBuscaKeyReleased
        buscarVacina();
    }//GEN-LAST:event_txtCampoBuscaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarregarCampos;
    private javax.swing.JButton btnCriar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tabelaVisuVacinas;
    private javax.swing.JTextField txtCampoBusca;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtFabricante;
    private javax.swing.JTextField txtIdVac;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtValidade;
    // End of variables declaration//GEN-END:variables

    public void listagemVacinas(){
        try {
            VacinaDAO vacDAO = new VacinaDAO();
            DefaultTableModel model = (DefaultTableModel) tabelaVisuVacinas.getModel();
            model.setNumRows(0);
            
            ArrayList<Vacina> lista = vacDAO.listagemVacinas();
            
            for(int num=0; num<lista.size(); num++){
                model.addRow(new Object[]{
                    lista.get(num).getIdVacina(),
                    lista.get(num).getNome_vac(),
                    lista.get(num).getLote(),
                    lista.get(num).getValidade(),
                    lista.get(num).getFabricante(),
                    lista.get(num).getDescricao()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro listagem jif:"+e);
        }
    }
    
    public void buscarVacina(){
        String sql = "select * from tb_vacinas where fabricante like ?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCampoBusca.getText()+"%");
            rs = pst.executeQuery();
            tabelaVisuVacinas.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void editarVacina(){
        Vacina v = new Vacina();
        v.setNome_vac(txtNome.getText());
        v.setLote(txtLote.getText());
        
        try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataValidade = LocalDate.parse(txtValidade.getText(), formatter);
        v.setValidade(dataValidade);
        } catch (DateTimeParseException e) {
        JOptionPane.showMessageDialog(this, "Data de validade inválida.");
        return; 
        }  
        
        v.setFabricante(txtFabricante.getText());
        v.setDescricao(txtDescricao.getText());
        v.setIdVacina(Integer.parseInt((txtIdVac.getText())));
        
        VacinaDAO vDAO = new VacinaDAO();
        
        try {
            vDAO.editarVacina(v);
            JOptionPane.showMessageDialog(null, "Vacina atualizada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro editar vac jif:"+e);
        }
        
    }
    
    public void cadastrarVacina(){
        Vacina v = new Vacina();
        
        v.setNome_vac(txtNome.getText());
        v.setLote(txtLote.getText());
        
        try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataValidade = LocalDate.parse(txtValidade.getText(), formatter);
        v.setValidade(dataValidade);
        } catch (DateTimeParseException e) {
        JOptionPane.showMessageDialog(this, "Data de validade inválida.");
        return; 
        }
        
        v.setFabricante(txtFabricante.getText());
        v.setDescricao(txtDescricao.getText());
        
        VacinaDAO vDAO = new VacinaDAO();
        
        try {
            vDAO.cadastrarVacina(v);
            JOptionPane.showMessageDialog(null,"Vacina cadastrada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro cad vac jif:"+e);
        }
    }
    
    public void excluirVacina(){
        int idVacina = Integer.parseInt(txtIdVac.getText());
        VacinaDAO vDAO = new VacinaDAO();
        
        int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esta vacina?", "Excluir Vacina", JOptionPane.YES_NO_OPTION);
        if (confirmacao == JOptionPane.YES_OPTION) {
            vDAO.excluirVacina(idVacina);
            JOptionPane.showMessageDialog(null, "Vacina excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao excluir vacina.");
        }
    }
    
    public void carregarCampos(){
        int setar = tabelaVisuVacinas.getSelectedRow();
        
        txtIdVac.setText(tabelaVisuVacinas.getModel().getValueAt(setar, 0).toString());
        txtNome.setText(tabelaVisuVacinas.getModel().getValueAt(setar,1).toString());
        txtLote.setText(tabelaVisuVacinas.getModel().getValueAt(setar, 2).toString());
        txtValidade.setText(tabelaVisuVacinas.getModel().getValueAt(setar,3).toString());
        txtFabricante.setText(tabelaVisuVacinas.getModel().getValueAt(setar, 4).toString());
        txtDescricao.setText(tabelaVisuVacinas.getModel().getValueAt(setar,5).toString());
    }
    
    public void limparCampos(){
        txtIdVac.setText("");
        txtNome.setText("");
        txtLote.setText("");
        txtValidade.setText("");
        txtFabricante.setText("");
        txtDescricao.setText("");
    }
}
