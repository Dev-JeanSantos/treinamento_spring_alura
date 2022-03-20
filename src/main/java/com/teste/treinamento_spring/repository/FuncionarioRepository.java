package com.teste.treinamento_spring.repository;

import com.teste.treinamento_spring.orm.Cargo;
import com.teste.treinamento_spring.orm.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
}
