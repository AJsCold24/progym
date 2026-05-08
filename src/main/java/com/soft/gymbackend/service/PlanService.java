package com.soft.gymbackend.service;

import com.soft.gymbackend.model.Plan;
import com.soft.gymbackend.repository.PlanRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlanService {
    private final PlanRepository planRepository;
    public PlanService(PlanRepository planRepository) { this.planRepository = planRepository; }

    public List<Plan> listarTodos() { return planRepository.findAll(); }
    public List<Plan> listarPorTipo(String tipo) { return planRepository.findByTipo(tipo); }
    public Plan buscarPorId(Long id) { return planRepository.findById(id).orElseThrow(() -> new RuntimeException("Plan no encontrado: " + id)); }
    public Plan guardar(Plan plan) { return planRepository.save(plan); }
    public void eliminar(Long id) { planRepository.deleteById(id); }
}
