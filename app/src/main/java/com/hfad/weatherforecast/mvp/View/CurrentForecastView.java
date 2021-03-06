package com.hfad.weatherforecast.mvp.View;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.hfad.weatherforecast.model.current.CurrentForecast;

@StateStrategyType(SkipStrategy.class)
public interface CurrentForecastView extends MvpView{
	void showProgress();
	void hideProgress();
	void showForecasts(CurrentForecast currentForecast);
	void showError();
}
