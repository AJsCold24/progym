package com.soft.gymbackend.repository;

import com.soft.gymbackend.model.Membresia;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class MembresiaRepository {
    private final Map<Long, Membresia> store = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public List<Membresia> findAll() { return new ArrayList<>(store.values()); }
    public List<Membresia> findBySocioId(Long socioId) {
        return store.values().stream().filter(m -> m.getSocio() != null && socioId.equals(m.getSocio().getId())).collect(Collectors.toList());
    }
    public List<Membresia> findProximasAVencer(LocalDate hoy, LocalDate limite) {
        return store.values().stream().filter(m -> m.getFechaVencimiento() != null &&
            !m.getFechaVencimiento().isBefore(hoy) && !m.getFechaVencimiento().isAfter(limite)).collect(Collectors.toList());
    }
    public Optional<Membresia> findById(Long id) { return Optional.ofNullable(store.get(id)); }
    public Membresia save(Membresia m) {
        if (m.getId() == null) m.setId(seq.getAndIncrement());
        store.put(m.getId(), m);
        return m;
    }
}
