package com.hfad.weatherforecast.model;

import com.google.gson.annotations.SerializedName;

public class Wind {

	@SerializedName("speed")
	public int mSpeed;

	@SerializedName("direction")
	public Direction mDirection;
}
