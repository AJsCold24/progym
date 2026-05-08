package com.soft.gymbackend.repository;

import com.soft.gymbackend.model.Producto;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ProductoRepository {
    private final Map<Long, Producto> store = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public List<Producto> findAll() { return new ArrayList<>(store.values()); }
    public List<Producto> findByStockActualLessThanEqual(int limit) {
        return store.values().stream().filter(p -> p.getStockActual() <= limit).collect(Collectors.toList());
    }
    public Optional<Producto> findById(Long id) { return Optional.ofNullable(store.get(id)); }
    public Producto save(Producto p) {
        if (p.getId() == null) p.setId(seq.getAndIncrement());
        store.put(p.getId(), p);
        return p;
    }
    public void deleteById(Long id) { store.remove(id); }
}
