package com.dcx.ufpb.jefferson.payment_service.repositories;

import com.dcx.ufpb.jefferson.payment_service.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Não precisa do @Repository já que há uma herança de um componente registrado do Spring que neste caso é o JpaReposiroty
//@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
