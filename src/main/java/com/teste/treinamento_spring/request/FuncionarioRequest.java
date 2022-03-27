package com.teste.treinamento_spring.request;

import com.teste.treinamento_spring.orm.Funcionario;
import com.teste.treinamento_spring.orm.UnidadeTrabalho;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRequest {

    private Long id;
    private String nome;
    private String cpf;
    private Double salario;
    private LocalDate dataContratacao;
    private Long cargoId;

    private List<UnidadeTrabalhoRequest> unidades = new ArrayList<>();

    @Deprecated
    public FuncionarioRequest() {
    }

    public FuncionarioRequest(Long id,
                              String nome,
                              String cpf,
                              Double salario,
                              LocalDate dataContratacao,
                              Long cargoId) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.cargoId = cargoId;
    }

    public FuncionarioRequest(Funcionario entity) {
        id = entity.getId();
        nome = entity.getNome();
        cpf = entity.getCpf();
        salario = entity.getSalario();
        dataContratacao = entity.getDataContratacao();
        cargoId = entity.getCargo().getId();
    }

    public FuncionarioRequest(Funcionario entity, List<UnidadeTrabalho> uts) {
        this(entity);
        uts.forEach(x -> this.unidades.add(new UnidadeTrabalhoRequest(x)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Long getCargoId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }

    public List<UnidadeTrabalhoRequest> getUnidades() {
        return unidades;
    }

    @Override
    public String toString() {
        return "FuncionarioRequest{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", salario=" + salario +
                ", dataContratacao=" + dataContratacao +
                ", cargoId=" + cargoId +
                ", unidades=" + unidades +
                '}';
    }
}
