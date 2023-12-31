package ventanas;

import java.sql.*;
import clases.Coneccion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luciano
 */
public class GestionarEquipos extends javax.swing.JFrame {

    String user;
    public static int idEquipoUpdate = 0;

    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form GestionarClientes
     */
    public GestionarEquipos() {
        initComponents();
        user = Login.userName;

        setSize(630, 330);
        setResizable(false);
        setTitle("Tecnico - Sesión de " + user);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_DEFAULT));
        labelFondo.setIcon(icono);
        this.repaint();

        try {
            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();

            PreparedStatement pst = con.prepareStatement("select id_equipo, tipo_equipo,marca,estatus  from equipos");
            ResultSet rs = pst.executeQuery();

            tablaEquipos = new JTable(model);
            jScrollPaneEquipos.setViewportView(tablaEquipos);

            model.addColumn("Id");
            model.addColumn("Tipo");
            model.addColumn("Marca");
            model.addColumn("Estado");

            while (rs.next()) {
                //Crear vector de tipo OBJETO
                Object[] fila = new Object[4];
                //Guardar en el vector los valores encontrados en la consulta a la base de datos.
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al intentar llenar la tabla Equipos." + e);
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla.");
        }
        ObtenerDatosTabla();

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
        jScrollPaneEquipos = new javax.swing.JScrollPane();
        tablaEquipos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox<>();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Equipos registrados");

        tablaEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneEquipos.setViewportView(tablaEquipos);

        jLabel2.setText("Creado por Luciano Salgado");

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo Ingreso", "No reparado", "En revisión", "Reparado", "Entregado" }));
        comboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addGap(490, 490, 490)
                .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPaneEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(labelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jScrollPaneEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(labelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEstadoActionPerformed
        String seleccion = comboEstado.getSelectedItem().toString();
        model.setRowCount(0);
        model.setColumnCount(0);
        String Query = "";

        try {
            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            if (seleccion.equals("Todos")) {
                Query = "select id_equipo, tipo_equipo,marca,estatus  from equipos";

            } else {
                Query = "select id_equipo, tipo_equipo,marca,estatus  from equipos where estatus= '" + seleccion + "'";
            }
            PreparedStatement pst = con.prepareStatement(Query);
            ResultSet rs = pst.executeQuery();
            tablaEquipos = new JTable(model);
            jScrollPaneEquipos.setViewportView(tablaEquipos);

            model.addColumn("Id");
            model.addColumn("Tipo");
            model.addColumn("Marca");
            model.addColumn("Estado");
            while (rs.next()) {
                //Crear vector de tipo OBJETO
                Object[] fila = new Object[4];
                //Guardar en el vector los valores encontrados en la consulta a la base de datos.
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al recuperar datos de Equipos." + e);
            JOptionPane.showMessageDialog(null, "Error al recuperar datos de equipos");
        }
        ObtenerDatosTabla();
    }//GEN-LAST:event_comboEstadoActionPerformed

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
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionarEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPaneEquipos;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JTable tablaEquipos;
    // End of variables declaration//GEN-END:variables

    public void ObtenerDatosTabla() {
        tablaEquipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Aqui se guarda en una variable la cordenada donde se genera el evento es decir donde se da un click.
                int fila_point = tablaEquipos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idEquipoUpdate = (int) model.getValueAt(fila_point, columna_point);
                   new InformacionEquipoTecnico().setVisible(true);
                }
            }

            //Hacemos que la tabla no sea editable
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        });
    }

}
