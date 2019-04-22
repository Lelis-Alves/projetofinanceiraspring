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

	public Emprestimo buscar(Long codigo) {
		Optional<Emprestimo> obj = emprestimoRepo.findById(codigo);
		return obj.orElse(null);
	}

	public List<Emprestimo> listar() {
		return emprestimoRepo.findAll();
	}

	public Emprestimo insert(Emprestimo obj) {
		obj.setCodigo(null);
		return emprestimoRepo.save(obj);
	}

	public Emprestimo update(Emprestimo obj) {
		buscar(obj.getCodigo());
		return emprestimoRepo.save(obj);
	}

	public void delete(Long codigo) {
		buscar(codigo);
		emprestimoRepo.deleteById(codigo);
	}

}
