package com.hfad.weatherforecast.model.future;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import android.database.sqlite.SQLiteDatabase;

import com.google.gson.annotations.SerializedName;
import com.hfad.weatherforecast.model.GeoData.Astronomy;
import com.hfad.weatherforecast.model.GeoData.HourForecast;
import com.hfad.weatherforecast.model.GeoData.Links;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;

@DatabaseTable(tableName = FutureForecast.TABLE_NAME)
public class FutureForecast {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM", Locale.getDefault());

    public static final String TABLE_NAME = "futureforecast";
    private static final String COLUMN_DATE = "data";
    private static final String COLUMN_ID = "_id";
    public static final String COLUMN_HOURFORECAST = "hourforecast";

    @DatabaseField(columnName = COLUMN_ID, id = true)
    private int mId;

    @DatabaseField(columnName = COLUMN_DATE)
    @SerializedName("date")
    public Date mDate;

    private String data;

    @ForeignCollectionField(columnName = COLUMN_HOURFORECAST, eager = true)
    @SerializedName("hours")
    private Collection<HourForecast> mHours;

    @SerializedName("astronomy")
    private Astronomy astronomy;

    @SerializedName("links")
    private Links links;


    public Collection<HourForecast> getHours() {
        return mHours;
    }

    public String getDate() {
        data = SIMPLE_DATE_FORMAT.format(mDate);
        return data = "01.01.01";
    }

    public void setId(int id) {
        mId = id;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public static void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) throws SQLException {
        TableUtils.createTable(connectionSource, FutureForecast.class);
    }

    public int getId() {
        return mId;
    }
}
