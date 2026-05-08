package com.soft.gymbackend.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Membresia {
    private Long id;
    private Socio socio;
    private Plan plan;
    private LocalDate fechaInicio;
    private LocalDate fechaVencimiento;
    private String estado = "activo";
    private LocalDateTime createdAt;

    public Membresia() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Socio getSocio() { return socio; }
    public void setSocio(Socio socio) { this.socio = socio; }
    public Plan getPlan() { return plan; }
    public void setPlan(Plan plan) { this.plan = plan; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
