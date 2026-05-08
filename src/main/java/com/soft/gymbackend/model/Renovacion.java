package com.soft.gymbackend.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Renovacion {
    private Long id;
    private Socio socio;
    private Membresia membresia;
    private String planAnterior;
    private String planNuevo;
    private LocalDate fechaVencimiento;
    private String observaciones;
    private LocalDateTime createdAt;

    public Renovacion() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Socio getSocio() { return socio; }
    public void setSocio(Socio socio) { this.socio = socio; }
    public Membresia getMembresia() { return membresia; }
    public void setMembresia(Membresia membresia) { this.membresia = membresia; }
    public String getPlanAnterior() { return planAnterior; }
    public void setPlanAnterior(String planAnterior) { this.planAnterior = planAnterior; }
    public String getPlanNuevo() { return planNuevo; }
    public void setPlanNuevo(String planNuevo) { this.planNuevo = planNuevo; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
