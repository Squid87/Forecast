package com.hfad.weatherforecast;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.hfad.weatherforecast.fragment.AboutFragment;
import com.hfad.weatherforecast.fragment.CurrentForecastFragment;
import com.hfad.weatherforecast.fragment.FutureForecastsFragment;
import com.hfad.weatherforecast.fragment.SelectCityFragment;
import com.hfad.weatherforecast.mvp.MainPresenter;
import com.hfad.weatherforecast.mvp.View.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends MvpAppCompatActivity implements MainView {
	private static final String LOG_TAG = "Click";

	@InjectPresenter
	MainPresenter mMainPresenter;

	@BindView(R.id.toolbar_actionbar)
	Toolbar mToolbar;

	@BindView(R.id.menu_navigation_home)
	BottomNavigationItemView mBottomNavigationItemView;

	@BindView(R.id.activity_main_forecast_bottom_navigation)
	BottomNavigationView mBottomNavigationView;

	@BindView(R.id.activity_main_forecast_switch)
	Switch mSwitch;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_forecast);
		initBind();
		setSupportActionBar(mToolbar);

		//Переключение между экранами
		mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item) {
				switch (item.getItemId()) {
					case R.id.menu_navigation_home:
						mMainPresenter.startCurrentForecast();
						break;
					case R.id.menu_navigation_settings:
						mMainPresenter.startSelectCity();
						break;
					case R.id.menu_navigation_about:
						mMainPresenter.startAbout();
						break;
				}
				return false;
			}
		});

		mSwitch.setOnClickListener(view -> mMainPresenter.switchWork(mSwitch.isChecked()));
	}


	private void initBind() {
		ButterKnife.bind(this);
	}

	@Override
	public void startSelectCity() {

		getSupportFragmentManager().beginTransaction()
				.replace(R.id.activity_main_forecast_container, new SelectCityFragment())
				.commit();

		getSupportFragmentManager().executePendingTransactions();
	}

	@Override
	public void openAbout() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.activity_main_forecast_container, new AboutFragment())
				.commit();
		getSupportFragmentManager().executePendingTransactions();
	}

	@Override
	public void openCurrentForecast() {

		getSupportFragmentManager().beginTransaction()
				.replace(R.id.activity_main_forecast_container, new CurrentForecastFragment())
				.commit();
		getSupportFragmentManager().executePendingTransactions();

	}

	@Override
	public void hideSwitch() {
		mSwitch.setVisibility(View.GONE);
	}

	@Override
	public void showSwitch() {
		mSwitch.setChecked(false);
		mSwitch.setVisibility(View.VISIBLE);
	}

	@Override
	public void openWeaklyForecast() {

		getSupportFragmentManager().beginTransaction()
				.replace(R.id.activity_main_forecast_container, new FutureForecastsFragment())
				.commit();
		getSupportFragmentManager().executePendingTransactions();

	}

}

