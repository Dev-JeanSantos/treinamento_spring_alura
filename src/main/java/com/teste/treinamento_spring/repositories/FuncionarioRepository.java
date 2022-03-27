package com.teste.treinamento_spring.repositories;

import com.teste.treinamento_spring.orms.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario>findByNome(String nome);
}
