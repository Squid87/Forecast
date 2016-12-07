package com.hfad.weatherforecast.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.weatherforecast.R;
import com.hfad.weatherforecast.model.Forecast;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


@SuppressWarnings("WeakerAccess")
public class RecyclerViewCurrentForecastHolder extends RecyclerView.ViewHolder {

	@BindView(R.id.item_activity_current_weather_degree)
	TextView mCurrentDegreeTextView;

	@BindView(R.id.item_activity_current_weather_cloud)
	TextView mCurrentCloudTextView;

	@BindView(R.id.item_activity_current_weather_humidity)
	TextView mCurrentHumidityTextView;

	@BindView(R.id.item_activity_current_weather_wind_direction)
	TextView mCurrentWindDirectionTextView;

	@BindView(R.id.item_activity_current_weather_wind_speed)
	TextView mCurrentWindSpeedTextView;

	@BindView(R.id.item_activity_current_weather_image_image_view)
	ImageView mIconImageView;

	@BindView(R.id.item_activity_current_weather_pressure)
	TextView mParssureTextView;


	public RecyclerViewCurrentForecastHolder(View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
	}

	public void bind(Forecast forecast) {
			Picasso.with(itemView.getContext())
					.load("http:" + forecast.getIconPath())
					.placeholder(R.mipmap.ic_launcher)
					.into(mIconImageView);


		//mTextViewData.setText(String.valueOf(model.getDate()));
		//mCityTextView.setText("Barnaul");

		mCurrentDegreeTextView.setText(String.valueOf(forecast.getTemperature()));
		mParssureTextView.setText(String.valueOf(forecast.getPressure()));
		mCurrentHumidityTextView.setText(String.valueOf(forecast.getHumidity()));
		mCurrentWindDirectionTextView.setText(String.valueOf(forecast.getWind().getDirection()));
		mCurrentWindSpeedTextView.setText(String.valueOf(forecast.getWind().getSpeed()));
		mCurrentCloudTextView.setText(String.valueOf(forecast.getCloud().getTitle()));
	}
}
