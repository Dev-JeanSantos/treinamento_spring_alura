package com.teste.treinamento_spring;

import com.teste.treinamento_spring.service.CrudCargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TreinamentoSpringApplication implements CommandLineRunner {

	private Boolean system = true;

	private final CrudCargoService service;

	public TreinamentoSpringApplication(CrudCargoService service) {
		this.service = service;
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
			System.out.println("1 -> ENTRAR NO SISTEMA");

			int action = scanner.nextInt();
			if(action == 1){
				service.iniciar(scanner);
			}else {
				system = false;
			}
		}
	}
}
