package io.egen.weather_rest.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.weather_rest.entity.WeatherData;
import io.egen.weather_rest.exception.NotFoundException;
import io.egen.weather_rest.repository.WeatherRepository;
import io.egen.weather_rest.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{


	private WeatherRepository weatherRepository;
	
	public WeatherServiceImpl(WeatherRepository weatherRepository) {
		this.weatherRepository = weatherRepository;
	}

	@Override
	@Transactional
	public WeatherData getWeatherdata(WeatherData weatherData) {
		
		return weatherRepository.getWeatherdata(weatherData);
	}
	
	@Override
	public List<String> findAllCities() {

		return weatherRepository.findAllCities();
	}

	@Override
	public WeatherData latestWeatherPerCity(String cityName) {

		WeatherData existingData = weatherRepository.latestWeatherPerCity(cityName);
		if (existingData == null)
		{
			throw new NotFoundException("Latest Weather for City = " + cityName + " does not exist" );
		}
		return existingData;
	}

	@Override
	public String latestWeatherPropertyPerCity(String cityName, String property) {
		
		String existingData = weatherRepository.latestWeatherPropertyPerCity(cityName, property);
		
		if (existingData.isEmpty())
		{
			throw new NotFoundException("Latest Weather property = " + property+ " for city " + cityName + " does not exist");
		}
		return existingData;
	}

	@Override
	public List<WeatherData> hourlyAvgWeather(String cityName) {
		
		 List<WeatherData> existingData = weatherRepository.hourlyAvgWeather(cityName);
		if (existingData == null)
		{
			throw new NotFoundException("Hourly Average Weather for city = " + cityName + " does not exists");
		}
		return existingData;
		
	}

	@Override
	public WeatherData dailyAvgWeather(String cityName, String date) {
		
		WeatherData existingData = weatherRepository.dailyAvgWeather(cityName, date);
		if (existingData==null)
		{
			throw new NotFoundException("daily Average Weather for city = " + cityName + " does not exists");
		}
		
		return existingData;
	}


}
