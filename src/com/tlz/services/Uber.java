package com.tlz.services;

public class Uber extends Transportation{
    @Override
    public int getPrice() {
        return 100;
    }

    @Override
    public String toString() {
        return "Uber";
    }
}
