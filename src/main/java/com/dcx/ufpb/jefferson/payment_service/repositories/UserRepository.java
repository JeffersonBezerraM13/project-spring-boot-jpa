package com.dcx.ufpb.jefferson.payment_service.repositories;

import com.dcx.ufpb.jefferson.payment_service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Não precisa do @Repository já que há uma herança de um componente registrado do Spring que neste caso é o JpaReposiroty
//@Repository                                        //Repositorio de User
public interface UserRepository extends JpaRepository<User, Long> {
}
