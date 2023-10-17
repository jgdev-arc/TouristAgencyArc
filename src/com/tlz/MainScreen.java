package com.tlz;

import com.tlz.packages.Offer1;
import com.tlz.packages.Offer2;
import com.tlz.packages.Offer3;
import com.tlz.packages.PackageBuilder;
import com.tlz.services.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class MainScreen extends JFrame {

    // Customization
    Font myFont = new Font("SansSerif", Font.BOLD, 20);
    Font myFont2 = new Font("SansSerif", Font.BOLD, 16);

    Color myColor = Color.GRAY;

    public boolean isIndividualOrNot = false;
    public int packagePrice = 0;


    // Panel 1
    JTextField customerName;
    JTextField customerPhone;
    JTextField customerAge;
    JTextField customerJob;
    JRadioButton isIndividual;
    JRadioButton isGroup;
    ButtonGroup group0;

    JComboBox<String> comboBox;

    // Panel 2
    JRadioButton package1RadioBtn;
    JRadioButton package2RadioBtn;
    JRadioButton package3RadioBtn;
    ButtonGroup group1;

    // Panel 3
    JComboBox<String> comboBox1;
    JComboBox<String> comboBox2;
    JComboBox<String> comboBox3;

    JLabel transLBL;
    JLabel activityLBL;
    JLabel accommodationLBL;

    // Panel 4
    JRadioButton payment1RadioBtn;
    JRadioButton payment2RadioBtn;
    JTextArea totalPriceLBL;
    ButtonGroup group2;

    // Panel 5
    JTextArea detailTransArea;
    JTextArea detailActivityArea;
    JTextArea detailAccommodationArea;

    // Panel 6
    JButton chatBtn;
    JButton makeReservationBtn;
    JLabel searchLBL;
    JTextField searchField;
    JButton makeSearch;
    JTextArea reservationDetailsArea;



    public MainScreen() {

       CustomizePanel1();
       CustomizePanel2();
       CustomizePanel3();
       CustomizePanel4();
       CustomizePanel5();
       CustomizePanel6();
       CustomizePanel7();

    }


    private void CustomizePanel1() {

        JPanel p1 = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                " Customer ",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor);

        p1.setBorder(titledBorder);

        JLabel nameLBL = new JLabel(" Name");
        JLabel phoneLBL = new JLabel(" Phone");
        JLabel ageLBL = new JLabel(" Age");
        JLabel jobLBL = new JLabel(" Job");
        JLabel isIndividualLBL = new JLabel("Individual Trip?");

        customerName = new JTextField();
        customerName.setOpaque(false);
        customerPhone = new JTextField();
        customerPhone.setOpaque(false);
        customerAge = new JTextField();
        customerAge.setOpaque(false);
        customerJob = new JTextField();
        customerJob.setOpaque(false);

        isIndividual = new JRadioButton("Individual");
        isGroup = new JRadioButton("Group");

        // Adding Widgets to panel
        p1.add(nameLBL);
        p1.add(customerName);
        p1.add(phoneLBL);
        p1.add(customerPhone);
        p1.add(ageLBL);
        p1.add(customerAge);
        p1.add(jobLBL);

        // Drop down menu
        String[] jobs = {"Student", "Business", "Retired", "Employee"};
        comboBox = new JComboBox<>(jobs);
        comboBox.setBounds(120, 10, 80, 20);
        p1.add(comboBox);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();
                System.out.println("Selected: " + selected);
            }
        });

        p1.add(isIndividual);
        p1.add(isGroup);
        group0 = new ButtonGroup();
        group0.add(isGroup);
        group0.add(isIndividual);

        isIndividual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isIndividualOrNot = true;

                // Disable offers
                package1RadioBtn.setEnabled(false);
                package2RadioBtn.setEnabled(false);
                package3RadioBtn.setEnabled(false);

                comboBox1.setEnabled(true);
                comboBox2.setEnabled(true);
                comboBox3.setEnabled(true);
            }
        });

        isGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isIndividualOrNot = false;

                // Enable offers
                package1RadioBtn.setEnabled(true);
                package2RadioBtn.setEnabled(true);
                package3RadioBtn.setEnabled(true);

                comboBox1.setEnabled(false);
                comboBox2.setEnabled(false);
                comboBox3.setEnabled(false);
            }
        });

        p1.setBounds(15, 15, 300, 200);
        p1.setLayout(new GridLayout(5, 2));

        setLayout(null);
        add(p1);

    }

    private void CustomizePanel2() {
        JPanel p2 = new JPanel();
        TitledBorder titledBorder2 = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                " Special Offers ",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor);

        p2.setBorder(titledBorder2);

        package1RadioBtn = new JRadioButton("Package 1");
        package2RadioBtn = new JRadioButton("Package 2");
        package3RadioBtn = new JRadioButton("Package 3");

        group1 = new ButtonGroup();
        group1.add(package1RadioBtn);
        group1.add(package2RadioBtn);
        group1.add(package3RadioBtn);

        package1RadioBtn.setActionCommand("pack1");
        package2RadioBtn.setActionCommand("pack2");
        package3RadioBtn.setActionCommand("pack3");

        package1RadioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detailAccommodationArea.setText("Accommodation: 5 Star Resort \nAll Inclusive");
                detailActivityArea.setText("Activities: Gorgeous Sky Diving Experience");
                detailTransArea.setText("Transportation: Uber Black");

                PackageBuilder offer1 = new Offer1();
                offer1.createPackage();
                totalPriceLBL.setText("Total Price: " + "$ " + offer1.getP().getTotalPrice());

            }
        });

        package2RadioBtn.addActionListener(e -> {
            detailAccommodationArea.setText("Accommodation: 5 Star Hotel \nAll Inclusive");
            detailActivityArea.setText("Activities: Unforgettable Island Cruise");
            detailTransArea.setText("Transportation: Deluxe Bus");

            PackageBuilder offer2 = new Offer1();
            offer2.createPackage();
            totalPriceLBL.setText("Total Price: " + "$ " + offer2.getP().getTotalPrice());
        });

        package3RadioBtn.addActionListener(e -> {
            detailAccommodationArea.setText("Accommodation: 4 Star Hotel \nAll Inclusive");
            detailActivityArea.setText("Activities: Scooba Diving Adventure");
            detailTransArea.setText("Transportation: Deluxe Bus");

            PackageBuilder offer3 = new Offer1();
            offer3.createPackage();
            totalPriceLBL.setText("Total Price: " + "$ " + offer3.getP().getTotalPrice());
        });

        p2.add(package1RadioBtn);
        p2.add(package2RadioBtn);
        p2.add(package3RadioBtn);

        p2.setBounds(15, 250, 300, 200);
        p2.setLayout(new GridLayout(3, 1));

        setLayout(null);
        add(p2);



    }

    private void CustomizePanel3() {
        JPanel p3 = new JPanel();
        TitledBorder titledBorder3 = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                " Individual Trips ",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor);

        p3.setBorder(titledBorder3);

        transLBL = new JLabel("Transportation");
        accommodationLBL = new JLabel("Accommodation");
        activityLBL = new JLabel("Activity");
        p3.add(transLBL);

        // Transportation
        String[] transportation = {"Taxi", "Deluxe Bus"};
        comboBox1 = new JComboBox<>(transportation);
        comboBox1.setBounds(120, 10, 80, 20);
        p3.add(comboBox1);

        comboBox1.addActionListener(e -> {
            String selected = (String) comboBox1.getSelectedItem();

            if (selected.equals("Taxi")) {
                System.out.println("Transportation: Taxi");
            }
        });

        p3.add(activityLBL);

        String[] activities = {"Cruise", "Sky Diving"};
        comboBox2 = new JComboBox<>(activities);
        comboBox2.setBounds(120, 10, 80, 20);
        p3.add(comboBox2);

        comboBox2.addActionListener(e -> {

        });

        // Accommodations
        p3.add(accommodationLBL);

        String[] accommodations = {"Hotel", "Motel"};
        comboBox3 = new JComboBox<>(accommodations);
        comboBox3.setBounds(130, 10, 80, 20);
        p3.add(comboBox3);

        comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        p3.setBounds(15, 500, 300, 150);
        p3.setLayout(new GridLayout(3, 2));

        setLayout(null);
        add(p3);



    }

    private void CustomizePanel4() {
        JPanel p4 = new JPanel();
        TitledBorder titledBorder4 = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                " Payment Methods ",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor);

        p4.setBorder(titledBorder4);

        totalPriceLBL = new JTextArea("Total Price: $______ ");
        totalPriceLBL.setOpaque(false);
        totalPriceLBL.setFont(myFont2);
        payment1RadioBtn = new JRadioButton("Paypal");
        payment2RadioBtn = new JRadioButton("Credit Card");
        group2 = new ButtonGroup();
        group2.add(payment1RadioBtn);
        group2.add(payment2RadioBtn);

        p4.add(payment1RadioBtn);
        p4.add(payment2RadioBtn);
        p4.add(totalPriceLBL);
        p4.setBounds(330, 15, 300, 400);
        p4.setLayout(new GridLayout(3, 1));

        setLayout(null);
        add(p4);


    }

    private void CustomizePanel5() {
        JPanel p5 = new JPanel();
        TitledBorder titledBorder5 = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                " Service Details ",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor);

        p5.setBorder(titledBorder5);

        detailTransArea = new JTextArea();
        detailActivityArea = new JTextArea();
        detailAccommodationArea = new JTextArea();
        detailAccommodationArea.setOpaque(false);
        detailAccommodationArea.setOpaque(false);
        detailActivityArea.setOpaque(false);
        detailTransArea.setOpaque(false);

        detailAccommodationArea.setEnabled(false);
        detailTransArea.setEnabled(false);
        detailActivityArea.setEnabled(false);

        detailAccommodationArea.setEnabled(false);
        detailTransArea.setEnabled(false);
        detailActivityArea.setEnabled(false);

        detailAccommodationArea.setFont(myFont);
        detailTransArea.setFont(myFont);
        detailActivityArea.setFont(myFont);

        p5.add(detailTransArea);
        p5.add(detailActivityArea);
        p5.add(detailAccommodationArea);

        p5.setBounds(330, 450, 300, 300);
        p5.setLayout(new GridLayout(3, 1));

        setLayout(null);
        add(p5);


    }

    public void CustomizePanel6() {
        JPanel p6 = new JPanel();
        TitledBorder titledBorder6 = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                " Control Panel ",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor);

        p6.setBorder(titledBorder6);

        chatBtn = new JButton("Start Live Chat");
        makeReservationBtn = new JButton("Make Reservation");
        searchLBL = new JLabel("Search Customer By Phone");
        searchField = new JTextField();
        makeSearch = new JButton("Search Customer");

        p6.add(chatBtn);
        p6.add(makeReservationBtn);
        p6.add(searchLBL);
        p6.add(searchField);
        p6.add(makeSearch);

        makeReservationBtn.addActionListener(e -> {
            try {
                MakeReservation();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        makeSearch.addActionListener(e -> {
            SearchCustomerByMobileNumber();
        });

        p6.setBounds(660, 15, 300, 300);
        p6.setLayout(new GridLayout(10, 1));

        setLayout(null);
        add(p6);
        
    }

    public void CustomizePanel7() {
        JPanel p7 = new JPanel();
        TitledBorder titledBorder7 = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                " Reservation Details ",
                TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION,
                myFont,
                myColor);

        p7.setBorder(titledBorder7);

        reservationDetailsArea = new JTextArea();
        reservationDetailsArea.setOpaque(false);
        reservationDetailsArea.setEnabled(false);
        reservationDetailsArea.setFont(myFont2);

        JScrollPane scrollableTextArea = new JScrollPane(reservationDetailsArea);
        p7.add(scrollableTextArea);

        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        p7.setBounds(660, 330, 300, 300);
        p7.setLayout(new GridLayout(1, 1));

        setLayout(null);
        add(p7);

    }

    private Customer createCustomer() {
        Customer c = new Customer(
                customerName.getText(),
                customerPhone.getText(),
                customerAge.getText(),
                comboBox.getSelectedItem().toString(),
                isIndividualOrNot
        );

        System.out.println("" + c.toString());
        return c;
    }

    private void MakeReservation() throws IOException {
        Customer c = createCustomer();

        ArrayList<Services> servicesArrayList = getChosenServices();
        SaveReservationToDisk();
    }

    private ArrayList<Services> getChosenServices() {
        ArrayList<Services> servicesArrayList = new ArrayList<>();

        if (isIndividualOrNot) {
            Transportation trans;
            Activities act;
            Accommodations acc;

            String selected1 = (String) comboBox1.getSelectedItem();
            String selected2 = (String) comboBox2.getSelectedItem();
            String selected3 = (String) comboBox3.getSelectedItem();

            if (selected1.equals("Uber")) {
                trans = new Uber();
            } else {
                trans = new Bus();
            }

            if (selected2.equals("Cruise")) {
                act = new Cruise();
            } else {
                act = new SkyDiving();
            }

            if (selected3.equals("Hotel")) {
                acc = new Hotel();
            } else {
                acc = new Motel();
            }

            packagePrice = trans.getPrice() + act.getPrice() + acc.getPrice();
            servicesArrayList.clear();
            servicesArrayList.add(trans);
            servicesArrayList.add(act);
            servicesArrayList.add(acc);

            DisplayTotalPrice(packagePrice);
        } else {
            // Group Trip

            if (package1RadioBtn.isSelected()) {
                PackageBuilder offer1 = new Offer1();
                offer1.createPackage();

                DisplayTotalPrice(offer1.getP().getTotalPrice());

                // Add chosen services to arraylist
                servicesArrayList.clear();
                servicesArrayList.add(offer1.getP().getTrans());
                servicesArrayList.add(offer1.getP().getAct());
                servicesArrayList.add(offer1.getP().getAcc());
            } else if (package2RadioBtn.isSelected()) {
                PackageBuilder offer2 = new Offer2();
                DisplayTotalPrice(offer2.getP().getTotalPrice());

                // Add chosen services to arraylist
                servicesArrayList.clear();
                servicesArrayList.add(offer2.getP().getTrans());
                servicesArrayList.add(offer2.getP().getAct());
                servicesArrayList.add(offer2.getP().getAcc());
            } else if (package3RadioBtn.isSelected()) {
                PackageBuilder offer3 = new Offer3();
                DisplayTotalPrice(offer3.getP().getTotalPrice());

                // Add chosen services to arraylist
                servicesArrayList.clear();
                servicesArrayList.add(offer3.getP().getTrans());
                servicesArrayList.add(offer3.getP().getAct());
                servicesArrayList.add(offer3.getP().getAcc());
            }
        }

        return servicesArrayList;

    }

    private void DisplayTotalPrice(int packagePrice) {
        int beforeDiscount = packagePrice;

        if (comboBox.getSelectedItem().equals("Student")) {
            packagePrice = (int) (packagePrice * 0.9);
        } else if (comboBox.getSelectedItem().equals("Business")) {
            packagePrice = (int) (packagePrice * 1);
        } else if (comboBox.getSelectedItem().equals("Retired")) {
            packagePrice = (int) (packagePrice * 0.8);
        } else if (comboBox.getSelectedItem().equals("Employee")) {
            packagePrice = (int) (packagePrice * 0.7);
        }

        totalPriceLBL.setText("Total Price Before Discount: " +
                "$" + beforeDiscount + "\nTotal Price After Discount: " +
                "$" + packagePrice);

    }

    public void SaveReservationToDisk() throws IOException {

        File file = new File("C:\\Users\\Lord Zedd\\Desktop\\myReservationFile.dat");
        String phoneNumber = customerPhone.getText();

        if (!file.exists()) {
            file.createNewFile();
            SaveCurrentReservationToNewFile(phoneNumber, file);
        } else {
            // If file already exists

            try {
                TreeMap<String, Reservation> newMapToSave = new TreeMap<>();

                // Get existing file to write new reservation
                InputStream is = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(is);

                Reservation reservation = new Reservation(createCustomer(), getChosenServices());

                // Reads the saved map
                TreeMap<String, Reservation> mapInFile = (TreeMap<String, Reservation>) ois.readObject();
                ois.close();
                is.close();

                // Clone the mapInFile items into newMapToSave
                for (Map.Entry<String, Reservation> m : mapInFile.entrySet()) {
                    newMapToSave.put(m.getKey(), m.getValue());
                }

                // Add new reservation to map
                newMapToSave.put(phoneNumber, reservation);

                // Save new map to disk
                OutputStream os = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(os);
                oos.writeObject(newMapToSave);
                oos.flush();
                oos.close();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }



    }

    private void SaveCurrentReservationToNewFile(String phoneNumber, File file) throws IOException {
        // Memento Design Pattern Implementation

        Originator originator = new Originator(
                createCustomer(),
                getChosenServices(),
                new Caretaker()
        );
        originator.createReservation(phoneNumber);
    }

    public void SearchCustomerByMobileNumber() {
        File file = new File("C:\\Users\\Lord Zedd\\Desktop\\myReservationFile.dat");

        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);

            TreeMap<String, Reservation> mapInFile = (TreeMap<String, Reservation>) ois.readObject();
            ois.close();
            is.close();

            // Displays reservation details
            Reservation reservationFound = mapInFile.get(searchField.getText());
            reservationDetailsArea.setText(reservationFound.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



    public static void main (String[]args) throws ParseException {
        MainScreen mainFrame = new MainScreen();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Tourist Agency Management System");
        mainFrame.setBounds(250, 150, 1200, 800);
    }
}
