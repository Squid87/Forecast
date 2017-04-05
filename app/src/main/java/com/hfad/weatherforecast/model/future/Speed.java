package com.hfad.weatherforecast.model.future;

import com.google.gson.annotations.SerializedName;

public class Speed {
	@SerializedName("min")
	private int min;
	@SerializedName("max")
	private int max;
	@SerializedName("avg")
	private int avg;
}
