package com.teste.treinamento_spring.services;

import com.teste.treinamento_spring.orms.Funcionario;
import com.teste.treinamento_spring.repositories.FuncionarioRepository;
import com.teste.treinamento_spring.responses.FuncionarioResponse;
import com.teste.treinamento_spring.services.exceptions.ResourcesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RelatoriosService {

    @Autowired
    private FuncionarioRepository repository;

    @Transactional
    public FuncionarioResponse relatorioPorNome(String nome) {
        Optional<Funcionario> obj = repository.findByNomeLike(nome);
        Funcionario funcionario = obj.orElseThrow(() -> new ResourcesNotFoundException ("Funcionario não encontrado"));
        return new FuncionarioResponse(funcionario, funcionario.getUnidadeTrabalhos());
    }

    public FuncionarioResponse relatorioPorNomeMaiorSalarioDataContratacao(String nome, Double salario, String dataContratacao) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate ld = LocalDate.parse(dataContratacao, formatter);

        Optional<Funcionario> obj = repository.findNomeSalarioMaiorDataContratatcao(nome, salario, ld);
        Funcionario funcionario = obj.orElseThrow(() -> new ResourcesNotFoundException ("Funcionario não encontrado"));
        return new FuncionarioResponse(funcionario, funcionario.getUnidadeTrabalhos());
    }

    public List<FuncionarioResponse> relatorioPorContratacao(String dataContratacao) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate ld = LocalDate.parse(dataContratacao, formatter);

        List<Funcionario> list = repository.findDataContratatcao(ld);
        return list.stream().map(x -> new FuncionarioResponse(x)).collect(Collectors.toList());
    }
}
