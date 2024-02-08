package br.com.cotiinformatica.dtos;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientePostRequestDto {

	@Size(min = 8, max = 100, message = "Por favor, informe um nome de 8 a 100 caracteres.")
	@NotBlank(message = "Por favor, informe o nome do cliente.")
	private String nome;

	@Email(message = "Por favor, informe um endereço de email válido.")
	@NotBlank(message = "Por favor, informe o email do cliente.")
	private String email;

	@Pattern(regexp = "\\(\\d{2}\\)\\s\\d{5}-\\d{4}",
			message = "Por favor, informe o telefone no formato: '(99) 99999-9999'.")
	@NotBlank(message = "Por favor, informe o telefone do cliente.")
	private String telefone;

	@NotNull(message = "Por favor, informe o ID do cliente.")
	private UUID planoId;
}
