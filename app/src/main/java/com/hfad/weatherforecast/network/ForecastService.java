package com.hfad.weatherforecast.network;

import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ForecastService {

	@SuppressWarnings("FieldCanBeLocal")
	private String BASE_URL = "http://pogoda.ngs.ru";
	private Retrofit mRetrofit;
	private static ForecastService sInstance;
	private static String LOG = "HttpLog";


	private ForecastService(Context context) {
		HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
		interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
		mRetrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.client(client)
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

	public ForecastApiInterface createForecastApi() {
		return mRetrofit.create(ForecastApiInterface.class);
	}
}

