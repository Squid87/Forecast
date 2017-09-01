package com.hfad.weatherforecast.adapters;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfad.weatherforecast.R;
import com.hfad.weatherforecast.fragment.SelectIcon;
import com.hfad.weatherforecast.model.future.FutureForecast;
import com.hfad.weatherforecast.model.GeoData.HourForecast;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecyclerViewFutureForecastsHolder extends RecyclerView.ViewHolder {

	@BindView(R.id.item_activity_weather_image_view_00)
	ImageView m00ImageView;

	@BindView(R.id.item_activity_weather_image_view_06)
	ImageView m06ImageView;

	@BindView(R.id.item_activity_weather_image_view_12)
	ImageView m12ImageView;

	@BindView(R.id.item_activity_weather_image_view_18)
	ImageView m18ImageView;

	@BindView(R.id.item_activity_weather_text_view_sunset_time)
	TextView mSunsetTimeTextView;

	@BindView(R.id.item_activity_weather_text_view_rising_time)
	TextView mRisingTimeTextView;

	@BindView(R.id.item_activity_weather_text_view_date)
	TextView mDateTextView;

	@BindView(R.id.item_activity_weather_text_view_rising_cloud)
	TextView mRisingCloudTextView;

	@BindView(R.id.item_activity_weather_text_view_night_cloud)
	TextView mNightCloudTextView;

	@BindView(R.id.item_activity_weather_text_view_day_cloud)
	TextView mDayCloudTextView;

	@BindView(R.id.item_activity_weather_text_view_evening_cloud)
	TextView mEveningCloudTextView;

	@BindView(R.id.item_activity_weather_text_view_rising_degree)
	TextView mRisingDegreeTextView;

	@BindView(R.id.item_activity_weather_text_view_night_degree)
	TextView mNightDegreeTextView;

	@BindView(R.id.item_activity_weather_text_view_day_degree)
	TextView mDayDegreeTextView;

	@BindView(R.id.item_activity_weather_text_view_evening_degree)
	TextView mEveningDegreeTextView;


	public RecyclerViewFutureForecastsHolder(View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
	}

	public void bind(FutureForecast model) {
		SelectIcon mSelectIcon = new SelectIcon();

		List<HourForecast> hours = new ArrayList<>(model.getHours());

		Picasso.with(itemView.getContext())
				.load(mSelectIcon.getSelectIconFutureForecast(hours.get(0)))
				.placeholder(R.mipmap.ic_launcher)
				.into(m00ImageView);

		Picasso.with(itemView.getContext())
				.load(mSelectIcon.getSelectIconFutureForecast(hours.get(1)))
				.placeholder(R.mipmap.ic_launcher)
				.into(m06ImageView);

		Picasso.with(itemView.getContext())
				.load(mSelectIcon.getSelectIconFutureForecast(hours.get(2)))
				.placeholder(R.mipmap.ic_launcher)
				.into(m12ImageView);

		Picasso.with(itemView.getContext())
				.load(mSelectIcon.getSelectIconFutureForecast(hours.get(3)))
				//.load("http:" + hours.get(3).getIconPath())
				.placeholder(R.mipmap.ic_launcher)
				.into(m18ImageView);


		mDateTextView.setText(String.valueOf(model.getDate()));
		mRisingTimeTextView.setText(String.valueOf(model.getAstronomy().getSunrise()));
		mSunsetTimeTextView.setText(String.valueOf(model.getAstronomy().getSunset()));

		//Облочность
		mNightCloudTextView.setText(hours.get(0).getCloud().getTitle());
		mRisingCloudTextView.setText(hours.get(1).getCloud().getTitle());
		mDayCloudTextView.setText(hours.get(2).getCloud().getTitle());
		mEveningCloudTextView.setText(hours.get(3).getCloud().getTitle());

		//Температура
		mNightDegreeTextView.setText(String.valueOf(hours.get(0).getTemperature().getAvg()) + "°" + "C");
		mRisingDegreeTextView.setText(String.valueOf(hours.get(1).getTemperature().getAvg()) + "°" + "C");
		mDayDegreeTextView.setText(String.valueOf(hours.get(2).getTemperature().getAvg()) + "°" + "C");
		mEveningDegreeTextView.setText(String.valueOf(hours.get(3).getTemperature().getAvg()) + "°" + "C");

	}
}
