package com.hfad.weatherforecast.model.GeoData;

import com.google.gson.annotations.SerializedName;

public class Wind {

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
}
