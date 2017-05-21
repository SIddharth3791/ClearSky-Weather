package io.egen.weather_rest.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import io.egen.weather_rest.entity.WeatherData;
import io.egen.weather_rest.repository.WeatherRepository;
import io.egen.weather_rest.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{

	private WeatherRepository weatherRepository;
	
	public WeatherServiceImpl(WeatherRepository weatherRepository) {
		this.weatherRepository = weatherRepository;
	}

	@Override
	public WeatherData getWeatherdata() {
		
		return weatherRepository.getWeatherdata();
	}
	
	@Override
	public List<String> findAllCities() {
		// TODO Auto-generated method stub
		return weatherRepository.findAllCities();
	}

	@Override
	public WeatherData latestWeatherPerCity(String cityName) {
		// Change the code
		return weatherRepository.latestWeatherPerCity(cityName);
	}

	@Override
	public WeatherData latestWeatherPropertyPerCity(String cityName, String property) {
		// change the code
		return weatherRepository.latestWeatherPropertyPerCity(cityName, property);
	}

	@Override
	public WeatherData hourlyAvgWeather(String cityName) {
		// change the code
		return weatherRepository.hourlyAvgWeather(cityName);
	}

	@Override
	public WeatherData dailyAvgWeather(String cityName, Date date) {
		// Change the code
		return weatherRepository.dailyAvgWeather(cityName, date);
	}


}
