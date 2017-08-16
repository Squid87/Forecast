package com.hfad.weatherforecast.mvp;


import java.io.IOException;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.hfad.weatherforecast.WeatherApplication;
import com.hfad.weatherforecast.database.DataBaseService;
import com.hfad.weatherforecast.model.CityManager;
import com.hfad.weatherforecast.model.future.FutureForecastsResponse;
import com.hfad.weatherforecast.mvp.View.FutureForecastsView;
import com.hfad.weatherforecast.network.ForecastService;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class FutureForecastsPresenter extends MvpPresenter<FutureForecastsView> {

	private static final String LOG_TAG = "Click";
	ForecastService mForecastService = ForecastService.getInstance(WeatherApplication.getInstance());
	DataBaseService mDataBaseService;

	@Override
	protected void onFirstViewAttach() {
		super.onFirstViewAttach();
		getViewState().showProgress();
		Observable.fromCallable(this::requestWeathers)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Subscriber<Response<FutureForecastsResponse>>() {

					@Override
					public void onCompleted() {
						getViewState().hideProgress();
					}

					@Override
					public void onError(Throwable e) {

						getViewState().hideProgress();
						//загружаем данные из БД
						e.printStackTrace();

					}

					@Override
					public void onNext(Response<FutureForecastsResponse> response) {
						FutureForecastsResponse forecastResponse = response.body();
						getViewState().showForecasts(forecastResponse.getForecasts());
						Log.d(LOG_TAG, "RX");

					}
				});
	}

	private Response<FutureForecastsResponse> requestWeathers() throws IOException {
		return mForecastService.createForecastApi().getForecasts(CityManager.getInstance().getSelectedCity()).execute();
	}
}
