package com.soft.gymbackend.dto;

public class LoginResponse {
    private String mensaje;
    private String rol;
    public LoginResponse(String mensaje, String rol) { this.mensaje = mensaje; this.rol = rol; }
    public String getMensaje() { return mensaje; }
    public String getRol() { return rol; }
}
