package com.tlz.packages;

import com.tlz.services.*;

public class Offer1 extends PackageOffer{
    public Offer1() {
        super(new Uber(), new Hotel(), new SkyDiving());
    }
}
