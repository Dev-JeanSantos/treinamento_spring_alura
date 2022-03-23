package com.teste.treinamento_spring.service;

import com.teste.treinamento_spring.orm.Funcionario;
import com.teste.treinamento_spring.repository.CargoRepository;
import com.teste.treinamento_spring.repository.FuncionarioRepository;
import com.teste.treinamento_spring.repository.UnidadeTrabalhoRepository;
import com.teste.treinamento_spring.response.RelatorioFuncionarioResponse;
import com.teste.treinamento_spring.service.exceptions.ResourcesNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class CrudFuncionarioService {


    private Boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private CargoRepository cargoRepository;
    @Autowired
    private UnidadeTrabalhoRepository unidadeTrabalhoRepository;
    @Autowired
    private EntityManager manager;


//    private void (Scanner scanner) {
//
//        Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
//        funcionarios.forEach(funcionario -> System.out.println(funcionario));
//    }
//
//    private void atualizar (Scanner scanner){
//            System.out.println("Digite o Id do funcionario que vc deseja atualizar:");
//            Long id = scanner.nextLong();
//            System.out.println("Atualize o nome do funcionario");
//            String nome = scanner.next();
//            System.out.println("Atualize o cpf do funcionario");
//            String cpf = scanner.next();
//            System.out.println("Atualize o salario do funcionario");
//            Double salario = scanner.nextDouble();
//            System.out.println("Atualize a data de contratação do funcionario");
//            String dataContratacao = scanner.next();
//
//            System.out.println("Digite o Id do Cargo desse Funcionario");
//            Long cargoId = scanner.nextLong();
//
//
//            Funcionario funcionario = new Funcionario();
//            List<UnidadeTrabalho> unidadeTrabalhos = unidade(scanner);
//            funcionario.setId(id);
//            funcionario.setNome(nome);
//            funcionario.setCpf(cpf);
//            funcionario.setDataContratacao(LocalDate.parse(dataContratacao));
//            funcionario.setSalario(salario);
//
//            Optional<Cargo> cargo = cargoRepository.findById(cargoId);
//            funcionario.setCargo(cargo.get());
//            funcionario.setUnidadeTrabalhos(unidadeTrabalhos);
//
//            funcionarioRepository.save(funcionario);
//            System.out.println("O funcionario " + funcionario + " com id " + id + " foi atualizado com sucesso");
//        }
//
//        private void salvar (Scanner scanner){
//            System.out.println("Nome do funcionario:");
//            String nome = scanner.next();
//            System.out.println("CPF do funcionario:");
//            String cpf = scanner.next();
//            System.out.println("Data de Contratação do funcionario:");
//            String dataContratacao = scanner.next();
//            System.out.println("Salário do funcionario:");
//            Double salario = scanner.nextDouble();
//            System.out.println("Digite o Id do Cargo desse Funcionario");
//            Long IdCargo = scanner.nextLong();
//
//            List<UnidadeTrabalho> unidadeTrabalhos = unidade(scanner);
//
//            Funcionario funcionario = new Funcionario();
//            funcionario.setNome(nome);
//            funcionario.setCpf(cpf);
//            funcionario.setDataContratacao(LocalDate.parse(dataContratacao));
//            funcionario.setSalario(salario);
//            Optional<Cargo> cargo = cargoRepository.findById(IdCargo);
//            funcionario.setCargo(cargo.get());
//            funcionario.setUnidadeTrabalhos(unidadeTrabalhos);
//
//            funcionarioRepository.save(funcionario);
//            System.out.println("O funcionario: " + funcionario + " foi salvo com sucesso");
//        }
//
//        private void deletar (Scanner scanner) {
//            System.out.println("Digite o Id do funcionario que vc deseja excluir:");
//            Long id = scanner.nextLong();
//            funcionarioRepository.deleteById(id);
//            System.out.println("O funcionario com id " + id + " foi excluido com sucesso");
//        }
//
//        private List<UnidadeTrabalho> unidade (Scanner scanner){
//            Boolean isTrue = true;
//            List<UnidadeTrabalho> unidades = new ArrayList<>();
//            while (isTrue){
//                System.out.println("Digite o Id da unidade (Para SAIR digite 0) ");
//                Long unidadeId = scanner.nextLong();
//                if(unidadeId != 0){
//                    Optional<UnidadeTrabalho> unidade = unidadeTrabalhoRepository.findById(unidadeId);
//                    unidades.add(unidade.get());
//                }else {
//                    isTrue = false;
//                }
//            }
//            return unidades;
//    }

    @Transactional
    public Page<RelatorioFuncionarioResponse> findAll(PageRequest pageRequest) {
        Page<Funcionario> list = funcionarioRepository.findAll(pageRequest);
        return list.map(x -> new RelatorioFuncionarioResponse(x));
    }

    @Transactional(readOnly = true)
    public RelatorioFuncionarioResponse findById(Long id) {
        Optional<Funcionario> obj = funcionarioRepository.findById(id);
        Funcionario entity = obj.orElseThrow(() -> new ResourcesNotFoundException("Praia não Encontrada"));
        return new RelatorioFuncionarioResponse(entity);
    }


}

