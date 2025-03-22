package com.fve.truper.service;

import com.fve.truper.entity.Orden;
import com.fve.truper.entity.Producto;
import com.fve.truper.repository.OrdenRepository;
import com.fve.truper.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class OrdenServiceImpl implements OrdenService {

    private final OrdenRepository ordenRepository;
    private final ProductoRepository productoRepository;

    @Override
    public Orden save(Orden orden) {
        BigDecimal total = BigDecimal.valueOf(orden.getProductos().stream()
                .mapToDouble(o -> o.getPrecio().doubleValue())
                .sum());
        orden.setTotal(total);
        Orden savedOrder = ordenRepository.save(orden);
        for (Producto producto : orden.getProductos()) {
            producto.setOrden(savedOrder);
            productoRepository.save(producto);
        }
        //productoRepository.saveAll(orden.getProductos());
        return savedOrder;
    }

    @Override
    public Orden findById(Long id) {
        Orden orderFound = ordenRepository.findById(id).orElse(null);
        List<Producto> productoList = productoRepository.findByOrden( orderFound.getOrdenId() );
        if(productoList != null) {
            System.out.println("Tamaño de la Lista:" + productoList.size());
            orderFound.setProductos(productoList);
        }else{
            orderFound.setProductos(null);
            System.out.println("No se encontro el producto");
        }


        return orderFound;
    }
}
