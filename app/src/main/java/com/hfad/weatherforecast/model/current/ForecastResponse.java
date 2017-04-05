package com.hfad.weatherforecast.model.current;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ForecastResponse {

	@SerializedName("forecasts")
	public List<CurrentForecast> mCurrentForecasts =new ArrayList<>();

	public List<CurrentForecast> getCurrentForecasts() {
		return mCurrentForecasts;
	}

	public void setCurrentForecasts(List<CurrentForecast> currentForecasts) {
		mCurrentForecasts = currentForecasts;
	}
}
