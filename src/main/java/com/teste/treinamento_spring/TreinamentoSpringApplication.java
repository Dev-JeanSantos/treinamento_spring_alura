package com.teste.treinamento_spring;

import com.teste.treinamento_spring.orm.Cargo;
import com.teste.treinamento_spring.repository.CargoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TreinamentoSpringApplication implements CommandLineRunner {


	private final CargoRepository cargoRepository;

	public TreinamentoSpringApplication(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TreinamentoSpringApplication.class,
				args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cargo cargo = new Cargo();
		cargo.setDescricao("Tech Líder");
		cargoRepository.save(cargo);

	}
}
