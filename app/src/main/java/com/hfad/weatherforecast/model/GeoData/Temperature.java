package com.hfad.weatherforecast.model.GeoData;

import java.sql.SQLException;

import android.database.sqlite.SQLiteDatabase;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;

@DatabaseTable(tableName = Temperature.TABLE_NAME)
public class Temperature {

	public static final String TABLE_NAME = "temperature";
	private static final String COLUMN_AVG = "avg";
	private static final String COLUMN_ID = "_id";


	@DatabaseField(columnName = COLUMN_ID, id = true)
	private String mId;

	@SerializedName("min")
	private int min;

	@SerializedName("max")
	private int max;

	@DatabaseField(columnName = COLUMN_AVG)
	@SerializedName("avg")
	private int avg;

	public int getAvg() {
		return avg;
	}

	public String getId() {
		return mId;
	}

	public void setId(String id) {
		mId = id;
	}

	public static void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) throws SQLException {
		TableUtils.createTable(connectionSource, Temperature.class);
	}

}
