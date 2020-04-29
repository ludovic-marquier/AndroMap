package com.example.data;

public class Ville {

    private Coordinates coordinates;
    private String name;
    private int nbHabitants;
    private String codePostal;
    private double latitude;
    private double longitude;

    public Ville(){

    }

    public Ville(Coordinates coordinates, String name, int nbHabitants, String codePostal) {
        this.coordinates = coordinates;
        this.name = name;
        this.nbHabitants = nbHabitants;
        this.codePostal = codePostal;
    }


    public Ville(String name, int nbHabitants, String codePostal, double latitude, double longitude) {
        this.name = name;
        this.nbHabitants = nbHabitants;
        this.codePostal = codePostal;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbHabitants() {
        return nbHabitants;
    }

    public void setNbHabitants(int nbHabitants) {
        this.nbHabitants = nbHabitants;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
}
