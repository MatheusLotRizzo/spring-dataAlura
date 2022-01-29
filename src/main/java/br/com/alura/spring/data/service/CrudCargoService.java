package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {

	private Boolean system = true;

	private final CargoRepository cargoRepository;

	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("\nQual ação de cargo deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar Registros");
			System.out.println("4 - Deletar Registros");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				salvar(scanner);
				break;

			case 2:
				atualizar(scanner);
				break;
			
			case 3:
				visualizar();
				break;
			
			case 4:
				deletar(scanner);
				break;

			default:
				system = false;
				break;
			}
		}
		
	}

	private void salvar(Scanner scanner) {
		System.out.println("\nDescricao do cargo");
		String descricao = scanner.next();
		System.out.println("Descrição: " + descricao);
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Cargo Salvo");
	}

	private void atualizar(Scanner scanner) {

		System.out.println("\nId do cargo");
		int id = scanner.nextInt();
		System.out.println("Nova descrição");
		String descricao = scanner.next();

		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Descrição Atualizada");
	}
	
	private void visualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		System.out.println("\n");
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("\nId do cargo a ser deletado");
		int id = scanner.nextInt();
		cargoRepository.deleteById(id);
		System.out.println("Cargo deletado");
	}
}
