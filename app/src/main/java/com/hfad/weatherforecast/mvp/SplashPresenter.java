package com.hfad.weatherforecast.mvp;

import java.util.concurrent.TimeUnit;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.hfad.weatherforecast.model.CityManager;
import com.hfad.weatherforecast.mvp.View.SplashView;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


@InjectViewState
public class SplashPresenter extends MvpPresenter<SplashView> {
	private static final int SPLASH_SHOW_TIME_SECONDS = 1;

	@Override
	protected void onFirstViewAttach() {
		super.onFirstViewAttach();

		Observable.just("")
				.subscribeOn(Schedulers.computation())
				.delay(SPLASH_SHOW_TIME_SECONDS, TimeUnit.SECONDS)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(s -> startNextScreen());
	}

	private void startNextScreen() {

		if (CityManager.getInstance().getSelectedCity() == null) {
			getViewState().startSelectCityScreen();
		} else {
			getViewState().startForecastScreen();
		}
	}
}
