package com.hfad.weatherforecast.model.GeoData;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;

@DatabaseTable(tableName = Astronomy.TABLE_NAME)
public class Astronomy {

	public static final String TABLE_NAME = "astronomy";
	private static final String COLUMN_SUNRISE = "sunrise";
	private static final String COLUMN_SUNSET = "sunset";
	private static final String COLUMN_ID = "_id";

	@DatabaseField(columnName = COLUMN_ID, id = true)
	private String mId;

	@DatabaseField(columnName = COLUMN_SUNRISE)
	@SerializedName("sunrise")
	private String sunrise;

	@DatabaseField(columnName = COLUMN_SUNSET)
	@SerializedName("sunset")
	private String sunset;

	@SerializedName("length_day_human")
	private String lengthDayHuman;

	@SerializedName("moon_illuminated")
	private int moonIlluminated;

	@SerializedName("moon_phase")
	private String moonPhase;

	public String getSunrise() {
		return sunrise;
	}

	public String getSunset() {
		return sunset;
	}

	public void setId(String id) {
		mId = id;
	}

	public static void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) throws SQLException, java.sql.SQLException {
		TableUtils.createTable(connectionSource, Astronomy.class);
	}
}
