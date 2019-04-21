package br.com.ealves.financeira.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ealves.financeira.model.Emprestimo;
import br.com.ealves.financeira.services.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoResource {
	
	@Autowired
	private EmprestimoService emprestimoService;
	
	@GetMapping
	public ResponseEntity<List<Emprestimo>> findAll() {
		List<Emprestimo> list = emprestimoService.listar();
		return ResponseEntity.ok().body(list);
	}
	
	
	
	
	
	
	
	

}
