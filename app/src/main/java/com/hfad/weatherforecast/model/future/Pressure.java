package com.hfad.weatherforecast.model.future;

import com.google.gson.annotations.SerializedName;

public class Pressure {

	@SerializedName("min")
	private int min;

	@SerializedName("max")
	private int max;

	@SerializedName("avg")
	private int avg;
}
