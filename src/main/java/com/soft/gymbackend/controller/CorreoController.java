package com.soft.gymbackend.controller;

import com.soft.gymbackend.model.CorreoEnviado;
import com.soft.gymbackend.model.Membresia;
import com.soft.gymbackend.service.CorreoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/correos")
@CrossOrigin(origins = "*")
public class CorreoController {
    private final CorreoService correoService;
    public CorreoController(CorreoService correoService) { this.correoService = correoService; }

    @GetMapping public List<CorreoEnviado> listarTodos() { return correoService.listarTodos(); }
    @GetMapping("/socio/{socioId}") public List<CorreoEnviado> listarPorSocio(@PathVariable Long socioId) { return correoService.listarPorSocio(socioId); }
    @GetMapping("/proximos-vencer") public List<Membresia> proximosAVencer() { return correoService.sociosProximosAVencer(); }
    @PostMapping public ResponseEntity<CorreoEnviado> crear(@RequestBody CorreoEnviado correo) { return ResponseEntity.ok(correoService.guardar(correo)); }
}
