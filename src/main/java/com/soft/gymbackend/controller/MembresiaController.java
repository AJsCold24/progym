package com.soft.gymbackend.controller;

import com.soft.gymbackend.model.Membresia;
import com.soft.gymbackend.service.MembresiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/membresias")
@CrossOrigin(origins = "*")
public class MembresiaController {
    private final MembresiaService membresiaService;
    public MembresiaController(MembresiaService membresiaService) { this.membresiaService = membresiaService; }

    @GetMapping public List<Membresia> listarTodas() { return membresiaService.listarTodas(); }
    @GetMapping("/socio/{socioId}") public List<Membresia> listarPorSocio(@PathVariable Long socioId) { return membresiaService.listarPorSocio(socioId); }
    @GetMapping("/proximas-vencer") public List<Membresia> proximasAVencer() { return membresiaService.proximasAVencer(); }
    @PostMapping public ResponseEntity<Membresia> crear(@RequestBody Membresia membresia) { return ResponseEntity.ok(membresiaService.guardar(membresia)); }
    @PutMapping("/{id}") public ResponseEntity<Membresia> actualizar(@PathVariable Long id, @RequestBody Membresia membresia) { return ResponseEntity.ok(membresiaService.actualizar(id, membresia)); }
}
