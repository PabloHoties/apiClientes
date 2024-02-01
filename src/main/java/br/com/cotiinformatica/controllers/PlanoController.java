package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.entities.Plano;
import br.com.cotiinformatica.repositories.PlanoRepository;

@RestController
@RequestMapping(value = "/api/planos")
public class PlanoController {

	@GetMapping()
	public List<Plano> getAll() throws Exception {
		
		PlanoRepository planoRepository = new PlanoRepository();
		return planoRepository.findAll();
	}

	@GetMapping("{id}")
	public Plano getById(@PathVariable("id") UUID id) throws Exception {
		
		PlanoRepository planoRepository = new PlanoRepository();
		return planoRepository.findById(id);
	}
}
