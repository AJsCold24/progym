package com.soft.gymbackend.repository;

import com.soft.gymbackend.model.SalidaInventario;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class SalidaInventarioRepository {
    private final Map<Long, SalidaInventario> store = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public List<SalidaInventario> findAllByOrderByFechaDesc() {
        return store.values().stream().sorted(Comparator.comparing(s -> s.getFecha() == null ? java.time.LocalDateTime.MIN : s.getFecha(), Comparator.reverseOrder())).collect(Collectors.toList());
    }
    public Optional<SalidaInventario> findById(Long id) { return Optional.ofNullable(store.get(id)); }
    public SalidaInventario save(SalidaInventario s) {
        if (s.getId() == null) s.setId(seq.getAndIncrement());
        store.put(s.getId(), s);
        return s;
    }
}
