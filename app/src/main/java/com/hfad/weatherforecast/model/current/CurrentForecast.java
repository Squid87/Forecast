package com.hfad.weatherforecast.model.current;

import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.google.gson.annotations.SerializedName;
import com.hfad.weatherforecast.model.GeoData.Astronomy;
import com.hfad.weatherforecast.model.GeoData.Cloud;
import com.hfad.weatherforecast.model.GeoData.Links;
import com.hfad.weatherforecast.model.GeoData.Precipitation;
import com.hfad.weatherforecast.model.GeoData.Temperature;
import com.hfad.weatherforecast.model.GeoData.Wind;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;

@DatabaseTable(tableName = CurrentForecast.TABLE_NAME)
public class CurrentForecast {

    public static final String TABLE_NAME = "currentforecast";

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM", Locale.getDefault());

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TEMPERATURE = "temperature" ;
    private static final String COLUMN_PRESSURE = "pressure";
    private static final String COLUMN_HUMIDITY = "humidity";
    private static final String COLUMN_CLOUD = "cloud";

    @DatabaseField(columnName = COLUMN_ID, generatedId = true)
    private int mId;

    @DatabaseField(columnName = COLUMN_DATE)
    @SerializedName("date")
    public Date mDate;

    private String data;

    @DatabaseField(columnName = COLUMN_TEMPERATURE)
    @SerializedName("temperature")
    private double mTemperature;

    @DatabaseField(columnName = COLUMN_PRESSURE)
    @SerializedName("pressure")
    private int mPressure;


    @DatabaseField(columnName = COLUMN_HUMIDITY)
    @SerializedName("humidity")
    private int mHumidity;

    @SerializedName("wind")
    private Wind mWind;

    @DatabaseField(columnName = COLUMN_CLOUD)
    @SerializedName("cloud")
    private Cloud mCloud;

    @SerializedName("precipitation")
    public Precipitation mPrecipitation;

    @SerializedName("astronomy")
    public Astronomy mAstronomy;

    @SerializedName("icon_path")
    public String mIconPath;

    @SerializedName("links")
    public Links mLinks;

    public int getHumidity() {
        return mHumidity;
    }

    public int getPressure() {
        return mPressure;
    }

    public double getTemperature() {
        return mTemperature;
    }

    public Cloud getCloud() {
        return mCloud;
    }

    public String getIconPath() {
        return mIconPath;
    }

    public void setIconPath(String iconPath) {
        mIconPath = iconPath;
    }

    public String getDate() {
        data = SIMPLE_DATE_FORMAT.format(mDate);
        return data;
    }

    public Links getLinks() {
        return mLinks;
    }

    public Wind getWind() {
        return mWind;
    }

    public static void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) throws SQLException {
        TableUtils.createTable(connectionSource, CurrentForecast.class);
    }
}
