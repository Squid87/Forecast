package com.hfad.weatherforecast.database;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import android.content.Context;
import android.util.Log;

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
        currentForecast.getWind().getDirection().setID(CurrentForecast.CURRENT_FORECAST_ID);
        currentForecast.getAstronomy().setId(CurrentForecast.CURRENT_FORECAST_ID);

        mDatabaseHelper.getCloudDao().createOrUpdate(currentForecast.getCloud());
        mDatabaseHelper.getWindDao().createOrUpdate(currentForecast.getWind());
        mDatabaseHelper.getDirectionDao().createOrUpdate(currentForecast.getWind().getDirection());
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
                hourForecast.getCloud().setId(hourId);
                hourForecast.getTemperature().setId(hourId);
                hourForecast.setParentFutureForecast(futureForecasts.get(i));
                mDatabaseHelper.getTemperaturesDao().createOrUpdate(hourForecast.getTemperature());
                mDatabaseHelper.getCloudDao().createOrUpdate(hourForecast.getCloud());
                mDatabaseHelper.getHoursDao().createOrUpdate(hourForecast);
            }

            futureForecast.getAstronomy().setId(String.valueOf(i));
            mDatabaseHelper.getAstronomyDao().createOrUpdate(futureForecast.getAstronomy());
            mDatabaseHelper.getFutureForecastDao().createOrUpdate(futureForecast);

        }
    }

    public CurrentForecast getCurrentForecast() throws SQLException {
        return mDatabaseHelper.getCurrentForecastDao().queryForId("1111");
    }

    public List<FutureForecast> getFutureForecast() throws SQLException {
        List<FutureForecast> mFutureForecasts = mDatabaseHelper.getFutureForecastDao().queryForAll();
        return mFutureForecasts;
    }
}
