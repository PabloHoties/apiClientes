package br.com.cotiinformatica.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class ClientePostRequestDto {

	private String nome;
	private String email;
	private String telefone;
	private UUID planoId;
}
