package com.soft.gymbackend.repository;

import com.soft.gymbackend.model.EntradaInventario;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class EntradaInventarioRepository {
    private final Map<Long, EntradaInventario> store = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public List<EntradaInventario> findAllByOrderByFechaDesc() {
        return store.values().stream().sorted(Comparator.comparing(e -> e.getFecha() == null ? java.time.LocalDateTime.MIN : e.getFecha(), Comparator.reverseOrder())).collect(Collectors.toList());
    }
    public Optional<EntradaInventario> findById(Long id) { return Optional.ofNullable(store.get(id)); }
    public EntradaInventario save(EntradaInventario e) {
        if (e.getId() == null) e.setId(seq.getAndIncrement());
        store.put(e.getId(), e);
        return e;
    }
}
