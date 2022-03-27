package com.teste.treinamento_spring.orms;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_cargos")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank (message = "Campo Obrigatório")
    private String descricao;

    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionarios =  new ArrayList<>();

    @Deprecated
    public Cargo() {
    }

    public Cargo( Long id,
                 @NotBlank (message = "Campo Obrigatório") String descricao,
                 List<Funcionario> funcionarios) {
        this.id = id;
        this.descricao = descricao;
        this.funcionarios = funcionarios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", funcionarios=" + funcionarios +
                '}';
    }
}
