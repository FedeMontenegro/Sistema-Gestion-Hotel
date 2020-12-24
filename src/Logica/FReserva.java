package Logica;

import Datos.VReserva;
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
public class FReserva {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.Conectar();
    private String sSQL = "";
    public int totalRegistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"idReserva", "idHabitacion", "numeroHabitacion", "idCliente", "nombreCliente", "idTrabajador", "nombreTrabajador", "tipoReserva", "fechaReserva", "fechaIngreso", "fechaEgreso", "costoAlojamiento", "estadoReserva"};
        
        String [] registro = new String[13];
        
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        sSQL = "select r.idreserva, r.idhabitacion, h.numero, r.idcliente, "
                + "(select p.nombre from persona p where p.idpersona = r.idcliente) as clienten, "
                + "(select p.apaterno from persona p where p.idpersona = r.idcliente) as clienteAPaterno, "
                + "r.idtrabajador, (select p.nombre from persona p where p.idpersona = r.idtrabajador) as trabajadorn, "
                + "(select p.apaterno from persona p where p.idpersona = r.idtrabajador) as trabajadorAPaterno, "
                + "r.tipo_reserva, r.fecha_reserva, r.fecha_ingreso, r.fecha_salida, "
                + "r.costo_alojamiento, r.estado "
                + "from reserva r inner join habitacion h on r.idhabitacion = h.idhabitacion "
                + "where r.fecha_reserva like '%" + buscar + "%' order by idreserva desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while(rs.next()){
                registro [0] = rs.getString("idreserva");
                registro [1] = rs.getString("idhabitacion");
                registro [2] = rs.getString("numero");
                registro [3] = rs.getString("idcliente");
                registro [4] = rs.getString("clienten") + " " + rs.getString("clienteAPaterno");
                registro [5] = rs.getString("idtrabajador");
                registro [6] = rs.getString("trabajadorn") + " " + rs.getString("trabajadorAPaterno");
                registro [7] = rs.getString("tipo_reserva");
                registro [8] = rs.getString("fecha_reserva");
                registro [9] = rs.getString("fecha_ingreso");
                registro [10] = rs.getString("fecha_salida");
                registro [11] = rs.getString("costo_alojamiento");
                registro [12] = rs.getString("estado");
                
                totalRegistros += 1;
                modelo.addRow(registro);
            }
            return modelo;
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null, "Error en el método Mostrar de la clase FReserva: " + e);
            return null;
        }
    }
    
    public boolean Insertar(VReserva dts){
        sSQL = "insert into reserva(idhabitacion, idcliente, idtrabajador, tipo_reserva, fecha_reserva, fecha_ingreso, fecha_salida, costo_alojamiento, estado)" +
                "values (?, ? ,? ,?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdHabitacion());
            pst.setInt(2, dts.getIdCliente());
            pst.setInt(3, dts.getIdTrabajador());
            pst.setString(4, dts.getTipoDeReserva());
            pst.setDate(5, dts.getFechaReserva());
            pst.setDate(6, dts.getFechaIngreso());
            pst.setDate(7, dts.getFechaEgreso());
            pst.setDouble(8, dts.getCostoAlojamiento());
            pst.setString(9, dts.getEstado());
            
            int n = pst.executeUpdate();
            
            if (n!= 0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al insertar la reserva " + e);
            return false;
        }
    }
    
    public boolean Editar(VReserva dts){
        
        sSQL = "update reserva set idhabitacion = ?, idcliente = ?, idtrabajador = ?, tipo_reserva = ?, fecha_reserva = ?, fecha_ingreso = ?, fecha_salida = ?, costo_alojamiento = ?, estado" +
                " where idreserva = ?";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdHabitacion());
            pst.setInt(2, dts.getIdCliente());
            pst.setInt(3, dts.getIdTrabajador());
            pst.setString(4, dts.getTipoDeReserva());
            pst.setDate(5, dts.getFechaReserva());
            pst.setDate(6, dts.getFechaIngreso());
            pst.setDate(7, dts.getFechaEgreso());
            pst.setDouble(8, dts.getCostoAlojamiento());
            pst.setString(9, dts.getEstado());
            
            pst.setInt(10, dts.getIdReserva());
            
            int n = pst.executeUpdate();
            
            if (n!= 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un error al editar la reserva: " + e);
            return false;
        }
    }
    
    public boolean Eliminar(VReserva dts){
        sSQL = "delete from reserva where idreserva = ?";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdReserva());
            
            int n = pst.executeUpdate();
            
            if (n!= 0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un error en el metodo Eliminar de la clase FReserva: " + e);
            return false;
        }
    }
    
    public boolean Pagar(VReserva dts){
        sSQL = "update reserva set estado = 'Pagada'" +
                " where idreserva = ?";
        try {
            
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdReserva());
            
            int n = pst.executeUpdate();
            
            if (n!= 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un error en el metodo Pagar de la clase FReserva: " + e);
            return false;
        }
    }
}
