package com.hfad.weatherforecast.mvp;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.hfad.weatherforecast.mvp.View.MainScreenView;


@InjectViewState
public class MainPresenter extends MvpPresenter<MainScreenView> {

	@Override
	protected void onFirstViewAttach() {
		super.onFirstViewAttach();

	}
}
