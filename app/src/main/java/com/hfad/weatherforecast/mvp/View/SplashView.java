package com.hfad.weatherforecast.mvp.View;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface SplashView extends MvpView {

	void startForecastScreen();
	void startSelectCityScreen();
}
