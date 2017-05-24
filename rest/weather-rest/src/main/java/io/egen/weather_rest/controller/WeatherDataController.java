package io.egen.weather_rest.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.egen.weather_rest.entity.WeatherData;
import io.egen.weather_rest.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/weather")
@Api(tags = "ClearSky-Weather Endpoints")
public class WeatherDataController {
	

	private WeatherService service;
	
	public WeatherDataController(WeatherService service) {
		this.service = service;
	}

	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Get Weather from mock weather sensor", notes = "Creates weather data per city every second")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public WeatherData getWeatherdata(@RequestBody WeatherData weatherData){
		return service.getWeatherdata(weatherData);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/cities")
	@ApiOperation(value = "Find all the cities weather are stored in Database ", notes = "returns unique city names")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<String> findAllCities() {
		return service.findAllCities();
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/latest/{cityName}")
	@ApiOperation(value = "Find latest weather per city ", notes = "Returns weather for particular city ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public WeatherData latestWeatherPerCity(@PathVariable("cityName")String cityName)
	{
		return service.latestWeatherPerCity(cityName);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/latest/{cityName}/{property}")
	@ApiOperation(value = "Find latest weather property per city", notes = "Returns Specific property for particular city")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public String latestWeatherPropertyPerCity(@PathVariable("cityName") String cityName, @PathVariable("property")String property)
	{
		return service.latestWeatherPropertyPerCity(cityName, property);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/hourlyavg/{cityName}")
	@ApiOperation(value = "Get Hourly avgerage weather report", notes = "Returns weather report")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public  List<WeatherData> hourlyAvgWeather(@PathVariable("cityName") String cityName)
	
	{
		return service.hourlyAvgWeather(cityName);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/dailyavg/{cityName}/{date}")
	@ApiOperation(value = "Get Daily avgerage weather report", notes = "Returns weather report")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public WeatherData dailyAvgWeather( @PathVariable("cityName") String cityName, @PathVariable("date") String date)
	{
		return service.dailyAvgWeather(cityName, date);
	}
}
