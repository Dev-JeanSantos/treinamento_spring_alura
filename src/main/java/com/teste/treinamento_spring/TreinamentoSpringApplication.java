package com.teste.treinamento_spring;

import com.teste.treinamento_spring.service.CrudCargoService;
import com.teste.treinamento_spring.service.CrudFuncionarioService;
import com.teste.treinamento_spring.service.CrudUnidadeTrabalhoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TreinamentoSpringApplication implements CommandLineRunner {

	private Boolean system = true;

	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private CrudUnidadeTrabalhoService unidadeTrabalhoService;

	public TreinamentoSpringApplication(CrudCargoService cargoService,
										CrudFuncionarioService funcionarioService,
										CrudUnidadeTrabalhoService unidadeTrabalhoService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TreinamentoSpringApplication.class,
				args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (system){
			System.out.println("QUAL AÇÃO VOCE DESEJA EXECUTAR: ");
			System.out.println("0 -> SAIR");
			System.out.println("1 -> ENTRAR NO SISTEMA CARGO");
			System.out.println("2 -> ENTRAR NO SISTEMA FUNCIONARIO");
			System.out.println("3 -> ENTRAR NO SISTEMA UNIDADE DE SERVIÇO");

			int action = scanner.nextInt();
			switch (action) {
				case 1:
					cargoService.iniciar(scanner);
					break;
				case 2:
					funcionarioService.iniciar(scanner);
					break;
				case 3:
					unidadeTrabalhoService.iniciar(scanner);
					break;
				default:
					system = false;
			}
		}
	}
}
