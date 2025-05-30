package com.dcx.ufpb.jefferson.payment_service.repositories;

import com.dcx.ufpb.jefferson.payment_service.entities.Category;
import com.dcx.ufpb.jefferson.payment_service.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//Não precisa do @Repository já que há uma herança de um componente registrado do Spring que neste caso é o JpaReposiroty
//@Repository                                        //Repositorio de Product
public interface ProductRepository extends JpaRepository<Product, Long> {
}
