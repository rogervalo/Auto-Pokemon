package com.rogelio.mx.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rogelio.mx.models.ContestType;
import com.rogelio.mx.models.Pokemon;

public class PokemonService {
	
	private static PokemonService pokemonService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PokemonService.class);
	
	@SuppressWarnings("unused")
	private void getPokemon() {
	}

	public ArrayList<Pokemon> getPokemones() {
		return new ArrayList<Pokemon>(PokemonClientServices.getInstance().getListPoquedex(0, 0));
	}
	
	public Pokemon getFirstPokemon() {
		return (new ArrayList<Pokemon>(PokemonClientServices.getInstance().getListPoquedex(0, 0))).get(0);
	}
	
	public List<String> getPokemonsContestType() {
		List<ContestType> contestTypeList = new ArrayList<ContestType>(PokemonClientServices.getInstance().getPokemonContestType().getResults());
		List<String> contestTypeNames = new ArrayList<String>();
		for(ContestType contestType : contestTypeList) {
			contestTypeNames.add(contestType.getName());
			LOGGER.info(contestType.getName());
		}
		return contestTypeNames;
	}
	
	
	public static PokemonService getInstance() {
		if(pokemonService == null) {
			pokemonService = new PokemonService();
		}
		return pokemonService;
	}

	

}
