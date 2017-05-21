package io.egen.weather_rest.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.egen.weather_rest.entity.WeatherData;
import io.egen.weather_rest.service.WeatherService;

@RestController
@RequestMapping(value = "/weather")
public class WeatherDataController {
	
	
	private WeatherService service;
	
	public WeatherDataController(WeatherService service) {
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public WeatherData getWeatherdata(){
		return service.getWeatherdata();
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/cities")
	public List<String> findAllCities() {
		return service.findAllCities();
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/latest/{cityName}")
	public WeatherData latestWeatherPerCity(@PathVariable("cityName")String cityName)
	{
		return service.latestWeatherPerCity(cityName);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/latest/{cityName}/{property}")
	public WeatherData latestWeatherPropertyPerCity(@PathVariable("cityName") String cityName, @PathVariable("property")String property)
	{
		return service.latestWeatherPropertyPerCity(cityName, property);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/hourlyavg/{cityName}")
	public WeatherData hourlyAvgWeather(@PathVariable("cityName") String cityName)
	
	{
		return service.hourlyAvgWeather(cityName);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/dailyavg/{cityName}")
	public WeatherData dailyAvgWeather( @PathVariable("cityName") String cityName, @PathVariable("date") Date date)
	{
		return service.dailyAvgWeather(cityName, date);
	}
}
