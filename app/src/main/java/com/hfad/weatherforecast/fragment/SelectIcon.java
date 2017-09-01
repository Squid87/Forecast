package com.hfad.weatherforecast.fragment;


import com.hfad.weatherforecast.model.GeoData.HourForecast;
import com.hfad.weatherforecast.model.current.CurrentForecast;
import com.hfad.weatherforecast.model.future.FutureForecast;

public class SelectIcon {

    public int getSelectIconCurrentForecast(CurrentForecast currentForecast) {

        if ("cloudy_non_day".equals(currentForecast.getIcon())) {
            return 0x7f030001;
        }
        if ("cloudy_rain_day".equals(currentForecast.getIcon())) {
            return 0x7f030002;
        }
        if ("cloudy_rain_night".equals(currentForecast.getIcon())) {
            return 0x7f030003;
        }
        if ("mostly_cloudy_none_day".equals(currentForecast.getIcon())) {
            return 0x7f030006;
        }
        if ("mostly_cloudy_rain_day".equals(currentForecast.getIcon())) {
            return 0x7f030007;
        }
        if ("mostly_cloudy_rain_night".equals(currentForecast.getIcon())) {
            return 0x7f030008;
        }
        if ("partly_cloudy_none_night".equals(currentForecast.getIcon())) {
            return 0x7f030009;
        }
        if ("partly_cloudy_rain_night".equals(currentForecast.getIcon())) {
            return 0x7f03000b;
        }
        if ("partly_cloudy_rain_day".equals(currentForecast.getIcon())) {
            return 0x7f03000a;
        }
        if ("sunshine_none_day".equals(currentForecast.getIcon())) {
            return 0x7f03000e;
        }
        if ("sunshine_non_night".equals(currentForecast.getIcon())) {
            return 0x7f03000f;
        }
        return 0x7f030003;
    }

    public int getSelectIconFutureForecast(HourForecast hourForecast) {
        if ("cloudy_non_day".equals(hourForecast.getIcon())) {
            return 0x7f030001;
        }
        if ("cloudy_rain_day".equals(hourForecast.getIcon())) {
            return 0x7f030002;
        }
        if ("cloudy_rain_night".equals(hourForecast.getIcon())) {
            return 0x7f030003;
        }
        if ("mostly_cloudy_none_day".equals(hourForecast.getIcon())) {
            return 0x7f030006;
        }
        if ("mostly_cloudy_rain_day".equals(hourForecast.getIcon())) {
            return 0x7f030007;
        }
        if ("mostly_cloudy_rain_night".equals(hourForecast.getIcon())) {
            return 0x7f030008;
        }
        if ("partly_cloudy_none_night".equals(hourForecast.getIcon())) {
            return 0x7f030009;
        }
        if ("partly_cloudy_rain_night".equals(hourForecast.getIcon())) {
            return 0x7f03000b;
        }
        if ("partly_cloudy_rain_day".equals(hourForecast.getIcon())) {
            return 0x7f03000a;
        }
        if ("sunshine_none_day".equals(hourForecast.getIcon())) {
            return 0x7f03000e;
        }
        if ("sunshine_non_night".equals(hourForecast.getIcon())) {
            return 0x7f03000f;
        }
        return 0x7f030003;
    }
}
