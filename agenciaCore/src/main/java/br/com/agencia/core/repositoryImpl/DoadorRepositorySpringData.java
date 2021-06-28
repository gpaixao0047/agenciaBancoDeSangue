package br.com.agencia.core.repositoryImpl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import br.com.agencia.core.entity.Doador;

public interface DoadorRepositorySpringData extends JpaRepository<Doador, Integer>, JpaSpecificationExecutor<Doador>{

	@Query("SELECT COUNT(*) FROM Doador WHERE estado = ?1")
	Integer getDoadorPorEstado(String estado);

	@Query("SELECT MAX(idade) FROM Doador")
	Integer findMaxIdade();
	
	@Query("SELECT imc FROM Doador WHERE idade >= ?1 AND idade <=?2")
	List<Integer> findImcMedioPorIdade(Integer idadeInicial, Integer idadeFinal);

	@Query("SELECT COUNT(*) FROM Doador WHERE sexo = ?1")
	Integer findQtdeCadastrados(String sexo);

	@Query("SELECT COUNT(*) FROM Doador WHERE sexo =?1 AND imc > 30")
	Integer findQtdeObesosCadastrados(String sexo);

	@Query("SELECT COUNT(*) FROM Doador WHERE tipoSanguineo = ?1")
	Integer findQtdTipoSanguineoCadastrado(String tipoSanguineo);

	@Query("SELECT idade FROM Doador WHERE tipoSanguineo = ?1")
	List<Integer> findIdadeByTipoSanguineo(String tipoSanguineo);

	@Query("SELECT COUNT(*) FROM Doador WHERE tipoSanguineo = ?1 OR tipoSanguineo = ?2 OR tipoSanguineo = ?3 OR tipoSanguineo =?4 "
			+ " AND idade >16 AND idade < 69 AND peso > 50")
	Integer findDoadoresTipoAPlus(String tipoSanguineoAPlus, String tipoSanguineoALess, String tipoSanguineoOPlus,
			String tipoSanguineoOLess);

	@Query("SELECT COUNT(*) FROM Doador WHERE tipoSanguineo = ?1 OR tipoSanguineo = ?2 AND idade >16 AND idade < 69 AND peso > 50")
	Integer findDoadoresTipoALess(String tipoSanguineoAPlus, String tipoSanguineoOLess);

	@Query("SELECT COUNT(*) FROM Doador WHERE tipoSanguineo = ?1 OR tipoSanguineo = ?2 OR tipoSanguineo = ?3 OR tipoSanguineo = ?4 AND idade >16 AND idade < 69 AND peso > 50")
	Integer getDoadoresTipoBPlus(String tipoSanguineoBPlus, String tipoSanguineoBLess, String tipoSanguineoOPlus,
			String tipoSanguineoOLess);

	@Query("SELECT COUNT(*) FROM Doador WHERE tipoSanguineo = ?1 OR tipoSanguineo = ?2 AND idade >16 AND idade < 69 AND peso > 50")
	Integer getDoadoresTipoBLess(String tipoSanguineoBLess, String tipoSanguineoOLess);

	@Query("SELECT COUNT(*) FROM Doador WHERE tipoSanguineo = ?1 OR tipoSanguineo = ?2 OR tipoSanguineo = ?3 OR tipoSanguineo = ?4 "
			+ " OR tipoSanguineo = ?5 OR tipoSanguineo = ?6 OR tipoSanguineo = ?7 OR tipoSanguineo = ?8   AND idade >16 AND idade < 69 AND peso > 50")
	Integer getDoadoresTipoABPlus(String tipoSanguineoAPlus, String tipoSanguineoBPlus, String tipoSanguineoOPlus,
			String tipoSanguineoABPlus, String tipoSanguineoALess, String tipoSanguineoBLess, String tipoSanguineoOLess,
			String tipoSanguineoABLess);

	@Query("SELECT COUNT(*) FROM Doador WHERE tipoSanguineo = ?1 OR tipoSanguineo = ?2 OR tipoSanguineo = ?3 OR tipoSanguineo =?4 "
			+ " AND idade >16 AND idade < 69 AND peso > 50")
	Integer getDdoadoresTipoABLess(String tipoSanguineoALess, String tipoSanguineoBLess, String tipoSanguineoOLess,
			String tipoSanguineoABLess);

	@Query("SELECT COUNT(*) FROM Doador WHERE tipoSanguineo = ?1 OR tipoSanguineo = ?2 AND idade >16 AND idade < 69 AND peso > 50")
	Integer getDoadoresTipoOPlus(String tipoSanguineoOPlus, String tipoSanguineoOLess);

	@Query("SELECT COUNT(*) FROM Doador WHERE tipoSanguineo = ?1 AND idade >16 AND idade < 69 AND peso > 50")
	Integer getDoadorTipoOLess(String tipoSanguineoOLess);

}
