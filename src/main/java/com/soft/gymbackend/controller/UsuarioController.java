package com.soft.gymbackend.controller;

import com.soft.gymbackend.model.Usuario;
import com.soft.gymbackend.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) { this.usuarioService = usuarioService; }

    @GetMapping public List<Usuario> listarTodos() { return usuarioService.listarTodos(); }
    @GetMapping("/{id}") public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) { return ResponseEntity.ok(usuarioService.buscarPorId(id)); }
    @PostMapping public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) { return ResponseEntity.ok(usuarioService.guardar(usuario)); }
    @PutMapping("/{id}") public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario usuario) { return ResponseEntity.ok(usuarioService.actualizar(id, usuario)); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> eliminar(@PathVariable Long id) { usuarioService.eliminar(id); return ResponseEntity.noContent().build(); }
}
