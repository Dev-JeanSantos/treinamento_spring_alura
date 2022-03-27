package com.teste.treinamento_spring.requestes;

import com.teste.treinamento_spring.orms.Cargo;
import com.teste.treinamento_spring.validations.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CargoRequest {

    private Long id;
    @NotBlank(message = "Campo Obrigatório")
    //@UniqueValue(domainClass = Cargo.class, fieldName = "descricao", message = "Cargo já existente na base de dados")
    private String descricao;

    @Deprecated
    public CargoRequest() {
    }

    public CargoRequest(Long id,
                        @NotBlank(message = "Campo Obrigatório") String descricao) {
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
