package com.hfad.weatherforecast;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.hfad.weatherforecast.adapters.Pref;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends MvpAppCompatActivity {
		//implements MainScreenView {

	@BindView(R.id.toolbar_actionbar)
	Toolbar mToolbar;
	Pref mPref;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_forecast);
		initBind();
		setSupportActionBar(mToolbar);
	}

	private void initBind() {
		ButterKnife.bind(this);
	}

//	@Override
//	public void startSelectCity() {
//		getSupportFragmentManager().beginTransaction()
//				.add(R.id.activity_main_forecast_container, new SelectCityFragment())
//				.commit();
//		getSupportFragmentManager().executePendingTransactions();
//
//	}
//
//	@Override
//	public void startAbout() {
//
//	}
//
//	@Override
//	public void currentForecast() {
//		getSupportFragmentManager().beginTransaction()
//				.add(R.id.activity_main_forecast_container, new CurrentFragment())
//				.commit();
//		getSupportFragmentManager().executePendingTransactions();
//	}
//
//	@Override
//	public void weaklyForecast() {
//	}

}
