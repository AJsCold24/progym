package com.soft.gymbackend.repository;

import com.soft.gymbackend.model.Pago;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class PagoRepository {
    private final Map<Long, Pago> store = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public List<Pago> findAll() { return new ArrayList<>(store.values()); }
    public List<Pago> findBySocioId(Long socioId) {
        return store.values().stream().filter(p -> p.getSocio() != null && socioId.equals(p.getSocio().getId())).collect(Collectors.toList());
    }
    public Optional<Pago> findById(Long id) { return Optional.ofNullable(store.get(id)); }
    public Pago save(Pago p) {
        if (p.getId() == null) p.setId(seq.getAndIncrement());
        store.put(p.getId(), p);
        return p;
    }
}
