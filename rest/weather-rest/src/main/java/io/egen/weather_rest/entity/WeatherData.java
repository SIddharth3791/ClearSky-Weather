package io.egen.weather_rest.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;



@Entity
@NamedQueries({
	@NamedQuery(name = "WeatherData.findAllCities", query = "SELECT DISTINCT u.city FROM WeatherData u"),
	@NamedQuery(name = "WeatherData.latestWeatherPerCity",query = "SELECT  u FROM WeatherData u where u.city =:pCity ORDER BY u.timestamp DESC"),
	@NamedQuery(name = "WeatherData.latestWeatherPropertyPerCity",query = "SELECT u FROM WeatherData u where u.city=:pCity  Order by u.timestamp DESC")
	})
public class WeatherData {

	@Id
	private String weatherDataId;
	private String city;
	private String description;
	private String humidity;
	private String pressure;
	private String temperature;

	@OneToOne(cascade = { CascadeType.ALL })
	private Wind wind;

	// @Temporal(TemporalType.TIMESTAMP)

	private Date timestamp;

	public WeatherData() {
		this.weatherDataId = UUID.randomUUID().toString();
	}

	public String getWeatherId() {
		return weatherDataId;
	}

	public void setWeatherId(String weatherId) {
		this.weatherDataId = weatherId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

		try {
			this.timestamp = date.parse(timestamp);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}



}
