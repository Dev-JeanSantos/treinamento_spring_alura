package com.teste.treinamento_spring.service;

import com.teste.treinamento_spring.orm.UnidadeTrabalho;
import com.teste.treinamento_spring.repository.UnidadeTrabalhoRepository;
import com.teste.treinamento_spring.request.UnidadeTrabalhoRequest;
import com.teste.treinamento_spring.response.UnidadeTrabalhoResponse;
import com.teste.treinamento_spring.service.exceptions.DataBaseException;
import com.teste.treinamento_spring.service.exceptions.ResourcesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class CrudUnidadeTrabalhoService {

    @Autowired
    private UnidadeTrabalhoRepository repository;

    public Page<UnidadeTrabalhoResponse> findAll(PageRequest pageRequest) {
        Page<UnidadeTrabalho> list = repository.findAll(pageRequest);
        return list.map(x -> new UnidadeTrabalhoResponse(x));
    }

    public UnidadeTrabalhoResponse findById(Long id) {
        Optional<UnidadeTrabalho> obj = repository.findById(id);
        UnidadeTrabalho entity = obj.orElseThrow(() -> new ResourcesNotFoundException("Unidade de Trabalho não Encontrada"));
        return new UnidadeTrabalhoResponse(entity);
    }

    public UnidadeTrabalhoRequest insert(UnidadeTrabalhoRequest request) {
        UnidadeTrabalho entity = new UnidadeTrabalho();
        entity.setDescricao(request.getDescricao());
        entity.setEndereco(request.getEndereco());
        entity = repository.save(entity);
        return new UnidadeTrabalhoRequest(entity);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch ( EmptyResultDataAccessException e) {
            throw new ResourcesNotFoundException("ID not found " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity Violation");
        }
    }

    @Transactional
    public UnidadeTrabalhoRequest update(Long id, UnidadeTrabalhoRequest request) {
        try {
            UnidadeTrabalho entity = repository.getOne(id);
            entity.setDescricao(request.getDescricao());
            entity.setEndereco(request.getEndereco());
            entity = repository.save(entity);
            return new UnidadeTrabalhoRequest(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourcesNotFoundException("Id Não encontrado" + id);
        }
    }
}
