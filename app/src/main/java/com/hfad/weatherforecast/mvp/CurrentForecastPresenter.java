package com.hfad.weatherforecast.mvp;


import java.io.IOException;

import com.arellomobile.mvp.MvpPresenter;
import com.hfad.weatherforecast.WeatherApplication;
import com.hfad.weatherforecast.adapters.Pref;
import com.hfad.weatherforecast.model.ForecastResponse;
import com.hfad.weatherforecast.mvp.View.CurrentForecastView;
import com.hfad.weatherforecast.network.ForecastService;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class CurrentForecastPresenter extends MvpPresenter<CurrentForecastView> {
	Pref mPref = new Pref();
	ForecastService mForecastService = ForecastService.getInstance(WeatherApplication.getInstance());

	@Override
	protected void onFirstViewAttach() {
		super.onFirstViewAttach();

		//getViewState().showProgress;
		Observable.fromCallable(this::requestWeathers)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Subscriber<Response<ForecastResponse>>() {
					@Override
					public void onCompleted() {
						//getViewState().hideProgress
					}

					@Override
					public void onError(Throwable e) {
						//getViewState().hideProgress
						//getViewState().showError
					}

					@Override
					public void onNext(Response<ForecastResponse> response) {
						ForecastResponse forecastResponse = response.body();
						//getViewState().showForecasts
					}
				});
	}

	private Response<ForecastResponse> requestWeathers() throws IOException {

		return mForecastService.createForecaastApi().getCurrenForecast(mPref.loadCity()).execute();
	}
}
