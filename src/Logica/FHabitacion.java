package Logica;

import Datos.VHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fede
 */
public class FHabitacion {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sSQL = "";
    public int totalRegistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"idhabitacion", "numero", "piso", "descripcion", "caracteristicas", "precio", "estado", "tipo_de_habitacion"};
        
        String [] registro = new String[8];
        
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select * from habitacion where piso like '%" + buscar + "%' order by idHabitacion";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idHabitacion");
                registro [1] = rs.getString("numero");
                registro [2] = rs.getString("piso");
                registro [3] = rs.getString("descripcion");
                registro [4] = rs.getString("caracteristicas");
                registro [5] = rs.getString("precio_diario");
                registro [6] = rs.getString("estado");
                registro [7] = rs.getString("tipo_habitacion");
                
                totalRegistros = 1;
                modelo.addRow(registro);
            }
            return modelo;
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al ejecutar consulta SQL: " + e);
            return null;
        }
    }
    
    public boolean Insertar(VHabitacion dts){
        sSQL = "insert into habitacion(numero, piso, descripcion, caracteristicas, precio_diario, estado, tipo_habitacion)" +
                "values (?, ? ,? ,? ,?, ?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNumero());
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getDescripcion());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecio_diario());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipo_habitacion());
            
            int n = pst.executeUpdate();
            
            if (n!= 0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al insertar la habitación: " + e);
            return false;
        }
    }
    
    public boolean Editar(VHabitacion dts){
        sSQL = "update habitacion set numero = ?, piso = ?, descripcion = ?, caracteristicas = ?, precio_diario = ?, estado = ?, tipo_habitacion = ?" +
                " where idHabitacion = ?";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNumero());
            pst.setString(2, dts.getPiso());
            pst.setString(3, dts.getDescripcion());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPrecio_diario());
            pst.setString(6, dts.getEstado());
            pst.setString(7, dts.getTipo_habitacion());
            pst.setInt(8, dts.getIdHabitacion());
            
            int n = pst.executeUpdate();
            
            if (n!= 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al editar la habitación: " + e);
            return false;
        }
    }
    
    public boolean Eliminar(VHabitacion dts){
        sSQL = "delete from habitacion where idHabitacion = ?";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(7, dts.getIdHabitacion());
            
            int n = pst.executeUpdate();
            
            if (n!= 0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al eliminar la habitación: " + e);
            return false;
        }
    }
    
    public DefaultTableModel MostrarVista(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"idhabitacion", "numero", "piso", "descripcion", "caracteristicas", "precio", "estado", "tipo_de_habitacion"};
        
        String [] registro = new String[8];
        
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select * from habitacion where piso like '%" + buscar + "%' and estado = 'Disponible' order by idHabitacion";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idHabitacion");
                registro [1] = rs.getString("numero");
                registro [2] = rs.getString("piso");
                registro [3] = rs.getString("descripcion");
                registro [4] = rs.getString("caracteristicas");
                registro [5] = rs.getString("precio_diario");
                registro [6] = rs.getString("estado");
                registro [7] = rs.getString("tipo_habitacion");
                
                totalRegistros += 1;
                modelo.addRow(registro);
            }
            return modelo;
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al ejecutar consulta SQL: " + e);
            return null;
        }
    }
    
    public boolean Desocupar(VHabitacion dts){
        sSQL = "update habitacion set estado = 'Disponible'" +
                " where idHabitacion = ?";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdHabitacion());
            
            int n = pst.executeUpdate();
            
            if (n!= 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al editar la habitación: " + e);
            return false;
        }
    }
    
    public boolean Ocupar(VHabitacion dts){
        sSQL = "update habitacion set estado = 'Ocupado'" +
                " where idHabitacion = ?";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdHabitacion());
            
            int n = pst.executeUpdate();
            
            if (n!= 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al editar la habitación: " + e);
            return false;
        }
    }
}
