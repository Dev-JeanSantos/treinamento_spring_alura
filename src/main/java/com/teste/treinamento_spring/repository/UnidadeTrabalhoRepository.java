package com.teste.treinamento_spring.repository;

import com.teste.treinamento_spring.orm.Funcionario;
import com.teste.treinamento_spring.orm.UnidadeTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeTrabalhoRepository extends JpaRepository<UnidadeTrabalho, Long> {
}
