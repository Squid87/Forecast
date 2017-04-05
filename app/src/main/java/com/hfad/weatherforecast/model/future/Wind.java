package com.hfad.weatherforecast.model.future;

import com.google.gson.annotations.SerializedName;

public class Wind {

	@SerializedName("speed")
	private Speed speed;

	@SerializedName("direction")
	private Direction direction;
}
