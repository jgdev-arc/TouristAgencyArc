package com.tlz.packages;

import com.tlz.services.*;

public class Offer3 extends PackageOffer{
    public Offer3() {
        super(new Bus(), new Motel(), new SkyDiving());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
