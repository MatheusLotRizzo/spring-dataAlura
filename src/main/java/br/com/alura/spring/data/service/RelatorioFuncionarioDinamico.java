package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.specification.SpecificationFuncionario;

@Service
public class RelatorioFuncionarioDinamico {
	private final FuncionarioRepository funcionariorepository;
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public RelatorioFuncionarioDinamico(FuncionarioRepository funcionariorepository) {
		this.funcionariorepository = funcionariorepository;
	}
	
	public void inicial(Scanner scanner) {
		System.out.println("Digite o nome:");
		String nome = scanner.next();
		
		if(nome.equalsIgnoreCase("NULL")) {
			nome = null;
		}
		
		System.out.println("Digite o cpf:");
		String cpf = scanner.next();
		
		if(cpf.equalsIgnoreCase("NULL")) {
			cpf = null;
		}
		
		System.out.println("Digite o salario:");
		Double salario = scanner.nextDouble();
		if(salario == 0) {
			salario = null;
		}
		
		System.out.println("Digite o data contratação:");
		String data = scanner.next();
		LocalDate dataContratacao = null; //LocalDate.now();
		if(data.equalsIgnoreCase("NULL")) {
			data = null;
		}else {
			dataContratacao = LocalDate.parse(data, formatter);
		}
		
		List<Funcionario> funcionarios = funcionariorepository.findAll(Specification.where
				(SpecificationFuncionario.nome(nome))
				.or(SpecificationFuncionario.cpf(cpf))
				.or(SpecificationFuncionario.salario(salario))
				.or(SpecificationFuncionario.dataContratacao(dataContratacao)));
		
		funcionarios.forEach(System.out::println);
		
	}
}
