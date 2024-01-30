package br.com.cotiinformatica.entities;

import java.util.List;
import java.util.UUID;

public class Plano {

	private UUID id;
	private String nome;
	private List<Cliente> clientes;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
