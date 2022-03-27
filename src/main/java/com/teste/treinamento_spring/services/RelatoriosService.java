package com.teste.treinamento_spring.services;

import com.teste.treinamento_spring.orms.Funcionario;
import com.teste.treinamento_spring.repositories.FuncionarioRepository;
import com.teste.treinamento_spring.responses.FuncionarioResponse;
import com.teste.treinamento_spring.services.exceptions.ResourcesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RelatoriosService {

    @Autowired
    private FuncionarioRepository repository;

    @Transactional
    public FuncionarioResponse relatorioPorNome(String nome) {
        Optional<Funcionario> obj = repository.findByNome(nome);
        Funcionario funcionario = obj.orElseThrow(() -> new ResourcesNotFoundException ("Funcionario não enontrado"));
        return new FuncionarioResponse(funcionario, funcionario.getUnidadeTrabalhos());

    }
}
