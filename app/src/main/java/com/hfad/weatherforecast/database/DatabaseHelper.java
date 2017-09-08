package com.hfad.weatherforecast.database;

import java.sql.SQLException;
import java.util.Date;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hfad.weatherforecast.model.GeoData.Astronomy;
import com.hfad.weatherforecast.model.GeoData.Cloud;
import com.hfad.weatherforecast.model.GeoData.Direction;
import com.hfad.weatherforecast.model.GeoData.HourForecast;
import com.hfad.weatherforecast.model.GeoData.Temperature;
import com.hfad.weatherforecast.model.GeoData.Wind;
import com.hfad.weatherforecast.model.current.CurrentForecast;
import com.hfad.weatherforecast.model.future.FutureForecast;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static String TAG = "DatabaseHelper";

    private static final String DATABASE_NAME = "forecast.db";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelper mDataBaseHelper;


    private Dao<HourForecast, Integer> dHours;
    private Dao<CurrentForecast, Integer> dCurrentForecast;
    private Dao<FutureForecast, Integer> dFutureForecast;
    private Dao<Wind, Integer> dWind;
    public Dao<Cloud, Integer> dCloud;
    public Dao<Temperature, Integer> dTemperatures;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //синглтон для Хелпера
    public static DatabaseHelper getInstance(Context context) {
        if (mDataBaseHelper == null) {
            synchronized (DatabaseHelper.class) {
                if (mDataBaseHelper == null) {
                    mDataBaseHelper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
                }
            }
        }
        return mDataBaseHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        Log.d(TAG, "creating DB" + DATABASE_NAME);
        try {
            Astronomy.onCreate(database, connectionSource);
            Cloud.onCreate(database, connectionSource);
            Direction.onCreate(database, connectionSource);
            HourForecast.onCreate(database, connectionSource);
            Temperature.onCreate(database, connectionSource);
            Wind.onCreate(database, connectionSource);
            CurrentForecast.onCreate(database, connectionSource);
            FutureForecast.onCreate(database, connectionSource);

        } catch (SQLException e) {
            Log.e(TAG, "error creating DB" + DATABASE_NAME);
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, CurrentForecast.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<HourForecast, Integer> getHoursDao() throws SQLException {
        if (dHours == null) {
            dHours = getDao(HourForecast.class);
        }
        return dHours;
    }

    public Dao<CurrentForecast, Integer> getCurrentForecastDao() throws SQLException {
        if (dCurrentForecast == null) {
            dCurrentForecast = getDao(CurrentForecast.class);
        }
        return dCurrentForecast;
    }

    public Dao<FutureForecast, Integer> getFutureForecastDao() throws SQLException {
        if (dFutureForecast == null) {
            dFutureForecast = getDao(FutureForecast.class);
        }
        return dFutureForecast;
    }

    public Dao<Wind, Integer> getWindDao() throws SQLException {
        if (dWind == null) {
            dWind = getDao(Wind.class);
        }
        return dWind;
    }

    public Dao<Cloud, Integer> getCloudDao() throws SQLException {
        if (dCloud == null) {
            dCloud = getDao(Cloud.class);
        }
        return dCloud;
    }

    public Dao<Temperature, Integer> getTemperaturesDao() throws SQLException {
        if (dTemperatures == null) {
            dTemperatures = getDao(Temperature.class);
        }
        return dTemperatures;
    }

}
