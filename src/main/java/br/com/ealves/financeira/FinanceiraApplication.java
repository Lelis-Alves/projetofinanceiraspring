package br.com.ealves.financeira;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ealves.financeira.model.Emprestimo;
import br.com.ealves.financeira.model.TipoRisco;
import br.com.ealves.financeira.repositories.EmprestimoRepository;
import br.com.ealves.financeira.services.CalculadorDeImpostos;
import br.com.ealves.financeira.services.TaxaDeJuros;

@SpringBootApplication
public class FinanceiraApplication implements CommandLineRunner {

	@Autowired
	private EmprestimoRepository emprestimoRepo;

	public static void main(String[] args) {
		SpringApplication.run(FinanceiraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		TaxaDeJuros taxaDeJuros = new TaxaDeJuros();
		
		
		Emprestimo emprestimo = new Emprestimo(null, "João", 1000, TipoRisco.A);
		Emprestimo emprestimo1 = new Emprestimo(null, "Maria",2000 , TipoRisco.B);
		Emprestimo emprestimo2 = new Emprestimo(null, "Jose", 3000, TipoRisco.C);
		
		
		CalculadorDeImpostos calculador = new CalculadorDeImpostos();	
		calculador.realizaCalculoTaxaDeJuros(emprestimo1, TipoRisco.B, taxaDeJuros);		
		
		emprestimoRepo.saveAll(Arrays.asList(emprestimo, emprestimo1, emprestimo2));

	}

}
