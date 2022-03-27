package com.teste.treinamento_spring.services;

import com.teste.treinamento_spring.orms.Funcionario;
import com.teste.treinamento_spring.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatoriosService {
    private Boolean system = true;
    private FuncionarioRepository repository;

    public void relatorio(String nome) {
        List<Funcionario> funcionarios = repository.findByNome(nome);
        funcionarios.forEach(System.out::println);

    }
}
