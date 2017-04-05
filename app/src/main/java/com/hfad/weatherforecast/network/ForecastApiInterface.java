package com.hfad.weatherforecast.network;

import com.hfad.weatherforecast.model.current.City;
import com.hfad.weatherforecast.model.current.ForecastResponse;
import com.hfad.weatherforecast.model.future.FutureForecastsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ForecastApiInterface {

	@GET("api/v1/forecasts/forecast")
	Call<FutureForecastsResponse> getForecasts(@Query("city") City city);

	@GET("api/v1/forecasts/current")
	Call<ForecastResponse> getCurrentForecast(@Query("city") City city);
}
