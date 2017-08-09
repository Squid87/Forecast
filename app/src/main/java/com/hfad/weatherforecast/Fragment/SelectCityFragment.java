package com.hfad.weatherforecast.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.hfad.weatherforecast.R;
import com.hfad.weatherforecast.adapters.RecyclerViewSelectCityAdapter;
import com.hfad.weatherforecast.model.City;
import com.hfad.weatherforecast.mvp.SelectCityPresenter;
import com.hfad.weatherforecast.mvp.View.SelectCityView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SelectCityFragment extends MvpAppCompatFragment implements SelectCityView {
	@InjectPresenter
	SelectCityPresenter mPresenter;

	@BindView(R.id.fragment_select_city_recycler_view)
	RecyclerView mSelectCityRecyclerView;

	RecyclerViewSelectCityAdapter mSelectCityRecyclerViewAdapter;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_select_city, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ButterKnife.bind(this, view);

		mSelectCityRecyclerViewAdapter = new RecyclerViewSelectCityAdapter(LayoutInflater.from(getContext()),
				city -> mPresenter.userSelectCity(city));

		mSelectCityRecyclerView.setAdapter(mSelectCityRecyclerViewAdapter);
		mSelectCityRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
	}

	@Override
	public void onSelectedCity(City city) {
		//pass
	}
}
