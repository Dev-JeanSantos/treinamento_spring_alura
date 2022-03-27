package com.teste.treinamento_spring.service;

import com.teste.treinamento_spring.orm.Cargo;
import com.teste.treinamento_spring.orm.Funcionario;
import com.teste.treinamento_spring.orm.UnidadeTrabalho;
import com.teste.treinamento_spring.repository.CargoRepository;
import com.teste.treinamento_spring.repository.FuncionarioRepository;
import com.teste.treinamento_spring.repository.UnidadeTrabalhoRepository;
import com.teste.treinamento_spring.request.FuncionarioRequest;
import com.teste.treinamento_spring.request.UnidadeTrabalhoRequest;
import com.teste.treinamento_spring.response.FuncionarioResponse;
import com.teste.treinamento_spring.response.RelatorioFuncionarioResponse;
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
public class CrudFuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private CargoRepository cargoRepository;
    @Autowired
    private UnidadeTrabalhoRepository unidadeTrabalhoRepository;

    @Transactional
    public Page<RelatorioFuncionarioResponse> findAll(PageRequest pageRequest) {
        Page<Funcionario> list = funcionarioRepository.findAll(pageRequest);
        return list.map(x -> new RelatorioFuncionarioResponse(x));
    }

    @Transactional(readOnly = true)
    public FuncionarioResponse findById(Long id) {
        Optional<Funcionario> obj = funcionarioRepository.findById(id);
        Funcionario entity = obj.orElseThrow(() -> new ResourcesNotFoundException("Funcionário não Encontrado"));
        return new FuncionarioResponse(entity, entity.getUnidadeTrabalhos());
    }


    @Transactional
    public Page<FuncionarioResponse> findAllFuncionarios(PageRequest pageRequest) {
        Page<Funcionario> list = funcionarioRepository.findAll(pageRequest);
        return list.map(x -> new FuncionarioResponse(x));
    }

    public FuncionarioRequest insert(FuncionarioRequest request) {
        Funcionario entity = new Funcionario();
        montarObjeto(request, entity);
        entity = funcionarioRepository.save(entity);
        return new FuncionarioRequest(entity, entity.getUnidadeTrabalhos());
    }

    public void delete(Long id) {
        try {
            funcionarioRepository.deleteById(id);
        }
        catch ( EmptyResultDataAccessException e) {
            throw new ResourcesNotFoundException("ID not found " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity Violation");
        }
    }

    @Transactional
    public FuncionarioRequest update(Long id, FuncionarioRequest request) {
        try {
            Funcionario entity = funcionarioRepository.getOne(id);
            montarObjeto(request, entity);
            entity = funcionarioRepository.save(entity);
            return new FuncionarioRequest(entity, entity.getUnidadeTrabalhos());
        }
        catch (EntityNotFoundException e) {
            throw new ResourcesNotFoundException("Id Não encontrado" + id);
        }
    }

    private void montarObjeto(FuncionarioRequest request, Funcionario entity) {
        entity.setNome(request.getNome());
        entity.setCpf(request.getCpf());
        entity.setSalario(request.getSalario());
        entity.setDataContratacao(request.getDataContratacao());

        Cargo cargo = cargoRepository.getOne(request.getCargoId());
        entity.setCargo(cargo);

        entity.getUnidadeTrabalhos().clear();
        for (UnidadeTrabalhoRequest utRequest : request.getUnidades()) {
            UnidadeTrabalho ut = unidadeTrabalhoRepository.getOne(utRequest.getId());
            entity.getUnidadeTrabalhos().add(ut);
        }
    }


}

