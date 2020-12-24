package Logica;

import Datos.VConsumo;
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
public class FConsumo {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sSQL = "";
    public int totalRegistros;
    public Double totalConsumos;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"idConsumo", "idReserva", "idProducto", "nombreProducto", "cantidadProducto", "precioVenta", "estado"};
        
        String [] registro = new String[7];
        
        totalRegistros = 0;
        totalConsumos = 0.0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select c.idconsumo, c.idreserva, c.idproducto, p.nombre, c.cantidad, c.precio_venta, c.estado " 
                + "from consumo c inner join producto p on c.idproducto = p.idproducto "
                + "where c.idreserva = " + buscar + " order by c.idconsumo desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idconsumo");
                registro [1] = rs.getString("idreserva");
                registro [2] = rs.getString("idproducto");
                registro [3] = rs.getString("nombre");
                registro [4] = rs.getString("cantidad");
                registro [5] = rs.getString("precio_venta");
                registro [6] = rs.getString("estado");
                
                totalRegistros += 1;
                totalConsumos += (rs.getDouble("Cantidad") * rs.getDouble("precio_venta"));
                modelo.addRow(registro);
            }
            return modelo;
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, "Error en el método Mostrar de la clase FConsumo: " + e);
            return null;
        }
    }
    
    public boolean Insertar(VConsumo dts){
        sSQL = "insert into consumo(idreserva, idproducto, cantidad, precio_venta, estado)" +
                "values (?, ? ,? ,?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdReserva());
            pst.setInt(2, dts.getIdProducto());
            pst.setDouble(3, dts.getCantidadProducto());
            pst.setDouble(4, dts.getPrecioVenta());
            pst.setString(5, dts.getEstado());
            
            int n = pst.executeUpdate();
            
            if (n!= 0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al insertar el consumo " + e);
            return false;
        }
    }
    
    public boolean Editar(VConsumo dts){
        
        sSQL = "update consumo set idreserva = ?, idproducto = ?, cantidad = ?, precio_venta = ?, estado = ?" +
                " where idconsumo = ?";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdReserva());
            pst.setInt(2, dts.getIdProducto());
            pst.setDouble(3, dts.getCantidadProducto());
            pst.setDouble(4, dts.getPrecioVenta());
            pst.setString(5, dts.getEstado());
            pst.setInt(6, dts.getIdConsumo());
            
            int n = pst.executeUpdate();
            
            if (n!= 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al editar el consumo: " + e);
            return false;
        }
    }
    
    public boolean Eliminar(VConsumo dts){
        sSQL = "delete from consumo where idconsumo = ?";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdConsumo());
            
            int n = pst.executeUpdate();
            
            if (n!= 0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al eliminar el consumo: " + e);
            return false;
        }
    }
}
