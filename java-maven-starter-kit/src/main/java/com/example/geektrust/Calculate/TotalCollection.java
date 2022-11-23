package com.example.geektrust.Calculate;

import java.util.HashMap;

import com.example.geektrust.Constants.TypeOfPassenger;
import com.example.geektrust.Types.AdultPassenger;
import com.example.geektrust.Types.CitizenPassenger;
import com.example.geektrust.Types.KidPassenger;
import com.example.geektrust.Types.MetroCard;
import com.example.geektrust.Types.Passenger;
import com.example.geektrust.Types.Station;

public class TotalCollection {

    // cardName, MetroCard
    private HashMap<String, MetroCard> cardInfo = new HashMap<>();

    // startPoint, station
    private HashMap<String, Station> stationInfo = new HashMap<>();

    public void createMetroCard(String cardName, float Balance) {
        MetroCard card = new MetroCard(cardName, Balance);
        cardInfo.put(cardName, card);
    }

    public float checkInForTravel(String cardName, String passengerType, String startPoint) {
        float currentFare = 0;
        if (cardInfo.containsKey(cardName)) {
            Station station = null;
            Passenger passenger = getPassengerType(passengerType, startPoint, cardInfo.get(cardName));
            currentFare = passenger.checkIn();
            int discountAmount = passenger.getDiscountAmount();
            if (stationInfo.containsKey(startPoint)) {
                station = stationInfo.get(startPoint);
            } else {
                station = new Station(startPoint);
                stationInfo.put(startPoint, station);
            }
            station.addPassenger(passengerType, currentFare, discountAmount);
        } else {
            System.out.println("Card Name does not exists");
        }
        return currentFare;
    }

    private Passenger getPassengerType(String passengerType, String startPoint, MetroCard card) {
        Passenger passenger = null;
        switch (passengerType) {
            case TypeOfPassenger.ADULT:
                passenger = new AdultPassenger(card, startPoint);
                break;
            case TypeOfPassenger.SENIOR_CITIZEN:
                passenger = new CitizenPassenger(card, startPoint);
                break;
            case TypeOfPassenger.KID:
                passenger = new KidPassenger(card, startPoint);
                break;
        }
        return passenger;
    }

    public void printSummary() {

        if (stationInfo.containsKey("CENTRAL")) {
            Station centralStation = stationInfo.get("CENTRAL");
            centralStation.printSummary();
        }
        if (stationInfo.containsKey("AIRPORT")) {
            Station airportStation = stationInfo.get("AIRPORT");
            airportStation.printSummary();
        }
    }

}
