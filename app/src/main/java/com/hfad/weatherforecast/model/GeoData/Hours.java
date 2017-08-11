package com.hfad.weatherforecast.model.GeoData;

import com.google.gson.annotations.SerializedName;

public class Hours {

	@SerializedName("hour")
	private int hour;

	@SerializedName("temperature")
	private Temperature temperature;

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

	public Cloud getCloud() { return cloud;	}
}
