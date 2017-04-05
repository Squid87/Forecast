package com.hfad.weatherforecast.model.future;

import com.google.gson.annotations.SerializedName;

public class Direction {

	@SerializedName("title")
	private String title;

	@SerializedName("title_letter")
	private String titleLetter;

	@SerializedName("title_short")
	private String titleShort;

	@SerializedName("value")
	private String value;
}
