package com.tlz.packages;

import com.tlz.services.Accommodations;
import com.tlz.services.Activities;
import com.tlz.services.Transportation;

public class Package {
    Transportation trans;
    Accommodations acc;
    Activities act;

    public Package() {}

    public Package(Transportation trans, Accommodations acc, Activities act) {
        this.trans = trans;
        this.acc = acc;
        this.act = act;
    }

    public Transportation getTrans() {
        return trans;
    }

    public void setTrans(Transportation trans) {
        this.trans = trans;
    }

    public Accommodations getAcc() {
        return acc;
    }

    public void setAcc(Accommodations acc) {
        this.acc = acc;
    }

    public Activities getAct() {
        return act;
    }

    public void setAct(Activities act) {
        this.act = act;
    }

    public int getTotalPrice() {
        int totalPrice = trans.getPrice() + acc.getPrice() + act.getPrice();
        return totalPrice;
    }



}
