package com.soft.gymbackend.service;

import com.soft.gymbackend.model.Producto;
import com.soft.gymbackend.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;
    public ProductoService(ProductoRepository productoRepository) { this.productoRepository = productoRepository; }

    public List<Producto> listarTodos() { return productoRepository.findAll(); }
    public List<Producto> listarStockBajo() { return productoRepository.findByStockActualLessThanEqual(5); }
    public Producto buscarPorId(Long id) { return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado: " + id)); }
    public Producto guardar(Producto producto) {
        if (producto.getCreatedAt() == null) producto.setCreatedAt(LocalDateTime.now());
        return productoRepository.save(producto);
    }
    public Producto actualizar(Long id, Producto datos) {
        Producto p = buscarPorId(id);
        p.setNombre(datos.getNombre()); p.setCategoria(datos.getCategoria()); p.setDescripcion(datos.getDescripcion());
        p.setPrecioCompra(datos.getPrecioCompra()); p.setPrecioVenta(datos.getPrecioVenta()); p.setStockMinimo(datos.getStockMinimo());
        return productoRepository.save(p);
    }
    public void eliminar(Long id) { productoRepository.deleteById(id); }
}
