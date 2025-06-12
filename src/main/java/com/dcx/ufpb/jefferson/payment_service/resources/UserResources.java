package com.dcx.ufpb.jefferson.payment_service.resources;

import com.dcx.ufpb.jefferson.payment_service.entities.User;
import com.dcx.ufpb.jefferson.payment_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping (value = "/users")
public class UserResources {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") //Valor do id do usuario. A URL vai precisar de um parametro para ser o id da consulta
    public ResponseEntity<User> findById(@PathVariable Long id){ //O paremetro da URl vai entrar como essa variavel do método, para isso precisa da anotation @PathVariable
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
        User obj = service.insert(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build(); //resposta sem corpo
        //resposta HTTP para sem corpo é 204
    }

    //Padrão API Rest é put
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
        user = service.update(id, user);
        return ResponseEntity.ok().body(user);
    }
}
