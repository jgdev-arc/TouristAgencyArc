package com.tlz;

import com.tlz.services.Services;

import java.io.Serializable;
import java.util.ArrayList;

public class Reservation implements Serializable {
    Customer cus;
    ArrayList<Services> servicesArrayList;

    public Reservation(Customer cus, ArrayList<Services> servicesArrayList) {
        this.cus = cus;
        this.servicesArrayList = servicesArrayList;
    }

    public Customer getCus() {
        return cus;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public ArrayList<Services> getServicesArrayList() {
        return servicesArrayList;
    }

    public void setServicesArrayList(ArrayList<Services> servicesArrayList) {
        this.servicesArrayList = servicesArrayList;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "cus=" + cus +
                ", servicesArrayList=" + servicesArrayList +
                '}';
    }
}
