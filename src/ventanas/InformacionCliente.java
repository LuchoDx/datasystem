package ventanas;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.*;
import clases.Coneccion;
import clases.VincularConDB;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
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
public class InformacionCliente extends javax.swing.JFrame {

    String user;
    int idClienteUpdate = 0;
    public static int idEquipo = 0;
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form InformacionCliente
     */
    public InformacionCliente() {
        initComponents();
        user = Login.userName;
        idClienteUpdate = GestionarClientes.idClienteUpdate;

        setSize(630, 430);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_DEFAULT));
        labelFondo.setIcon(icono);
        this.repaint();

        try {
            Coneccion cn1 = new Coneccion();
            Connection con1 = cn1.conectar();

            PreparedStatement pst1 = con1.prepareStatement("select * from clientes where id_cliente = '" + idClienteUpdate + "'");
            ResultSet rs1 = pst1.executeQuery();

            if (rs1.next()) {
                setTitle("Informacion del Cliente " + rs1.getString("nombre_cliente") + " - Sesión de " + user);
                laberTitulo.setText("Información del Cliente " + rs1.getString("nombre_cliente"));
                txtNombre.setText(rs1.getString("nombre_cliente"));
                txtGmail.setText(rs1.getString("mail_cliente"));
                txtTelefono.setText(rs1.getString("tel_cliente"));
                txtDireccion.setText(rs1.getString("dir_cliente"));
                txtModificadoPor.setText(rs1.getString("ultima_modificacion"));
            }
            cn1.desconectar();
        } catch (SQLException e) {
            System.err.println("Error en cargar usuario. " + e);
            JOptionPane.showMessageDialog(null, "Error al cargar, contacte al administrador.");
        }
        try {
            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();

            PreparedStatement pst = con.prepareStatement("select id_equipo, tipo_equipo, marca,estatus from equipos where id_cliente = '" + idClienteUpdate + "'");
            ResultSet rs = pst.executeQuery();

            tablaEquipos = new JTable(model);
            jScrollPane1.setViewportView(tablaEquipos);

            model.addColumn("ID Equipo");
            model.addColumn("Tipo de equipo");
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
            System.out.println("Error al intentar llenar la tabla Equipos. " + e);
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla.");
        }
        tablaEquipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Aqui se guarda en una variable la cordenada donde se genera el evento es decir donde se da un click.
                int fila_point = tablaEquipos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idEquipo = (int) model.getValueAt(fila_point, columna_point);
                    new InformacionEquipo().setVisible(true);
                }
            }

            //Hacemos que la tabla no sea editable
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        });
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
        txtNombre = new javax.swing.JTextField();
        txtGmail = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtModificadoPor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEquipos = new javax.swing.JTable();
        botonRegistrar = new javax.swing.JButton();
        botonActualizarCliente = new javax.swing.JButton();
        botonImprimirReporte = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        laberTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        laberTitulo.setForeground(new java.awt.Color(255, 255, 255));
        laberTitulo.setText("Información del Cliente");

        labelNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre.setText("Nombre:");

        labelNombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNombre1.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre1.setText("Gmail:");

        labelNombre2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNombre2.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre2.setText("Télefono:");

        labelNombre3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNombre3.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre3.setText("Dirección:");

        labelNombre4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelNombre4.setForeground(new java.awt.Color(255, 255, 255));
        labelNombre4.setText("Ultima Modificación por:");

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

        txtDireccion.setBackground(new java.awt.Color(153, 153, 255));
        txtDireccion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(255, 255, 255));
        txtDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDireccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        txtModificadoPor.setBackground(new java.awt.Color(153, 153, 255));
        txtModificadoPor.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txtModificadoPor.setForeground(new java.awt.Color(255, 255, 255));
        txtModificadoPor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtModificadoPor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtModificadoPor.setEnabled(false);

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
        jScrollPane1.setViewportView(tablaEquipos);

        botonRegistrar.setBackground(new java.awt.Color(153, 153, 255));
        botonRegistrar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        botonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        botonRegistrar.setText("Registrar Equipo");
        botonRegistrar.setBorder(null);
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

        botonActualizarCliente.setBackground(new java.awt.Color(153, 153, 255));
        botonActualizarCliente.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        botonActualizarCliente.setForeground(new java.awt.Color(255, 255, 255));
        botonActualizarCliente.setText("Actualizar Cliente");
        botonActualizarCliente.setBorder(null);
        botonActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarClienteActionPerformed(evt);
            }
        });

        botonImprimirReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        botonImprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImprimirReporteActionPerformed(evt);
            }
        });

        jLabel1.setText("Creado por Luciano Salgado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(laberTitulo))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelNombre))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombre1)
                    .addComponent(txtGmail, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombre2)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombre4)
                    .addComponent(txtModificadoPor, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonActualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(botonImprimirReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelNombre3))
            .addComponent(labelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(laberTitulo)
                .addGap(11, 11, 11)
                .addComponent(labelNombre)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(labelNombre1)
                        .addGap(5, 5, 5)
                        .addComponent(txtGmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(labelNombre2)
                        .addGap(5, 5, 5)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(labelNombre4)
                        .addGap(5, 5, 5)
                        .addComponent(txtModificadoPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(botonActualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonImprimirReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(labelNombre3))
            .addComponent(labelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtGmail.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyReleased
    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        Color col = new Color(153, 153, 255);
        txtNombre.setBackground(col);

        if (txtNombre.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped
    private void txtGmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGmailKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtTelefono.requestFocus();
        }
    }//GEN-LAST:event_txtGmailKeyReleased
    private void txtGmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGmailKeyTyped
        Color col = new Color(153, 153, 255);
        txtGmail.setBackground(col);

        if (txtGmail.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtGmailKeyTyped
    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtDireccion.requestFocus();
        }
    }//GEN-LAST:event_txtTelefonoKeyReleased
    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        Color col = new Color(153, 153, 255);
        txtTelefono.setBackground(col);

        if (txtTelefono.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped
    private void txtDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyReleased

    }//GEN-LAST:event_txtDireccionKeyReleased
    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        Color col = new Color(153, 153, 255);
        txtDireccion.setBackground(col);

        if (txtDireccion.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        new RegistrarEquipo().setVisible(true);
    }//GEN-LAST:event_botonRegistrarActionPerformed
    private void botonActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarClienteActionPerformed
        int var = 0;
        String nombre = txtNombre.getText().trim();
        String gmail = txtGmail.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String direccion = txtDireccion.getText().trim();

        if (nombre.equals("")) {
            txtNombre.setBackground(Color.red);
            var++;
        }
        if (gmail.equals("")) {
            txtGmail.setBackground(Color.red);
            var++;
        }
        if (telefono.equals("")) {
            txtTelefono.setBackground(Color.red);
            var++;
        }
        if (direccion.equals("")) {
            txtDireccion.setBackground(Color.red);
            var++;
        }
        if (var == 0) {
            VincularConDB v = new VincularConDB();
            v.actualizarCliente(nombre, gmail, telefono, direccion,
                    user, txtNombre, txtGmail, txtTelefono, txtDireccion, this);
        } else {
            JOptionPane.showMessageDialog(null, "No pueden quedar campos en blanco");
        }
    }//GEN-LAST:event_botonActualizarClienteActionPerformed
    private void botonImprimirReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimirReporteActionPerformed
        //Codigo para imprimir un archivo PDF
        //Creamos un objeto de tipo documento.
        Document documento = new Document();
        try {
            //Obtenemos la ruta del escritorio del usuario. ejm: C:\Users\luciano
            String ruta = System.getProperty("user.home");
            //Creamos una instancia indicando la ruta y carpeta donde queremos que se guarde el archivo pdf
            //damos el nombre(en este caso se toma el nombre de un JTextField) que queramos que tenga el archivo e indicamos que sera un archivo .pdf
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + txtNombre.getText().trim() + ".pdf"));

            try {
                //Importamos la clase Image de itextpdf para poder insertar imagenes en el archivo pdf
                //para que no entre en conflicto se llama directamente aqui y no se importa al principio
                //ya que ya esta importada una clase llamada Image perteneciente al JDK
                com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg");
                //Asignamos escala de visualizacion del objeto creado.
                header.scaleToFit(650, 1000);
                //Colocamos al centro el objeto creado. con ayuda de la libreria Chunk
                header.setAlignment(Chunk.ALIGN_CENTER);

                //Creamos objeto de tipo paragrap para determinar que tipo de texto queremos mostrar y el texto en si.
                Paragraph parrafo = new Paragraph();
                //Alineamos el texto en el centro
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                //Agregamos un elemento al objeto parrafo de tipo stringn que va a ser el texto que va a tener.
                parrafo.add("Información del cliente. \n\n");
                //Damos formato al texto. 
                parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

                //generamos el documento agregando los objetos anteriormente credos(la imagen y el texto en este caso)
                documento.open();
                documento.add(header);
                documento.add(parrafo);

                //Creamos una tabla donde se guardaran los datos obtenidos delde el programa o base de datos.
                PdfPTable tablaCliente = new PdfPTable(5);//entre () se especifican la cantidad de columnas
                tablaCliente.addCell("ID");
                tablaCliente.addCell("Nombre Cliente");
                tablaCliente.addCell("Gmail");
                tablaCliente.addCell("Télefono");
                tablaCliente.addCell("Dirección");

                try {
                    Coneccion cn = new Coneccion();
                    Connection con = cn.conectar();
                    String Query = "select * from clientes where id_cliente = '" + idClienteUpdate + "'";

                    PreparedStatement pst = con.prepareStatement(Query);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        do {
                            tablaCliente.addCell(rs.getString(1));
                            tablaCliente.addCell(rs.getString(2));
                            tablaCliente.addCell(rs.getString(3));
                            tablaCliente.addCell(rs.getString(4));
                            tablaCliente.addCell(rs.getString(5));

                        } while (rs.next());
                        documento.add(tablaCliente);
                    }

                    Paragraph parrafo2 = new Paragraph();
                    parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo2.add("\n\n Equipos Registrados. \n\n");
                    parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

                    documento.add(parrafo2);

                    PdfPTable tablaEquipos = new PdfPTable(4);
                    tablaEquipos.addCell("ID Equipo");
                    tablaEquipos.addCell("Tipo");
                    tablaEquipos.addCell("Marca");
                    tablaEquipos.addCell("Estado");

                    try {
                        Coneccion cn2 = new Coneccion();
                        Connection con2 = cn2.conectar();
                        String Query2 = "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '" + idClienteUpdate + "'";
                        PreparedStatement pst2 = con2.prepareStatement(Query2);
                        ResultSet rs2 = pst2.executeQuery();

                        if (rs2.next()) {
                            do {
                                tablaEquipos.addCell(rs2.getString(1));
                                tablaEquipos.addCell(rs2.getString(2));
                                tablaEquipos.addCell(rs2.getString(3));
                                tablaEquipos.addCell(rs2.getString(4));
                            } while (rs2.next());
                            documento.add(tablaEquipos);
                        }

                    } catch (SQLException e) {
                        System.err.println("Error al cargar equipos." + e);
                    }

                } catch (SQLException e) {
                    System.err.println("Error al obtener los datos de clientes." + e);
                }
                documento.close();
                JOptionPane.showMessageDialog(null, "Reporte creado correctamente.");

            } catch (BadElementException e) {
                System.out.println("Error al obtener la imagen para el archivo pdf." + e);
            }
        } catch (DocumentException | IOException e) {
            System.err.println("Error en pdf o ruta de imagen" + e);
            JOptionPane.showMessageDialog(null, "Error al crear PDF.");
        }
    }//GEN-LAST:event_botonImprimirReporteActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InformacionCliente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarCliente;
    private javax.swing.JButton botonImprimirReporte;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelNombre1;
    private javax.swing.JLabel labelNombre2;
    private javax.swing.JLabel labelNombre3;
    private javax.swing.JLabel labelNombre4;
    private javax.swing.JLabel laberTitulo;
    private javax.swing.JTable tablaEquipos;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtGmail;
    private javax.swing.JTextField txtModificadoPor;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
