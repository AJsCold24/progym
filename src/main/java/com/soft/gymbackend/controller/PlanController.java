package com.soft.gymbackend.controller;

import com.soft.gymbackend.model.Plan;
import com.soft.gymbackend.service.PlanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/planes")
@CrossOrigin(origins = "*")
public class PlanController {
    private final PlanService planService;
    public PlanController(PlanService planService) { this.planService = planService; }

    @GetMapping public List<Plan> listarTodos() { return planService.listarTodos(); }
    @GetMapping("/{id}") public ResponseEntity<Plan> buscarPorId(@PathVariable Long id) { return ResponseEntity.ok(planService.buscarPorId(id)); }
    @PostMapping public ResponseEntity<Plan> crear(@RequestBody Plan plan) { return ResponseEntity.ok(planService.guardar(plan)); }
    @PutMapping("/{id}") public ResponseEntity<Plan> actualizar(@PathVariable Long id, @RequestBody Plan plan) { plan.setId(id); return ResponseEntity.ok(planService.guardar(plan)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> eliminar(@PathVariable Long id) { planService.eliminar(id); return ResponseEntity.noContent().build(); }
}
