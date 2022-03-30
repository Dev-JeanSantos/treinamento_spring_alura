package com.teste.treinamento_spring.repositories;

import com.teste.treinamento_spring.orms.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByNomeLike(String nome);

    @Query("SELECT f FROM Funcionario f WHERE f.nome = :nome AND f.salario >= :salario " +
            "AND f.dataContratacao = :dataContratacao" )
    Optional<Funcionario> findNomeSalarioMaiorDataContratatcao(String nome,
                                                               Double salario,
                                                               LocalDate dataContratacao);

}

