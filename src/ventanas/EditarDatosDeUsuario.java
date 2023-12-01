package ventanas;

import clases.Coneccion;
import clases.VincularConDB;
import clases.LlenarFormularioConDatosDeUsuario;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import static ventanas.UsuariosRegistrados.idClienteUpdate;

/**
 *
 * @author luciano
 */
public class EditarDatosDeUsuario extends javax.swing.JFrame {

    /**
     * Creates new form EditarDatosDeUsuario
     */
    public String nombreU, nombreUsuarioUpdate;
    int idUserUpdate;

    public EditarDatosDeUsuario() {

        initComponents();
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);
        Login l = new Login();
        nombreU = l.userName;
        idUserUpdate = UsuariosRegistrados.idClienteUpdate;
        setTitle("Administrador - Sesión de " + nombreU);

        LlenarFormularioConDatosDeUsuario llenar = new LlenarFormularioConDatosDeUsuario();

        llenar.LlenarFormulario(laberTitulo, idClienteUpdate, txtNombre, txtGmail, txtTelefono, comboPermisosDe, txtNombreUsuario, comboEstado, txtRegistradoPor);
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_DEFAULT));
        labelFondo.setIcon(icono);
        this.repaint();

        try {
            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement("select nombre_usuario from usuarios where id = '" + idUserUpdate + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                //Se guarda en la variable String el resultado obtenido de la consulta especificando de donde sacar el dato
                nombreUsuarioUpdate = rs.getString("nombre_usuario");
                laberTitulo.setText("Información del Usuario " + nombreUsuarioUpdate);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener nombre de Usuario.");
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

        laberTitulo = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelNombre1 = new javax.swing.JLabel();
        labelNombre2 = new javax.swing.JLabel();
        labelNombre3 = new javax.swing.JLabel();
        labelNombre4 = new javax.swing.JLabel();
        labelNombre5 = new javax.swing.JLabel();
        labelNombre6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtGmail = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtNombreUsuario = new javax.swing.JTextField();
        txtRegistradoPor = new javax.swing.JTextField();
        comboEstado = new javax.swing.JComboBox<>();
        comboPermisosDe = new javax.swing.JComboBox<>();
        botonActualizar = new javax.swing.JButton();
        botonRestaurarContrasenia = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        laberTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        laberTitulo.setForeground(new java.awt.Color(255, 255, 255));
        laberTitulo.setText("Información del Usuario");

        labelNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setText("Nombre:");

        labelNombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNombre1.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre1.setText("Gmail:");

        labelNombre2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNombre2.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre2.setText("Telefono:");

        labelNombre3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNombre3.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre3.setText("Permisos de:");

        labelNombre4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNombre4.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre4.setText("Nombre de Usuario:");

        labelNombre5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNombre5.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre5.setText("Estado:");

        labelNombre6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNombre6.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre6.setText("Registrado Por:");

        txtNombre.setBackground(new java.awt.Color(153, 153, 255));
        txtNombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtGmail.setBackground(new java.awt.Color(153, 153, 255));
        txtGmail.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtGmail.setForeground(new java.awt.Color(255, 255, 255));
        txtGmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtGmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGmailKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGmailKeyTyped(evt);
            }
        });

        txtTelefono.setBackground(new java.awt.Color(153, 153, 255));
        txtTelefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(255, 255, 255));
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtNombreUsuario.setBackground(new java.awt.Color(153, 153, 255));
        txtNombreUsuario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNombreUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreUsuarioKeyTyped(evt);
            }
        });

        txtRegistradoPor.setBackground(new java.awt.Color(153, 153, 255));
        txtRegistradoPor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtRegistradoPor.setForeground(new java.awt.Color(255, 255, 255));
        txtRegistradoPor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegistradoPor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtRegistradoPor.setEnabled(false);

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        comboPermisosDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Capturista", "Tecnico" }));

        botonActualizar.setBackground(new java.awt.Color(153, 153, 255));
        botonActualizar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        botonActualizar.setForeground(new java.awt.Color(255, 255, 255));
        botonActualizar.setText("Actualizar Usuario");
        botonActualizar.setBorder(null);
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        botonRestaurarContrasenia.setBackground(new java.awt.Color(153, 153, 255));
        botonRestaurarContrasenia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        botonRestaurarContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        botonRestaurarContrasenia.setText("Restaurar Contraseña");
        botonRestaurarContrasenia.setBorder(null);
        botonRestaurarContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRestaurarContraseniaActionPerformed(evt);
            }
        });

        jLabel1.setText("Creado por Luciano Salgado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(txtRegistradoPor, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelNombre2))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(comboPermisosDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelNombre3))
            .addGroup(layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelNombre))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelNombre1))
            .addGroup(layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(labelNombre5))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(laberTitulo))
            .addGroup(layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(botonRestaurarContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(labelNombre6))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(380, 380, 380)
                .addComponent(labelNombre4))
            .addComponent(labelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(txtRegistradoPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(labelNombre2))
            .addGroup(layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(comboPermisosDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(labelNombre3))
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(labelNombre))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(labelNombre1))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(labelNombre5))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(laberTitulo))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(botonRestaurarContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(labelNombre6))
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(txtGmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(labelNombre4))
            .addComponent(labelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed

        String nombre = txtNombre.getText().trim();
        String email = txtGmail.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String username = txtNombreUsuario.getText().trim();
        String permiso = comboPermisosDe.getSelectedItem().toString();
        String estatus = comboEstado.getSelectedItem().toString();

        int var = 0;

        if (nombre.equals("")) {
            txtNombre.setBackground(Color.red);
            var++;
        }
        if (email.equals("")) {
            txtGmail.setBackground(Color.red);
            var++;
        }
        if (telefono.equals("")) {
            txtTelefono.setBackground(Color.red);
            var++;
        }
        if (username.equals("")) {
            txtNombreUsuario.setBackground(Color.red);
            var++;
        }

        if (var == 0) {
            VincularConDB au = new VincularConDB();
            au.validarDisponibilidadDeUsername(username, txtNombreUsuario,
                    nombre, email, telefono, permiso, estatus, this);
        } else {

            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtGmail.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyReleased
    private void txtGmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGmailKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtTelefono.requestFocus();
        }
    }//GEN-LAST:event_txtGmailKeyReleased
    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNombreUsuario.requestFocus();
        }
    }//GEN-LAST:event_txtTelefonoKeyReleased
    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        Color col = new Color(153, 153, 255);
        txtTelefono.setBackground(col);

        int key = evt.getKeyChar();
        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }
        if (txtTelefono.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped
    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        Color col = new Color(153, 153, 255);
        txtNombre.setBackground(col);

        if (txtNombre.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped
    private void txtGmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGmailKeyTyped
        Color col = new Color(153, 153, 255);
        txtGmail.setBackground(col);

        if (txtGmail.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGmailKeyTyped
    private void txtNombreUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreUsuarioKeyTyped
        Color col = new Color(153, 153, 255);
        txtNombreUsuario.setBackground(col);

        if (txtNombreUsuario.getText().length() >= 14) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreUsuarioKeyTyped
    private void botonRestaurarContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRestaurarContraseniaActionPerformed
        new CambiarContraseña().setVisible(true);
    }//GEN-LAST:event_botonRestaurarContraseniaActionPerformed

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
            java.util.logging.Logger.getLogger(EditarDatosDeUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarDatosDeUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarDatosDeUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarDatosDeUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EditarDatosDeUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonRestaurarContrasenia;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JComboBox<String> comboPermisosDe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNombre1;
    private javax.swing.JLabel labelNombre2;
    private javax.swing.JLabel labelNombre3;
    private javax.swing.JLabel labelNombre4;
    private javax.swing.JLabel labelNombre5;
    private javax.swing.JLabel labelNombre6;
    private javax.swing.JLabel laberTitulo;
    private javax.swing.JTextField txtGmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtRegistradoPor;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}