package com.example.geektrust;

import org.junit.jupiter.api.Test;

import com.example.geektrust.Calculate.TotalCollection;
import com.example.geektrust.Types.AdultPassenger;
import com.example.geektrust.Types.CitizenPassenger;
import com.example.geektrust.Types.KidPassenger;
import com.example.geektrust.Types.MetroCard;
import com.example.geektrust.Types.Passenger;

import junit.framework.Assert;

public class MainTest {

    @Test
    public void Test_GivenBalance_Adult_CreateMetroCard() {
        MetroCard card = new MetroCard("MC1", 200);
        Passenger passenger = new AdultPassenger(card, "CENTRAL");
        float amount = passenger.checkIn();
        Assert.assertEquals((int) amount, 200);
    }

    @Test
    public void Test_GivenBalance_SeniorCitizen_CreateMetroCard() {
        MetroCard card = new MetroCard("MC2", 100);
        Passenger passenger = new CitizenPassenger(card, "CENTRAL");
        float amount = passenger.checkIn();
        Assert.assertEquals((int) amount, 100);
    }

    @Test
    public void Test_GivenBalance_KID_CreateMetroCard() {
        MetroCard card = new MetroCard("MC3", 50);
        Passenger passenger = new KidPassenger(card, "CENTRAL");
        float amount = passenger.checkIn();
        Assert.assertEquals((int) amount, 50);
    }

    @Test
    public void Test_GivenBalance_ApplyServiceTax_CreateMetroCard() {
        MetroCard card = new MetroCard("MC4", 200);
        Passenger passenger = new KidPassenger(card, "CENTRAL");
        float amount = passenger.checkIn();
        Assert.assertEquals((int) amount, 50);
        Passenger adultpassenger = new AdultPassenger(card, "CENTRAL");
        float amount1 = adultpassenger.checkIn();
        Assert.assertEquals((int) amount1, 201);
    }

    @Test
    public void Test_GivenBalance_ApplyDiscount_CreateMetroCard() {
        MetroCard card = new MetroCard("MC5", 150);
        Passenger passenger = new KidPassenger(card, "CENTRAL");
        float amount = passenger.checkIn();
        Assert.assertEquals((int) amount, 50);
        Passenger adultpassenger = new KidPassenger(card, "AIRPORT");
        float amount1 = adultpassenger.checkIn();
        Assert.assertEquals((int) amount1, 25);
    }

    @Test
    public void Test_GivenBalance_KidTotalCollection_CreateMetroCard() {
        TotalCollection collection = new TotalCollection();
        collection.createMetroCard("MC", 200);
        float total = collection.checkInForTravel("MC", "KID", "CENTRAL");
        Assert.assertEquals((int)total, 50);
    }

    @Test
    public void Test_GivenBalance_AdultTotalCollection_CreateMetroCard() {
        TotalCollection collection = new TotalCollection();
        collection.createMetroCard("TestMC", 200);
        float total = collection.checkInForTravel("TestMC", "ADULT", "CENTRAL");
        collection.printSummary();
        Assert.assertEquals((int)total, 200);
    }

    @Test
    public void Test_GivenBalance_CitizenTotalCollection_CreateMetroCard() {
        TotalCollection collection = new TotalCollection();
        collection.createMetroCard("MockMC", 200);
        float total = collection.checkInForTravel("MockMC", "SENIOR_CITIZEN", "AIRPORT");
        collection.printSummary();
        Assert.assertEquals((int)total, 100);
    }
}