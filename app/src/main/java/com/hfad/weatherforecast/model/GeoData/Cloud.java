package com.hfad.weatherforecast.model.GeoData;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;

@DatabaseTable(tableName = Cloud.TABLE_NAME)
public class Cloud {

	public static final String TABLE_NAME = "cloud";
	private static final String COLUMN_TITLE = "title";
	private static final String COLUMN_ID = "_id";

	@DatabaseField(columnName = COLUMN_ID,generatedId = true)
	private int mId;

	@DatabaseField(columnName = COLUMN_TITLE)
	@SerializedName("title")
	private String mTitle;

	@SerializedName("value")
	public String mValue;

	public String getTitle() {return mTitle;}

	public String getValue(){return mValue;}

	public int getId() {return mId;}

	public static void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) throws SQLException, java.sql.SQLException {
		TableUtils.createTable(connectionSource,Cloud.class);
	}
}
