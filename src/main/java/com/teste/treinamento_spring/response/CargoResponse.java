package com.teste.treinamento_spring.response;

import com.teste.treinamento_spring.orm.Cargo;

public class CargoResponse {

    private String descricao;

    public CargoResponse() {
    }

    public CargoResponse(String descricao) {
        this.descricao = descricao;
    }
    public CargoResponse(Cargo entity) {
        this.descricao = entity.getDescricao();
    }

    public String getDescricao() {
        return descricao;
    }
}
