package com.hfad.weatherforecast.mvp;

import java.util.concurrent.TimeUnit;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.hfad.weatherforecast.adapters.Pref;
import com.hfad.weatherforecast.mvp.View.SplashView;


@InjectViewState
public class SplashPresenter extends MvpPresenter<SplashView> {
	private static final int SPLASH_SHOW_TIME_SECONDS = 1;

	@Override
	protected void onFirstViewAttach() {
		super.onFirstViewAttach();
		Pref pref = new Pref();

		try {
			TimeUnit.SECONDS.sleep(SPLASH_SHOW_TIME_SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (pref.loadCity()==null) {
			getViewState().startSelectCityScreen();
		} else {
			getViewState().startForecastScreen();
		}
	}
}
