package com.hfad.weatherforecast;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.hfad.weatherforecast.fragment.SelectCityFragment;
import com.hfad.weatherforecast.model.City;
import com.hfad.weatherforecast.mvp.SelectCityPresenter;
import com.hfad.weatherforecast.mvp.View.SelectCityView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectCityActivity extends MvpAppCompatActivity implements SelectCityView {
	@InjectPresenter
	SelectCityPresenter mPresenter;

	@BindView(R.id.fragment_select_city_button_skip)
	Button mSkipButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_city_activity);
		initBind();
		SelectCityFragment cityFragment = new SelectCityFragment();

		//кнопка выбора города по умолчанию
		mSkipButton.setOnClickListener(view -> mPresenter.userClickSkip());

		getSupportFragmentManager().beginTransaction()
				.add(R.id.select_city_activity_conteiner, cityFragment)
				.commit();
		getSupportFragmentManager().executePendingTransactions();
	}

	@Override
	public void onSelectedCity(City city) {
		Intent mainIntent = new Intent(this, MainActivity.class);
		startActivity(mainIntent);
	}

	public void initBind() {
		ButterKnife.bind(this);
	}

}
