package com.mycompany.tddjunit5.airconditioner;

public class Thermometer {

	private double temperature;
	private Sensor sensor;

	public double getTemperature() {
		if (sensor.isBlocked()) {
			throw new RuntimeException("Sensor is blocked");
		}
		return temperature;
	}

	public void setTemperature(double temparature) {
		this.temperature = temparature;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

}
