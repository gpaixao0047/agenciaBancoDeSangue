package br.com.agencia.core.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = @Builder)
public class ImcMedioPorIdadeQuery {
	
	private String faixeDeIdade;
	private Integer mediaImc;
}
