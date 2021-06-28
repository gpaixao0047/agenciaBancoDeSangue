package br.com.agencia.core.repository;

import java.util.List;

import br.com.agencia.core.entity.Doador;

public interface DoadorRepository {

	List<Doador> cadastrar(List<Doador> listEntity);

	Integer getDoadorPorEstado(String estado);

	List<Doador> findAll();

	Integer findMaxIdade();

	List<Integer> findImcMedioPorIdade(Integer idadeInicial, Integer idadeFinal);

	Integer findQtdeCadastrados(String sexo);

	Integer findQtdeObesosCadastrados(String sexo);

	Integer findQtdTipoSanguineoCadastrado(String tipoSanguineo);

	List<Integer> findIdadeByTipoSanguineo(String tipoSanguineo);

	Integer findDoadoresTipoAPlus(String tipoSanguineoAPlus, String tipoSanguineoALess, String tipoSanguineoOPlus,
			String tipoSanguineoOLess);

	Integer findDoadoresTipoALess(String tipoSanguineoAPlus, String tipoSanguineoOLess);

	Integer getDoadoresTipoBPlus(String tipoSanguineoBPlus, String tipoSanguineoBLess, String tipoSanguineoOPlus,
			String tipoSanguineoOLess);

	Integer getDoadoresTipoBLess(String tipoSanguineoBLess, String tipoSanguineoOLess);

	Integer getDoadoresTipoABPlus(String tipoSanguineoAPlus, String tipoSanguineoBPlus, String tipoSanguineoOPlus,
			String tipoSanguineoABPlus, String tipoSanguineoALess, String tipoSanguineoBLess, String tipoSanguineoOLess,
			String tipoSanguineoABLess);

	Integer getDdoadoresTipoABLess(String tipoSanguineoALess, String tipoSanguineoBLess, String tipoSanguineoOLess,
			String tipoSanguineoABLess);

	Integer getDoadoresTipoOPlus(String tipoSanguineoOPlus, String tipoSanguineoOLess);

	Integer getDoadorTipoOLess(String tipoSanguineoOLess);

}
