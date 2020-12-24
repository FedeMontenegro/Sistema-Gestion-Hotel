package Datos;

import java.sql.Date;
/**
 *
 * @author Fede
 */
public class VReserva {
    private int idReserva;
    private int idHabitacion;
    private int idCliente;
    private int idTrabajador;
    private String tipoDeReserva;
    private Date fechaReserva;
    private Date fechaIngreso;
    private Date fechaEgreso;
    private Double costoAlojamiento;
    private String estado;

    public VReserva() {
    }

    public VReserva(int idReserva, int idHabitacion, int idCliente, int idTrabajador, String tipoDeReserva, Date fechaReserva, Date fechaIngreso, Date fechaEgreso, Double costoAlojamiento, String estado) {
        this.idReserva = idReserva;
        this.idHabitacion = idHabitacion;
        this.idCliente = idCliente;
        this.idTrabajador = idTrabajador;
        this.tipoDeReserva = tipoDeReserva;
        this.fechaReserva = fechaReserva;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.costoAlojamiento = costoAlojamiento;
        this.estado = estado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getTipoDeReserva() {
        return tipoDeReserva;
    }

    public void setTipoDeReserva(String tipoDeReserva) {
        this.tipoDeReserva = tipoDeReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public Double getCostoAlojamiento() {
        return costoAlojamiento;
    }

    public void setCostoAlojamiento(Double costoAlojamiento) {
        this.costoAlojamiento = costoAlojamiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
