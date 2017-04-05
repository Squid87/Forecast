package com.hfad.weatherforecast.model.future;

import com.google.gson.annotations.SerializedName;

public class Astronomy {
	@SerializedName("sunrise")
	private String sunrise;
	@SerializedName("sunset")
	private String sunset;
	@SerializedName("length_day_human")
	private String lengthDayHuman;
	@SerializedName("moon_illuminated")
	private int moonIlluminated;
	@SerializedName("moon_phase")
	private String moonPhase;

	public String getSunrise() {
		return sunrise;
	}

	public String getSunset() {
		return sunset;
	}
}
