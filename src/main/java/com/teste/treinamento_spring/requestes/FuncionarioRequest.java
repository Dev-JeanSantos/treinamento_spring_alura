package com.teste.treinamento_spring.requestes;

import com.teste.treinamento_spring.orms.Funcionario;
import com.teste.treinamento_spring.orms.UnidadeTrabalho;
import com.teste.treinamento_spring.validations.UniqueValue;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRequest {

    private Long id;
    @NotBlank(message = "Campo Obrigatório")
    private String nome;
    @NotBlank(message = "Campo Obrigatório")
    //@UniqueValue(domainClass = Funcionario.class, fieldName = "cpf", message = "CPF já existente na base de dados")
    private String cpf;
    @NotNull(message = "Campo Obrigatório")
    @Positive(message = "Valor Positivo Obrigatório")
    private Double salario;
    @NotNull(message = "Campo Obrigatório")
    @Past(message = "Data não pode ser no futuro")
    private LocalDate dataContratacao;

    @NotNull(message = "Campo Obrigatório")
    private Long cargoId;

    private List<UnidadeTrabalhoRequest> unidades = new ArrayList<>();

    @Deprecated
    public FuncionarioRequest() {
    }

    public FuncionarioRequest(Long id,

                              @NotBlank(message = "Campo Obrigatório") String nome,
                              @NotBlank(message = "Campo Obrigatório") String cpf,
                              @Positive(message = "Valor Positivo Obrigatório")
                              @NotNull(message = "Campo Obrigatório") Double salario,
                              @NotNull(message = "Campo Obrigatório")
                              @Past(message = "Data não pode ser no futuro") LocalDate dataContratacao,
                              @NotNull(message = "Campo Obrigatório") Long cargoId) {
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
