package com.teste.treinamento_spring.service;

import com.teste.treinamento_spring.orm.Cargo;
import com.teste.treinamento_spring.repository.CargoRepository;
import org.springframework.stereotype.Service;

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

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualiza(scanner);
                default:
                    system = false;
            }
        }
    }

    private void atualiza(Scanner scanner) {
        System.out.println("Digite o Id do cargo que vc deseja atualizar:");
        Long id = scanner.nextLong();
        System.out.println("Atualize o nome do cargo");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);

        System.out.println("O Cargo " + cargo + "com Id " + id + " foi salvo com sucesso");
    }

    private void salvar(Scanner scanner) {
        System.out.println("Descrição do Cargo:");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        cargoRepository.save(cargo);
        System.out.println("O Cargo " + cargo + "foi salvo com sucesso");
    }
}
