package com.hfad.weatherforecast.model.future;

import com.google.gson.annotations.SerializedName;

public class Cloud {

	@SerializedName("title")
	private String title;

	@SerializedName("value")
	private String value;

	public String getTitle() {
		return title;
	}
}
