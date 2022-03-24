package com.teste.treinamento_spring.resource;

import com.teste.treinamento_spring.request.UnidadeTrabalhoRequest;
import com.teste.treinamento_spring.response.UnidadeTrabalhoResponse;
import com.teste.treinamento_spring.service.CrudUnidadeTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/udtrabalho")
public class UnidadeDeTrabalhoControllers {

    @Autowired
    private CrudUnidadeTrabalhoService service;

   @GetMapping
   public ResponseEntity<Page<UnidadeTrabalhoResponse>> findAllPaged(
           @RequestParam(value = "page", defaultValue = "0") Integer page,
           @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
           @RequestParam(value = "direction", defaultValue = "ASC") String direction,
           @RequestParam(value = "orderBy", defaultValue = "descricao") String orderBy
   ){
       PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy );
       Page<UnidadeTrabalhoResponse> list = service.findAll(pageRequest);
       return ResponseEntity.ok().body(list);
   }

   @GetMapping(value = "/{id}")
   public ResponseEntity<UnidadeTrabalhoResponse> findById(@PathVariable Long id) {
       UnidadeTrabalhoResponse response = service.findById(id);
       return ResponseEntity.ok().body(response);
   }

   @PostMapping
   public ResponseEntity<UnidadeTrabalhoRequest> insert(@Valid @RequestBody UnidadeTrabalhoRequest request) {
       request = service.insert(request);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
               .buildAndExpand(request.getId()).toUri();
       return ResponseEntity.created(uri).body(request);
   }

   @DeleteMapping(value = "/{id}")
   public ResponseEntity<UnidadeTrabalhoRequest> delete(@PathVariable Long id){
       service.delete(id);
       return ResponseEntity.noContent().build();
   }

   @PutMapping(value = "/{id}")
   public ResponseEntity<UnidadeTrabalhoRequest> update(@PathVariable Long id, @Valid @RequestBody UnidadeTrabalhoRequest request){
       request = service.update(id, request);
       return ResponseEntity.ok().body(request);
   }
}
