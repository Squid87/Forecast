package com.hfad.weatherforecast.network;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ForecastService {

	@SuppressWarnings("FieldCanBeLocal")
	private String BASE_URL = "http://pogoda.ngs.ru";
	private Retrofit mRetrofit;
	private static ForecastService sInstance;


	private ForecastService(Context context) {
		mRetrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
	}

	public static ForecastService getInstance(Context context) {
		if (sInstance == null) {
			synchronized (ForecastService.class) {
				if (sInstance == null) {
					sInstance = new ForecastService(context);
				}
			}
		}
		return sInstance;
	}

	public ForecastApiInterface createForecaastApi(){
		return mRetrofit.create(ForecastApiInterface.class);
	}
}

