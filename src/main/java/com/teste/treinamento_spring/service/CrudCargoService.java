package com.teste.treinamento_spring.service;

import com.teste.treinamento_spring.orm.Cargo;
import com.teste.treinamento_spring.repository.CargoRepository;
import com.teste.treinamento_spring.request.CargoRequest;
import com.teste.treinamento_spring.response.CargoResponse;
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
public class CrudCargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Transactional
    public Page<CargoResponse> findAll(PageRequest pageRequest) {
        Page<Cargo> list = cargoRepository.findAll(pageRequest);
        return list.map(x -> new CargoResponse(x));
    }

    @Transactional(readOnly = true)
    public CargoResponse findById(Long id) {
        Optional<Cargo> obj = cargoRepository.findById(id);
        Cargo entity = obj.orElseThrow(() -> new ResourcesNotFoundException("Cargo não Encontrado"));
        return new CargoResponse(entity);
    }

    public CargoRequest insert(CargoRequest request) {
        Cargo entity = new Cargo();
        entity.setDescricao(request.getDescricao());
        entity = cargoRepository.save(entity);
        return new CargoRequest(entity);
    }

    public void delete(Long id) {
        try {
            cargoRepository.deleteById(id);
        }
        catch ( EmptyResultDataAccessException e) {
            throw new ResourcesNotFoundException("ID not found " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Integrity Violation");
        }
    }

    @Transactional
    public CargoRequest update(Long id, CargoRequest request) {
        try {
            Cargo entity = cargoRepository.getOne(id);
            entity.setDescricao(request.getDescricao());
            entity = cargoRepository.save(entity);
            return new CargoRequest(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourcesNotFoundException("Id Não encontrado" + id);
        }
    }
}
