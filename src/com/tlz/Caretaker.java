package com.tlz;

import java.io.*;
import java.util.TreeMap;

public class Caretaker {

    TreeMap<String, Reservation> newMapToSave = new TreeMap<>();
    File file = new File("C:\\Users\\Lord Zedd\\Desktop\\myReservationFile.dat");

    public void saveMemento(String phoneNumber, Reservation reservation) throws IOException {
        newMapToSave.put(phoneNumber, reservation);
        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(newMapToSave);
        oos.flush();
        oos.close();
    }

}
