package com.teste.treinamento_spring.response;

import com.teste.treinamento_spring.orm.Funcionario;
import com.teste.treinamento_spring.orm.UnidadeTrabalho;
import com.teste.treinamento_spring.request.UnidadeTrabalhoRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioResponse {
    private String nome;
    private String cpf;
    private Double salario;
    private LocalDate dataContratacao;
    private Long cargoId;
    private String  cargo;

    private List<UnidadeTrabalhoRequest> unidades = new ArrayList<>();

    public FuncionarioResponse() {
    }

    public FuncionarioResponse(String nome,
                               String cpf,
                               Double salario,
                               LocalDate dataContratacao,
                               Long cargoId,
                               String cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.cargoId = cargoId;
        this.cargo = cargo;
    }

    public FuncionarioResponse(Funcionario entity) {
        nome = entity.getNome();
        cpf = entity.getCpf();
        salario = entity.getSalario();
        dataContratacao = entity.getDataContratacao();
        cargoId = entity.getCargo().getId();
        cargo = entity.getCargo().getDescricao();
    }
    public FuncionarioResponse(Funcionario entity, List<UnidadeTrabalho> ut) {
        this(entity);
        ut.forEach(x -> this.unidades.add(new UnidadeTrabalhoRequest(x)));
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

    public Long getCargoId() {
        return cargoId;
    }
    public LocalDate getDataContratacao() {
        return dataContratacao;
    }
    public String getCargo() {
        return cargo;
    }

    public List<UnidadeTrabalhoRequest> getUnidades() {
        return unidades;
    }
}
