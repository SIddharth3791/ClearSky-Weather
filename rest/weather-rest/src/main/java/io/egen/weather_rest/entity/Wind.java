package io.egen.weather_rest.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wind {

	@Id
	private String windDataId;
	private String Speed;
	private String degree;
	
	public Wind() {
		this.windDataId = UUID.randomUUID().toString();
	}
	
	public String getWindDataId() {
		return windDataId;
	}
	public void setWindDataId(String windDataId) {
		this.windDataId = windDataId;
	}
	public String getSpeed() {
		return Speed;
	}
	public void setSpeed(String speed) {
		Speed = speed;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	
	
	
}
