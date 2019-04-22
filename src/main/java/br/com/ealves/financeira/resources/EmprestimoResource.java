package br.com.ealves.financeira.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ResponseEntity<Emprestimo> find(@PathVariable Long id) {
		Emprestimo obj = emprestimoService.buscar(id);
		return obj != null ? ResponseEntity.ok().body(obj) : ResponseEntity.notFound().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Emprestimo obj) {
		obj = emprestimoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}").buildAndExpand(obj.getCodigo())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Emprestimo obj, @PathVariable Long codigo) {
		obj.setCodigo(codigo);
		obj = emprestimoService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long codigo) {
		emprestimoService.delete(codigo);
		return ResponseEntity.noContent().build();
	}

}
