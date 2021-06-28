package br.com.agencia.core.factory;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.agencia.core.command.DoadorCommand;
import br.com.agencia.core.entity.Doador;
import br.com.agencia.core.query.DoadorQuery;

public class DoadorFactory {
	private DoadorFactory() {
	}
	
	public static Doador makeDoadorCommandToEntity(DoadorCommand doadorCommand) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(doadorCommand, Doador.class);
	}
	
	public static DoadorQuery makeDoadorEntityToQuery(Doador doadorEntity) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(doadorEntity, DoadorQuery.class);
	}
	
	public static List<DoadorQuery> makeListDoadorEntityToListDoadorQuery(List<Doador> listDoadorEntity){
		return listDoadorEntity.stream()
				.map(DoadorFactory::makeDoadorEntityToQuery)
				.collect(toList());
	}
	
	public static List<Doador> makeListDoadorCommandToListEntity(List<DoadorCommand> listDoadorCommand){
		return listDoadorCommand.stream()
				.map(DoadorFactory::makeDoadorCommandToEntity)
				.collect(toList());
	}
}
