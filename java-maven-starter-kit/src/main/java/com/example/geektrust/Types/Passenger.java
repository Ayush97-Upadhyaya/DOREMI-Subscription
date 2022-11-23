package com.example.geektrust.Types;

import com.example.geektrust.Constants.Amount;

public abstract class Passenger {
    protected MetroCard card;

    protected String startPoint;

    protected float amountToTravel;

    protected int discountAmount;

    public Passenger(MetroCard card, String startPoint) {
        this.card = card;
        this.startPoint = startPoint;
        if (card.getStartPoint().isEmpty()) {
            card.setStartPoint(startPoint);
        }
    }

    public float checkIn() {
        float calculatedFare = calculateTotalFare();
        float serviceCharge = 0;
        float currentBalance = this.card.getBalance();

        if (currentBalance < calculatedFare) {
            float balanceToBeAdded = calculatedFare - currentBalance;
            this.card.addBalance(balanceToBeAdded);
            serviceCharge = (balanceToBeAdded * Amount.SERVICE_CHARGE);
        }

        this.card.deductBalance(calculatedFare);

        return calculatedFare + serviceCharge;
    }

    private float calculateTotalFare() {
        if (!this.card.getStartPoint().equalsIgnoreCase(startPoint)) {
            this.card.setStartPoint("");
            this.discountAmount += this.amountToTravel * Amount.DISCOUNT_PERCENT;
            return this.amountToTravel * Amount.DISCOUNT_PERCENT;
        }

        return this.amountToTravel;
    }

    public int getDiscountAmount() {
        return this.discountAmount;
    }

}
