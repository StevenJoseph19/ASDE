package com.mycompany.tddjunit5.airconditioner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.mycompany.tddjunit5.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AirConditioningSystemTest {

	@InjectMocks
	AirConditioningSystem airConditioningSystem;
	@Mock
	Thermometer thermometer;

	@Test
	void testAirConditioningSystemStarted() {

		when(thermometer.getTemperature()).thenReturn(25.0);
		airConditioningSystem.setTemperatureThreshold(24.0);
		airConditioningSystem.checkAirConditioningSystem();
		assertTrue(airConditioningSystem.isOpen());
		verify(thermometer, times(1)).getTemperature();
	}

	@Test
	void testAirConditioningSystemStopped() {

		when(thermometer.getTemperature()).thenReturn(23.0);
		airConditioningSystem.setTemperatureThreshold(24.0);
		airConditioningSystem.checkAirConditioningSystem();
		assertFalse(airConditioningSystem.isOpen());
		verify(thermometer, times(1)).getTemperature();
	}

}
