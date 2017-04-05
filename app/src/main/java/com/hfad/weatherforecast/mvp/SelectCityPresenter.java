package com.hfad.weatherforecast.mvp;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.hfad.weatherforecast.model.CityManager;
import com.hfad.weatherforecast.model.current.City;
import com.hfad.weatherforecast.mvp.View.SelectCityView;

@InjectViewState
public class SelectCityPresenter extends MvpPresenter<SelectCityView> {
	public void userSelectCity(City selectedCity) {
		CityManager.getInstance().selectCity(selectedCity);
	}
}
