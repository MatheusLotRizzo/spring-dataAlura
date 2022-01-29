package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeTrabalhoService;
import br.com.alura.spring.data.service.RelatorioFuncionarioDinamico;
import br.com.alura.spring.data.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Boolean system = true;

	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcService;
	private final CrudUnidadeTrabalhoService unidadeService;
	private final RelatoriosService relService;
	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;
	
	public SpringDataApplication(CrudCargoService cargoService, 
			CrudFuncionarioService funcService,
			CrudUnidadeTrabalhoService unidadeService,
			RelatoriosService relService,
			RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
		this.cargoService = cargoService;
		this.funcService = funcService;
		this.unidadeService = unidadeService;
		this.relService = relService;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("\nQual a ação que deseja fazer?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargos");
			System.out.println("2 - Unidade de Trabalho");
			System.out.println("3 - Funcionário");
			System.out.println("4 - Relatórios");
			System.out.println("5 - Relatórios Dinamicos");

			int action = scanner.nextInt();

			if (action == 1) {
				cargoService.inicial(scanner);
			} else if (action == 2) {
				unidadeService.inicial(scanner);
			} else if (action == 3) {
				funcService.inicial(scanner);
			}else if (action == 4) {
				relService.inicial(scanner);
			}else if (action == 5) {
				relatorioFuncionarioDinamico.inicial(scanner);
			} else {
				system = false;
			}

		}
	}
}
