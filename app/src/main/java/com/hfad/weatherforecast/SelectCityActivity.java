package com.hfad.weatherforecast;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.hfad.weatherforecast.fragment.SelectCityFragment;
import com.hfad.weatherforecast.model.current.City;
import com.hfad.weatherforecast.mvp.SelectCityPresenter;
import com.hfad.weatherforecast.mvp.View.SelectCityView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectCityActivity extends MvpAppCompatActivity implements SelectCityListener,SelectCityView {

	@InjectPresenter
	SelectCityPresenter mPresenter;

	@BindView(R.id.fragment_select_city_button_skip)
	Button mSkipButton;

	public SelectCityListener mSelectCityListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_city_activity);
		initBind();
		SelectCityFragment cityFragment = new SelectCityFragment();
		cityFragment.setOnCityListener(this);
		setOnCityListener(this);

		//кнопка выбора города по умолчанию
		mSkipButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				City city = City.barnaul;
				mPresenter.userSelectCity(city);
				mSelectCityListener.onSelectCity(city);
			}
		});

		getSupportFragmentManager().beginTransaction()
				.add(R.id.select_city_activity_conteiner, cityFragment)
				.commit();
		getSupportFragmentManager().executePendingTransactions();
	}

	public void setOnCityListener(SelectCityListener selectCityListener) {
		mSelectCityListener = selectCityListener;
	}
	@Override
	public void onSelectCity(City city) {
		Intent mainIntent = new Intent(this, MainActivity.class);
		startActivity(mainIntent);
	}

	public void initBind() {
		ButterKnife.bind(this);
	}

}
