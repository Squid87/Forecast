package com.hfad.weatherforecast.mvp.View;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.hfad.weatherforecast.model.City;


@StateStrategyType(SkipStrategy.class)//TODO почему skip и какие могут быть проблемы?

public interface SelectCityView extends MvpView {
	void onSelectedCity(City city);
}
