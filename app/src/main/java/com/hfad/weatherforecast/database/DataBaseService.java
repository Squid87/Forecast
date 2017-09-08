package com.hfad.weatherforecast.database;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.content.Context;

import com.google.common.collect.ForwardingTable;
import com.hfad.weatherforecast.model.GeoData.Cloud;
import com.hfad.weatherforecast.model.GeoData.HourForecast;
import com.hfad.weatherforecast.model.GeoData.Temperature;
import com.hfad.weatherforecast.model.GeoData.Wind;
import com.hfad.weatherforecast.model.current.CurrentForecast;
import com.hfad.weatherforecast.model.current.ForecastResponse;
import com.hfad.weatherforecast.model.future.FutureForecast;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.query.In;

public class DataBaseService {

    private DatabaseHelper mDatabaseHelper;

    public DataBaseService(Context context) {
        mDatabaseHelper = DatabaseHelper.getInstance(context);
    }

    public void saveCurrentForecast(CurrentForecast currentForecast) throws SQLException {

        if (!mDatabaseHelper.getCurrentForecastDao().idExists(0)) {
            mDatabaseHelper.getCurrentForecastDao().create(currentForecast);
        } else {
            updateCurrentForecast(currentForecast);
        }
    }


    public void saveFutureForecasts(List<FutureForecast> futureForecasts) throws SQLException {

        // if (!mDatabaseHelper.getFutureForecastDao().idExists(1)) {
        for (FutureForecast forecast : futureForecasts) {
            mDatabaseHelper.getFutureForecastDao().createOrUpdate(forecast);

            Collection<HourForecast> hourForecasts = forecast.getHours();
            mDatabaseHelper.getFutureForecastDao().assignEmptyForeignCollection(forecast, FutureForecast.COLUMN_HOURFORECAST);
            forecast.getHours().addAll(hourForecasts);
            mDatabaseHelper.getFutureForecastDao().update(forecast);
        }
        //} else {
        //    updateFutureForecast(futureForecasts);
        //}
    }

//    public List<CurrentForecast> getCurrentForecast() throws SQLException {
//        return mDatabaseHelper.getCurrentForecastDao().queryForAll();
//    }

    public void updateCurrentForecast(CurrentForecast currentForecast) throws SQLException {
        UpdateBuilder<CurrentForecast, Integer> updateBuilder = mDatabaseHelper.getCurrentForecastDao().updateBuilder();
        updateBuilder.updateColumnValue("temperature", currentForecast.getTemperature());
        updateBuilder.updateColumnValue("humidity", currentForecast.getHumidity());
        updateBuilder.updateColumnValue("pressure", currentForecast.getPressure());
        updateBuilder.update();

        UpdateBuilder<Wind, Integer> updateBuilder1Wind = mDatabaseHelper.getWindDao().updateBuilder();
        updateBuilder1Wind.updateColumnValue("speed", currentForecast.getWind().getSpeed());
        updateBuilder1Wind.update();
    }

    public void updateFutureForecast(List<FutureForecast> futureForecasts) throws SQLException {

//        UpdateBuilder<FutureForecast, Integer> updateBuilderFuture = mDatabaseHelper.getFutureForecastDao().updateBuilder();
//        UpdateBuilder<HourForecast, Integer> updateBuilderHourForecast = mDatabaseHelper.getHoursDao().updateBuilder();
//        UpdateBuilder<Cloud, Integer> updateBuilderCloud = mDatabaseHelper.getCloudDao().updateBuilder();
//        UpdateBuilder<Temperature, Integer> updateBuilderTemperature = mDatabaseHelper.getTemperaturesDao().updateBuilder();
//
//        updateBuilderFuture.where().idEq(1);
//        updateBuilderFuture.where().idEq(2);
//        updateBuilderFuture.where().idEq(3);
//        updateBuilderFuture.where().idEq(4);
//        updateBuilderFuture.update();

//        List<HourForecast> hourForecasts = new ArrayList<>();
//        hourForecasts.add((HourForecast) futureForecasts.get(0).getHours());
//        hourForecasts.add((HourForecast) futureForecasts.get(1).getHours());
//        hourForecasts.add((HourForecast) futureForecasts.get(2).getHours());
//        hourForecasts.add((HourForecast) futureForecasts.get(3).getHours());
//
//
//        updateBuilderTemperature.where().eq("_id", 1);
//        updateBuilderTemperature.updateColumnValue("avg", hourForecasts.get(0).getTemperature().getAvg());
//        updateBuilderTemperature.update();
//        updateBuilderTemperature.where().eq("_id", 2);
//        updateBuilderTemperature.updateColumnValue("avg", hourForecasts.get(1).getTemperature().getAvg());
//        updateBuilderTemperature.update();

    }
}
