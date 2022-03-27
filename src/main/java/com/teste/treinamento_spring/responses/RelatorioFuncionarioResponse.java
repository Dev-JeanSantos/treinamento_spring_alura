package com.teste.treinamento_spring.responses;


import com.teste.treinamento_spring.orms.Cargo;
import com.teste.treinamento_spring.orms.Funcionario;

import java.time.LocalDate;

public class RelatorioFuncionarioResponse {
    private String nome;
    private String cpf;
    private Double salario;
    private LocalDate dataContratacao;
    private Long idCargo;

    private Cargo cargoResponse;

    public RelatorioFuncionarioResponse() {
    }

    public RelatorioFuncionarioResponse(String nome,
                                        String cpf,
                                        Double salario,
                                        LocalDate dataContratacao,
                                        Long idCargo,
                                        Cargo cargoResponse) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.idCargo = idCargo;
        this.cargoResponse = cargoResponse;
    }

    public RelatorioFuncionarioResponse(Funcionario entity) {
        this.nome = entity.getNome();
        this.cpf = entity.getCpf();
        this.salario = entity.getSalario();
        this.dataContratacao = entity.getDataContratacao();
        this.idCargo = entity.getId();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getSalario() {
        return salario;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }
}
