package com.teste.treinamento_spring.validacoes;
import javax.validation.Payload;

public @interface ExistsId {

    String message() default "{com.teste.treinamento_spring.validacoes.existsid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    String fieldName();
    Class<?> domainClass();
}