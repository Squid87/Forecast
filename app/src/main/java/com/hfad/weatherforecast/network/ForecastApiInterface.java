package com.hfad.weatherforecast.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Илья on 30.10.2016.
 */

public interface ForecastApiInterface {

	@GET()
	Call<com.hfad.weatherforecast.model.ForecastResponse> getForecasts(@Query("city") String city);
}
