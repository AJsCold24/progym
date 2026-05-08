package com.soft.gymbackend.controller;

import com.soft.gymbackend.model.EntradaInventario;
import com.soft.gymbackend.model.SalidaInventario;
import com.soft.gymbackend.service.InventarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventario")
@CrossOrigin(origins = "*")
public class InventarioController {
    private final InventarioService inventarioService;
    public InventarioController(InventarioService inventarioService) { this.inventarioService = inventarioService; }

    @GetMapping("/entradas") public List<EntradaInventario> listarEntradas() { return inventarioService.listarEntradas(); }
    @GetMapping("/salidas") public List<SalidaInventario> listarSalidas() { return inventarioService.listarSalidas(); }
    @PostMapping("/entradas") public ResponseEntity<EntradaInventario> registrarEntrada(@RequestBody EntradaInventario entrada) { return ResponseEntity.ok(inventarioService.registrarEntrada(entrada)); }
    @PostMapping("/salidas") public ResponseEntity<SalidaInventario> registrarSalida(@RequestBody SalidaInventario salida) { return ResponseEntity.ok(inventarioService.registrarSalida(salida)); }
}
