package org.example.bank.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Utilisateur,Integer> {
    Optional<Utilisateur>findByMail(String mail);
}
