package com.hfad.weatherforecast.Fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.weatherforecast.R;
import com.hfad.weatherforecast.model.Forecasts;
import com.hfad.weatherforecast.mvp.View.CurrentForecastView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CurrentFragment extends Fragment implements CurrentForecastView {

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

	@BindView(R.id.item_activity_current_weather_rising_time)
	TextView mRisingTimeTextView;

	@BindView(R.id.item_activity_current_weather_sunset_time)
	TextView mSunSetTimeTextView;

	List<Forecasts> mForecasts = new ArrayList<>();

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ButterKnife.bind(this, view);
		bind((Forecasts) mForecasts);
	}

	private void bind(Forecasts forecasts) {

		Picasso.with(getActivity())
				.load("http:" + forecasts.getIconPath())
				.placeholder(R.mipmap.ic_launcher)
				.into(mIconImageView);

		//mTextViewData.setText(String.valueOf(model.getDate()));
		//mCityTextView.setText("Barnaul");


		mRisingTimeTextView.setText(String.valueOf(forecasts.mAstronomy.getSunrise()));
		mSunSetTimeTextView.setText(String.valueOf(forecasts.mAstronomy.getSunset()));
		mCurrentDegreeTextView.setText(String.valueOf(forecasts.getTemperature()));
		mParssureTextView.setText(String.valueOf(forecasts.getPressure()));
		mCurrentHumidityTextView.setText(String.valueOf(forecasts.getHumidity()));
		mCurrentWindDirectionTextView.setText(String.valueOf(forecasts.getWind().getDirection()));
		mCurrentWindSpeedTextView.setText(String.valueOf(forecasts.getWind().getSpeed()));
		mCurrentCloudTextView.setText(String.valueOf(forecasts.getCloud().getTitle()));
	}
}

