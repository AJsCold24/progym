package com.soft.gymbackend.service;

import com.soft.gymbackend.model.Socio;
import com.soft.gymbackend.repository.SocioRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SocioService {
    private final SocioRepository socioRepository;
    public SocioService(SocioRepository socioRepository) { this.socioRepository = socioRepository; }

    public List<Socio> listarTodos() { return socioRepository.findAll(); }
    public List<Socio> listarActivos() { return socioRepository.findByEstado("activo"); }
    public List<Socio> buscarPorNombre(String nombre) { return socioRepository.findByNombreContainingIgnoreCase(nombre); }
    public Socio buscarPorId(Long id) { return socioRepository.findById(id).orElseThrow(() -> new RuntimeException("Socio no encontrado: " + id)); }
    public Socio guardar(Socio socio) {
        if (socioRepository.existsByDni(socio.getDni())) throw new RuntimeException("Ya existe un socio con DNI: " + socio.getDni());
        socio.setCreatedAt(LocalDateTime.now());
        if (socio.getFechaInscripcion() == null) socio.setFechaInscripcion(LocalDate.now());
        return socioRepository.save(socio);
    }
    public Socio actualizar(Long id, Socio datos) {
        Socio socio = buscarPorId(id);
        socio.setNombre(datos.getNombre()); socio.setApellido(datos.getApellido());
        socio.setTelefono(datos.getTelefono()); socio.setEmail(datos.getEmail()); socio.setEstado(datos.getEstado());
        return socioRepository.save(socio);
    }
    public void eliminar(Long id) { socioRepository.deleteById(id); }
}
