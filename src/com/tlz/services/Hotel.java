package com.tlz.services;

public class Hotel extends Accommodations{
    @Override
    public int getPrice() {
        return 150;
    }

    @Override
    public String toString() {
        return "5 Star Hotel";
    }
}
