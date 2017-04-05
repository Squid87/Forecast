package com.hfad.weatherforecast.model.current;

import com.google.gson.annotations.SerializedName;

public class Direction {

	@SerializedName("title")
	public String mTitle;

	@SerializedName("title_letter")
	public String mTitleLetter;

	@SerializedName("title_short")
	public String mTitleShort;

	@SerializedName("value")
	public String mValue;

	public String getTitleShort() {
		return mTitleShort;
	}
}
