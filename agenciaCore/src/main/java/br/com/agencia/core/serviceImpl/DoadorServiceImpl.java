package br.com.agencia.core.serviceImpl;

import static br.com.agencia.core.factory.DoadorFactory.makeListDoadorCommandToListEntity;
import static br.com.agencia.core.factory.DoadorFactory.makeListDoadorEntityToListDoadorQuery;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agencia.core.command.DoadorCommand;
import br.com.agencia.core.entity.Doador;
import br.com.agencia.core.query.DoadorQuery;
import br.com.agencia.core.query.ImcMedioPorIdadeQuery;
import br.com.agencia.core.query.PorcentagemDeObesosQuery;
import br.com.agencia.core.repository.DoadorRepository;
import br.com.agencia.core.service.DoadorService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class DoadorServiceImpl implements DoadorService {

	private final DoadorRepository repository;
	private final String tipoSanguineoAPlus = "A+";
	private final String tipoSanguineoALess = "A-";
	private final String tipoSanguineoBPlus ="B+";
	private final String tipoSanguineoBLess ="B-";
	private final String tipoSanguineoABPlus ="AB+";
	private final String tipoSanguineoABLess ="AB-";
	private final String tipoSanguineoOPlus ="O+";
	private final String tipoSanguineoOLess ="O-";

	@Override
	public List<DoadorQuery> cadastrar(List<DoadorCommand> doadorCommand) {
		List<Doador> listEntity = makeListDoadorCommandToListEntity(doadorCommand);
		listEntity = setIdadeAndImc(listEntity);
		listEntity = repository.cadastrar(listEntity);
		return makeListDoadorEntityToListDoadorQuery(listEntity);
	}

	private List<Doador> setIdadeAndImc(List<Doador> listDoadorEntity) {
		LocalDate dataAtual = LocalDate.now();
		for (Doador doador : listDoadorEntity) {
			Double imc = doador.getPeso() / (doador.getAltura() * 2);
			doador.setIdade(dataAtual.getYear() - doador.getDataNasc().getYear());
			doador.setImc((double) imc.longValue());
		}
		return listDoadorEntity;
	}

	@Override
	public Integer getDoadorPorEstado(String estado) {
		return repository.getDoadorPorEstado(estado.toUpperCase());
	}

	@Override
	public List<ImcMedioPorIdadeQuery> getImcMedioPorIdade() {
		Integer maxIdadeCadastrado = repository.findMaxIdade();
		return separandoIdades(maxIdadeCadastrado + 10);
	}

	private List<ImcMedioPorIdadeQuery> separandoIdades(Integer maxIdadeCadastrado) {
		List<ImcMedioPorIdadeQuery> imcMedioPorIdadeQuery = new ArrayList<ImcMedioPorIdadeQuery>();
		Integer idadeInicial = 0;
		Integer idadeFinal = 10;
		for (int i = 0; i <= maxIdadeCadastrado; i++) {
			List<Integer> imcs = repository.findImcMedioPorIdade(idadeInicial, idadeFinal);
			if (!imcs.isEmpty()) {
				Integer mediaImc = calculandoMediaImc(imcs);
				String faixeDeIdade = "IMC médio na faixa de idade " + idadeInicial + " anos, até " + idadeFinal
						+ " anos";
				imcMedioPorIdadeQuery.add(new ImcMedioPorIdadeQuery(faixeDeIdade, mediaImc));
			}

			idadeInicial = idadeFinal + 1;
			idadeFinal = idadeFinal + 10;
			i = idadeFinal;

		}
		return imcMedioPorIdadeQuery;
	}

	private Integer calculandoMediaImc(List<Integer> imcs) {
		Integer totalImcs = 0;
		for (Integer imc : imcs) {
			totalImcs = totalImcs + imc;
		}
		return totalImcs / imcs.size();
	}

	@Override
	public PorcentagemDeObesosQuery getPercentualObesos(String sexo) {
		Integer qtdeCadastrados = repository.findQtdeCadastrados(sexo);
		Integer qtdeObesos = repository.findQtdeObesosCadastrados(sexo);
		float resultado = (float) qtdeObesos / qtdeCadastrados;
		DecimalFormat formatador = new DecimalFormat("0.00");
		String resultFinal = formatador.format(resultado) + "%";
		PorcentagemDeObesosQuery porcentagemObesosQuery = new PorcentagemDeObesosQuery(resultFinal);
		return porcentagemObesosQuery;
	}

	@Override
	public Integer getIdadeMediaTipoSanguineo(String tipoSanguineo) {
		Integer qtdeCadastrado = repository.findQtdTipoSanguineoCadastrado(tipoSanguineo);
		List<Integer> listIdades = repository.findIdadeByTipoSanguineo(tipoSanguineo);
		Integer somaIdades = somaIdades(listIdades);
		Integer media =somaIdades/qtdeCadastrado;
		return media;
	}
	
	private Integer somaIdades(List<Integer> listIdades) {
		Integer totalIdades = 0;
		for(Integer idade : listIdades) {
			totalIdades = totalIdades + idade;
		}
		return totalIdades;
	}

	@Override
	public Integer getQutdePossiveisDoadores(String tipoSanguineo) {
		if(tipoSanguineo.equals("A+")) {
			return repository.findDoadoresTipoAPlus(tipoSanguineoAPlus,tipoSanguineoALess,tipoSanguineoOPlus,tipoSanguineoOLess);
		}if(tipoSanguineo.equals("A-")) {
			return repository.findDoadoresTipoALess(tipoSanguineoAPlus, tipoSanguineoOLess);
		}if(tipoSanguineo.equals("B+")) {
			return repository.getDoadoresTipoBPlus(tipoSanguineoBPlus,tipoSanguineoBLess,tipoSanguineoOPlus,tipoSanguineoOLess);
		}if(tipoSanguineo.equals("B-")) {
			return repository.getDoadoresTipoBLess(tipoSanguineoBLess,tipoSanguineoOLess);
		}if(tipoSanguineo.equals("AB+")) {
			return repository.getDoadoresTipoABPlus(tipoSanguineoAPlus,tipoSanguineoBPlus,tipoSanguineoOPlus,tipoSanguineoABPlus,tipoSanguineoALess,tipoSanguineoBLess,tipoSanguineoOLess,tipoSanguineoABLess);
		}if(tipoSanguineo.equals("AB-")) {
			return repository.getDdoadoresTipoABLess(tipoSanguineoALess,tipoSanguineoBLess,tipoSanguineoOLess,tipoSanguineoABLess);
		}if(tipoSanguineo.equals("O+")) {
			return repository.getDoadoresTipoOPlus(tipoSanguineoOPlus,tipoSanguineoOLess);
		}else {
			return repository.getDoadorTipoOLess(tipoSanguineoOLess);
		}
		
		
	}
	

}
