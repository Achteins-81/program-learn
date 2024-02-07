package org.achteins81.app.webservice.impl;

import org.achteins81.app.webservice.WeatherService;

import javax.jws.WebService;

@WebService
public class WeatherServiceImpl implements WeatherService {
    @Override
    public String getWeatherByCityName(String cityName) {
        return cityName + "天气晴朗！";
    }
}
