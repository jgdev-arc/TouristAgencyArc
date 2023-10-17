package com.tlz.packages;

import com.tlz.services.*;

public class Offer2 extends PackageBuilder{

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void buildTransportation() {
        p.setTrans(new Bus());
    }

    @Override
    public void buildAccommodations() {
        p.setAcc(new Hotel());
    }

    @Override
    public void buildActivities() {
        p.setAct(new Cruise());
    }
}
