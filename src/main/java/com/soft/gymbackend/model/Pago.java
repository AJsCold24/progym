package com.soft.gymbackend.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pago {
    private Long id;
    private Socio socio;
    private Membresia membresia;
    private BigDecimal monto;
    private String metodoPago;
    private String concepto;
    private String estado = "completado";
    private LocalDateTime fechaPago;

    public Pago() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Socio getSocio() { return socio; }
    public void setSocio(Socio socio) { this.socio = socio; }
    public Membresia getMembresia() { return membresia; }
    public void setMembresia(Membresia membresia) { this.membresia = membresia; }
    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }
    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
    public String getConcepto() { return concepto; }
    public void setConcepto(String concepto) { this.concepto = concepto; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDateTime getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDateTime fechaPago) { this.fechaPago = fechaPago; }
}
