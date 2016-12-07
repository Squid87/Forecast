package com.hfad.weatherforecast.mvp;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.hfad.weatherforecast.mvp.View.MainView;


@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

	@Override
	protected void onFirstViewAttach() {
		super.onFirstViewAttach();
	}
	public void startCurrentForecast(){
		getViewState().currentForecast();
	}
}
