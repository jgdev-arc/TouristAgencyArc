package com.tlz.packages;

import com.tlz.services.*;

public class Offer1 extends PackageBuilder{
    @Override
    public void buildTransportation() {
        p.setTrans(new Uber());
    }

    @Override
    public void buildAccommodations() {
        p.setAcc(new Hotel());
    }

    @Override
    public void buildActivities() {
        p.setAct(new SkyDiving());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
