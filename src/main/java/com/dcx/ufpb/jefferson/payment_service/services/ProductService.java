package com.dcx.ufpb.jefferson.payment_service.services;

import com.dcx.ufpb.jefferson.payment_service.entities.Product;
import com.dcx.ufpb.jefferson.payment_service.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//registrando essa classe como @Service para que o @Autowired funcione corretamente entre as classes que se relacionam
//@Service marca essa classe como um componente registrado do Spring
//Assim o mecanismo de injeção de dependencia do Sprin poderá funcionar
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElse(null); //precisa criar uma classe que seja exception compativel com Spring
    }
}
