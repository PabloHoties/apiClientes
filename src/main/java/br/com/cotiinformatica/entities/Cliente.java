package br.com.cotiinformatica.entities;

import java.util.UUID;

import lombok.Data;

@Data
public class Cliente {

	private UUID id;
	private String nome;
	private String email;
	private String telefone;
	private Plano plano;

}
