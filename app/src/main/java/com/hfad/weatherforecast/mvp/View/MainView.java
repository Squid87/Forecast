package com.hfad.weatherforecast.mvp.View;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;


@StateStrategyType(AddToEndSingleStrategy.class)
public interface MainView extends MvpView {

	@StateStrategyType(SkipStrategy.class)//лучше oneexecution
	void startSelectCity();

	void startAbout();

	void currentForecast();

	void weaklyForecast();

	void hideSwitch();

	void showSwitch();
}
