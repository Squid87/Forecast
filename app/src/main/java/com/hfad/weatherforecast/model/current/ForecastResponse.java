package com.hfad.weatherforecast.model.current;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ForecastResponse {

	@SerializedName("forecasts")
	public List<CurrentForecast> mCurrentForecasts = new ArrayList<>();

	public CurrentForecast getCurrentForecast() {
		return mCurrentForecasts.get(0); //TODO проверка на то что список не пустой
	}
}
