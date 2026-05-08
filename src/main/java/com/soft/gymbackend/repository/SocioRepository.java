package com.soft.gymbackend.repository;

import com.soft.gymbackend.model.Socio;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class SocioRepository {
    private final Map<Long, Socio> store = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public List<Socio> findAll() { return new ArrayList<>(store.values()); }
    public List<Socio> findByEstado(String estado) {
        return store.values().stream().filter(s -> estado.equals(s.getEstado())).collect(Collectors.toList());
    }
    public List<Socio> findByNombreContainingIgnoreCase(String nombre) {
        return store.values().stream().filter(s -> s.getNombre().toLowerCase().contains(nombre.toLowerCase())).collect(Collectors.toList());
    }
    public Optional<Socio> findById(Long id) { return Optional.ofNullable(store.get(id)); }
    public boolean existsByDni(String dni) { return store.values().stream().anyMatch(s -> dni.equals(s.getDni())); }
    public Socio save(Socio s) {
        if (s.getId() == null) s.setId(seq.getAndIncrement());
        store.put(s.getId(), s);
        return s;
    }
    public void deleteById(Long id) { store.remove(id); }
}
