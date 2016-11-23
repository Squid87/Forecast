package com.hfad.weatherforecast.network;

import com.hfad.weatherforecast.model.City;
import com.hfad.weatherforecast.model.ForecastResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ForecastApiInterface {

	@GET("api/v1/forecasts/forecast")
	Call<ForecastResponse> getForecasts(@Query("city") City city);

	@GET("api/v1/forecasts/current")
	Call<ForecastResponse> getCurrenForecast(@Query("city") City city);
}
