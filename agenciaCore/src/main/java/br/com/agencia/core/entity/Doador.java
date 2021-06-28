package br.com.agencia.core.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = @Builder)
@Entity
@SequenceGenerator(name = "SEQ_DOADOR", allocationSize = 1)
public class Doador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DOADOR")
	private Integer idDoador;
	private String nome;
	private String cpf;
	private String rg;
	@Column(name = "data_nascimento")
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
	private String tipoSanguineo;
	private Integer idade;
	private Double imc;
}
