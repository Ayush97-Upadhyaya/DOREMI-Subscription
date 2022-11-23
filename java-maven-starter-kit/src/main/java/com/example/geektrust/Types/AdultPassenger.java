package com.example.geektrust.Types;

import com.example.geektrust.Constants.Amount;

public class AdultPassenger extends Passenger {

    public AdultPassenger(MetroCard card, String startPoint) {
        super(card, startPoint);
        this.amountToTravel = Amount.Adult_Amount;
    }
}
