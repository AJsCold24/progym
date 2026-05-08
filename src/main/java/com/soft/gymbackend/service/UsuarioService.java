package com.soft.gymbackend.service;

import com.soft.gymbackend.model.Usuario;
import com.soft.gymbackend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository) { this.usuarioRepository = usuarioRepository; }

    public List<Usuario> listarTodos() { return usuarioRepository.findAll(); }
    public Usuario buscarPorId(Long id) { return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + id)); }
    public Usuario buscarPorUsername(String username) { return usuarioRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + username)); }
    public Usuario guardar(Usuario usuario) {
        if (usuarioRepository.existsByUsername(usuario.getUsername())) throw new RuntimeException("Ya existe el usuario: " + usuario.getUsername());
        usuario.setCreatedAt(LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }
    public Usuario actualizar(Long id, Usuario datos) {
        Usuario u = buscarPorId(id);
        u.setNombre(datos.getNombre()); u.setApellido(datos.getApellido()); u.setRol(datos.getRol());
        return usuarioRepository.save(u);
    }
    public void eliminar(Long id) { usuarioRepository.deleteById(id); }
}
