package com.soft.gymbackend.controller;

import com.soft.gymbackend.model.Renovacion;
import com.soft.gymbackend.service.RenovacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/renovaciones")
@CrossOrigin(origins = "*")
public class RenovacionController {
    private final RenovacionService renovacionService;
    public RenovacionController(RenovacionService renovacionService) { this.renovacionService = renovacionService; }

    @GetMapping public List<Renovacion> listarTodas() { return renovacionService.listarTodas(); }
    @GetMapping("/socio/{socioId}") public List<Renovacion> listarPorSocio(@PathVariable Long socioId) { return renovacionService.listarPorSocio(socioId); }
    @PostMapping public ResponseEntity<Renovacion> crear(@RequestBody Renovacion renovacion) { return ResponseEntity.ok(renovacionService.guardar(renovacion)); }
}
