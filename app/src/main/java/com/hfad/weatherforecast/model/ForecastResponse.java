package com.hfad.weatherforecast.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ForecastResponse {

	@SerializedName("forecasts")
	public List<Forecast> mForecasts =new ArrayList<>();

	public List<Forecast> getForecasts() {
		return mForecasts;
	}

	public void setForecasts(List<Forecast> forecasts) {
		mForecasts = forecasts;
	}
}
