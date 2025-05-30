package com.dcx.ufpb.jefferson.payment_service.services;

import com.dcx.ufpb.jefferson.payment_service.entities.Category;
import com.dcx.ufpb.jefferson.payment_service.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//registrando essa classe como @Service para que o @Autowired funcione corretamente entre as classes que se relacionam
//@Service marca essa classe como um componente registrado do Spring
//Assim o mecanismo de injeção de dependencia do Sprin poderá funcionar
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElse(null); //precisa criar uma classe que seja exception compativel com Spring
    }
}
