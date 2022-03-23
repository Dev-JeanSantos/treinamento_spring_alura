package com.teste.treinamento_spring.resource;

import com.teste.treinamento_spring.response.RelatorioFuncionarioResponse;
import com.teste.treinamento_spring.service.CrudFuncionarioService;
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
   public ResponseEntity<RelatorioFuncionarioResponse> findById(@PathVariable Long id) {
      RelatorioFuncionarioResponse response = service.findById(id);
      return ResponseEntity.ok().body(response);
  }


}
