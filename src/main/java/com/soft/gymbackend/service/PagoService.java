package com.soft.gymbackend.service;

import com.soft.gymbackend.model.Pago;
import com.soft.gymbackend.repository.PagoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PagoService {
    private final PagoRepository pagoRepository;
    public PagoService(PagoRepository pagoRepository) { this.pagoRepository = pagoRepository; }

    public List<Pago> listarTodos() { return pagoRepository.findAll(); }
    public List<Pago> listarPorSocio(Long socioId) { return pagoRepository.findBySocioId(socioId); }
    public Pago buscarPorId(Long id) { return pagoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pago no encontrado: " + id)); }
    public Pago guardar(Pago pago) {
        pago.setFechaPago(LocalDateTime.now());
        return pagoRepository.save(pago);
    }
}
