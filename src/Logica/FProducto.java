package Logica;

import Datos.VHabitacion;
import Datos.VProducto;
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
public class FProducto {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sSQL = "";
    public int totalRegistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"idProducto", "nombreProducto", "descripcion", "unidadDeMedida", "precio"};
        
        String [] registro = new String[5];
        
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select * from producto where nombre like '%" + buscar + "%' order by idproducto";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idproducto");
                registro [1] = rs.getString("nombre");
                registro [2] = rs.getString("descripcion");
                registro [3] = rs.getString("unidad_medida");
                registro [4] = rs.getString("precio_venta");
                
                totalRegistros += 1;
                modelo.addRow(registro);
            }
            return modelo;
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al ejecutar la consulta SQL: " + e);
            return null;
        }
    }
    
    public boolean Insertar(VProducto dts){
        sSQL = "insert into producto(nombre, descripcion, unidad_medida, precio_venta)" +
                "values (?, ? ,? ,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getDescripcion());
            pst.setString(3, dts.getUnidadDeMedida());
            pst.setDouble(4, dts.getPrecioVenta());
            
            int n = pst.executeUpdate();
            
            if (n!= 0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al insertar el producto " + e);
            return false;
        }
    }
    
    public boolean Editar(VProducto dts){
        
        sSQL = "update producto set nombre = ?, descripcion = ?, unidad_medida = ?, precio_venta = ?" +
                " where idproducto = ?";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getDescripcion());
            pst.setString(3, dts.getUnidadDeMedida());
            pst.setDouble(4, dts.getPrecioVenta());
            pst.setInt(5, dts.getIdProducto());
            
            int n = pst.executeUpdate();
            
            if (n!= 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al editar el producto: " + e);
            return false;
        }
    }
    
    public boolean Eliminar(VProducto dts){
        sSQL = "delete from producto where idproducto = ?";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdProducto());
            
            int n = pst.executeUpdate();
            
            if (n!= 0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al eliminar el producto: " + e);
            return false;
        }
    }
}
