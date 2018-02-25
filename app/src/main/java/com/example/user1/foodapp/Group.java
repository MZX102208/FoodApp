package com.example.user1.foodapp;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by SriramHariharan on 2/24/18.
 */

public class Group {
    private String name;
    private ArrayList<Eats> eats;
    private ArrayList<User> people;
    double score;
    String photo;

    public Group(String n, String ph){
        name = n;
        photo = ph;
        NumberFormat formatter = new DecimalFormat("#0.00");
        score = Double.parseDouble(formatter.format(Math.random()*30.0));
    }
    public Group(String n, ArrayList<Eats> e, ArrayList<User> p, String ph){
        name = n;
        eats = e;
        people = p;
        photo = ph;
        score = calculateScore(eats);
    }

    public Group(String n, ArrayList<Eats> e, ArrayList<User> p, String ph, double s){
        name = n;
        eats = e;
        people = p;
        score = s;
        photo = ph;
    }


    public String getName() {
        return name;
    }

    public ArrayList<Eats> getEats() {
        return eats;
    }

    public ArrayList<User> getPeople() {
        return people;
    }

    public double getScore() {
        return score;
    }

    public String getPhoto() {
        return photo;
    }

    public double calculateScore(ArrayList<Eats> e){
        return 0.0;
    }


}
