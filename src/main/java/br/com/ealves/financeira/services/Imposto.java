package br.com.ealves.financeira.services;

import br.com.ealves.financeira.model.Emprestimo;
import br.com.ealves.financeira.model.TipoRisco;

public interface Imposto {
	
	double calcula(Emprestimo emprestimo, TipoRisco tipo);

}
