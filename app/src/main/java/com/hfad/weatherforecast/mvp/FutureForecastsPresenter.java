package com.hfad.weatherforecast.mvp;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.hfad.weatherforecast.WeatherApplication;
import com.hfad.weatherforecast.database.DataBaseService;
import com.hfad.weatherforecast.model.CityManager;
import com.hfad.weatherforecast.model.current.CurrentForecast;
import com.hfad.weatherforecast.model.future.FutureForecast;
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
	DataBaseService mDataBaseService = new DataBaseService(WeatherApplication.getInstance());

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

						Toast toast = Toast.makeText(WeatherApplication.getInstance(),
								"Данные загружены из Базы данных", Toast.LENGTH_LONG);
						toast.show();
						toast.setGravity(Gravity.CENTER, 0, 0);

						//загружаем данные из БД
						try {
							getViewState().showForecasts(mDataBaseService.getFutureForecast());
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						e.printStackTrace();

					}

					@Override
					public void onNext(Response<FutureForecastsResponse> response) {
						FutureForecastsResponse forecastResponse = response.body();
						List<FutureForecast> forecasts = forecastResponse.getForecasts().subList(0, 4);
						getViewState().showForecasts(forecasts);

						try {
							mDataBaseService.saveFutureForecasts(forecasts);
						} catch (SQLException e) {
							e.printStackTrace();
						}

						Log.d(LOG_TAG, "RX");

					}
				});
	}

	private Response<FutureForecastsResponse> requestWeathers() throws IOException {
		return mForecastService.createForecastApi().getForecasts(CityManager.getInstance().getSelectedCity()).execute();
	}
}
