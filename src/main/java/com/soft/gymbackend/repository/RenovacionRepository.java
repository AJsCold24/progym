package com.soft.gymbackend.repository;

import com.soft.gymbackend.model.Renovacion;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class RenovacionRepository {
    private final Map<Long, Renovacion> store = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public List<Renovacion> findAllByOrderByCreatedAtDesc() {
        return store.values().stream().sorted(Comparator.comparing(r -> r.getCreatedAt() == null ? java.time.LocalDateTime.MIN : r.getCreatedAt(), Comparator.reverseOrder())).collect(Collectors.toList());
    }
    public List<Renovacion> findBySocioId(Long socioId) {
        return store.values().stream().filter(r -> r.getSocio() != null && socioId.equals(r.getSocio().getId())).collect(Collectors.toList());
    }
    public Optional<Renovacion> findById(Long id) { return Optional.ofNullable(store.get(id)); }
    public Renovacion save(Renovacion r) {
        if (r.getId() == null) r.setId(seq.getAndIncrement());
        store.put(r.getId(), r);
        return r;
    }
}
