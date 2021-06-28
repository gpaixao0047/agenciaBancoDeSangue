package br.com.agencia.core.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agencia.core.command.DoadorCommand;
import br.com.agencia.core.query.DoadorQuery;
import br.com.agencia.core.query.ImcMedioPorIdadeQuery;
import br.com.agencia.core.query.PorcentagemDeObesosQuery;
import br.com.agencia.core.service.DoadorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/doador")
@RequiredArgsConstructor
public class DoadorController {

	private final DoadorService service;
	
	@PostMapping
	@Transactional
	public ResponseEntity<List<DoadorQuery>> cadastrar (@RequestBody List<DoadorCommand> doadorCommand){
		List<DoadorQuery> doadorQuery = service.cadastrar(doadorCommand);
		return ok(doadorQuery);
	}
	
	@GetMapping("/getDoadorPorEstado/{estado}")
	@Transactional
	public ResponseEntity<Integer> getDoadorPorEstado (@PathVariable String estado){
		Integer doadoresPorEstado = service.getDoadorPorEstado(estado);
		return ok(doadoresPorEstado);
	}
	
	@GetMapping("/icmMedioPorIdade")
	@Transactional
	public ResponseEntity<List<ImcMedioPorIdadeQuery>> getIcmMedioPorIdade(){
		List<ImcMedioPorIdadeQuery>icmMedioPorIdadeQuery = service.getImcMedioPorIdade();
		return ok(icmMedioPorIdadeQuery);
	}
	
	@GetMapping("/getPercentualObesos/{sexo}")
	@Transactional
	public ResponseEntity<PorcentagemDeObesosQuery> getPercentualObesos(@PathVariable String sexo){
		PorcentagemDeObesosQuery result = service.getPercentualObesos(sexo);
		return ok(result);
	}
	
	@GetMapping("/getIdadeMediaTipoSanguineo/{tipoSanguineo}")
	@Transactional
	public ResponseEntity<Integer> getIdadeMediaTipoSanguineo(@PathVariable String tipoSanguineo){
		Integer result = service.getIdadeMediaTipoSanguineo(tipoSanguineo);
		return ok(result);
	}
	
	@GetMapping("/getQtdePossiveisDoadores/{tipoSanguineo}")
	@Transactional
	public ResponseEntity<Integer> getQutdePossiveisDoadores(@PathVariable String tipoSanguineo){
		Integer result = service.getQutdePossiveisDoadores(tipoSanguineo);
		return ok(result);
	}
}
