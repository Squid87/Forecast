package com.hfad.weatherforecast.mvp;


import java.io.IOException;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.hfad.weatherforecast.WeatherApplication;
import com.hfad.weatherforecast.model.CityManager;
import com.hfad.weatherforecast.model.current.ForecastResponse;
import com.hfad.weatherforecast.mvp.View.CurrentForecastView;
import com.hfad.weatherforecast.network.ForecastService;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class CurrentForecastPresenter extends MvpPresenter<CurrentForecastView> {


	ForecastService mForecastService = ForecastService.getInstance(WeatherApplication.getInstance());

	@Override
	protected void onFirstViewAttach() {
		super.onFirstViewAttach();

		getViewState().showProgress();
		Observable.fromCallable(this::requestWeathers)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Subscriber<Response<ForecastResponse>>() {
					@Override
					public void onCompleted() {
						getViewState().hideProgress();
					}

					@Override
					public void onError(Throwable e) {

						getViewState().hideProgress();
						getViewState().showError();
						//загружаем данные из БД
						e.printStackTrace();

					}

					@Override
					public void onNext(Response<ForecastResponse> response) {
						ForecastResponse forecastResponse = response.body();
						getViewState().showForecasts(forecastResponse.getCurrentForecasts().get(0));
					}
				});
	}

	private Response<ForecastResponse> requestWeathers() throws IOException {
		return mForecastService.createForecastApi().getCurrentForecast(CityManager.getInstance().getSelectedCity()).execute();
	}
}
