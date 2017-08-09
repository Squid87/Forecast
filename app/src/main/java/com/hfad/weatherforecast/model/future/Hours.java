package com.hfad.weatherforecast.model.future;

import com.google.gson.annotations.SerializedName;
import com.hfad.weatherforecast.model.Cloud;

public class Hours {

	@SerializedName("hour")
	private int hour;

	@SerializedName("temperature")
	private Temperature temperature;

	@SerializedName("pressure")
	private Pressure pressure;

	@SerializedName("humidity")
	private Humidity humidity;

	@SerializedName("wind")
	private Wind wind;

	@SerializedName("cloud")
	private Cloud cloud;

	@SerializedName("precipitation")
	private Precipitation precipitation;

	@SerializedName("icon")
	private String icon;

	@SerializedName("icon_path")
	private String iconPath;

	public String getIconPath() {
		return iconPath;
	}

	public Temperature getTemperature() {
		return temperature;
	}

	public Cloud getCloud() {

		return cloud;
	}
}
