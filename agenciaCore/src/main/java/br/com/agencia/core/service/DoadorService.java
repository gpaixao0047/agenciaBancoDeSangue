package br.com.agencia.core.service;

import java.util.List;

import br.com.agencia.core.command.DoadorCommand;
import br.com.agencia.core.query.DoadorQuery;
import br.com.agencia.core.query.ImcMedioPorIdadeQuery;
import br.com.agencia.core.query.PorcentagemDeObesosQuery;

public interface DoadorService {

	List<DoadorQuery> cadastrar(List<DoadorCommand> doadorCommand);

	Integer getDoadorPorEstado(String estado);

	List<ImcMedioPorIdadeQuery> getImcMedioPorIdade();

	PorcentagemDeObesosQuery getPercentualObesos(String sexo);

	Integer getIdadeMediaTipoSanguineo(String tipoSanguineo);

	Integer getQutdePossiveisDoadores(String tipoSanguineo);

}
