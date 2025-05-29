package com.dcx.ufpb.jefferson.payment_service.resources;

import com.dcx.ufpb.jefferson.payment_service.model.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/users")
public class UserResources {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"Maria","maria@gmail.com","83 97777-7777","12345");
        return ResponseEntity.ok().body(u);
    }
}
