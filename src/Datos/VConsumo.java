package Datos;

/**
 *
 * @author Fede
 */
public class VConsumo {
    private int idConsumo;
    private int idReserva;
    private int idProducto;
    private Double CantidadProducto;
    private Double precioVenta;
    private String estado;

    public VConsumo() {
    }

    public VConsumo(int idConsumo, int idReserva, int idProducto, Double CantidadProducto, Double precioVenta, String estado) {
        this.idConsumo = idConsumo;
        this.idReserva = idReserva;
        this.idProducto = idProducto;
        this.CantidadProducto = CantidadProducto;
        this.precioVenta = precioVenta;
        this.estado = estado;
    }

    public int getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(int idConsumo) {
        this.idConsumo = idConsumo;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Double getCantidadProducto() {
        return CantidadProducto;
    }

    public void setCantidadProducto(Double CantidadProducto) {
        this.CantidadProducto = CantidadProducto;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
