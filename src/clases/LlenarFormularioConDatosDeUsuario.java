package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author luciano
 */
public class LlenarFormularioConDatosDeUsuario {

    int id;

    public void LlenarFormulario(JLabel laberTitulo, int idU, JTextField nombre, JTextField gmail, JTextField telefono, JComboBox permisos, JTextField nombreDeUsuario, JComboBox estado, JTextField registradoPor) {
        this.id = idU;
        try {
            Coneccion cn = new Coneccion();
            Connection con = cn.conectar();
            PreparedStatement pst = con.prepareStatement("select nombre_usuario, email, telefono, tipo_nivel,username , estatus, registrado_por from usuarios where id_usuario = " + id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                nombre.setText(rs.getString(1));
                gmail.setText(rs.getString(2));
                telefono.setText(rs.getString(3));

                if (rs.getString(4).equals("Administrador")) {
                    permisos.setSelectedIndex(0);
                } else if (rs.getString(4).equals("Capturista")) {
                    permisos.setSelectedIndex(1);
                } else if (rs.getString(4).equals("Tecnico")) {
                    permisos.setSelectedIndex(2);
                }
                nombreDeUsuario.setText(rs.getString(5));
                laberTitulo.setText("Información del Usuario " + rs.getString(5));

                if (rs.getString(6).equals("Activo")) {
                    estado.setSelectedIndex(0);
                } else if (rs.getString(6).equals("Inactivo")) {
                    estado.setSelectedIndex(1);
                }
                registradoPor.setText(rs.getString(7));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos del usuario " + ex);
        }
    }
}