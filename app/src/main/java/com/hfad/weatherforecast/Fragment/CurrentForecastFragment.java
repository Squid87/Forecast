package com.hfad.weatherforecast.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.hfad.weatherforecast.R;
import com.hfad.weatherforecast.model.CityManager;
import com.hfad.weatherforecast.model.current.CurrentForecast;
import com.hfad.weatherforecast.mvp.CurrentForecastPresenter;
import com.hfad.weatherforecast.mvp.View.CurrentForecastView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CurrentForecastFragment extends MvpAppCompatFragment implements CurrentForecastView {

	@InjectPresenter
	CurrentForecastPresenter mPresenter;

	@BindView(R.id.item_activity_current_weather_progress_bar)
	ProgressBar mCurrentForecastProgressBar;

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

	@BindView(R.id.item_activity_current_weather_date)
	TextView mDate;

	@BindView(R.id.item_activity_current_weather_city)
	TextView mCityTextView;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_current_weather, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ButterKnife.bind(this, view);

	}

	private void bind(CurrentForecast currentForecast) {
		Picasso.with(getActivity())
				.load("http:" + currentForecast.getIconPath())
				.placeholder(R.mipmap.ic_launcher)
				.into(mIconImageView);

		mDate.setText(String.valueOf(currentForecast.getDate()));
		mCityTextView.setText(CityManager.getInstance().getSelectedCity().getCityNameRes());
		mRisingTimeTextView.setText(String.valueOf(currentForecast.mAstronomy.getSunrise()));
		mSunSetTimeTextView.setText(String.valueOf(currentForecast.mAstronomy.getSunset()));
		mCurrentDegreeTextView.setText(String.valueOf(currentForecast.getTemperature()) + "°" + "C");
		mParssureTextView.setText(String.valueOf(currentForecast.getPressure()) + " мм.р.с");
		mCurrentHumidityTextView.setText(String.valueOf(currentForecast.getHumidity()) + " %");
		mCurrentWindDirectionTextView.setText(String.valueOf(currentForecast.getWind().getDirection().getTitleShort()));
		mCurrentWindSpeedTextView.setText(String.valueOf(currentForecast.getWind().getSpeed()) + " м/с");
		mCurrentCloudTextView.setText(String.valueOf(currentForecast.getCloud().getTitle()));
	}

	@Override
	public void showProgress() {
		mCurrentForecastProgressBar.setVisibility(ProgressBar.VISIBLE);
	}

	@Override
	public void hideProgress() {
		mCurrentForecastProgressBar.setVisibility(ProgressBar.GONE);
	}


	@Override
	public void showForecasts(CurrentForecast currentForecast) {
		bind(currentForecast);
	}

	@Override
	public void showError() {
		Toast toast = Toast.makeText(getContext(),
				"Проверьте соединение с интернетом!", Toast.LENGTH_SHORT);
		toast.show();
		toast.setGravity(Gravity.CENTER, 0, 0);
	}
}

