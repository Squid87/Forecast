package com.hfad.weatherforecast;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.hfad.weatherforecast.fragment.CurrentForecastFragment;
import com.hfad.weatherforecast.fragment.SelectCityFragment;
import com.hfad.weatherforecast.mvp.MainPresenter;
import com.hfad.weatherforecast.mvp.View.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends MvpAppCompatActivity implements MainView {
	@InjectPresenter
	MainPresenter mMainPresenter;

	private static final String LOG_TAG = "Click";

	@BindView(R.id.toolbar_actionbar)
	Toolbar mToolbar;

	@BindView(R.id.menu_navigation_home)
	BottomNavigationItemView mBottomNavigationItemView;

//	@BindView(R.id.activity_main_forecast_switch)
//	Switch mSwitch;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_forecast);
		initBind();
		setSupportActionBar(mToolbar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_toolbar, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
			case R.id.menu_toolbar_current_forecast:
				Log.d(LOG_TAG, "Onclick");
				mMainPresenter.startCurrentForecast();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}


	private void initBind() {
		ButterKnife.bind(this);
	}

	@Override
	public void startSelectCity() {
		getSupportFragmentManager().beginTransaction()
				.add(R.id.activity_main_forecast_container, new SelectCityFragment())
				.commit();
		getSupportFragmentManager().executePendingTransactions();
	}

	@Override
	public void startAbout() {

	}

	@Override
	public void currentForecast() {

		getSupportFragmentManager().beginTransaction()
				.add(R.id.activity_main_forecast_container, new CurrentForecastFragment())
				.commit();
		getSupportFragmentManager().executePendingTransactions();

	}

	@Override
	public void weaklyForecast() {
	}

}

