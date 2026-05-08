package com.soft.gymbackend.repository;

import com.soft.gymbackend.model.Usuario;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UsuarioRepository {
    private final Map<Long, Usuario> store = new LinkedHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    public List<Usuario> findAll() { return new ArrayList<>(store.values()); }
    public Optional<Usuario> findById(Long id) { return Optional.ofNullable(store.get(id)); }
    public Optional<Usuario> findByUsername(String username) {
        return store.values().stream().filter(u -> username.equals(u.getUsername())).findFirst();
    }
    public boolean existsByUsername(String username) {
        return store.values().stream().anyMatch(u -> username.equals(u.getUsername()));
    }
    public Usuario save(Usuario u) {
        if (u.getId() == null) u.setId(seq.getAndIncrement());
        store.put(u.getId(), u);
        return u;
    }
    public void deleteById(Long id) { store.remove(id); }
}
