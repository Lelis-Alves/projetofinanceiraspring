package br.com.ealves.financeira.services;

import br.com.ealves.financeira.model.Emprestimo;
import br.com.ealves.financeira.model.TipoRisco;

public class TaxaDeJuros implements Imposto {

	private TipoRisco tipo;

	@Override
	public double calcula(Emprestimo emprestimo, TipoRisco tipo) {
		double valor = 0;

		if (TipoRisco.A.equals(tipo)) {
			return emprestimo.getLimiteCredito() * 0;
		}

		if (TipoRisco.B.equals(tipo)) {
			return emprestimo.getLimiteCredito() * 0.10;
		}

		if (TipoRisco.C.equals(tipo)) {
			return emprestimo.getLimiteCredito() * 0.20;
		}
		return valor;
		
	}

}
