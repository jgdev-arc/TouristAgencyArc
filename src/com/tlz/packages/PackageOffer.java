package com.tlz.packages;

import com.tlz.services.Accommodations;
import com.tlz.services.Activities;
import com.tlz.services.Transportation;

import java.io.Serializable;

public abstract class PackageOffer implements Serializable {

    public Transportation trans;
    public Accommodations acc;
    public Activities act;

    public PackageOffer(Transportation trans, Accommodations acc, Activities act) {
        this.trans = trans;
        this.acc = acc;
        this.act = act;
    }

    public int getTotalPrice() {
        int totalPrice = trans.getPrice() + acc.getPrice() + act.getPrice();
        return totalPrice;
    }

    @Override
    public String toString() {
        return "PackageOffer{" +
                "trans=" + trans +
                ", acc=" + acc +
                ", act=" + act +
                '}';
    }
}
