package com.teste.treinamento_spring.resources;

import com.teste.treinamento_spring.requestes.FuncionarioRequest;
import com.teste.treinamento_spring.responses.FuncionarioResponse;
import com.teste.treinamento_spring.services.CrudFuncionarioService;
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
@RequestMapping(value = "/funcionarios")
public class FuncionarioControllers {

   @Autowired
   private CrudFuncionarioService service;

   @GetMapping
   public ResponseEntity<Page<FuncionarioResponse>> findAllPaged(
           @RequestParam(value = "page", defaultValue = "0") Integer page,
           @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
           @RequestParam(value = "direction", defaultValue = "ASC") String direction,
           @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy
   ){
       PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy );
       Page<FuncionarioResponse> list = service.findAllFuncionarios(pageRequest);
       return ResponseEntity.ok().body(list);
   }

   @GetMapping(value = "/{id}")
   public ResponseEntity<FuncionarioResponse> findById(@PathVariable Long id) {
       FuncionarioResponse response = service.findById(id);
       return ResponseEntity.ok().body(response);
   }

   @PostMapping
   public ResponseEntity<FuncionarioRequest> insert(@Valid @RequestBody FuncionarioRequest request) {
       request = service.insert(request);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
               .buildAndExpand(request.getId()).toUri();
       return ResponseEntity.created(uri).body(request);
   }

   @DeleteMapping(value = "/{id}")
   public ResponseEntity<FuncionarioRequest> delete(@PathVariable Long id){
       service.delete(id);
       return ResponseEntity.noContent().build();
   }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FuncionarioRequest> update(@PathVariable Long id,
                                                     @Valid @RequestBody FuncionarioRequest request){
        request = service.update(id, request);
        return ResponseEntity.ok().body(request);
    }
}
