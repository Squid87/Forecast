package com.hfad.weatherforecast.model.GeoData;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;

@DatabaseTable(tableName = Direction.TABLE_NAME)
public class Direction {

	public static final String TABLE_NAME = "direction";
	private static final String COLUMN_ID = "_id";
	private static final String COLUMN_TITLE = "title";


	@DatabaseField(columnName = COLUMN_ID,generatedId = true)
	private int mID;

	@SerializedName("title")
	public String mTitle;

	@SerializedName("title_letter")
	public String mTitleLetter;

	@DatabaseField(columnName = COLUMN_TITLE)
	@SerializedName("title_short")
	private String mTitleShort;

	@SerializedName("value")
	public String mValue;

	public String getTitleShort() {
		return mTitleShort;
	}

	public int getID() {return mID;	}

	public static void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) throws SQLException, java.sql.SQLException {
		TableUtils.createTable(connectionSource,Direction.class);
	}

}
