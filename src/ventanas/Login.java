package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import clases.VincularConDB;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author luciano
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    String estado, permiso, contrasenia;
    public static String userName;

    public Login() {
        initComponents();
        setSize(400, 550);
        setTitle("Acceso al Sistema");
        setResizable(false);
        setLocationRelativeTo(null);

        ImageIcon wallpaper = new ImageIcon("src/images/MarioBros-World.png");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(labelImagenFondo.getWidth(), labelImagenFondo.getHeight(), Image.SCALE_DEFAULT));
        labelImagenFondo.setIcon(icono);
        this.repaint();

        ImageIcon logo = new ImageIcon("src/images/DS.png");
        Icon logoDS = new ImageIcon(logo.getImage().getScaledInstance(labelLogo.getWidth(), labelLogo.getHeight(), Image.SCALE_DEFAULT));
        labelLogo.setIcon(logoDS);
        this.repaint();
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

        jLabel1 = new javax.swing.JLabel();
        botonAcceder = new javax.swing.JButton();
        txt_user = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        labelLogo = new javax.swing.JLabel();
        labelImagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Creado por Luciano Salgado");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        botonAcceder.setBackground(new java.awt.Color(135, 135, 255));
        botonAcceder.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        botonAcceder.setForeground(new java.awt.Color(255, 255, 255));
        botonAcceder.setText("Acceder");
        botonAcceder.setBorder(null);
        botonAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAccederActionPerformed(evt);
            }
        });

        txt_user.setBackground(new java.awt.Color(153, 153, 255));
        txt_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_user.setForeground(new java.awt.Color(255, 255, 255));
        txt_user.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_userActionPerformed(evt);
            }
        });
        txt_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_userKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_userKeyTyped(evt);
            }
        });

        txt_password.setBackground(new java.awt.Color(153, 153, 255));
        txt_password.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_passwordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_passwordKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(labelImagenFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(botonAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(480, 480, 480)
                .addComponent(jLabel1))
            .addComponent(labelImagenFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(botonAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_userActionPerformed

    private void botonAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAccederActionPerformed
        if (!txt_user.getText().equals("") && !txt_password.getText().equals("")) {
            userName = txt_user.getText().trim();
            contrasenia = txt_password.getText().trim();

            VincularConDB validarInicio = new VincularConDB();
            validarInicio.validarInicioDeSesion(userName, contrasenia, txt_user, txt_password);

            if (validarInicio.existe && validarInicio.estado.equalsIgnoreCase("Activo")) {
                if (validarInicio.permiso.equals("Administrador")) {
                    dispose();
                    new Administrador(userName).setVisible(true);

                } else if (validarInicio.permiso.equals("Capturista")) {
                    dispose();
                    new Capturista().setVisible(true);

                } else if (validarInicio.permiso.equals("Tecnico")) {
                    dispose();
                    new Tecnico().setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El usuario se encuentra Inactivo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }//GEN-LAST:event_botonAccederActionPerformed

    private void txt_userKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_userKeyTyped
        if (txt_user.getText().length() >= 14) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_userKeyTyped

    private void txt_passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyTyped
        if (txt_password.getText().length() >= 14) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_passwordKeyTyped

    private void txt_userKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_userKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_password.requestFocus();
        }
    }//GEN-LAST:event_txt_userKeyReleased

    private void txt_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            botonAcceder.doClick();
        }
    }//GEN-LAST:event_txt_passwordKeyReleased

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAcceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelImagenFondo;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}