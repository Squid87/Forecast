package com.hfad.weatherforecast.adapters;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.hfad.weatherforecast.model.Forecasts;


public class RecyclerViewCurrentForecastAdapter extends RecyclerView.Adapter<RecyclerViewCurrentForecastHolder> {

	private List<Forecasts> weather = new ArrayList<>();

	@Override
	public RecyclerViewCurrentForecastHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return null;
	}

	@Override
	public void onBindViewHolder(RecyclerViewCurrentForecastHolder holder, int position) {
		holder.bind(weather.get(position));
	}

	@Override
	public int getItemCount() {
		return weather.size();
	}

	public void setCollection(List<Forecasts> collection) {
		weather.addAll(collection);
		notifyDataSetChanged();
	}
}
