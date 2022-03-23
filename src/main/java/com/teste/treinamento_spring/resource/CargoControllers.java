package com.teste.treinamento_spring.resource;

import com.teste.treinamento_spring.request.CargoRequest;
import com.teste.treinamento_spring.response.CargoResponse;
import com.teste.treinamento_spring.service.CrudCargoService;
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
@RequestMapping(value = "/cargos")
public class CargoControllers {

    @Autowired
    private CrudCargoService service;

   @GetMapping
   public ResponseEntity<Page<CargoResponse>> findAllPaged(
           @RequestParam(value = "page", defaultValue = "0") Integer page,
           @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
           @RequestParam(value = "direction", defaultValue = "ASC") String direction,
           @RequestParam(value = "orderBy", defaultValue = "descricao") String orderBy
   ){
       PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy );
       Page<CargoResponse> list = service.findAll(pageRequest);
       return ResponseEntity.ok().body(list);
   }

   @GetMapping(value = "/{id}")
   public ResponseEntity<CargoResponse> findById(@PathVariable Long id) {
       CargoResponse response = service.findById(id);
       return ResponseEntity.ok().body(response);
   }

   @PostMapping
   public ResponseEntity<CargoRequest> insert(@Valid @RequestBody CargoRequest request) {
       request = service.insert(request);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
               .buildAndExpand(request.getId()).toUri();
       return ResponseEntity.created(uri).body(request);
   }

   @DeleteMapping(value = "/{id}")
   public ResponseEntity<CargoRequest> delete(@PathVariable Long id){
       service.delete(id);
       return ResponseEntity.noContent().build();
   }

   @PutMapping(value = "/{id}")
   public ResponseEntity<CargoRequest> update(@PathVariable Long id, @Valid @RequestBody CargoRequest request){
       request = service.update(id, request);
       return ResponseEntity.ok().body(request);
   }
}
