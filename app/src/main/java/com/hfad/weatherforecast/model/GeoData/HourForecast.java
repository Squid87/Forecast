package com.hfad.weatherforecast.model.GeoData;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.annotations.SerializedName;
import com.hfad.weatherforecast.model.future.FutureForecast;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;

@DatabaseTable(tableName = HourForecast.TABLE_NAME)
public class HourForecast {

	public static final String TABLE_NAME = "hours";
	public static final String COLUMN_TEMPERATURE = "temperature";
	private static final String COLUMN_CLOUD = "cloud";
	private static final String COLUMN_ICON_PATH = "iconPath";
	private static final String COLUMN_TIME = "time";
	private static final String COLUMN_ID = "_id";
	private static final String COLUMN_PARENT_FUTURE_FORECAST = "column_parent_future_forecast";

	@DatabaseField(columnName = COLUMN_TIME)
	@SerializedName("hour")
	private int hour;

	@DatabaseField(columnName = COLUMN_ID, generatedId = true)
	private int mID;

	@DatabaseField(columnName = COLUMN_PARENT_FUTURE_FORECAST,  foreign = true)
	private FutureForecast parentFutureForecast;

	@DatabaseField(columnName = COLUMN_TEMPERATURE, foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
	@SerializedName("temperature")
	private Temperature temperature;


	@DatabaseField(columnName = COLUMN_CLOUD, foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
	@SerializedName("cloud")
	private Cloud cloud;

	@SerializedName("precipitation")
	private Precipitation precipitation;

	@DatabaseField(columnName = COLUMN_ICON_PATH)
	@SerializedName("icon")
	private String mIcon;

	@SerializedName("icon_path")
	private String iconPath;

	public HourForecast() {
	}

	public String getIconPath() {
		return iconPath;
	}

	public String getIcon(){ return mIcon; }

	public Temperature getTemperature() {
		return temperature;
	}

	public Cloud getCloud() {
		return cloud;
	}

	public int getID() {
		return mID;
	}

	public static void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) throws SQLException, java.sql.SQLException {
		TableUtils.createTable(connectionSource, HourForecast.class);
	}
}
