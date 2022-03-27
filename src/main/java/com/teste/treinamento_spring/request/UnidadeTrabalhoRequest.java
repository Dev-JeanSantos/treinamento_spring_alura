package com.teste.treinamento_spring.request;

import com.teste.treinamento_spring.orm.Cargo;
import com.teste.treinamento_spring.orm.UnidadeTrabalho;

public class UnidadeTrabalhoRequest {

    private Long id;
    private String descricao;
    private String endereco;

    public UnidadeTrabalhoRequest() {
    }

    public UnidadeTrabalhoRequest(Long id, String descricao, String endereco) {
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
