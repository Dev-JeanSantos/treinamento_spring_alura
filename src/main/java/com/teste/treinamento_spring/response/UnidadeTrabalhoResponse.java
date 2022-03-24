package com.teste.treinamento_spring.response;

import com.teste.treinamento_spring.orm.Cargo;
import com.teste.treinamento_spring.orm.UnidadeTrabalho;

public class UnidadeTrabalhoResponse {

    private String descricao;
    private String endereco;

    public UnidadeTrabalhoResponse() {
    }

    public UnidadeTrabalhoResponse(String descricao, String endereco) {
        this.descricao = descricao;
        this.endereco = endereco;
    }
    public UnidadeTrabalhoResponse(UnidadeTrabalho entity) {
        descricao = entity.getDescricao();
        endereco = entity.getEndereco();
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEndereco() {
        return endereco;
    }
}
