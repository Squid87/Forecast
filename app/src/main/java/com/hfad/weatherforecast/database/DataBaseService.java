package com.hfad.weatherforecast.database;


import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import android.content.Context;

import com.hfad.weatherforecast.model.GeoData.Hours;
import com.hfad.weatherforecast.model.GeoData.Temperature;
import com.hfad.weatherforecast.model.current.CurrentForecast;
import com.hfad.weatherforecast.model.future.FutureForecast;

public class DataBaseService {

    private DatabaseHelper mDatabaseHelper;

    public DataBaseService(Context context) {
        mDatabaseHelper = DatabaseHelper.getInstance(context);
    }

    public void saveCurrentForecasts(CurrentForecast currentForecasts) throws SQLException {
        mDatabaseHelper.getdCurrentForecastDao().create(currentForecasts);
    }

    public void saveFutureDorecasts(List<FutureForecast> futureForecasts) throws SQLException {;
        for (FutureForecast forecast : futureForecasts) {
            //mDatabaseHelper.getdHoursDao().create((Collection<Hours>) forecast);
        }
    }
}
