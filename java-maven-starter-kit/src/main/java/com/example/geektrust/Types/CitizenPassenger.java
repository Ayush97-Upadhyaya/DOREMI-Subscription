package com.example.geektrust.Types;

import com.example.geektrust.Constants.Amount;

public class CitizenPassenger extends Passenger {

    public CitizenPassenger(MetroCard card, String startPoint) {
        super(card, startPoint);
        this.amountToTravel = Amount.Senior_Citizen_Amount;
    }
}
