package br.com.front.service;

import java.util.List;

import br.com.front.bean.ImcMedioPorIdadeBean;
import br.com.front.bean.PorcentagemDeObesosQuery;
import feign.Param;
import feign.RequestLine;

public interface DoadorService {

	@RequestLine("GET /doador/getDoadorPorEstado/{estado}")
	Integer getCandidatosPorEstados(@Param("estado")String estado) throws Exception;

	@RequestLine("GET /doador/getIcmMedioPorIdade")
	List<ImcMedioPorIdadeBean> getImcMedioPorIdades()throws Exception;

	@RequestLine("GET /doador/getPercentualObesos/{sexo}")
	PorcentagemDeObesosQuery getQtdeObesosPorSexo(@Param("sexo")String sexo)throws Exception;

	@RequestLine("GET /doador/getIdadeMediaTipoSanguineo/{tipoSanguineo}")
	Integer getMediaIdadePorTipoSanguineo(@Param("tipoSanguineo")String tipoSanguineo)throws Exception;

	@RequestLine("GET /doador/getQtdePossiveisDoadores/{tipoSanguineo}")
	Integer getQtdePossiveisDoadores(@Param("tipoSanguineo")String tipoSanguineoPossiveisDoadores);

}
