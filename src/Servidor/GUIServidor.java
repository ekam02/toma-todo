/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Interface.InterfaceCliente;
import Interface.InterfaceServidor;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lorena
 */
public class GUIServidor extends javax.swing.JFrame {


    /**
     * Creates new form GUIServidor
     */
    public GUIServidor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbEstadoServidor = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        btnDetener = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor del juego");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inicio del servidor"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbEstadoServidor.setText("Estado: Detenido");
        jPanel1.add(lbEstadoServidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        btnDetener.setText("Detener");
        btnDetener.setEnabled(false);
        btnDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetenerActionPerformed(evt);
            }
        });
        jPanel1.add(btnDetener, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        try {
            // TODO add your handling code here:
            InterfaceServidor intPir = null;
            InterfaceCliente intPirCliente = null;
            RegistrarServidorNombres(intPir, intPirCliente);
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(GUIServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetenerActionPerformed
        
            // TODO add your handling code here:
            
            btnDetener.setEnabled(false);
            btnIniciar.setEnabled(true);
            lbEstadoServidor.setText("Estado: Inactivo");
            System.exit(0);
       
    }//GEN-LAST:event_btnDetenerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GUIServidor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetener;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbEstadoServidor;
    // End of variables declaration//GEN-END:variables

    private void RegistrarServidorNombres(InterfaceServidor intPir, InterfaceCliente intPirCliente) throws RemoteException, MalformedURLException {
        
            
            intPir = (InterfaceServidor) new ImplementacionPirinola(); //Instanciamos el objeto remoto
            //intPirCliente = (InterfaceCliente) new ImplementacionPirinola(); //Instanciamos el objeto remoto
            LocateRegistry.createRegistry(1099); // Creamos e inicializamos el servidor de nombres
            
            Naming.rebind("Chat", intPir); // Registramos el objeto creado en el servidor de nombres
            //Naming.rebind("Chat", intPirCliente); // Registramos el objeto creado en el servidor de nombres

            btnDetener.setEnabled(true);
            btnIniciar.setEnabled(false);
            lbEstadoServidor.setText("Estado: Activo");
        
    }
}
