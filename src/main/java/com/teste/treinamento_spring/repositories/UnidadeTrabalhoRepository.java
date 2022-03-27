package com.teste.treinamento_spring.repositories;

import com.teste.treinamento_spring.orms.UnidadeTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeTrabalhoRepository extends JpaRepository<UnidadeTrabalho, Long> {
}
