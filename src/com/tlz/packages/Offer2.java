package com.tlz.packages;

import com.tlz.services.*;

public class Offer2 extends PackageOffer{
    public Offer2() {
        super(new Bus(), new Hotel(), new Cruise());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
