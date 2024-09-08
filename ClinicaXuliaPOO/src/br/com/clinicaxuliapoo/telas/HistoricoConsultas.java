package br.com.clinicaxuliapoo.telas;

import br.com.clinicaxuliapoo.dao.ConsultaDAO;
import br.com.clinicaxuliapoo.model.Consulta;
import br.com.clinicaxuliapoo.model.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author J. Silva
 */
public class HistoricoConsultas extends javax.swing.JInternalFrame {

    /**
     * Creates new form HistoricoConsultas
     */
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    ConsultaDAO consultaDAO = new ConsultaDAO();
    private DateTimeFormatter dateTimeFormatter;
            
    public HistoricoConsultas() {
        super("Histórico de Consultas",true,true,true);
        initComponents();
        conexao = ModuloConexao.conector();
        listarConsultas();
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
        tabelaVisuConsultas = new javax.swing.JTable();
        txtCampoBusca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCancelarConsulta = new javax.swing.JButton();

        tabelaVisuConsultas.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        tabelaVisuConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DATA", "VETERINARIO", "DONO PET", "PET", "STATUS"
            }
        ));
        jScrollPane1.setViewportView(tabelaVisuConsultas);

        txtCampoBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCampoBuscaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCampoBuscaKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/clinicaxuliapoo/icones/lupa.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 204));
        jLabel2.setText("Visualizar Consultas");

        btnCancelarConsulta.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        btnCancelarConsulta.setText("Cancelar Consulta");
        btnCancelarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCancelarConsulta)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCampoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCampoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelarConsulta)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarConsultaActionPerformed
       cancelarConsulta();
    }//GEN-LAST:event_btnCancelarConsultaActionPerformed

    private void txtCampoBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCampoBuscaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCampoBuscaKeyPressed

    private void txtCampoBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCampoBuscaKeyReleased
        buscarConsulta();
    }//GEN-LAST:event_txtCampoBuscaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaVisuConsultas;
    private javax.swing.JTextField txtCampoBusca;
    // End of variables declaration//GEN-END:variables

    private void listarConsultas(){
        try {
            DefaultTableModel model = (DefaultTableModel) tabelaVisuConsultas.getModel();
            model.setNumRows(0);
            
            List<Consulta> listaConsulta = consultaDAO.listarConsultas();
            
            for(int num = 0; num<listaConsulta.size();num++){
                model.addRow(new Object[]{
                    listaConsulta.get(num).getIdConsulta(),
                    listaConsulta.get(num).getDataHora(),
                    listaConsulta.get(num).getIdVeterinario(),
                    listaConsulta.get(num).getIdCliente(),
                    listaConsulta.get(num).getIdPet(),
                    listaConsulta.get(num).getStatus()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro listar consultas jif:"+e);
        }
    }
    
    private void buscarConsulta(){
        String sql = "select * from tb_consultas where idConsulta like ?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCampoBusca.getText()+"%");
            rs = pst.executeQuery();
            tabelaVisuConsultas.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro buscar consulta jif"+e);
        }
    }
    
    private void cancelarConsulta(){
        int selectedRow = tabelaVisuConsultas.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tabelaVisuConsultas.getModel();

        
        if(selectedRow != -1){
            int idConsulta = (int) model.getValueAt(selectedRow,0);
            
            try {
                consultaDAO.cancelarConsulta(idConsulta);
                buscarConsulta();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"erro cancel consulta jif:"+e);
            }
        } else{
            JOptionPane.showMessageDialog(this,"Selecione uma consulta para cancelar.");
        }
    }

}
