package com.rogelio.mx.service;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rogelio.mx.client.PokemonRepository;
import com.rogelio.mx.models.ContestTypeResult;
import com.rogelio.mx.models.Pokemon;
import com.rogelio.mx.models.PokemonResults;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.rogelio.mx.constants.TimeOutConstants.TIMEOUT_FIVE_SECONDS;
import static com.rogelio.mx.constants.ApiConstants.API_BASE_URL;

public class PokemonClientServices {

	private static final Logger LOGGER = LoggerFactory.getLogger(PokemonClientServices.class);

	private Retrofit pokemonRepository;

	private Collection<Pokemon> pokemonList = null;
	private ContestTypeResult contestTypeResult = null;
	

	private static PokemonClientServices pokemonClientServices;

	private PokemonClientServices() {
		try {
			pokemonRepository = new Retrofit.Builder().baseUrl(API_BASE_URL)
					.addConverterFactory(GsonConverterFactory.create())
					.client(new OkHttpClient.Builder().connectTimeout(TIMEOUT_FIVE_SECONDS, TimeUnit.SECONDS)
							.readTimeout(TIMEOUT_FIVE_SECONDS, TimeUnit.SECONDS)
							.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
							.build())
					.build();
			// .create(PockemonClientService.class);
		} catch (Exception e) {
			LOGGER.error("Could not create the service", e);
		}
	}

	public Collection<Pokemon> getListPoquedex(int offset, int limit) {
		if(offset < 1 || limit < 1) {
			offset = 20;
			limit = 20;
		}
		PokemonRepository jgsonPlaceHolderApi = pokemonRepository.create(PokemonRepository.class);
		Call<PokemonResults> call = jgsonPlaceHolderApi.getPokemonList(offset, limit);
		call.enqueue(new Callback<PokemonResults>() {
			@Override
			public void onResponse(Call<PokemonResults> call, Response<PokemonResults> response) {
				// TODO Auto-generated method stub
				if (!response.isSuccessful()) {
					LOGGER.error("Codigo Respuesta: ", response.code());
					return;
				} else {
					pokemonList = response.body().getPokemonesList();
				}
			}

			@Override
			public void onFailure(Call<PokemonResults> call, Throwable t) {
				LOGGER.error("Erro : ", t.getMessage());

			}
		});
		try {
			new Thread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pokemonList;
	}
	
	

	public static PokemonClientServices getInstance() {
		if (pokemonClientServices == null) {
			pokemonClientServices = new PokemonClientServices();
		}
		return pokemonClientServices;
	}

	public ContestTypeResult getPokemonContestType() {
		PokemonRepository jgsonPlaceHolderApi = pokemonRepository.create(PokemonRepository.class);
		Call<ContestTypeResult> call = jgsonPlaceHolderApi.getContestType();
		call.enqueue(new Callback<ContestTypeResult>() {
			@Override
			public void onResponse(Call<ContestTypeResult> call, Response<ContestTypeResult> response) {
				// TODO Auto-generated method stub
				if (!response.isSuccessful()) {
					LOGGER.error("Codigo Respuesta: ", response.code());
					return;
				} else {
					contestTypeResult = response.body();
				}
			}

			@Override
			public void onFailure(Call<ContestTypeResult> call, Throwable t) {
				LOGGER.error("Erro : ", t.getMessage());

			}
		});
		try {
			new Thread().sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contestTypeResult;
	}
	
}
