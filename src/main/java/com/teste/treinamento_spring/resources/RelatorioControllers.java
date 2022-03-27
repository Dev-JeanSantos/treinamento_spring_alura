package com.teste.treinamento_spring.resources;

import com.teste.treinamento_spring.responses.FuncionarioResponse;
import com.teste.treinamento_spring.responses.RelatorioFuncionarioResponse;
import com.teste.treinamento_spring.services.CrudFuncionarioService;
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
    private CrudFuncionarioService service;
    @Autowired
    private EntityManager manager;

   @GetMapping
   public ResponseEntity<Page<RelatorioFuncionarioResponse>> findAllPaged(
           @RequestParam(value = "page", defaultValue = "0") Integer page,
           @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
           @RequestParam(value = "direction", defaultValue = "ASC") String direction,
           @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy
   ){
       PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy );
       Page<RelatorioFuncionarioResponse> list = service.findAll(pageRequest);
       return ResponseEntity.ok().body(list);
   }

   @GetMapping(value = "/{id}")
   public ResponseEntity<FuncionarioResponse> findById(@PathVariable Long id) {
      FuncionarioResponse response = service.findById(id);
      return ResponseEntity.ok().body(response);
  }


}