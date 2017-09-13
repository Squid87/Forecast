package com.hfad.weatherforecast.model.current;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.database.sqlite.SQLiteDatabase;

import com.google.gson.annotations.SerializedName;
import com.hfad.weatherforecast.model.GeoData.Astronomy;
import com.hfad.weatherforecast.model.GeoData.Cloud;
import com.hfad.weatherforecast.model.GeoData.Links;
import com.hfad.weatherforecast.model.GeoData.Precipitation;
import com.hfad.weatherforecast.model.GeoData.Wind;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;

@DatabaseTable(tableName = CurrentForecast.TABLE_NAME)
public class CurrentForecast {

	public static final String CURRENT_FORECAST_ID = "1111";
	public static final String TABLE_NAME = "currentforecast";

	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM", Locale.getDefault());

	private static final String COLUMN_ID = "_id";
	private static final String COLUMN_DATE = "date";
	private static final String COLUMN_TEMPERATURE = "temperature";
	private static final String COLUMN_PRESSURE = "pressure";
	private static final String COLUMN_HUMIDITY = "humidity";
	private static final String COLUMN_CLOUD = "cloud";
	private static final String COLUMN_WIND = "wind";
	private static final String COLUMN_ASTRONOMY = "astronomy";
	private static final String COLUMN_ICONPATH = "iconpath";

	@DatabaseField(columnName = COLUMN_ID, id = true)
	private String mId = CURRENT_FORECAST_ID;

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

	@DatabaseField(columnName = COLUMN_WIND, foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
	@SerializedName("wind")
	private Wind mWind;

	@DatabaseField(columnName = COLUMN_CLOUD, foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
	@SerializedName("cloud")
	private Cloud mCloud;

	@SerializedName("precipitation")
	public Precipitation mPrecipitation;

	@DatabaseField(columnName = COLUMN_ASTRONOMY, foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
	@SerializedName("astronomy")
	public Astronomy mAstronomy;

	@SerializedName("icon")
	private String mIcon;

	@DatabaseField(columnName = COLUMN_ICONPATH)
	@SerializedName("icon_path")
	public String mIconPath;

	@SerializedName("links")
	public Links mLinks;

	public String getIcon() {
		return mIcon;
	}

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

	public Astronomy getAstronomy() {
		return mAstronomy;
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
