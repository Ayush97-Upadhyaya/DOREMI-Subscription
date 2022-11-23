package com.example.geektrust.Types;

import java.util.*;

public class Station {
    private String stationName;

    private float totalCollection;

    private int discountAmount;

    private HashMap<String, Float> passengerTypeToCollection;

    private HashMap<String, Integer> passengerTypeToNoOfPassenger;

    public Station(String stationName) {
        this.stationName = stationName;
        this.totalCollection = 0;
        this.discountAmount = 0;
        passengerTypeToCollection = new HashMap<>();
        passengerTypeToNoOfPassenger = new HashMap<>();
    }

    public void addPassenger(String passengerType, float currentFare, int discountAmt) {
        if (passengerTypeToCollection.containsKey(passengerType)) {
            passengerTypeToCollection.put(passengerType, passengerTypeToCollection.get(passengerType) + currentFare);
            passengerTypeToNoOfPassenger.put(passengerType, passengerTypeToNoOfPassenger.get(passengerType) + 1);
        } else {
            passengerTypeToCollection.put(passengerType, currentFare);
            passengerTypeToNoOfPassenger.put(passengerType, 1);
        }
        this.totalCollection += currentFare;
        this.discountAmount += discountAmt;
    }

    public void printSummary() {
        System.out.println(
                "TOTAL_COLLECTION " + this.stationName + " " + (int) this.totalCollection + " " + this.discountAmount);
        printPassengerSummary();
    }

    private void printPassengerSummary() {
        System.out.println("PASSENGER_TYPE_SUMMARY");

        List<Map.Entry<String, Float>> sortedPassengerList = new LinkedList<Map.Entry<String, Float>>(
                passengerTypeToCollection.entrySet());
        // Sort the list
        Collections.sort(sortedPassengerList, new Comparator<Map.Entry<String, Float>>() {
            public int compare(Map.Entry<String, Float> o1,
                    Map.Entry<String, Float> o2) {
                return (o2.getValue()).compareTo(o1.getValue()) == 0 ?  (o1.getKey()).compareTo(o2.getKey()): (o2.getValue()).compareTo(o1.getValue());
            }
        });
        for (Map.Entry<String, Float> passenger : sortedPassengerList) {
            System.out.println(passenger.getKey() + " " + passengerTypeToNoOfPassenger.get(passenger.getKey()));
        }
    }
}
