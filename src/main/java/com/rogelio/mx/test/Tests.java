package com.rogelio.mx.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.testng.annotations.Test;

import com.rogelio.mx.service.PokemonService;

import static com.rogelio.mx.constants.ContestTypeConstants.CONTEST_TYPES;

public class Tests {
	
	
	
	@Test(description = "R001: The user should be able to see all the pokemons on the first page results on pokedex")
	public void testOne() {
		assertThat(PokemonService.getInstance()
				.getPokemones())
				.isNotEmpty();
	}
	
	@Test(description = "R002: The user should be able to identify the name of the first pokemon")
	public void test002() {
		assertThat(PokemonService.getInstance()
				.getFirstPokemon().getName().toString()).as("Name Pokemon is not equals").isEqualTo("spearow");
	}
	
	
	@Test(description = "R002: The user should be able to identify all the pokemons contest type")
	public void test003() {
		List<String> contestType = PokemonService.getInstance().getPokemonsContestType();
		Assertions.assertThat(contestType.containsAll(Arrays.asList(CONTEST_TYPES))).as("contest type list is not equals").isTrue();
	}
	

}
