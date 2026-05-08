package com.soft.gymbackend.service;

import com.soft.gymbackend.model.EntradaInventario;
import com.soft.gymbackend.model.Producto;
import com.soft.gymbackend.model.SalidaInventario;
import com.soft.gymbackend.repository.EntradaInventarioRepository;
import com.soft.gymbackend.repository.SalidaInventarioRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class InventarioService {
    private final EntradaInventarioRepository entradaRepo;
    private final SalidaInventarioRepository salidaRepo;
    private final ProductoService productoService;

    public InventarioService(EntradaInventarioRepository entradaRepo, SalidaInventarioRepository salidaRepo, ProductoService productoService) {
        this.entradaRepo = entradaRepo; this.salidaRepo = salidaRepo; this.productoService = productoService;
    }

    public List<EntradaInventario> listarEntradas() { return entradaRepo.findAllByOrderByFechaDesc(); }
    public List<SalidaInventario> listarSalidas() { return salidaRepo.findAllByOrderByFechaDesc(); }

    public EntradaInventario registrarEntrada(EntradaInventario entrada) {
        Producto p = productoService.buscarPorId(entrada.getProducto().getId());
        p.setStockActual(p.getStockActual() + entrada.getCantidad());
        productoService.guardar(p);
        entrada.setFecha(LocalDateTime.now());
        return entradaRepo.save(entrada);
    }

    public SalidaInventario registrarSalida(SalidaInventario salida) {
        Producto p = productoService.buscarPorId(salida.getProducto().getId());
        if (p.getStockActual() < salida.getCantidad()) throw new RuntimeException("Stock insuficiente para: " + p.getNombre());
        p.setStockActual(p.getStockActual() - salida.getCantidad());
        productoService.guardar(p);
        salida.setFecha(LocalDateTime.now());
        return salidaRepo.save(salida);
    }
}
