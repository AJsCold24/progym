package com.soft.gymbackend.service;

import com.soft.gymbackend.model.CorreoEnviado;
import com.soft.gymbackend.model.Membresia;
import com.soft.gymbackend.repository.CorreoEnviadoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CorreoService {
    private final CorreoEnviadoRepository correoRepository;
    private final MembresiaService membresiaService;

    public CorreoService(CorreoEnviadoRepository correoRepository, MembresiaService membresiaService) {
        this.correoRepository = correoRepository; this.membresiaService = membresiaService;
    }

    public List<CorreoEnviado> listarTodos() { return correoRepository.findAllByOrderByFechaEnvioDesc(); }
    public List<CorreoEnviado> listarPorSocio(Long socioId) { return correoRepository.findBySocioId(socioId); }
    public CorreoEnviado guardar(CorreoEnviado correo) {
        correo.setFechaEnvio(LocalDateTime.now());
        return correoRepository.save(correo);
    }
    public List<Membresia> sociosProximosAVencer() { return membresiaService.proximasAVencer(); }
}
