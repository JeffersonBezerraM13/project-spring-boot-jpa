package com.dcx.ufpb.jefferson.payment_service.repositories;

import com.dcx.ufpb.jefferson.payment_service.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
