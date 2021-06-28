package br.com.front.view.doador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.front.bean.DoadorBean;
import br.com.front.bean.ImcMedioPorIdadeBean;
import br.com.front.bean.PorcentagemDeObesosQuery;
import br.com.front.controller.DoadorController;
import lombok.Data;

@SuppressWarnings("deprecation")
@SessionScoped
@ManagedBean(name = "doadorCrudView")
@Data
public class DoadorCrudView extends DoadorBean {
	private String estadoSelecionado;
	private String sexoSelecionado;
	private String totalDeObesosPorSexo;
	private Integer resultadoMediaTipoSanguineo;
	private Integer totalCandidatosPorEstado;
	private String tipoSanguineo;
	private String tipoSanguineoPossiveisDoadoresParaCadTipo;
	private Integer resultadoPossiveisDoadores;
	private List<ImcMedioPorIdadeBean> imcMedioPorIdadeList;
	private PorcentagemDeObesosQuery porcentagemDeObesos;

	@PostConstruct
	private void init() {
		try {
			imcMedioPorIdadeList = DoadorController.getImcMedioPorIdades();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void getCandidatosPorEstado() throws Exception {
		if (!estadoSelecionado.equals("VAZIO")) {
			totalCandidatosPorEstado = DoadorController.getCandidatosPorEstado(estadoSelecionado);
		}
	}

	public void getQtdeObesosPorSexo() throws Exception {
		if (!sexoSelecionado.equals("VAZIO")) {
			porcentagemDeObesos = DoadorController.getQtdeObesosPorSexo(sexoSelecionado);
		}

	}

	public void getTipoSanguineoPossiveisDoadores() throws Exception {
		if (!tipoSanguineo.equals("VAZIO")) {
			resultadoMediaTipoSanguineo = DoadorController.getMediaIdadePorTipoSanguineo(tipoSanguineo);
		}

	}

	public void getQtdePossiveisDoadores() {
		if (!tipoSanguineoPossiveisDoadoresParaCadTipo.equals("VAZIO")) {
			resultadoPossiveisDoadores = DoadorController
					.getQtdePossiveisDoadores(tipoSanguineoPossiveisDoadoresParaCadTipo);
		}

	}
}
