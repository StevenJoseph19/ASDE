package com.mycompany.tddjunit5.airport;

import java.util.*;

public abstract class Flight {


	private String id;
//	List<Passenger> passengersList = new ArrayList<Passenger>();
	Set<Passenger> passengersSet = new HashSet<Passenger>();

	public Flight(String id) {
		this.id = id;

	}

	public String getId() {
		return id;
	}

	public Set<Passenger> getPassengersSet() {
		return Collections.unmodifiableSet(passengersSet);
	}

//	public List<Passenger> getPassengersList() {
//		return Collections.unmodifiableList(passengersList);
//	}

	public abstract boolean addPassenger(Passenger passenger);

	public abstract boolean removePassenger(Passenger passenger);

}
