package com.soft.gymbackend.controller;

import com.soft.gymbackend.model.Socio;
import com.soft.gymbackend.service.SocioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/socios")
@CrossOrigin(origins = "*")
public class SocioController {
    private final SocioService socioService;
    public SocioController(SocioService socioService) { this.socioService = socioService; }

    @GetMapping public List<Socio> listarTodos() { return socioService.listarTodos(); }
    @GetMapping("/activos") public List<Socio> listarActivos() { return socioService.listarActivos(); }
    @GetMapping("/{id}") public ResponseEntity<Socio> buscarPorId(@PathVariable Long id) { return ResponseEntity.ok(socioService.buscarPorId(id)); }
    @GetMapping("/buscar") public List<Socio> buscarPorNombre(@RequestParam String nombre) { return socioService.buscarPorNombre(nombre); }
    @PostMapping public ResponseEntity<Socio> crear(@RequestBody Socio socio) { return ResponseEntity.ok(socioService.guardar(socio)); }
    @PutMapping("/{id}") public ResponseEntity<Socio> actualizar(@PathVariable Long id, @RequestBody Socio socio) { return ResponseEntity.ok(socioService.actualizar(id, socio)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> eliminar(@PathVariable Long id) { socioService.eliminar(id); return ResponseEntity.noContent().build(); }
}
