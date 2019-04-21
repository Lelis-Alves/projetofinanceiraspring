package br.com.ealves.financeira.services;

import br.com.ealves.financeira.model.Emprestimo;
import br.com.ealves.financeira.model.TipoRisco;

public class CalculadorDeImpostos {
	
	public void realizaCalculoTaxaDeJuros(Emprestimo emprestimo, TipoRisco tipo, Imposto impostQualquer) {
			double taxaDeJuros = impostQualquer.calcula(emprestimo, tipo);
			System.out.println("taxa Juros: " + taxaDeJuros);	
		}
		
	


}
