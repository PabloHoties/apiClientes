package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Plano>> getAll() throws Exception {

		try {

			PlanoRepository planoRepository = new PlanoRepository();
			List<Plano> planos = planoRepository.findAll();

			if (planos.size() == 0)
				return ResponseEntity.status(204).body(null);

			return ResponseEntity.status(200).body(planos);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<Plano> getById(@PathVariable("id") UUID id) throws Exception {

		try {

			PlanoRepository planoRepository = new PlanoRepository();
			Plano plano = planoRepository.findById(id);

			if (plano == null)
				return ResponseEntity.status(204).body(null);

			return ResponseEntity.status(200).body(plano);
			
		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}

	}
}
