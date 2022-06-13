package com.mycompany.tddjunit5.airconditioner;

public class Thermometer {

	private double temperature;
	private Sensor sensor;

	public double getTemperature() {

		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

}
