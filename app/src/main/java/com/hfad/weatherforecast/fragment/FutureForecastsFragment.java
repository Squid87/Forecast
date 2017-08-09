package com.hfad.weatherforecast.fragment;


import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.hfad.weatherforecast.R;
import com.hfad.weatherforecast.adapters.RecyclerViewFutureForecastsAdapter;
import com.hfad.weatherforecast.model.future.FutureForecast;
import com.hfad.weatherforecast.mvp.FutureForecastsPresenter;
import com.hfad.weatherforecast.mvp.View.FutureForecastsView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FutureForecastsFragment extends MvpAppCompatFragment implements FutureForecastsView {

	@InjectPresenter
	FutureForecastsPresenter mFutureForecastsPresenter;
	RecyclerViewFutureForecastsAdapter mRecyclerViewFutureForecastsAdapter;

	@BindView(R.id.fragment_future_weather_progress_bar)
	ProgressBar mFutureProgressBar;

	@BindView(R.id.fragment_future_weather_recycler_view)
	RecyclerView mRecyclerView;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_future_weather, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ButterKnife.bind(this,view);
}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		mRecyclerViewFutureForecastsAdapter = new RecyclerViewFutureForecastsAdapter();
		mRecyclerView.setAdapter(mRecyclerViewFutureForecastsAdapter);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

	}

	@Override
	public void showProgress() {
		mFutureProgressBar.setVisibility(ProgressBar.VISIBLE);
	}

	@Override
	public void hideProgress() {
		mFutureProgressBar.setVisibility(ProgressBar.GONE);
	}

	@Override
	public void showForecasts(List<FutureForecast> futureForecasts) {
		mRecyclerViewFutureForecastsAdapter.setFutureForecasts(futureForecasts);

	}
}
