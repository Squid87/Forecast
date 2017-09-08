package com.hfad.weatherforecast.model.GeoData;

import java.sql.SQLException;
import java.util.Random;

import android.database.sqlite.SQLiteDatabase;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.table.TableUtils;


@DatabaseTable(tableName = Wind.TABLE_NAME)
public class Wind {

    public static final String TABLE_NAME = "wind";
    private static final String COLUMN_SPEED = "speed";
    private static final String COLUMN_ID = "_id";

    @DatabaseField(columnName = COLUMN_ID, generatedId = true)
    private int mId;

    @DatabaseField(columnName = COLUMN_SPEED)
    @SerializedName("speed")
    private int mSpeed;

    @SerializedName("direction")
    private Direction mDirection;

    public int getSpeed() {
        return mSpeed;
    }

    public Direction getDirection() {
        return mDirection;
    }

    public int getId() {
        return mId;
    }

    public static void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) throws SQLException {
        TableUtils.createTable(connectionSource, Wind.class);
    }
}
