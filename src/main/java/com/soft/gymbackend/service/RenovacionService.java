package com.soft.gymbackend.service;

import com.soft.gymbackend.model.Renovacion;
import com.soft.gymbackend.repository.RenovacionRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RenovacionService {
    private final RenovacionRepository renovacionRepository;
    public RenovacionService(RenovacionRepository renovacionRepository) { this.renovacionRepository = renovacionRepository; }

    public List<Renovacion> listarTodas() { return renovacionRepository.findAllByOrderByCreatedAtDesc(); }
    public List<Renovacion> listarPorSocio(Long socioId) { return renovacionRepository.findBySocioId(socioId); }
    public Renovacion guardar(Renovacion renovacion) {
        renovacion.setCreatedAt(LocalDateTime.now());
        return renovacionRepository.save(renovacion);
    }
}
