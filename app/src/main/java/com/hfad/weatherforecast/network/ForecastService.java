package com.hfad.weatherforecast.network;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Илья on 31.10.2016.
 */

public class ForecastService {

	@SuppressWarnings("FieldCanBeLocal")
	private String BASE_URL = "http://pogoda.ngs.ru";
	private Retrofit mRetrofit;
	private ForecastService mForecastService;


	public ForecastService(Context context) {
		mRetrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
	}

	public ForecastService getInstance(Context context) {
		if (mForecastService == null) {
			synchronized (ForecastService.class) {
				if (mForecastService == null) {
					mForecastService = new ForecastService(context);
				}
			}
		}
		return mForecastService;
	}

	public ForecastApiInterface createForecaastApi(){
		return mRetrofit.create(ForecastApiInterface.class);
	}
}

