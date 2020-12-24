package Datos;

/**
 *
 * @author Fede
 */
public class VCliente extends VPersona {
    private String codigoCliente;

    public VCliente() {
    }

    public VCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
            
    
}
