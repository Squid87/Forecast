package com.hfad.weatherforecast.database;


import java.sql.SQLException;
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
		currentForecast.getCloud().setId(CurrentForecast.CURRENT_FORECAST_ID);
		currentForecast.getWind().setId(CurrentForecast.CURRENT_FORECAST_ID);
		currentForecast.getAstronomy().setId(CurrentForecast.CURRENT_FORECAST_ID);

		mDatabaseHelper.getCloudDao().createOrUpdate(currentForecast.getCloud());
		mDatabaseHelper.getWindDao().createOrUpdate(currentForecast.getWind());
		mDatabaseHelper.getAstronomyDao().createOrUpdate(currentForecast.getAstronomy());

		mDatabaseHelper.getCurrentForecastDao().createOrUpdate(currentForecast);
	}


	public void saveFutureForecasts(List<FutureForecast> futureForecasts) throws SQLException {

		for (int i = 0; i < futureForecasts.size(); i++) {
			FutureForecast futureForecast = futureForecasts.get(i);

			futureForecast.setId(i);

			for (HourForecast hourForecast : futureForecast.getHours()) {
				String hourId = String.valueOf(futureForecast.getId() + hourForecast.getHour());

				hourForecast.setID(hourId);
				hourForecast.getCloud().setId(Integer.parseInt(hourId));
				hourForecast.getTemperature().setId(hourId);

				mDatabaseHelper.getTemperaturesDao().createOrUpdate(hourForecast.getTemperature());
				mDatabaseHelper.getCloudDao().createOrUpdate(hourForecast.getCloud());

				mDatabaseHelper.getHoursDao().createOrUpdate(hourForecast);
			}

			futureForecast.getAstronomy().setId(i);

			mDatabaseHelper.getFutureForecastDao().createOrUpdate(futureForecast);
		}
	}

	//    public List<CurrentForecast> getCurrentForecast() throws SQLException {
	//        return mDatabaseHelper.getCurrentForecastDao().queryForAll();
	//    }
}
