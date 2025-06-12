package com.dcx.ufpb.jefferson.payment_service.services;

import com.dcx.ufpb.jefferson.payment_service.entities.User;
import com.dcx.ufpb.jefferson.payment_service.repositories.UserRepository;
import com.dcx.ufpb.jefferson.payment_service.services.exceptions.DatabaseException;
import com.dcx.ufpb.jefferson.payment_service.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        //findById busca DO banco de dados o objeto
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        try {
            User user = findById(id);
            userRepository.delete(user);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user) {
        // getReferenceById instacia o user mas ele não busca do banco de dados, mas ele continua sendo monitorado pelo JPA
        try {
            User entity = userRepository.getReferenceById(id);
            updateData(entity,user);
            return userRepository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
