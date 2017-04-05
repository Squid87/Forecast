package com.hfad.weatherforecast.model.current;

import com.google.gson.annotations.SerializedName;

public class Cloud {

	@SerializedName("title")
	public String mTitle;

	@SerializedName("value")
	public String mValue;

	public String getTitle() {
		return mTitle;
	}
}
