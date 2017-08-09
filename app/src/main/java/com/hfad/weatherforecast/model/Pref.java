package com.hfad.weatherforecast.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.hfad.weatherforecast.WeatherApplication;


public class Pref {

	private Gson mGson;
	private final SharedPreferences mMsharedPreferences;

	private String KEY_CITY="KEY_CITY";


	public Pref() {
		mGson = new Gson();
		mMsharedPreferences = WeatherApplication.getInstance().getSharedPreferences("com.hfad.weatherforecast", Context.MODE_PRIVATE);
	}

	@SuppressLint("CommitPrefEdits")
	public void saveCity(City city) {
		mMsharedPreferences.edit().putString(KEY_CITY, mGson.toJson(city)).commit();
	}

	public City loadCity() {
		String jsonCity = mMsharedPreferences.getString(KEY_CITY, "");
		return mGson.fromJson(jsonCity, City.class);
	}
}
