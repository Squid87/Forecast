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

	public Links getLinks() {
		return mLinks;
	}

	public Wind getWind() {

		return mWind;
	}

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

	public int getHumidity() {
		return mHumidity;
	}

	public int getPressure() {

		return mPressure;
	}

	public String getDate() {
		return mDate;
	}

	public void setDate(String date) {
		mDate = date;
	}

	public double getTemperature() {
		return mTemperature;
	}

	public void setTemperature(double temperature) {
		mTemperature = temperature;
	}

	public Cloud getCloud() {
		return mCloud;
	}

	public void setCloud(Cloud cloud) {
		mCloud = cloud;
	}

	public String getIconPath() {
		return mIconPath;
	}

	public void setIconPath(String iconPath) {
		mIconPath = iconPath;
	}
}
