package com.soft.gymbackend.controller;

import com.soft.gymbackend.model.Pago;
import com.soft.gymbackend.service.PagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(origins = "*")
public class PagoController {
    private final PagoService pagoService;
    public PagoController(PagoService pagoService) { this.pagoService = pagoService; }

    @GetMapping public List<Pago> listarTodos() { return pagoService.listarTodos(); }
    @GetMapping("/socio/{socioId}") public List<Pago> listarPorSocio(@PathVariable Long socioId) { return pagoService.listarPorSocio(socioId); }
    @PostMapping public ResponseEntity<Pago> crear(@RequestBody Pago pago) { return ResponseEntity.ok(pagoService.guardar(pago)); }
}
