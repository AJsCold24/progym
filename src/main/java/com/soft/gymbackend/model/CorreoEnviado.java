package com.soft.gymbackend.model;

import java.time.LocalDateTime;

public class CorreoEnviado {
    private Long id;
    private Socio socio;
    private String emailDestino;
    private String asunto;
    private String cuerpo;
    private String estado = "enviado";
    private LocalDateTime fechaEnvio;

    public CorreoEnviado() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Socio getSocio() { return socio; }
    public void setSocio(Socio socio) { this.socio = socio; }
    public String getEmailDestino() { return emailDestino; }
    public void setEmailDestino(String emailDestino) { this.emailDestino = emailDestino; }
    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }
    public String getCuerpo() { return cuerpo; }
    public void setCuerpo(String cuerpo) { this.cuerpo = cuerpo; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDateTime fechaEnvio) { this.fechaEnvio = fechaEnvio; }
}
