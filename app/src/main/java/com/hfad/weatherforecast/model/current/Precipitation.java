package com.hfad.weatherforecast.model.current;

import com.google.gson.annotations.SerializedName;

public class Precipitation {

	@SerializedName("title")
	public String mTitle;

	@SerializedName("value")
	public String mValue;

	@SerializedName("day_value")
	public double mDayValue;
}
