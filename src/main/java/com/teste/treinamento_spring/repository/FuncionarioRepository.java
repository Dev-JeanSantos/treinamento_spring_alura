package com.teste.treinamento_spring.repository;

import com.teste.treinamento_spring.orm.Cargo;
import com.teste.treinamento_spring.orm.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario>findByNome(String nome);
}
