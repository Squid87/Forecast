package com.hfad.weatherforecast.mvp;


import android.view.Gravity;
import android.widget.Toast;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.hfad.weatherforecast.R;
import com.hfad.weatherforecast.WeatherApplication;
import com.hfad.weatherforecast.database.DataBaseService;
import com.hfad.weatherforecast.model.CityManager;
import com.hfad.weatherforecast.model.current.CurrentForecast;
import com.hfad.weatherforecast.model.current.ForecastResponse;
import com.hfad.weatherforecast.mvp.View.CurrentForecastView;
import com.hfad.weatherforecast.network.ForecastService;
import com.j256.ormlite.logger.Log;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@InjectViewState
public class CurrentForecastPresenter extends MvpPresenter<CurrentForecastView> {


    ForecastService mForecastService = ForecastService.getInstance(WeatherApplication.getInstance());
    DataBaseService mDataBaseService = new DataBaseService(WeatherApplication.getInstance());
    List<CurrentForecast> mCurrentForecasts = new ArrayList<>();


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
                        Toast toast = Toast.makeText(WeatherApplication.getInstance(),
                                "Данные загружены из Базы данных", Toast.LENGTH_LONG);
                        toast.show();
                        toast.setGravity(Gravity.CENTER, 0, 0);

                        //загружаем данные из БД
                        try {
                            getViewState().showForecasts(mDataBaseService.getCurrentForecast());
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Response<ForecastResponse> response) {
                        ForecastResponse forecastResponse = response.body();
                        getViewState().showForecasts(forecastResponse.getCurrentForecast());
                        try {
                            mDataBaseService.saveCurrentForecast(forecastResponse.getCurrentForecast());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    private Response<ForecastResponse> requestWeathers() throws IOException {
        return mForecastService.createForecastApi().getCurrentForecast(CityManager.getInstance().getSelectedCity()).execute();
    }

}
