package com.example.geektrust.Types;

import com.example.geektrust.Constants.Amount;

public class KidPassenger extends Passenger {

    public KidPassenger(MetroCard card, String startPoint) {
        super(card, startPoint);
        this.amountToTravel = Amount.Kid_Amount;
    }
}
