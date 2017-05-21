package io.egen.weather_rest.service;

import java.util.Date;
import java.util.List;


import io.egen.weather_rest.entity.WeatherData;

public interface WeatherService {

	public WeatherData getWeatherdata();
	public List<String> findAllCities();
	public WeatherData latestWeatherPerCity(String cityName);
	public WeatherData latestWeatherPropertyPerCity( String cityName, String property);
	public WeatherData hourlyAvgWeather(String cityName);
	public WeatherData dailyAvgWeather( String cityName,  Date date);
	
}
