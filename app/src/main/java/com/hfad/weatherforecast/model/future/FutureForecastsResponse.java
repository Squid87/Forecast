package com.hfad.weatherforecast.model.future;


import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class FutureForecastsResponse {

	@SerializedName("forecasts")
	public List<FutureForecast> mForecast =new ArrayList<>();

	public List<FutureForecast> getForecasts() {
		return mForecast;
	}
}
