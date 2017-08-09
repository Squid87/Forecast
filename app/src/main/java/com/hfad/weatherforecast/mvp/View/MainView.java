package com.hfad.weatherforecast.mvp.View;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;


@StateStrategyType(SingleStateStrategy.class)
public interface MainView extends MvpView {

	@StateStrategyType(OneExecutionStateStrategy.class)
	void startSelectCity();

	void openAbout();

	void openCurrentForecast();

	void openWeaklyForecast();

	void hideSwitch();

	void showSwitch();
}
