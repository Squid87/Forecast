package com.hfad.weatherforecast.adapters;


import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hfad.weatherforecast.R;
import com.hfad.weatherforecast.model.future.FutureForecast;

public class RecyclerViewFutureForecastsAdapter extends RecyclerView.Adapter<RecyclerViewFutureForecastsHolder> {

	private List<FutureForecast> mForecasts = new ArrayList<>();

	@Override
	public RecyclerViewFutureForecastsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View mInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity_weather, parent, false);
		return new RecyclerViewFutureForecastsHolder(mInflate);
	}

	@Override
	public void onBindViewHolder(RecyclerViewFutureForecastsHolder holder, int position) {
		holder.bind(mForecasts.get(position));
	}

	@Override
	public int getItemCount() {
		return mForecasts.size();
	}

	public void setFutureForecasts(List<FutureForecast> forecasts) {
		mForecasts.addAll(forecasts);
		notifyDataSetChanged();
	}
}
