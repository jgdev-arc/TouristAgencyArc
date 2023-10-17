package com.tlz.packages;

public abstract class PackageBuilder {
    Package p;

    public void createPackage() {
        p = new Package();

        buildTransportation();
        buildAccommodations();
        buildActivities();

    }

    public abstract void buildTransportation();
    public abstract void buildAccommodations();
    public abstract void buildActivities();

    public Package getP() {
        return p;
    }

    public void setP(Package p) {
        this.p = p;
    }
}
