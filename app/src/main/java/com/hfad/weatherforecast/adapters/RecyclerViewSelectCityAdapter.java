package com.hfad.weatherforecast.adapters;

import java.util.Arrays;
import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hfad.weatherforecast.R;
import com.hfad.weatherforecast.SelectCityListener;
import com.hfad.weatherforecast.model.current.City;


public class RecyclerViewSelectCityAdapter extends RecyclerView.Adapter<RecyclerViewSelectCityHolder> {
	private static final String TAG = "RecyclerViewSelectCityAdapter";

	private List<City> mCityList = Arrays.asList(City.values());

	private LayoutInflater mInflater;
	private SelectCityListener mCityListener;

	public RecyclerViewSelectCityAdapter(LayoutInflater inflater, SelectCityListener cityListener) {
		mInflater = inflater;
		mCityListener = cityListener;
	}

	@Override
	public RecyclerViewSelectCityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new RecyclerViewSelectCityHolder(mInflater.inflate(R.layout.item_select_city, parent, false));
	}

	@Override
	public void onBindViewHolder(RecyclerViewSelectCityHolder holder, final int position) {
		holder.bind(mCityList.get(position));

		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mCityListener.onSelectCity(mCityList.get(position));
			}
		});
	}

	@Override
	public int getItemCount() {
		return mCityList.size();
	}

}
