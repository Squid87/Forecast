package com.hfad.weatherforecast;

import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.hfad.weatherforecast.mvp.SplashPresenter;
import com.hfad.weatherforecast.mvp.View.SplashView;


public class SplashActivity extends MvpAppCompatActivity implements SplashView {
	@InjectPresenter
	SplashPresenter mPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
	}

	@Override
	public void startForecastScreen() {
		Intent mainIntent = new Intent(this, MainActivity.class);
		startActivity(mainIntent);
		finish();
	}

	@Override
	public void startSelectCityScreen() {
		Intent mainIntent = new Intent(this, SelectCityActivity.class);
		startActivity(mainIntent);
		finish();
}
}
