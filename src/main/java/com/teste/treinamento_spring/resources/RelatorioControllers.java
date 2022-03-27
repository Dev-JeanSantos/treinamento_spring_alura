package com.teste.treinamento_spring.resources;

import com.teste.treinamento_spring.responses.FuncionarioResponse;
import com.teste.treinamento_spring.responses.RelatorioFuncionarioResponse;
import com.teste.treinamento_spring.services.CrudFuncionarioService;
import com.teste.treinamento_spring.services.RelatoriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

@RestController
@RequestMapping(value = "/relatorios")
public class RelatorioControllers {

    @Autowired
    private RelatoriosService service;
    @Autowired
    private EntityManager manager;

   @GetMapping(value = "/{nome}")
   public ResponseEntity<FuncionarioResponse> findByNome(@PathVariable String nome) {
      FuncionarioResponse response = service.relatorioPorNome(nome);
      return ResponseEntity.ok().body(response);
  }


}
