package com.example.user1.foodapp;


import java.util.ArrayList;

/**
 * Created by SriramHariharan on 2/24/18.
 */

public class Group {
    private String name;
    private ArrayList<Eats> eats;
    private ArrayList<User> people;
    double score;
    int photo;

    public Group(String n, ArrayList<Eats> e, ArrayList<User> p, int ph, double s){
        name = n;
        eats = e;
        people = p;
        score = s;
        photo = ph;
    }
    public Group(String n, ArrayList<Eats> e, ArrayList<User> p, int ph){
        name = n;
        eats = e;
        people = p;
        photo = ph;
        score = calculateScore(eats);
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

    public int getPhoto() {
        return photo;
    }

    public double calculateScore(ArrayList<Eats> e){
        return 0.0;
    }


}
