package com.teste.treinamento_spring.service;

import com.teste.treinamento_spring.orm.Cargo;
import com.teste.treinamento_spring.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class CrudCargoService {

    private final CargoRepository cargoRepository;

    private Boolean system = true;

    public CrudCargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void iniciar(Scanner scanner) {

        while (system) {
            System.out.println("QUAL AÇÃO VOCE DESEJA EXECUTAR");
            System.out.println("0 -> SAIR");
            System.out.println("1 -> SALVAR CARGO");
            System.out.println("2 -> ATUALIZAR CARGO");
            System.out.println("3 -> BUSCAR CARGO");
            System.out.println("4 -> EXCLUIR CARGO");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3:
                    buscar(scanner);
                    break;
                case 4:
                    deletar(scanner);
                    break;
                default:
                    system = false;
            }
        }
    }

    private void buscar(Scanner scanner) {

        Iterable<Cargo> cargos = cargoRepository.findAll();
        cargos.forEach(cargo -> System.out.println(cargo));
    }

    private void atualizar (Scanner scanner){
            System.out.println("Digite o Id do cargo que vc deseja atualizar:");
            Long id = scanner.nextLong();
            System.out.println("Atualize o nome do cargo");
            String descricao = scanner.next();
            Cargo cargo = new Cargo();
            cargo.setId(id);
            cargo.setDescricao(descricao);
            cargoRepository.save(cargo);

            System.out.println("O Cargo " + cargo + " com id " + id + " foi atualizado com sucesso");
        }

        private void salvar (Scanner scanner){
            System.out.println("Descrição do Cargo:");
            String descricao = scanner.next();
            Cargo cargo = new Cargo();
            cargo.setDescricao(descricao);
            cargoRepository.save(cargo);
            System.out.println("O Cargo: " + cargo + " foi salvo com sucesso");
        }

        private void deletar (Scanner scanner) {
            System.out.println("Digite o Id do cargo que vc deseja excluir:");
            Long id = scanner.nextLong();
            Cargo cargo = new Cargo();
            cargo.setId(id);
            cargoRepository.delete(cargo);

            System.out.println("O Cargo com id " + id + " foi excluido com sucesso");
        }
    }
