package io.egen.weather_rest.repository.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import io.egen.weather_rest.entity.WeatherData;
import io.egen.weather_rest.repository.WeatherRepository;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository {

	@Override
	public WeatherData getWeatherdata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> findAllCities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WeatherData latestWeatherPerCity(String cityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WeatherData latestWeatherPropertyPerCity(String cityName, String property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WeatherData hourlyAvgWeather(String cityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WeatherData dailyAvgWeather(String cityName, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

}
