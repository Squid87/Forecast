package com.hfad.weatherforecast.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Илья on 30.10.2016.
 */

public class ForecastResponse {

	@SerializedName("forecasts")
	public List<Forecasts> mForecasts =new ArrayList<>();

	public List<Forecasts> getForecasts() {
		return mForecasts;
	}

	public void setForecasts(List<Forecasts> forecasts) {
		mForecasts = forecasts;
	}
}
