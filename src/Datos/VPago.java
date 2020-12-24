package Datos;

import java.sql.Date;

/**
 *
 * @author Fede
 */
public class VPago {
    private int idPago;
    private int idReserva;
    private String tipoDeComprobante;
    private String numeroDeComprobante;
    private Double igv;
    private Double totalPago;
    private Date fechaEmision;
    private Date fechaPago;

    public VPago() {
    }

    public VPago(int idPago, int idReserva, String tipoDeComprobante, String numeroDeComprobante, Double igv, Double totalPago, Date fechaEmision, Date fechaPago) {
        this.idPago = idPago;
        this.idReserva = idReserva;
        this.tipoDeComprobante = tipoDeComprobante;
        this.numeroDeComprobante = numeroDeComprobante;
        this.igv = igv;
        this.totalPago = totalPago;
        this.fechaEmision = fechaEmision;
        this.fechaPago = fechaPago;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getTipoDeComprobante() {
        return tipoDeComprobante;
    }

    public void setTipoDeComprobante(String tipoDeComprobante) {
        this.tipoDeComprobante = tipoDeComprobante;
    }

    public String getNumeroDeComprobante() {
        return numeroDeComprobante;
    }

    public void setNumeroDeComprobante(String numeroDeComprobante) {
        this.numeroDeComprobante = numeroDeComprobante;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(Double totalPago) {
        this.totalPago = totalPago;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    
}
