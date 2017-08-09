package com.hfad.weatherforecast.mvp;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.hfad.weatherforecast.model.CityManager;
import com.hfad.weatherforecast.model.City;
import com.hfad.weatherforecast.mvp.View.SelectCityView;

import rx.android.schedulers.AndroidSchedulers;

@InjectViewState
public class SelectCityPresenter extends MvpPresenter<SelectCityView> {
	public SelectCityPresenter() {
		CityManager.getInstance().subscribeToCityUpdates()
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(city -> getViewState().onSelectedCity(city));
	}

	public void userSelectCity(@NonNull City selectedCity) {
		CityManager.getInstance().selectCity(selectedCity);
	}

	public void userClickSkip() {
		CityManager.getInstance().selectCity(City.BARNAUL);
	}
}
