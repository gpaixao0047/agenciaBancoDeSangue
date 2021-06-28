package br.com.front.bean;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DoadorBean {
	private Integer idDoador;
	private String nome;
	private String cpf;
	private String rg;
	private LocalDate dataNasc;
	private String sexo;
	private String mae;
	private String pai;
	private String email;
	private String cep;
	private String endereco;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefoneFixo;
	private String celular;
	private double altura;
	private Integer peso;
	private Integer idade;
	private Double imc;
}
