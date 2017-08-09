package com.hfad.weatherforecast.mvp;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.hfad.weatherforecast.model.CityManager;
import com.hfad.weatherforecast.mvp.View.MainView;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;


@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
	private final Subscription mCityUpdatesSubscription;

	public MainPresenter() {
		mCityUpdatesSubscription = CityManager.getInstance().subscribeToCityUpdates()
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(city -> {
					getViewState().openCurrentForecast();
					getViewState().showSwitch();
				});
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mCityUpdatesSubscription.unsubscribe();
	}

	@Override
	protected void onFirstViewAttach() {
		super.onFirstViewAttach();
		getViewState().openCurrentForecast();
	}

	public void startCurrentForecast() {

		getViewState().openCurrentForecast();
		getViewState().showSwitch();
	}

	public void startAbout() {
		getViewState().openAbout();
		getViewState().hideSwitch();
	}

	public void startSelectCity() {
		getViewState().startSelectCity();
		getViewState().hideSwitch();
	}

	public void switchWork(Boolean isOn) {
		if (isOn) {
			getViewState().openWeaklyForecast();
		} else {
			getViewState().openCurrentForecast();
		}
	}
}
