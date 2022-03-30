package com.teste.treinamento_spring.resources;

import com.teste.treinamento_spring.responses.FuncionarioResponse;
import com.teste.treinamento_spring.services.RelatoriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/relatorios")
public class RelatorioControllers {

    @Autowired
    private RelatoriosService service;

   @GetMapping(value = "/{nome}")
   public ResponseEntity<FuncionarioResponse> findByNome(@PathVariable String nome) {
      FuncionarioResponse response = service.relatorioPorNome(nome);
      return ResponseEntity.ok().body(response);
  }

  @GetMapping
  public ResponseEntity<FuncionarioResponse> findByNomeSalarioDataContratacao(@RequestParam String nome, Double salario, String dataContratacao) {
       FuncionarioResponse response = service.relatorioPorNomeMaiorSalarioDataContratacao(nome, salario, dataContratacao);
       return ResponseEntity.ok().body(response);
  }

}
