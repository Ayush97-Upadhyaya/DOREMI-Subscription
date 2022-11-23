package com.example.geektrust.Types;

public class MetroCard {
    private String cardNo;
    private float balance;
    private String startPoint;

    public MetroCard(String cardNo, float balance) {
        this.cardNo = cardNo;
        this.balance = balance;
        this.startPoint = "";
    }

    public void addBalance(float balance) {
        this.balance = this.balance + balance;
    }

    public void deductBalance(float balance) {
        float actualBalance = this.balance - balance;
        if (actualBalance < 0) {
            actualBalance = 0;
        }
        this.balance = actualBalance;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public float getBalance() {
        return this.balance;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getStartPoint() {
        return this.startPoint;
    }
}
