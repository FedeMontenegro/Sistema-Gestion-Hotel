package Logica;

import Datos.VPago;
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
public class FPago {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sSQL = "";
    public int totalRegistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"idPago", "idReserva", "tipoDeComprobante", "numeroDeComprobante", "igv", "total", "fechaEmision", "fechaPago"};
        
        String [] registro = new String[8];
        
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select * from pago where idreserva = " + buscar + " order by idpago";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idpago");
                registro [1] = rs.getString("idreserva");
                registro [2] = rs.getString("tipo_comprobante");
                registro [3] = rs.getString("num_comprobante");
                registro [4] = rs.getString("igv");
                registro [5] = rs.getString("total_pago");
                registro [6] = rs.getString("fecha_emision");
                registro [7] = rs.getString("fecha_pago");
                
                totalRegistros += 1;
                modelo.addRow(registro);
            }
            return modelo;
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, "Ocurrió un error en el método Mostrar de la clase FPago: " + e);
            return null;
        }
    }
    
    public boolean Insertar(VPago dts){
        sSQL = "insert into pago(idreserva, tipo_comprobante, num_comprobante, igv, total_pago, fecha_emision, fecha_pago)" +
                "values (?, ? ,? ,?, ?, ?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdReserva());
            pst.setString(2, dts.getTipoDeComprobante());
            pst.setString(3, dts.getNumeroDeComprobante());
            pst.setDouble(4, dts.getIgv());
            pst.setDouble(5, dts.getTotalPago());
            pst.setDate(6, dts.getFechaEmision());
            pst.setDate(7, dts.getFechaPago());
            
            int n = pst.executeUpdate();
            
            if (n!= 0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al insertar el pago " + e);
            return false;
        }
    }
    
    public boolean Editar(VPago dts){
        
        sSQL = "update pago set idreserva = ?, tipo_comprobante = ?, igv = ?, total_pago = ?, fecha_emision = ?, fecha_pago = ? " +
                " where idpago = ?";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdReserva());
            pst.setString(2, dts.getTipoDeComprobante());
            pst.setString(3, dts.getNumeroDeComprobante());
            pst.setDouble(4, dts.getIgv());
            pst.setDouble(5, dts.getTotalPago());
            pst.setDate(6, dts.getFechaEmision());
            pst.setDate(7, dts.getFechaPago());
            pst.setInt(8, dts.getIdPago());
            
            int n = pst.executeUpdate();
            
            if (n!= 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al editar el pago: " + e);
            return false;
        }
    }
    
    public boolean Eliminar(VPago dts){
        sSQL = "delete from pago where idpago = ?";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdPago());
            
            int n = pst.executeUpdate();
            
            if (n!= 0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al eliminar el pago: " + e);
            return false;
        }
    }
}
