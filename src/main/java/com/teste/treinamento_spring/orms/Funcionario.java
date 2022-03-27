package com.teste.treinamento_spring.orms;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Campo Obrigatório")
    private String nome;
    @NotBlank(message = "Campo Obrigatório")
    private String cpf;
    @NotNull(message = "Campo Obrigatório")
    @Positive(message = "Valor Positivo Obrigatório")
    private Double salario;
    @NotNull(message = "Campo Obrigatório")
    @Past(message = "Data não pode ser no futuro")
    private LocalDate dataContratacao;

    @NotNull(message = "Campo Obrigatório")
    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @ManyToMany
    @JoinTable(name = "funcionarios_unidades", joinColumns = @JoinColumn(name = "fk_funcionario"),
            inverseJoinColumns = @JoinColumn(name = "fk_unidade")
    )
    List<UnidadeTrabalho>unidadeTrabalhos =  new ArrayList<>();

    public Funcionario() {
    }

    public Funcionario(Long id,
                       @NotBlank(message = "Campo Obrigatório")
                       @Past(message = "Data não pode ser no futuro") String nome,
                       @NotBlank(message = "Campo Obrigatório") String cpf,
                       @Positive(message = "Valor Positivo Obrigatório")
                       @NotNull(message = "Campo Obrigatório") Double salario,
                       @NotNull(message = "Campo Obrigatório") LocalDate dataContratacao,
                       @NotNull(message = "Campo Obrigatório") Cargo cargo,
                       List<UnidadeTrabalho> unidadeTrabalhos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.cargo = cargo;
        this.unidadeTrabalhos = unidadeTrabalhos;
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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }


    public List<UnidadeTrabalho> getUnidadeTrabalhos() {
        return unidadeTrabalhos;
    }
    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", salario=" + salario +
                ", dataContratacao=" + dataContratacao +
                ", cargo=" + cargo +
                ", unidadeTrabalhos=" + unidadeTrabalhos +
                '}';
    }
}
