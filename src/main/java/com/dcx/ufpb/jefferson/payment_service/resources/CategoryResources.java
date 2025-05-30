package com.dcx.ufpb.jefferson.payment_service.resources;

import com.dcx.ufpb.jefferson.payment_service.entities.Category;
import com.dcx.ufpb.jefferson.payment_service.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (value = "/categories")
public class CategoryResources {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") //Valor do id do usuario. A URL vai precisar de um parametro para ser o id da consulta
    public ResponseEntity<Category> findById(@PathVariable Long id){ //O paremetro da URl vai entrar como essa variavel do método, para isso precisa da anotation @PathVariable
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
