package com.hfad.weatherforecast.mvp.View;

import java.util.List;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.hfad.weatherforecast.model.future.FutureForecast;


@StateStrategyType(SkipStrategy.class)
public interface FutureForecastsView extends MvpView {

	void showProgress();
	void hideProgress();
	void showForecasts(List<FutureForecast> futureForecasts);
}
