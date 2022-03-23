package com.teste.treinamento_spring.service;

import com.teste.treinamento_spring.orm.Funcionario;
import com.teste.treinamento_spring.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {
    private Boolean system = true;
    private FuncionarioRepository repository;

    public void relatorio(String nome) {
        List<Funcionario> funcionarios = repository.findByNome(nome);
        funcionarios.forEach(System.out::println);

    }
}
