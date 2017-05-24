package io.egen.weather_rest.repository.impl;


import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.weather_rest.entity.WeatherData;
import io.egen.weather_rest.repository.WeatherRepository;


@Repository
public class WeatherRepositoryImpl implements WeatherRepository {

	@PersistenceContext
	private EntityManager em;


	@Override
	public WeatherData getWeatherdata(WeatherData weatherData) {

		em.persist(weatherData);
		return weatherData;
	}

	@Override
	public List<String> findAllCities() {

		TypedQuery<String> query = em.createNamedQuery("WeatherData.findAllCities", String.class);
		return query.getResultList();
	}

	@Override
	public WeatherData latestWeatherPerCity(String cityName) {
		TypedQuery<WeatherData> query = em.createNamedQuery("WeatherData.latestWeatherPerCity",WeatherData.class);
		query.setParameter("pCity", cityName);
		
		List<WeatherData> cityList = query.getResultList();
		
		if (!cityList.isEmpty())
		{
			return  cityList.get(0);
		}
		else
		{
			return null; 
		}

	}


	@Override
	public String latestWeatherPropertyPerCity(String cityName, String property) {

		TypedQuery<WeatherData> query = em.createNamedQuery("WeatherData.latestWeatherPropertyPerCity", WeatherData.class);
		query.setParameter("pCity", cityName);

		List<WeatherData> propertyList = query.getResultList();

		if(!propertyList.isEmpty())
		{
			if (property.equals("temperature"))
			{
				String tempOutput = propertyList.get(0).getTemperature(); 
				return "Latest Temperature at " + cityName + " is " + tempOutput;
			}
			else if (property.equals("humidity"))
			{
				String humidityOutput = propertyList.get(0).getHumidity(); 
				return "Latest Humidity at " + cityName + " is " + humidityOutput;
			}
			else if (property.equals("pressure"))
			{
				String pressureOutput = propertyList.get(0).getPressure();
				return "Latest Pressure at " + cityName + " is " + pressureOutput; 
			}
		}
		return " No Valid Data Found For City " + cityName; 

	}

	@Override
	public List<WeatherData> hourlyAvgWeather(String cityName) {		
		return null; 
	}


	@Override
	public WeatherData dailyAvgWeather(String cityName, String date) {

		return null;
			

	}

	
}
