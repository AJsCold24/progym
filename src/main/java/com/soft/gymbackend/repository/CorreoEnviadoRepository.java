package com.soft.gymbackend.repository;

import com.soft.gymbackend.model.CorreoEnviado;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class CorreoEnviadoRepository {
    private final Map<Long, CorreoEnviado> store = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public List<CorreoEnviado> findAllByOrderByFechaEnvioDesc() {
        return store.values().stream().sorted(Comparator.comparing(c -> c.getFechaEnvio() == null ? java.time.LocalDateTime.MIN : c.getFechaEnvio(), Comparator.reverseOrder())).collect(Collectors.toList());
    }
    public List<CorreoEnviado> findBySocioId(Long socioId) {
        return store.values().stream().filter(c -> c.getSocio() != null && socioId.equals(c.getSocio().getId())).collect(Collectors.toList());
    }
    public Optional<CorreoEnviado> findById(Long id) { return Optional.ofNullable(store.get(id)); }
    public CorreoEnviado save(CorreoEnviado c) {
        if (c.getId() == null) c.setId(seq.getAndIncrement());
        store.put(c.getId(), c);
        return c;
    }
}
