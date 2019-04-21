package br.com.ealves.financeira.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ealves.financeira.model.Emprestimo;
import br.com.ealves.financeira.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository emprestimoRepo;
	
	public Emprestimo buscar(Long id) {
		Optional<Emprestimo> obj = emprestimoRepo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Emprestimo> listar() {
		return emprestimoRepo.findAll();
	}
	

}
