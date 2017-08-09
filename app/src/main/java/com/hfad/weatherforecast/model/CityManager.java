package com.hfad.weatherforecast.model;


import android.support.annotation.Nullable;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;


public class CityManager {
	//region Singleton
	private static CityManager sInstance;
	public static CityManager getInstance() {
		if (sInstance == null) {
			synchronized (CityManager.class) {
				if (sInstance == null) {
					sInstance = new CityManager();
				}
			}
		}
		return sInstance;
	}

	private CityManager() {
	}
	//endregion

	private Subject<City, City> mCitySubject = PublishSubject.create();
	private Pref mPref = new Pref();

	public void selectCity(City city) {
		mPref.saveCity(city);
		mCitySubject.onNext(city);
	}

	@Nullable
	public City getSelectedCity() {
		return mPref.loadCity();
	}

	public Observable<City> subscribeToCityUpdates() {
		return mCitySubject;
	}
}
