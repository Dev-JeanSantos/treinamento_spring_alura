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

    public String getDescricao() {
        return descricao;
    }

    public Long getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }
}
