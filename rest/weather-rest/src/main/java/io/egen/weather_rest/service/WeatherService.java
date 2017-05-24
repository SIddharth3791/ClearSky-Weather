package io.egen.weather_rest.service;

import java.util.Date;
import java.util.List;


import io.egen.weather_rest.entity.WeatherData;

public interface WeatherService {

	public WeatherData getWeatherdata(WeatherData weatherData);
	public List<String> findAllCities();
	public WeatherData latestWeatherPerCity(String cityName);
	public String latestWeatherPropertyPerCity( String cityName, String property);
	public  List<WeatherData> hourlyAvgWeather(String cityName);
	public  WeatherData dailyAvgWeather( String cityName,  String date);
	
}
