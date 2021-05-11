package com.rogelio.mx.client;

import java.util.Collection;

import com.rogelio.mx.models.ContestTypeResult;
import com.rogelio.mx.models.PokemonResults;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokemonRepository {
	
	
	@GET("pokemon")
	Call<PokemonResults> getPokemonList(@Query("offset") int offset, @Query("limit")Integer limit);

	@GET("contest-type")
	Call<ContestTypeResult> getContestType();
	

}
