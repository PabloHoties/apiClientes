package br.com.cotiinformatica.entities;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class Plano {

	private UUID id;
	private String nome;
	private List<Cliente> clientes;

}
