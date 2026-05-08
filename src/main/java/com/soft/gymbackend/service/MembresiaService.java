package com.soft.gymbackend.service;

import com.soft.gymbackend.model.Membresia;
import com.soft.gymbackend.repository.MembresiaRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MembresiaService {
    private final MembresiaRepository membresiaRepository;
    public MembresiaService(MembresiaRepository membresiaRepository) { this.membresiaRepository = membresiaRepository; }

    public List<Membresia> listarTodas() { return membresiaRepository.findAll(); }
    public List<Membresia> listarPorSocio(Long socioId) { return membresiaRepository.findBySocioId(socioId); }
    public List<Membresia> proximasAVencer() {
        LocalDate hoy = LocalDate.now();
        return membresiaRepository.findProximasAVencer(hoy, hoy.plusDays(7));
    }
    public Membresia buscarPorId(Long id) { return membresiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Membresía no encontrada: " + id)); }
    public Membresia guardar(Membresia membresia) {
        membresia.setCreatedAt(LocalDateTime.now());
        return membresiaRepository.save(membresia);
    }
    public Membresia actualizar(Long id, Membresia datos) {
        Membresia m = buscarPorId(id);
        m.setEstado(datos.getEstado()); m.setFechaVencimiento(datos.getFechaVencimiento());
        return membresiaRepository.save(m);
    }
}
