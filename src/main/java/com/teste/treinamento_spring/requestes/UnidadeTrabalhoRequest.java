package com.teste.treinamento_spring.requestes;

import com.teste.treinamento_spring.orms.UnidadeTrabalho;
import com.teste.treinamento_spring.validations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class UnidadeTrabalhoRequest {

    private Long id;
    @NotBlank(message = "Campo Obrigatório")
    //@UniqueValue(domainClass = UnidadeTrabalho.class, fieldName = "descricao", message = "Unidade de Trabalho já existente na base de dados")
    private String descricao;
    @NotBlank(message = "Campo Obrigatório")
    private String endereco;

    public UnidadeTrabalhoRequest() {
    }

    public UnidadeTrabalhoRequest(Long id,
                                  @NotBlank(message = "Campo Obrigatório") String descricao,
                                  @NotBlank(message = "Campo Obrigatório") String endereco) {
        this.id = id;
        this.descricao = descricao;
        this.endereco = endereco;
    }

    public UnidadeTrabalhoRequest(UnidadeTrabalho entity) {
        id = entity.getId();
        descricao = entity.getDescricao();
        endereco = entity.getEndereco();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "UnidadeTrabalhoRequest{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
