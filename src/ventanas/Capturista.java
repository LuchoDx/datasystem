package ventanas;

import clases.Coneccion;
import clases.VincularConDB;
import java.sql.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

/**
 *
 * @author luciano
 */
public class Capturista extends javax.swing.JFrame {
    private String nombreCapturista, nombreUsuario;
    int sesionUsuario;

    /**
     * Creates new form Capturista
     */
    public Capturista() {

        nombreCapturista = Login.userName;
        sesionUsuario = Administrador.sesionUsuario;
//        setSize(550,300);
        setResizable(false);
        initComponents();
        setTitle("Capturista - Sesión de " + nombreCapturista);
        setLocationRelativeTo(null);

        if (sesionUsuario == 1) {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } else {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_DEFAULT));
        labelFondo.setIcon(icono);
        this.repaint();

        try {
            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement("select nombre_usuario from usuarios where username = '" + nombreCapturista + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                //Se guarda en la variable String el resultado obtenido de la consulta especificando de donde sacar el dato
                nombreUsuario = rs.getString("nombre_usuario");
                labelNombreUsuario.setText("Bienvenido " + nombreUsuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener nombre de capturista");
        }
    }
    //Cambiando el icono del JFrameLogin anteriormente editado en
    //propiedades/iconImage/value from existing component/propety/iconImage/ OK
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNombreUsuario = new javax.swing.JLabel();
        botonRegistrarCliente = new javax.swing.JButton();
        botonGestionarClientes = new javax.swing.JButton();
        botonImprimir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        labelNombreUsuario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        labelNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));

        botonRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        botonRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarClienteActionPerformed(evt);
            }
        });

        botonGestionarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informationuser.png"))); // NOI18N
        botonGestionarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGestionarClientesActionPerformed(evt);
            }
        });

        botonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        botonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImprimirActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registrar Cliente\n");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gestionar Clientes");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Imprimir Clientes");

        jLabel7.setForeground(new java.awt.Color(153, 153, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Creado por Luciano Salgado");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(botonRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(botonGestionarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(botonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3)
                .addGap(87, 87, 87)
                .addComponent(jLabel4)
                .addGap(87, 87, 87)
                .addComponent(jLabel5))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(labelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGestionarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(44, 44, 44)
                .addComponent(jLabel7))
            .addComponent(labelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarClienteActionPerformed
        new RegistrarClientes().setVisible(true);
    }//GEN-LAST:event_botonRegistrarClienteActionPerformed
    private void botonGestionarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGestionarClientesActionPerformed
        new GestionarClientes().setVisible(true);
    }//GEN-LAST:event_botonGestionarClientesActionPerformed

    private void botonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimirActionPerformed
          VincularConDB v = new VincularConDB();
        try {
            v.imprimirClientes();
        } catch (IOException ex) {
            Logger.getLogger(Capturista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Capturista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGestionarClientes;
    private javax.swing.JButton botonImprimir;
    private javax.swing.JButton botonRegistrarCliente;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JLabel labelNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
