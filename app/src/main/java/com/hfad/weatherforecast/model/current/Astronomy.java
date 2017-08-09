package com.hfad.weatherforecast.model.current;

import com.google.gson.annotations.SerializedName;

public class Astronomy {

	@SerializedName("sunrise")
	private String mSunrise;

	@SerializedName("sunset")
	private String mSunset;

	public String getSunrise() {
		return mSunrise;
	}

	public String getSunset() {
		return mSunset;
	}
}
