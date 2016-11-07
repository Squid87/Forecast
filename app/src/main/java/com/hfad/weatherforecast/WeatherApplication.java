package com.hfad.weatherforecast;

import com.arellomobile.mvp.MvpApplication;


public class WeatherApplication extends MvpApplication {
	private static WeatherApplication sInstance;

	public static WeatherApplication getInstance() {
		return sInstance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		sInstance = this;
	}
}
