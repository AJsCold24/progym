package com.soft.gymbackend.repository;

import com.soft.gymbackend.model.Plan;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class PlanRepository {
    private final Map<Long, Plan> store = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public List<Plan> findAll() { return new ArrayList<>(store.values()); }
    public List<Plan> findByTipo(String tipo) {
        return store.values().stream().filter(p -> tipo.equals(p.getTipo())).collect(Collectors.toList());
    }
    public Optional<Plan> findById(Long id) { return Optional.ofNullable(store.get(id)); }
    public Plan save(Plan p) {
        if (p.getId() == null) p.setId(seq.getAndIncrement());
        store.put(p.getId(), p);
        return p;
    }
    public void deleteById(Long id) { store.remove(id); }
}
