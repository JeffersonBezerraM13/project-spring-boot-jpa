package com.dcx.ufpb.jefferson.payment_service.services;

import com.dcx.ufpb.jefferson.payment_service.entities.User;
import com.dcx.ufpb.jefferson.payment_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//registrando essa classe como @Service para que o @Autowired funcione corretamente entre as classes que se relacionam
//@Service marca essa classe como um componente registrado do Spring
//Assim o mecanismo de injeção de dependencia do Sprin poderá funcionar
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElse(null); //precisa criar uma classe que seja exception compativel com Spring
    }
}
