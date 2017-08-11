package com.hfad.weatherforecast.model.GeoData;

import com.google.gson.annotations.SerializedName;

public class Temperature {

	@SerializedName("min")
	private int min;

	@SerializedName("max")
	private int max;

	@SerializedName("avg")
	private int avg;

	public int getAvg() {
		return avg;
	}
}
