package com.hfad.weatherforecast.model.future;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import com.google.gson.annotations.SerializedName;

public class FutureForecast {

	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM", Locale.getDefault());

	private String data;

	@SerializedName("date")
	public Date mDate;

	@SerializedName("hours")
	private Collection<Hours> hours;

	@SerializedName("astronomy")
	private Astronomy astronomy;

	@SerializedName("links")
	private Links links;


	public Collection<Hours>  getHours() {
		return hours;
	}

	public String getDate() {
		data = SIMPLE_DATE_FORMAT.format(mDate);
		return data;
	}

	public Astronomy getAstronomy() {
		return astronomy;
	}
}
