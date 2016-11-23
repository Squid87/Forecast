package com.hfad.weatherforecast.model;

import android.support.annotation.StringRes;

import com.google.gson.annotations.SerializedName;
import com.hfad.weatherforecast.R;


public enum City {

	@SerializedName("barnaul")
	BARNAUL(R.string.Barnaul),

	@SerializedName("omsk")
	OMSK(R.string.city_name_omsk),

	@SerializedName("tomsk")
	TOMSK(R.string.city_name_tomsk);

	@StringRes
	private int mCityNameRes;

	City(@StringRes int cityName) {
		mCityNameRes = cityName;
	}

	@StringRes
	public int getCityNameRes() {
		return mCityNameRes;
	}
}
