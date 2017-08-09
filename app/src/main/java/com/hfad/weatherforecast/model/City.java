package com.hfad.weatherforecast.model;

import android.support.annotation.StringRes;

import com.hfad.weatherforecast.R;


public enum City {

	BARNAUL(R.string.Barnaul, "barnaul"),

	OMSK(R.string.city_name_omsk, "omsk"),

	SHEREGESH(R.string.sheregesh, "sheregesh");

	@StringRes
	private int mCityNameRes;
	private String mServerName;

	City(@StringRes int cityName, String serverName) {
		mCityNameRes = cityName;
		mServerName = serverName;
	}

	@StringRes
	public int getCityNameRes() {
		return mCityNameRes;
	}

	@Override
	public String toString() {
		return mServerName;
	}
}
