package com.hfad.weatherforecast.database;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hfad.weatherforecast.model.GeoData.Astronomy;
import com.hfad.weatherforecast.model.GeoData.Cloud;
import com.hfad.weatherforecast.model.GeoData.Direction;
import com.hfad.weatherforecast.model.GeoData.Hours;
import com.hfad.weatherforecast.model.GeoData.Temperature;
import com.hfad.weatherforecast.model.GeoData.Wind;
import com.hfad.weatherforecast.model.current.CurrentForecast;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.query.In;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static String TAG = "Ошибка!";

    private static final String DATABASE_NAME = "forecast.db";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelper mDataBaseHelper;

    private Dao<Astronomy, Integer> dAstronomy;
    private Dao<Cloud, Integer> dCloud;
    private Dao<Direction, Integer> dDirection;
    private Dao<Hours, Integer> dHours;
    private Dao<Temperature, Integer> dTemperature;
    private Dao<Wind, Integer> dWind;
    private Dao<CurrentForecast, Integer> dCurrentForecast;

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
        try {
            Astronomy.onCreate(database, connectionSource);
            Cloud.onCreate(database, connectionSource);
            Direction.onCreate(database, connectionSource);
            Hours.onCreate(database, connectionSource);
            Temperature.onCreate(database, connectionSource);
            Wind.onCreate(database, connectionSource);
            CurrentForecast.onCreate(database, connectionSource);

        } catch (SQLException e) {
            Log.e(TAG, "error creating DB" + DATABASE_NAME);
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            //что такое dropTable?
            TableUtils.dropTable(connectionSource, Hours.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Astronomy, Integer> getAstronomyDao() throws SQLException {
        if (dAstronomy == null) {
            dAstronomy = getDao(Astronomy.class);
        }
        return dAstronomy;
    }

    public Dao<Cloud, Integer> getCloudDao() throws SQLException {
        if (dCloud == null) {
            dCloud = getDao(Cloud.class);
        }
        return dCloud;
    }

    public Dao<Direction, Integer> geDirectionDao() throws SQLException {
        if (dDirection == null) {
            dDirection = getDao(Direction.class);
        }
        return dDirection;
    }

    public Dao<Hours, Integer> getdHoursDao() throws SQLException {
        if (dHours == null) {
            dHours = getDao(Hours.class);
        }
        return dHours;
    }

    public Dao<Temperature, Integer> getTemperatureDao() throws SQLException {
        if (dTemperature == null) {
            dTemperature = getDao(Temperature.class);
        }
        return dTemperature;
    }

    public Dao<Wind, Integer> getWind() throws SQLException {
        if (dWind == null) {
            dWind = getDao(Wind.class);
        }
        return dWind;
    }

    public Dao<CurrentForecast, Integer> getdCurrentForecastDao() throws SQLException {
        if (dCurrentForecast == null) {
            dCurrentForecast = getDao(CurrentForecast.class);
        }
        return dCurrentForecast;
    }


}
