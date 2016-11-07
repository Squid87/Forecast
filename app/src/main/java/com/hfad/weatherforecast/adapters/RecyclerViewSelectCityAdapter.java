package com.hfad.weatherforecast.adapters;

import java.util.Arrays;
import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpDelegate;
import com.hfad.weatherforecast.SelectCityListener;
import com.hfad.weatherforecast.model.City;


public class RecyclerViewSelectCityAdapter extends RecyclerView.Adapter<RecyclerViewSelectCityHolder> {
	private static final String TAG = "RecyclerViewSelectCityAdapter";

	private MvpDelegate<?> mMvpDelegate;

	private List<City> mCityList = Arrays.asList(City.values());

	private SelectCityListener mCityListener;

	public RecyclerViewSelectCityAdapter(SelectCityListener cityListener) {
		mCityListener = cityListener;
	}

	@Override
	public RecyclerViewSelectCityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return null;
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
