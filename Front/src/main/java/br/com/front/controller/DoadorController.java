package br.com.front.controller;

import java.util.List;

import br.com.front.bean.ImcMedioPorIdadeBean;
import br.com.front.bean.PorcentagemDeObesosQuery;
import br.com.front.feign.FeignBuilder;
import br.com.front.service.DoadorService;


public class DoadorController {
	private static final DoadorService service = FeignBuilder.getInstanceWithTokenAcess(DoadorService.class);

	public static Integer getCandidatosPorEstado(String estado) throws Exception {
		return service.getCandidatosPorEstados(estado);
	}

	public static List<ImcMedioPorIdadeBean> getImcMedioPorIdades() throws Exception {
		return service.getImcMedioPorIdades();
	}

	public static PorcentagemDeObesosQuery getQtdeObesosPorSexo(String sexo) throws Exception {
		return service.getQtdeObesosPorSexo(sexo);
	}

	public static Integer getMediaIdadePorTipoSanguineo(String tipoSanguineo) throws Exception {
		return service.getMediaIdadePorTipoSanguineo(tipoSanguineo);
	}

	public static Integer getQtdePossiveisDoadores(String tipoSanguineoPossiveisDoadores) {
		return service.getQtdePossiveisDoadores(tipoSanguineoPossiveisDoadores);
	}
}
