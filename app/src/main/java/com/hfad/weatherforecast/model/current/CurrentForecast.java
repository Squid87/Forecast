package com.hfad.weatherforecast.model.current;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.google.gson.annotations.SerializedName;
import com.hfad.weatherforecast.model.GeoData.Astronomy;
import com.hfad.weatherforecast.model.GeoData.Cloud;
import com.hfad.weatherforecast.model.GeoData.Links;
import com.hfad.weatherforecast.model.GeoData.Precipitation;
import com.hfad.weatherforecast.model.GeoData.Wind;

public class CurrentForecast {

	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM", Locale.getDefault());

	@SerializedName("date")
	public Date mDate;

	private String data;

	@SerializedName("temperature")
	private double mTemperature;

	@SerializedName("pressure")
	private int mPressure;

	@SerializedName("humidity")
	private int mHumidity;

	@SerializedName("wind")
	private Wind mWind;

	@SerializedName("cloud")
	private Cloud mCloud;

	@SerializedName("precipitation")
	public Precipitation mPrecipitation;

	@SerializedName("astronomy")
	public Astronomy mAstronomy;

	@SerializedName("icon_path")
	public String mIconPath;

	@SerializedName("links")
	public Links mLinks;

	public int getHumidity() {
		return mHumidity;
	}

	public int getPressure() { return mPressure; }

	public double getTemperature() {
		return mTemperature;
	}

	public Cloud getCloud() {
		return mCloud;
	}

	public String getIconPath() {
		return mIconPath;
	}

	public void setIconPath(String iconPath) {
		mIconPath = iconPath;
	}

	public String getDate() {
		data = SIMPLE_DATE_FORMAT.format(mDate);
		return data;
	}

	public Links getLinks() {
		return mLinks;
	}

	public Wind getWind() {	return mWind; }
}
