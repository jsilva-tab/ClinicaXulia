package br.com.clinicaxuliapoo.telas;

import br.com.clinicaxuliapoo.dao.ConsultaDAO;
import br.com.clinicaxuliapoo.dao.ClienteDAO;
import br.com.clinicaxuliapoo.dao.VeterinarioDAO;
import br.com.clinicaxuliapoo.model.Veterinario;
import br.com.clinicaxuliapoo.model.Cliente;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;


public class MarcarConsulta extends javax.swing.JInternalFrame {

    /**
     * Creates new form MarcarConsulta
     */
    
    private ConsultaDAO consultaDAO = new ConsultaDAO();
    
    public MarcarConsulta() {
        super("Marcar Consulta",true,true,false,true);
        initComponents();
        preencherCBX();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnMarcarConsulta = new javax.swing.JButton();
        dcConsulta = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxVets = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxPet = new javax.swing.JComboBox();
        txtHora = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        cbxDonoPet = new javax.swing.JComboBox();

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 204));
        jLabel1.setText("Agendar Consulta");

        btnMarcarConsulta.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        btnMarcarConsulta.setText("Marcar Consulta");
        btnMarcarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcarConsultaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel2.setText("Data:");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel3.setText("Hora:");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel4.setText("Veterinário:");

        cbxVets.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbxVetsAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cbxVets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxVetsActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel6.setText("Pet:");

        cbxPet.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbxPetAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        txtHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel7.setText("Dono:");

        cbxDonoPet.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbxDonoPetAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cbxDonoPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDonoPetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxPet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dcConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbxDonoPet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbxVets, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(btnMarcarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxVets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxDonoPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnMarcarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxVetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxVetsActionPerformed
        
    }//GEN-LAST:event_cbxVetsActionPerformed

    private void cbxVetsAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbxVetsAncestorAdded
   
    }//GEN-LAST:event_cbxVetsAncestorAdded

    private void cbxPetAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbxPetAncestorAdded

    }//GEN-LAST:event_cbxPetAncestorAdded

    private void btnMarcarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcarConsultaActionPerformed
        marcarConsulta();
    }//GEN-LAST:event_btnMarcarConsultaActionPerformed

    private void cbxDonoPetAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbxDonoPetAncestorAdded
    }//GEN-LAST:event_cbxDonoPetAncestorAdded

    private void cbxDonoPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDonoPetActionPerformed
        atualizarComboPets();
    }//GEN-LAST:event_cbxDonoPetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMarcarConsulta;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cbxDonoPet;
    private javax.swing.JComboBox cbxPet;
    private javax.swing.JComboBox cbxVets;
    private com.toedter.calendar.JDateChooser dcConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JFormattedTextField txtHora;
    // End of variables declaration//GEN-END:variables

   private void preencherCBX(){
       try {
           VeterinarioDAO objVetDAO = new VeterinarioDAO();
           List<Veterinario> listaVet = objVetDAO.listarVeterinarios();
           
           for(Veterinario v : listaVet){
               cbxVets.addItem(v);
           }
           
           ClienteDAO objCliDAO = new ClienteDAO();
           List<Cliente> listaCli = objCliDAO.listarClientes();
           
           for(Cliente c : listaCli){
               cbxDonoPet.addItem(c);
           }
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"erro preencher:"+e);
       }
   }
    
   private void atualizarComboPets(){
       Cliente nomeDono = (Cliente) cbxDonoPet.getSelectedItem();
       String nomeDonoConvertido = nomeDono.toString();
       
       try {
           List<String> listaPet = consultaDAO.buscarPetPorNomeDono(nomeDonoConvertido);
           
           cbxPet.removeAllItems();
           
           for(String pet : listaPet){
               cbxPet.addItem(pet);
           }
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"erro atualizar cbxpets:"+e);
       }
   }
   
   private void marcarConsulta(){
    Veterinario nomeVet = (Veterinario) cbxVets.getSelectedItem();
    if (nomeVet == null) {
        JOptionPane.showMessageDialog(this, "Por favor, selecione um veterinário.");
        return;
    }
    String nomeVetConvertido = nomeVet.toString();

    Cliente nomeDono = (Cliente) cbxDonoPet.getSelectedItem();
    if (nomeDono == null) {
        JOptionPane.showMessageDialog(this, "Por favor, selecione o dono do pet.");
        return;
    }
    String nomeDonoConvertido = nomeDono.toString();

    String nomePet = (String) cbxPet.getSelectedItem();
    if (nomePet == null) {
        JOptionPane.showMessageDialog(this, "Por favor, selecione um pet.");
        return;
    }
       
       Date dataSelecionada = dcConsulta.getDate();
       String horaTxt = txtHora.getText();
       
       if (dataSelecionada == null) {
           JOptionPane.showMessageDialog(this,"Por favor, selecione uma data.");
           return;
       }
       
       LocalDate data = new java.sql.Date(dataSelecionada.getTime()).toLocalDate();
       LocalTime hora;
       
       try {
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
           hora = LocalTime.parse(horaTxt,formatter);
       } catch (Exception e) {
           JOptionPane.showMessageDialog(this, "Por favor, insira a hora no formato correto (HH:mm)");
           return;
       }
           
       LocalDateTime dataHora = LocalDateTime.of(data,hora);
       
       try {
           String idVet = consultaDAO.obterIdVetPorNome(nomeVetConvertido);
           String idDono = consultaDAO.obterIdDonoPorNome(nomeDonoConvertido);
           int idPet = consultaDAO.obterIdPetPorNome(nomePet);
           
           boolean sucesso = consultaDAO.agendarConsulta(dataHora, idVet, idDono, idPet);
           
           if (sucesso) {
               JOptionPane.showMessageDialog(this,"Consulta marcada com sucesso!");
           } else {
               JOptionPane.showMessageDialog(this,"Falha ao marcar consulta.");
           }
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"erro agendar consulta jif:"+e);
       }
   }
   
   
}
