package com.hfad.weatherforecast.model;

import com.google.gson.annotations.SerializedName;

public class Forecasts {

	@SerializedName("date")
	public String mDate;

	@SerializedName("temperature")
	public double mTemperature;

	@SerializedName("feel_like_temperature")
	public double mFeelLikeTemperature;

	@SerializedName("temperature_trend")
	public int mTemperatureTrend;

	@SerializedName("pressure")
	public int mPressure;

	@SerializedName("humidity")
	public int mHumidity;

	@SerializedName("wind")
	public Wind mWind;

	@SerializedName("cloud")
	public Cloud mCloud;

	@SerializedName("precipitation")
	public Precipitation mPrecipitation;


	@SerializedName("magnetic_status")
	public String mMagneticStatus;

	@SerializedName("water")
	public String mWater;

	@SerializedName("astronomy")
	public Astronomy mAstronomy;

	@SerializedName("source")
	public String mSource;

	@SerializedName("icon_path")
	public String mIconPath;

	@SerializedName("links")
	public Links mLinks;
}
