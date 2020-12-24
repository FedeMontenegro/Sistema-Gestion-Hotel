/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.VHabitacion;
import Datos.VPago;
import Datos.VReserva;
import Logica.Conexion;
import Logica.FConsumo;
import Logica.FHabitacion;
import Logica.FPago;
import Logica.FReserva;
import java.io.File;
import java.sql.Connection;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Fede
 */
public class FrmPago extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmPago
     */
    public FrmPago() {
        initComponents();
        Mostrar(idReserva);
        Inhabilitar();
        txtIdReserva.setText(idReserva);
        txtCliente.setText(cliente);
        txtIdHabitacion.setText(idHabitacion);
        txtTotalReserva.setText(Double.toString(totalReserva));
        
        FConsumo func = new FConsumo();
        func.mostrar(idReserva);
        
        txtTotalPago.setText(Double.toString(totalReserva + func.totalConsumos));
    }
    
    private String accion = "guardar";
    public static String idReserva;
    public static String cliente;
    public static String idHabitacion;
    public static String habitacion;
    public static Double totalReserva;
    
    void OcultarColumnas(){
        tablaListadoConsumo.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaListadoConsumo.getColumnModel().getColumn(0).setMinWidth(0);
        tablaListadoConsumo.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        
        tablaListadoConsumo.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListadoConsumo.getColumnModel().getColumn(1).setMinWidth(0);
        tablaListadoConsumo.getColumnModel().getColumn(1).setPreferredWidth(0);
        
    }
    
    void OcultarColumnasConsumo(){
        tablaListadoConsumo.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaListadoConsumo.getColumnModel().getColumn(0).setMinWidth(0);
        tablaListadoConsumo.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tablaListadoConsumo.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListadoConsumo.getColumnModel().getColumn(1).setMinWidth(0);
        tablaListadoConsumo.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        tablaListadoConsumo.getColumnModel().getColumn(2).setMaxWidth(0);
        tablaListadoConsumo.getColumnModel().getColumn(2).setMinWidth(0);
        tablaListadoConsumo.getColumnModel().getColumn(2).setPreferredWidth(0);
        
    }
    
    void Inhabilitar(){
        txtIdPago.setVisible(false);
        txtIdReserva.setVisible(false);
        txtCliente.setEnabled(false);
        txtNumComprobante.setEnabled(false);
        cboTipoDeComprobante.setEnabled(false);
        txtIgv.setEnabled(false);
        txtTotalPago.setEnabled(false);
        txtTotalReserva.setEnabled(false);
        dcFechaEmision.setEnabled(false);
        dcFechaPago.setEnabled(false);
        txtIdHabitacion.setVisible(false);
        txtHabitacion.setEnabled(false);
        
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        
        txtIdPago.setText("");
        txtNumComprobante.setText("");
        txtIgv.setText("");
        txtTotalPago.setText("");
        
    }
    
    void Habilitar(){
        txtIdPago.setVisible(false);
        txtIdReserva.setVisible(true);
        txtCliente.setEnabled(true);
        txtNumComprobante.setEnabled(true);
        cboTipoDeComprobante.setEnabled(true);
        txtIgv.setEnabled(true);
        txtTotalPago.setEnabled(true);
        txtTotalReserva.setEnabled(true);
        dcFechaEmision.setEnabled(true);
        dcFechaPago.setEnabled(true);
        txtIdHabitacion.setVisible(true);
        txtHabitacion.setEnabled(true);
        
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);
        
        txtIdPago.setText("");
        txtNumComprobante.setText("");
        txtIgv.setText("");
        //txtTotalPago.setText("");
        
    }
    
    void Mostrar(String mostrar){
        try {
            DefaultTableModel modelo;
            FPago func = new FPago();
            modelo = func.mostrar(mostrar);
            
            tablaListadoPago.setModel(modelo);
            OcultarColumnas();
            lblTotalRegistros.setText("Total Pagos: " + Integer.toString(func.totalRegistros));
            
            //Mostrar datos de los consumos
            
            FConsumo func2 = new FConsumo();
            modelo = func2.mostrar(mostrar);
            tablaListadoConsumo.setModel(modelo);
            OcultarColumnasConsumo();
            
            lblTotalRegistrosConsumo.setText("Total consumos: " + func.totalRegistros);
            lblTotalConsumo.setText("Consumo Total: " + func2.totalConsumos);
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnRegistroDeHabitaciones = new javax.swing.JPanel();
        txtIdPago = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        txtIdReserva = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        txtNumComprobante = new javax.swing.JTextField();
        lblPrecioDiario = new javax.swing.JLabel();
        cboTipoDeComprobante = new javax.swing.JComboBox<>();
        lblEstado = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtCliente = new javax.swing.JTextField();
        txtTotalReserva = new javax.swing.JTextField();
        txtIdHabitacion = new javax.swing.JTextField();
        txtHabitacion = new javax.swing.JTextField();
        lblPrecioDiario1 = new javax.swing.JLabel();
        lblPrecioDiario2 = new javax.swing.JLabel();
        txtIgv = new javax.swing.JTextField();
        lblPrecioDiario3 = new javax.swing.JLabel();
        txtTotalPago = new javax.swing.JTextField();
        lblPrecioDiario4 = new javax.swing.JLabel();
        lblPrecioDiario5 = new javax.swing.JLabel();
        dcFechaPago = new com.toedter.calendar.JDateChooser();
        dcFechaEmision = new com.toedter.calendar.JDateChooser();
        lblHabitacion = new javax.swing.JLabel();
        pnListadoDeHabitaciones = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaListadoConsumo = new javax.swing.JTable();
        lblTotalRegistrosConsumo = new javax.swing.JLabel();
        lblTotalConsumo = new javax.swing.JLabel();
        panelListadoPago = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaListadoPago = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        lblTotalRegistros = new javax.swing.JLabel();
        btnImprimirComprobante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnRegistroDeHabitaciones.setBackground(new java.awt.Color(255, 153, 51));
        pnRegistroDeHabitaciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Pagos"));

        lblNumero.setText("Reserva");

        txtIdReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdReservaActionPerformed(evt);
            }
        });

        lblDescripcion.setText("Total de reserva");

        txtNumComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumComprobanteActionPerformed(evt);
            }
        });

        lblPrecioDiario.setText("Tipo de comprobante");

        cboTipoDeComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boleta", "Factura", "Ticket", "Otro" }));
        cboTipoDeComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoDeComprobanteActionPerformed(evt);
            }
        });

        lblEstado.setText("Habitacion");

        btnNuevo.setBackground(new java.awt.Color(255, 153, 51));
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(255, 153, 51));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 153, 51));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        txtTotalReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalReservaActionPerformed(evt);
            }
        });

        txtIdHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdHabitacionActionPerformed(evt);
            }
        });

        txtHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHabitacionActionPerformed(evt);
            }
        });

        lblPrecioDiario1.setText("Igv");

        lblPrecioDiario2.setText("Total de pago");

        txtIgv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIgvActionPerformed(evt);
            }
        });

        lblPrecioDiario3.setText("Num comprobante");

        txtTotalPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPagoActionPerformed(evt);
            }
        });

        lblPrecioDiario4.setText("Fecha de pago");

        lblPrecioDiario5.setText("Fecha de emision");

        javax.swing.GroupLayout pnRegistroDeHabitacionesLayout = new javax.swing.GroupLayout(pnRegistroDeHabitaciones);
        pnRegistroDeHabitaciones.setLayout(pnRegistroDeHabitacionesLayout);
        pnRegistroDeHabitacionesLayout.setHorizontalGroup(
            pnRegistroDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnRegistroDeHabitacionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtIdPago, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addGroup(pnRegistroDeHabitacionesLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btnNuevo)
                .addGap(55, 55, 55)
                .addComponent(btnGuardar)
                .addGap(55, 55, 55)
                .addComponent(btnCancelar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnRegistroDeHabitacionesLayout.createSequentialGroup()
                .addGroup(pnRegistroDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRegistroDeHabitacionesLayout.createSequentialGroup()
                        .addGroup(pnRegistroDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumero)
                            .addComponent(lblDescripcion)
                            .addComponent(lblEstado))
                        .addGap(27, 27, 27)
                        .addGroup(pnRegistroDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnRegistroDeHabitacionesLayout.createSequentialGroup()
                                .addComponent(txtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnRegistroDeHabitacionesLayout.createSequentialGroup()
                                .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTotalReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnRegistroDeHabitacionesLayout.createSequentialGroup()
                        .addGroup(pnRegistroDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrecioDiario)
                            .addComponent(lblPrecioDiario3)
                            .addComponent(lblPrecioDiario2)
                            .addComponent(lblPrecioDiario1)
                            .addComponent(lblPrecioDiario5)
                            .addComponent(lblPrecioDiario4))
                        .addGap(30, 30, 30)
                        .addGroup(pnRegistroDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTipoDeComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcFechaEmision, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(dcFechaPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnRegistroDeHabitacionesLayout.setVerticalGroup(
            pnRegistroDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRegistroDeHabitacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtIdPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(pnRegistroDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnRegistroDeHabitacionesLayout.createSequentialGroup()
                        .addGroup(pnRegistroDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumero)
                            .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(pnRegistroDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescripcion)
                            .addComponent(txtTotalReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnRegistroDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstado)
                            .addComponent(txtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnRegistroDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrecioDiario)
                            .addComponent(cboTipoDeComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnRegistroDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrecioDiario3)
                            .addComponent(txtNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnRegistroDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIgv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecioDiario1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnRegistroDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecioDiario2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblPrecioDiario5))
                .addGap(18, 18, 18)
                .addGroup(pnRegistroDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcFechaPago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecioDiario4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnRegistroDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar)
                    .addComponent(btnNuevo))
                .addGap(91, 91, 91))
        );

        lblHabitacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHabitacion.setText("Pago");

        pnListadoDeHabitaciones.setBackground(new java.awt.Color(255, 255, 102));
        pnListadoDeHabitaciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Consumos"));
        pnListadoDeHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnListadoDeHabitacionesMouseClicked(evt);
            }
        });

        tablaListadoConsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaListadoConsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaListadoConsumoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaListadoConsumo);

        lblTotalRegistrosConsumo.setText("Registros");

        lblTotalConsumo.setText("Registros");

        javax.swing.GroupLayout pnListadoDeHabitacionesLayout = new javax.swing.GroupLayout(pnListadoDeHabitaciones);
        pnListadoDeHabitaciones.setLayout(pnListadoDeHabitacionesLayout);
        pnListadoDeHabitacionesLayout.setHorizontalGroup(
            pnListadoDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnListadoDeHabitacionesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTotalConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(lblTotalRegistrosConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnListadoDeHabitacionesLayout.setVerticalGroup(
            pnListadoDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnListadoDeHabitacionesLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnListadoDeHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalRegistrosConsumo)
                    .addComponent(lblTotalConsumo)))
        );

        panelListadoPago.setBackground(new java.awt.Color(255, 255, 102));
        panelListadoPago.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Pagos"));
        panelListadoPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelListadoPagoMouseClicked(evt);
            }
        });

        tablaListadoPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaListadoPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaListadoPagoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaListadoPago);

        btnEliminar.setBackground(new java.awt.Color(255, 255, 102));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir1.setBackground(new java.awt.Color(255, 255, 102));
        btnSalir1.setText("Salir");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });

        lblTotalRegistros.setText("Registros");

        btnImprimirComprobante.setText("Imprimir");
        btnImprimirComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirComprobanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelListadoPagoLayout = new javax.swing.GroupLayout(panelListadoPago);
        panelListadoPago.setLayout(panelListadoPagoLayout);
        panelListadoPagoLayout.setHorizontalGroup(
            panelListadoPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListadoPagoLayout.createSequentialGroup()
                .addComponent(btnImprimirComprobante)
                .addGap(383, 383, 383)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir1)
                .addGap(0, 129, Short.MAX_VALUE))
            .addGroup(panelListadoPagoLayout.createSequentialGroup()
                .addComponent(jScrollPane4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelListadoPagoLayout.setVerticalGroup(
            panelListadoPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListadoPagoLayout.createSequentialGroup()
                .addGroup(panelListadoPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(lblTotalRegistros)
                .addGap(54, 54, 54))
            .addGroup(panelListadoPagoLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnImprimirComprobante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHabitacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnRegistroDeHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnListadoDeHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelListadoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblHabitacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnListadoDeHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelListadoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnRegistroDeHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdReservaActionPerformed
        // TODO add your handling code here:
        txtIdReserva.transferFocus();
    }//GEN-LAST:event_txtIdReservaActionPerformed

    private void txtNumComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumComprobanteActionPerformed
        // TODO add your handling code here:
        txtNumComprobante.transferFocus();
    }//GEN-LAST:event_txtNumComprobanteActionPerformed

    private void cboTipoDeComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoDeComprobanteActionPerformed
        // TODO add your handling code here:
        cboTipoDeComprobante.transferFocus();
    }//GEN-LAST:event_cboTipoDeComprobanteActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        Habilitar();
        btnGuardar.setText("Guardar");
        accion = "Guardar";
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtIgv.getText().equals(null)) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar el IGV del comprobante a generar.");
        }
        if (txtTotalPago.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el total de pago del comprobante.");
            txtTotalPago.requestFocus();
            return;
        }
        if (txtNumComprobante.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar un numero de comprobante de pago.");
            txtNumComprobante.requestFocus();
            return;
        }

        VPago dts = new VPago();
        FPago func = new FPago();

        dts.setIdReserva(Integer.parseInt(txtIdReserva.getText()));

        int seleccionado = cboTipoDeComprobante.getSelectedIndex();
        dts.setTipoDeComprobante(cboTipoDeComprobante.getItemAt(seleccionado));
        
        dts.setNumeroDeComprobante(txtNumComprobante.getText());
        dts.setIgv(Double.parseDouble(txtIgv.getText()));
        dts.setTotalPago(Double.parseDouble(txtTotalPago.getText()));
        
        Calendar cal;
        int d, m, a;
        
        cal = dcFechaPago.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        
        dts.setFechaPago(new Date(a,m,d));
        
        cal = dcFechaEmision.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        
        dts.setFechaEmision(new Date(a,m,d));
        
        

        try{
            if (accion.equalsIgnoreCase("Guardar")) {
                if (func.Insertar(dts)) {
                    JOptionPane.showMessageDialog(rootPane, "El pago $" + txtTotalPago.getText() + " del señor " + txtCliente.getText() + " fué realizado satisfactoriamente.");
                    Mostrar(idReserva);
                    Inhabilitar();
                    
                    //Desocupar habitacion
                    
                    FHabitacion func2 = new FHabitacion();
                    VHabitacion dts2 = new VHabitacion();
                    
                    dts2.setIdHabitacion(Integer.parseInt(txtIdHabitacion.getText()));
                    func2.Desocupar(dts2);
                    
                    //Cancelar o pagar la reserva
                    
                    FReserva func3 = new FReserva();
                    VReserva dts3 = new VReserva();
                    
                    dts3.setIdReserva(Integer.parseInt(txtIdReserva.getText()));
                    func3.Pagar(dts3);
                }
            }else if (accion.equalsIgnoreCase("editar")) {
                dts.setIdPago(Integer.parseInt(txtIdPago.getText()));

                if (func.Editar(dts)) {
                    JOptionPane.showMessageDialog(rootPane, "El pago del Sr. "+ txtCliente.getText() + "fué modificado satisfactoriamente.");
                    Mostrar(idReserva);
                    Inhabilitar();

                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Ocurrio un error : " + e);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tablaListadoConsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaListadoConsumoMouseClicked
        // TODO add your handling code here:

      /*  try{
            btnGuardar.setText("Editar");
            Habilitar();
            btnEliminar.setEnabled(true);
            accion = "Editar";

            int fila = tablaListadoConsumo.rowAtPoint(evt.getPoint());

            txtIdPago.setText(tablaListadoConsumo.getValueAt(fila, 0).toString());
            txtIdReserva.setText(tablaListadoConsumo.getValueAt(fila, 1).toString());
            txtDescripcion.setText(tablaListadoConsumo.getValueAt(fila, 2).toString());
            cboTipoDeComprobante.setSelectedItem(tablaListadoConsumo.getValueAt(fila, 3).toString());
            txtNumComprobante.setText(tablaListadoConsumo.getValueAt(fila, 4).toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Ocurrió un error inesperado: " + e);
        }*/
    }//GEN-LAST:event_tablaListadoConsumoMouseClicked

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtTotalReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalReservaActionPerformed

    private void txtIdHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdHabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdHabitacionActionPerformed

    private void txtHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHabitacionActionPerformed

    private void txtIgvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgvActionPerformed

    private void txtTotalPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPagoActionPerformed

    private void tablaListadoPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaListadoPagoMouseClicked
        // TODO add your handling code here:
        try{
            btnGuardar.setText("Editar");
            Habilitar();
            btnEliminar.setEnabled(true);
            accion = "Editar";

            int fila = tablaListadoPago.rowAtPoint(evt.getPoint());

            txtIdPago.setText(tablaListadoPago.getValueAt(fila, 0).toString());
            //txtIdReserva.setText(tablaListado.getValueAt(fila, 1).toString());
            cboTipoDeComprobante.setSelectedItem(tablaListadoPago.getValueAt(fila, 2).toString());
            txtNumComprobante.setText(tablaListadoPago.getValueAt(fila, 3).toString());
            txtIgv.setText(tablaListadoPago.getValueAt(fila, 4).toString());
            txtTotalPago.setText(tablaListadoPago.getValueAt(fila, 5).toString());
            dcFechaEmision.setDate(Date.valueOf(tablaListadoPago.getValueAt(fila, 6).toString()));
            dcFechaPago.setDate(Date.valueOf(tablaListadoPago.getValueAt(fila, 7).toString()));
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Ocurrió un error inesperado: " + e);
        }
        
    }//GEN-LAST:event_tablaListadoPagoMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (!txtIdPago.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar el pago?");
            
            if (confirmacion == 0) {
                FPago func = new FPago();
                VPago dts = new VPago();
                
                dts.setIdPago(Integer.parseInt(txtIdPago.getText()));
                func.Eliminar(dts);
                Mostrar(idReserva);
                Inhabilitar();
            }
            
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void panelListadoPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelListadoPagoMouseClicked
        // TODO add your handling code here:
       /* try{
            btnGuardar.setText("Editar");
            Habilitar();
            btnEliminar.setEnabled(true);
            accion = "Editar";

            int fila = tablaListadoPago.rowAtPoint(evt.getPoint());

            txtIdPago.setText(tablaListadoPago.getValueAt(fila, 0).toString());
            //txtIdReserva.setText(tablaListado.getValueAt(fila, 1).toString());
            cboTipoDeComprobante.setSelectedItem(tablaListadoPago.getValueAt(fila, 2).toString());
            txtNumComprobante.setText(tablaListadoPago.getValueAt(fila, 3).toString());
            txtIgv.setText(tablaListadoPago.getValueAt(fila, 4).toString());
            txtTotalPago.setText(tablaListadoPago.getValueAt(fila, 5).toString());
            dcFechaEmision.setDate(Date.valueOf(tablaListadoPago.getValueAt(fila, 6).toString()));
            dcFechaPago.setDate(Date.valueOf(tablaListadoPago.getValueAt(fila, 7).toString()));
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Ocurrió un error inesperado: " + e);
        }*/
    }//GEN-LAST:event_panelListadoPagoMouseClicked

    private Connection connection = new Conexion().Conectar();
    
    private void pnListadoDeHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnListadoDeHabitacionesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pnListadoDeHabitacionesMouseClicked

    private void btnImprimirComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirComprobanteActionPerformed
        // TODO add your handling code here:
        if (!txtIdPago.getText().equals("")) {
            Map p = new HashMap();
            p.put("idpago", txtIdPago.getText());
            JasperReport report;
            JasperPrint print;

            try {
                report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                        + "/src/Reportes/rptComprobante.jrxml");
                print = JasperFillManager.fillReport(report, p, connection);
                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Comprobante");
                view.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnImprimirComprobanteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimirComprobante;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JComboBox<String> cboTipoDeComprobante;
    private com.toedter.calendar.JDateChooser dcFechaEmision;
    private com.toedter.calendar.JDateChooser dcFechaPago;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblHabitacion;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblPrecioDiario;
    private javax.swing.JLabel lblPrecioDiario1;
    private javax.swing.JLabel lblPrecioDiario2;
    private javax.swing.JLabel lblPrecioDiario3;
    private javax.swing.JLabel lblPrecioDiario4;
    private javax.swing.JLabel lblPrecioDiario5;
    private javax.swing.JLabel lblTotalConsumo;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JLabel lblTotalRegistrosConsumo;
    private javax.swing.JPanel panelListadoPago;
    private javax.swing.JPanel pnListadoDeHabitaciones;
    private javax.swing.JPanel pnRegistroDeHabitaciones;
    private javax.swing.JTable tablaListadoConsumo;
    private javax.swing.JTable tablaListadoPago;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtHabitacion;
    private javax.swing.JTextField txtIdHabitacion;
    private javax.swing.JTextField txtIdPago;
    private javax.swing.JTextField txtIdReserva;
    private javax.swing.JTextField txtIgv;
    private javax.swing.JTextField txtNumComprobante;
    private javax.swing.JTextField txtTotalPago;
    private javax.swing.JTextField txtTotalReserva;
    // End of variables declaration//GEN-END:variables
}
