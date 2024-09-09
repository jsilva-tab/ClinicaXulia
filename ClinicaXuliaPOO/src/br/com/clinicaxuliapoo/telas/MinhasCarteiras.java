package br.com.clinicaxuliapoo.telas;

import br.com.clinicaxuliapoo.dao.CarteiraDAO;
import br.com.clinicaxuliapoo.model.Carteira;
import br.com.clinicaxuliapoo.model.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MinhasCarteiras extends javax.swing.JInternalFrame {

    /**
     * Creates new form MinhasCarteiras
     */
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    
    public MinhasCarteiras() {
        super("Minhas Carteiras",false,true,true,true);
        initComponents();
        conexao = ModuloConexao.conector();
        listarCarteiras();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        petsPerfil1 = new br.com.clinicaxuliapoo.telas.PetsPerfil();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVisuCarteiras = new javax.swing.JTable();

        petsPerfil1.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 204));
        jLabel1.setText("Minhas Carteiras");

        tabelaVisuCarteiras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID PET", "NOME PET", "VACINA", "DATA APLICAÇÃO"
            }
        ));
        jScrollPane1.setViewportView(tabelaVisuCarteiras);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private br.com.clinicaxuliapoo.telas.PetsPerfil petsPerfil1;
    private javax.swing.JTable tabelaVisuCarteiras;
    // End of variables declaration//GEN-END:variables

    private void listarCarteiras(){
      try{
      CarteiraDAO carteiraDAO = new CarteiraDAO();
          
      DefaultTableModel model = (DefaultTableModel) tabelaVisuCarteiras.getModel();
      model.setNumRows(0);
      
      ArrayList<Carteira> lista = carteiraDAO.pesquisarCarteira();
      
      for(int num=0; num<lista.size(); num++){
           model.addRow(new Object[]{
               lista.get(num).getIdPet(),
               lista.get(num).getNomePet(),
               lista.get(num).getNomeVacina(),
               lista.get(num).getDataAplicacao()
          });
        }
      
      } catch(Exception e){
          JOptionPane.showMessageDialog(null,"erro lista cart jif"+e);
      }
    }
    
}
