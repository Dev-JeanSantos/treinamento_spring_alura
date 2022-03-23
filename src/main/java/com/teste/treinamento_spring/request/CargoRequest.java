package com.teste.treinamento_spring.request;

import com.teste.treinamento_spring.orm.Cargo;

public class CargoRequest {

    private Long id;
    private String descricao;

    public CargoRequest() {
    }

    public CargoRequest(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    public CargoRequest(Cargo entity) {
        id = entity.getId();
        descricao = entity.getDescricao();
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getId() {
        return id;
    }
}
