package com.teste.treinamento_spring.service;

import com.teste.treinamento_spring.orm.UnidadeTrabalho;
import com.teste.treinamento_spring.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudUnidadeTrabalhoService {

    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

    private Boolean system = true;

    public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
    }

    public void iniciar(Scanner scanner) {

        while (system) {
            System.out.println("QUAL AÇÃO VOCE DESEJA EXECUTAR");
            System.out.println("0 -> SAIR");
            System.out.println("1 -> SALVAR UNIDADE DE TRABALHO");
            System.out.println("2 -> ATUALIZAR  UNIDADE DE TRABALHO");
            System.out.println("3 -> BUSCAR  UNIDADE DE TRABALHO");
            System.out.println("4 -> EXCLUIR  UNIDADE DE TRABALHO");

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

        Iterable<UnidadeTrabalho> unidadeTrabalhos = unidadeTrabalhoRepository.findAll();
        unidadeTrabalhos.forEach( ut -> System.out.println(unidadeTrabalhos));
    }

    private void atualizar (Scanner scanner){
            System.out.println("Digite o Id do unidade que vc deseja atualizar:");
            Long id = scanner.nextLong();
            System.out.println("Atualize o nome da unidade");
            String descricao = scanner.next();
            System.out.println("Atualize o endereço da unidade");
            String endereco = scanner.next();
            UnidadeTrabalho ut = new UnidadeTrabalho();
            ut.setId(id);
            ut.setDescricao(descricao);
            ut.setEndereco(endereco);
            unidadeTrabalhoRepository.save(ut);
            System.out.println("A unidade de trabalho " + ut + " com id " + id + " foi atualizado com sucesso");
        }

        private void salvar (Scanner scanner){
            System.out.println("Nome da Unidade de Trabalho:");
            String descricao = scanner.next();
            System.out.println("Endereço da Unidade de Trabalho:");
            String endereco = scanner.next();
            UnidadeTrabalho ut = new UnidadeTrabalho();
            ut.setDescricao(descricao);
            ut.setEndereco(endereco);
            unidadeTrabalhoRepository.save(ut);
            System.out.println("O Cargo: " + ut + " foi salvo com sucesso");
        }

        private void deletar (Scanner scanner) {
            System.out.println("Digite o Id do cargo que vc deseja excluir:");
            Long id = scanner.nextLong();
            UnidadeTrabalho ut = new UnidadeTrabalho();
            ut.setId(id);
            unidadeTrabalhoRepository.delete(ut);

            System.out.println("O Cargo com id " + id + " foi excluido com sucesso");
        }
    }
