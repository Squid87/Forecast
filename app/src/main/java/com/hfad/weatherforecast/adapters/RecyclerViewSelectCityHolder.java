package com.hfad.weatherforecast.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hfad.weatherforecast.R;
import com.hfad.weatherforecast.model.City;

import butterknife.BindView;
import butterknife.ButterKnife;


@SuppressWarnings("WeakerAccess")
public class RecyclerViewSelectCityHolder extends RecyclerView.ViewHolder {

	@BindView(R.id.item_select_city_choice_city)
	private	TextView mSelectCityTextView;

	public RecyclerViewSelectCityHolder(View itemView) {
		super(itemView);
		ButterKnife.bind(this, itemView);
	}

	public void bind(City city) {
		mSelectCityTextView.setText(itemView.getContext().getString(city.getCityNameRes()));
	}
}
