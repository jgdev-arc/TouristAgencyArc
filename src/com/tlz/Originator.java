package com.tlz;

import com.tlz.services.Services;

import java.io.IOException;
import java.util.ArrayList;

public class Originator {
    Customer cus;
    ArrayList<Services> servicesArrayList;
    Caretaker caretaker;

    public Originator(Customer cus, ArrayList<Services> servicesArrayList, Caretaker caretaker) {
        this.cus = cus;
        this.servicesArrayList = servicesArrayList;
        this.caretaker = caretaker;
    }

    public void createReservation(String phoneNumber) throws IOException {
        caretaker.saveMemento(phoneNumber, new Reservation(cus, servicesArrayList));
    }

}
