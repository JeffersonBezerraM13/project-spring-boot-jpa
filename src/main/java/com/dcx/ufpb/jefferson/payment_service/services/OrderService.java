package com.dcx.ufpb.jefferson.payment_service.services;

import com.dcx.ufpb.jefferson.payment_service.model.entities.Order;
import com.dcx.ufpb.jefferson.payment_service.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//registrando essa classe como @Service para que o @Autowired funcione corretamente entre as classes que se relacionam
//@Service marca essa classe como um componente registrado do Spring
//Assim o mecanismo de injeção de dependencia do Sprin poderá funcionar
@Service
public class OrderService {

    @Autowired
    private OrderRepository OrderRepository;

    public List<Order> findAll() {
        return OrderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = OrderRepository.findById(id);
        return obj.orElse(null); //precisa criar uma classe que seja exception compativel com Spring
    }
}
