package clases;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ventanas.UsuariosRegistrados;
import ventanas.GestionarClientes;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author luciano
 */
public class VincularConDB {

    public int id, idClienteUpdate;
    public String nombre, email, telefono, username, contrasenia, permiso, estado, registradoPor, direccion, nombreDelCapturista;
    public boolean existe = false;

    public VincularConDB() {
        UsuariosRegistrados ur = new UsuariosRegistrados();
        this.id = ur.idClienteUpdate;
        idClienteUpdate = GestionarClientes.idClienteUpdate;
    }

    public void agregarIntegrante(String nombreU, String emailU, String telefonoU, String usernameU,
            String contraseniaU, String permisoU, String estatusU, String registradopor, JTextField txtUsername,
            JTextField txtNombre, JTextField txtEmail, JTextField txtTelefono, JTextField txtPassword,
            JComboBox comboPermisos, JComboBox comboEstatus, JFrame frame) {

        UsuariosRegistrados ur = new UsuariosRegistrados();
        this.id = ur.idClienteUpdate;
        this.nombre = nombreU;
        this.email = emailU;
        this.telefono = telefonoU;
        this.username = usernameU;
        this.contrasenia = contraseniaU;
        this.permiso = permisoU;
        this.estado = estatusU;
        this.registradoPor = registradopor;

        try {
            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement("select username from usuarios where username = '" + username + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtUsername.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible.");
                cn.desconectar();
            } else {
                String Query = "insert into usuarios (nombre_usuario, email, telefono, username, password, tipo_nivel, estatus, registrado_por) values(?,?,?,?,?,?,?,?)";

                Coneccion cn2 = new Coneccion();
                Connection con2 = cn2.conectar();
                PreparedStatement pst2 = con2.prepareStatement(Query);

                pst2.setString(1, nombre);
                pst2.setString(2, email);
                pst2.setString(3, telefono);
                pst2.setString(4, username);
                pst2.setString(5, contrasenia);
                pst2.setString(6, permiso);
                pst2.setString(7, estado);
                pst2.setString(8, registradoPor);

                pst2.executeUpdate();
                System.out.println("Nuevo usuario registrado con éxito.");

                txtNombre.setBackground(Color.GREEN);
                txtEmail.setBackground(Color.GREEN);
                txtTelefono.setBackground(Color.GREEN);
                txtUsername.setBackground(Color.GREEN);
                txtPassword.setBackground(Color.GREEN);
                txtNombre.setText("");
                txtEmail.setText("");
                txtTelefono.setText("");
                txtUsername.setText("");
                txtPassword.setText("");
                comboPermisos.setSelectedIndex(0);
                comboEstatus.setSelectedIndex(0);

                JOptionPane.showMessageDialog(null, "Un nuevo usuario a sido registrado.");
                cn2.desconectar();
                frame.dispose();
            }
        } catch (SQLException ex) {
            System.out.println("Error al intentar agregar un nuevo usuario." + ex);
            JOptionPane.showMessageDialog(null, "Error al registrar nuevo usuario.");
            Logger.getLogger(VincularConDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarContrasenia(String contraseniaU, JTextField txtContrasenia, JTextField txtConfirmContrasenia) {
        this.contrasenia = contraseniaU;
        try {
            String Query = "update usuarios set password = '" + contrasenia + "' where id_usuario = " + id;

            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement(Query);

            pst.executeUpdate();

            System.out.println("la Contraseña a cambiado con éxito.");
            cn.desconectar();
            txtContrasenia.setBackground(Color.GREEN);
            txtConfirmContrasenia.setBackground(Color.GREEN);
            JOptionPane.showMessageDialog(null, "Contraseña Actualizada");
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error al intentar cambiar la contraseña.");
            JOptionPane.showMessageDialog(null, "Error al intentar cabiar la contraseña.");
        }
    }

    public void agregarCliente(String nombreC, String gmailC, String telefonoC, String direccionC,
            String nombreDelCapturista1, JTextField txtNombre, JTextField txtGmail, JTextField txtTelefono,
            JTextField txtDireccion, JFrame frame) {
        this.nombre = nombreC;
        this.email = gmailC;
        this.telefono = telefonoC;
        this.direccion = direccionC;
        this.nombreDelCapturista = nombreDelCapturista1;
        try {
            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement("insert into clientes"
                    + "(nombre_cliente,mail_cliente,tel_cliente,dir_cliente,ultima_modificacion) values(?,?,?,?,?)");

            pst.setString(1, nombre);
            pst.setString(2, email);
            pst.setString(3, telefono);
            pst.setString(4, direccion);
            pst.setString(5, nombreDelCapturista);

            pst.executeUpdate();
            System.out.println("Cliente registrado con éxito.");

            txtNombre.setText("");
            txtGmail.setText("");
            txtTelefono.setText("");
            txtDireccion.setText("");
            txtNombre.setBackground(Color.GREEN);
            txtGmail.setBackground(Color.GREEN);
            txtTelefono.setBackground(Color.GREEN);
            txtTelefono.setBackground(Color.GREEN);
            txtDireccion.setBackground(Color.GREEN);
            cn.desconectar();

            JOptionPane.showMessageDialog(null, "Cliente registrado éxitosamente.");
            frame.dispose();

        } catch (SQLException e) {
            System.out.println("Error al registrar nuevo cliente." + e);
            JOptionPane.showMessageDialog(null, "Error al intentar cargar los datos del nuevo cliente.");
        }
    }

    public void actualizarCliente(String nombreC, String gmailC, String telefonoC, String direccionC,
            String nombreDelCapturista1, JTextField txtNombre, JTextField txtGmail, JTextField txtTelefono,
            JTextField txtDireccion, JFrame frame) {
        this.nombre = nombreC;
        this.email = gmailC;
        this.telefono = telefonoC;
        this.direccion = direccionC;
        this.nombreDelCapturista = nombreDelCapturista1;
        try {
            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement("update clientes set nombre_cliente=?,mail_cliente=?,tel_cliente=?,dir_cliente=?,ultima_modificacion=? where id_cliente = '" + idClienteUpdate + "'");

            pst.setString(1, nombre);
            pst.setString(2, email);
            pst.setString(3, telefono);
            pst.setString(4, direccion);
            pst.setString(5, nombreDelCapturista);

            pst.executeUpdate();
            System.out.println("Cliente Actualizado con éxito.");

            txtNombre.setText("");
            txtGmail.setText("");
            txtTelefono.setText("");
            txtDireccion.setText("");
            txtNombre.setBackground(Color.GREEN);
            txtGmail.setBackground(Color.GREEN);
            txtTelefono.setBackground(Color.GREEN);
            txtTelefono.setBackground(Color.GREEN);
            txtDireccion.setBackground(Color.GREEN);
            cn.desconectar();

            JOptionPane.showMessageDialog(null, "El cliente a sido actualizado éxitosamente.");
            frame.dispose();

        } catch (SQLException e) {
            System.out.println("Error al actualizar nuevo cliente." + e);
            JOptionPane.showMessageDialog(null, "Error al intentar actualizar los datos del nuevo cliente.");
        }
    }

    public void validarInicioDeSesion(String nombreU, String contraseniaU, JTextField txtNombreU, JTextField txtContraseniaU) {
        this.nombre = nombreU;
        this.contrasenia = contraseniaU;
        try {
            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement(""
                    + "select tipo_nivel, estatus from usuarios where username = '" + nombre + "' and password = '" + contrasenia + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                permiso = rs.getString("tipo_nivel");
                estado = rs.getString("estatus");
                existe = true;
            } else {
                JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos.");
                txtNombreU.setText("");
                txtContraseniaU.setText("");
                existe = false;
            }
            cn.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al registrar nuevo cliente." + e);
            JOptionPane.showMessageDialog(null, "Error al intentar cargar los datos del nuevo cliente.");
        }
    }

    public void validarDisponibilidadDeUsername(String usernameU, JTextField txtUsername, String nombreU,
            String emailU, String telefonoU, String permisoU, String estatusU, JFrame frame) {
        this.username = usernameU;
        this.nombre = nombreU;
        this.email = emailU;
        this.telefono = telefonoU;
        this.permiso = permisoU;
        this.estado = estatusU;
        try {
            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement("select username from usuarios where username = '" + username + "' and not id_usuario = '" + id + "'");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtUsername.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible.");
                cn.desconectar();
            } else {

                String Query = "update usuarios set nombre_usuario =?, email =?, telefono =?, username =?, tipo_nivel =?,  estatus =? where id_usuario = '" + id + "'";

                Coneccion cn2 = new Coneccion();
                Connection con2 = cn2.conectar();
                PreparedStatement pst2 = con2.prepareStatement(Query);

                pst2.setString(1, nombre);
                pst2.setString(2, email);
                pst2.setString(3, telefono);
                pst2.setString(4, username);
                pst2.setString(5, permiso);
                pst2.setString(6, estado);
                pst2.executeUpdate();
                cn2.desconectar();

                System.out.println("Se han actualizado los datos de un usuario.");
                JOptionPane.showMessageDialog(null, "Usuario Actualizado con exito.");

                frame.dispose();
                new UsuariosRegistrados().setVisible(true);
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar actualizar los datos de usuario.");
            System.out.println("Error al intentar actualizar los datos del usuario." + ex);
            Logger.getLogger(VincularConDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void registrarEquipo(String tipo_equipo, String marca, String modelo, String num_serie,
            String dia_ingreso, String mes_ingreso, String annio_ingreso, String observaciones,
            String estadoEquipo, String ultima_modificacion) {
        try {
            String Query = "insert into equipos (id_cliente, tipo_equipo,marca,modelo,num_serie,dia_ingreso,"
                    + "mes_ingreso, annio_ingreso,observaciones,estatus,ultima_modificacion) values(?,?,?,?,?,?,?,?,?,?,?)";

            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement(Query);

            pst.setInt(1, idClienteUpdate);
            pst.setString(2, tipo_equipo);
            pst.setString(3, marca);
            pst.setString(4, modelo);
            pst.setString(5, num_serie);
            pst.setString(6, dia_ingreso);
            pst.setString(7, mes_ingreso);
            pst.setString(8, annio_ingreso);
            pst.setString(9, observaciones);
            pst.setString(10, estadoEquipo);
            pst.setString(11, ultima_modificacion);
            pst.executeUpdate();

            System.out.println("Nuevo equipo Registrado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al intentar registrar equipo." + e);
            JOptionPane.showMessageDialog(null, "Error al intentar registrar equipo.");
        }
    }

    public void imprimirClientes() throws IOException {

        Document documento = new Document();
        

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Lista de Clientes.pdf"));
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
            parrafo.add("Clientes registrados. \n\n");
            //Damos formato al texto. 
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));

            //generamos el documento agregando los objetos anteriormente credos(la imagen y el texto en este caso)
            documento.open();
            documento.add(header);
            documento.add(parrafo);

            //Creamos una tabla donde se guardaran los datos obtenidos delde el programa o base de datos.
            PdfPTable tablaCliente = new PdfPTable(5);//entre () se especifican la cantidad de columnas
            tablaCliente.addCell("ID");
            tablaCliente.addCell("Nombre");
            tablaCliente.addCell("Gmail");
            tablaCliente.addCell("Télefono");
            tablaCliente.addCell("Dirección");

            try {
                Coneccion cn = new Coneccion();
                Connection con = cn.conectar();
                String Query = "select * from clientes";

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
                documento.close();
                JOptionPane.showMessageDialog(null, "Lista de clientes impresa.");
            } catch (SQLException e) {
                System.err.println("Error al obtener los datos de clientes." + e);
            }
            

        } catch (DocumentException | FileNotFoundException e) {
            System.err.println("Error en pdf o ruta de imagen" + e);
            JOptionPane.showMessageDialog(null, "Error al crear PDF.");
        }
    }
}