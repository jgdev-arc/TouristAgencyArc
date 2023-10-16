package com.tlz.services;

public class Bus extends Transportation{
    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return "Private Deluxe Bus";
    }
}
