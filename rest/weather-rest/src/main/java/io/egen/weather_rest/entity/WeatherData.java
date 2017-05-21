package io.egen.weather_rest.entity;

import java.util.Date;

public class WeatherData {
	
	private String weatherDataId;
	private String cityName;
	private String weatherDescription;
	private String humidityLevel;
	private String pressureLevel;
	private String temperatureLevel;
	private WindData windData;
	private Date weatherDataTimeStamp;
	
	
	public String getWeatherDataId() {
		return weatherDataId;
	}
	public void setWeatherDataId(String weatherDataId) {
		this.weatherDataId = weatherDataId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getWeatherDescription() {
		return weatherDescription;
	}
	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}
	public String getHumidityLevel() {
		return humidityLevel;
	}
	public void setHumidityLevel(String humidityLevel) {
		this.humidityLevel = humidityLevel;
	}
	public String getPressureLevel() {
		return pressureLevel;
	}
	public void setPressureLevel(String pressureLevel) {
		this.pressureLevel = pressureLevel;
	}
	public String getTemperatureLevel() {
		return temperatureLevel;
	}
	public void setTemperatureLevel(String temperatureLevel) {
		this.temperatureLevel = temperatureLevel;
	}
	public WindData getWindData() {
		return windData;
	}
	public void setWindData(WindData windData) {
		this.windData = windData;
	}
	public Date getWeatherDataTimeStamp() {
		return weatherDataTimeStamp;
	}
	public void setWeatherDataTimeStamp(Date weatherDataTimeStamp) {
		this.weatherDataTimeStamp = weatherDataTimeStamp;
	}
	
	

}
