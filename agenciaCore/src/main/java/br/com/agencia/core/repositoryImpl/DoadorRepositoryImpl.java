package br.com.agencia.core.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.agencia.core.entity.Doador;
import br.com.agencia.core.repository.DoadorRepository;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor(onConstructor_ = @Autowired)
public class DoadorRepositoryImpl implements DoadorRepository {
	
	private final DoadorRepositorySpringData repositorySpringData;
	
	@Override
	public List<Doador> cadastrar(List<Doador> listEntity) {
		return repositorySpringData.saveAll(listEntity);
	}

	@Override
	public Integer getDoadorPorEstado(String estado) {
		return repositorySpringData.getDoadorPorEstado(estado);
	}

	@Override
	public List<Doador> findAll() {
		return repositorySpringData.findAll();
	}

	@Override
	public Integer findMaxIdade() {
		return repositorySpringData.findMaxIdade();
	}

	@Override
	public List<Integer> findImcMedioPorIdade(Integer idadeInicial, Integer idadeFinal) {
		return repositorySpringData.findImcMedioPorIdade(idadeInicial,idadeFinal);
	}

	@Override
	public Integer findQtdeCadastrados(String sexo) {
		return repositorySpringData.findQtdeCadastrados(sexo);
	}

	@Override
	public Integer findQtdeObesosCadastrados(String sexo) {
		return repositorySpringData.findQtdeObesosCadastrados(sexo);
	}

	@Override
	public Integer findQtdTipoSanguineoCadastrado(String tipoSanguineo) {
		return repositorySpringData.findQtdTipoSanguineoCadastrado(tipoSanguineo);
	}

	@Override
	public List<Integer> findIdadeByTipoSanguineo(String tipoSanguineo) {
		return repositorySpringData.findIdadeByTipoSanguineo(tipoSanguineo);
	}

	@Override
	public Integer findDoadoresTipoAPlus(String tipoSanguineoAPlus, String tipoSanguineoALess,
			String tipoSanguineoOPlus, String tipoSanguineoOLess) {
		return repositorySpringData.findDoadoresTipoAPlus(tipoSanguineoAPlus,tipoSanguineoALess,tipoSanguineoOPlus,tipoSanguineoOLess);
	}

	@Override
	public Integer findDoadoresTipoALess(String tipoSanguineoAPlus, String tipoSanguineoOLess) {
		return repositorySpringData.findDoadoresTipoALess(tipoSanguineoAPlus,tipoSanguineoOLess);
	}

	@Override
	public Integer getDoadoresTipoBPlus(String tipoSanguineoBPlus, String tipoSanguineoBLess, String tipoSanguineoOPlus,
			String tipoSanguineoOLess) {
		return repositorySpringData.getDoadoresTipoBPlus(tipoSanguineoBPlus,tipoSanguineoBLess,tipoSanguineoOPlus,tipoSanguineoOLess);
	}

	@Override
	public Integer getDoadoresTipoBLess(String tipoSanguineoBLess, String tipoSanguineoOLess) {
		return repositorySpringData.getDoadoresTipoBLess(tipoSanguineoBLess,tipoSanguineoOLess);
	}

	@Override
	public Integer getDoadoresTipoABPlus(String tipoSanguineoAPlus, String tipoSanguineoBPlus,
			String tipoSanguineoOPlus, String tipoSanguineoABPlus, String tipoSanguineoALess, String tipoSanguineoBLess,
			String tipoSanguineoOLess, String tipoSanguineoABLess) {
		return repositorySpringData.getDoadoresTipoABPlus(tipoSanguineoAPlus,tipoSanguineoBPlus,tipoSanguineoOPlus,tipoSanguineoABPlus,tipoSanguineoALess,tipoSanguineoBLess,tipoSanguineoOLess,tipoSanguineoABLess);
	}

	@Override
	public Integer getDdoadoresTipoABLess(String tipoSanguineoALess, String tipoSanguineoBLess,
			String tipoSanguineoOLess, String tipoSanguineoABLess) {
		return repositorySpringData.getDdoadoresTipoABLess(tipoSanguineoALess,tipoSanguineoBLess,tipoSanguineoOLess,tipoSanguineoABLess);
	}

	@Override
	public Integer getDoadoresTipoOPlus(String tipoSanguineoOPlus, String tipoSanguineoOLess) {
		return repositorySpringData.getDoadoresTipoOPlus(tipoSanguineoOPlus,tipoSanguineoOLess);
	}

	@Override
	public Integer getDoadorTipoOLess(String tipoSanguineoOLess) {
		return repositorySpringData.getDoadorTipoOLess(tipoSanguineoOLess);
	}

}
