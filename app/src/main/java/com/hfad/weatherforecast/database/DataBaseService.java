package com.hfad.weatherforecast.database;


import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import android.content.Context;

import com.hfad.weatherforecast.model.GeoData.HourForecast;
import com.hfad.weatherforecast.model.current.CurrentForecast;
import com.hfad.weatherforecast.model.future.FutureForecast;

public class DataBaseService {

	private DatabaseHelper mDatabaseHelper;

	public DataBaseService(Context context) {
		mDatabaseHelper = DatabaseHelper.getInstance(context);
	}

	public void saveCurrentForecast(CurrentForecast currentForecast) throws SQLException {
		mDatabaseHelper.getCurrentForecastDao().createOrUpdate(currentForecast); //// TODO: сделать id нормальный
	}


	public void saveFutureForecasts(List<FutureForecast> futureForecasts) throws SQLException {

		for (FutureForecast forecast : futureForecasts) {
			mDatabaseHelper.getFutureForecastDao().createOrUpdate(forecast);

			Collection<HourForecast> hourForecasts = forecast.getHours();
			mDatabaseHelper.getFutureForecastDao().assignEmptyForeignCollection(forecast, FutureForecast.COLUMN_HOURFORECAST);
			forecast.getHours().addAll(hourForecasts);
			mDatabaseHelper.getFutureForecastDao().update(forecast);
		}
	}
}
