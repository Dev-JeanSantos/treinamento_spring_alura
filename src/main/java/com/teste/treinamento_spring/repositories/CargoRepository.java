package com.teste.treinamento_spring.repositories;

import com.teste.treinamento_spring.orms.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
