package io.egen.weather_rest.entity;

public class WindData {

	private String windDataId;
	private String windSpeed;
	private String degree;
	
	public String getWindDataId() {
		return windDataId;
	}
	public void setWindDataId(String windDataId) {
		this.windDataId = windDataId;
	}
	public String getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
}
