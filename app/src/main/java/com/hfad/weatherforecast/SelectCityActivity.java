package com.hfad.weatherforecast;


import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.hfad.weatherforecast.model.City;

public class SelectCityActivity extends MvpAppCompatActivity implements SelectCityListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_city_activity);

		SelectCityFragment cityFragment = new SelectCityFragment();
		cityFragment.setOnCityListener(this);

		getSupportFragmentManager().beginTransaction()
				.add(R.id.select_city_activity_conteiner, cityFragment)
				.commit();
		getSupportFragmentManager().executePendingTransactions();
	}

	@Override
	public void onSelectCity(City city) {
		//start main activity
		Intent mainIntent = new Intent(this, MainActivity.class);
		startActivity(mainIntent);
	}
}
