package com.mycompany.tddjunit5.milage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.mycompany.tddjunit5.airport.Passenger;

public class Milage {

    public static final int VIP_FACTOR = 10;
    public static final int USUAL_FACTOR = 20;

    private Map<Passenger, Integer> passengersMilageMap = new HashMap<>();
    private Map<Passenger, Integer> passengersPointsMap = new HashMap<>();

    public Map<Passenger, Integer> getPassengersPointsMap() {
        return Collections.unmodifiableMap(passengersPointsMap);
    }

    public void addMilage(Passenger passenger, int miles) {

    }

    public void calculategivenPoints() {
        for (Passenger passenger : passengersMilageMap.keySet()) {


        }

    }
}
