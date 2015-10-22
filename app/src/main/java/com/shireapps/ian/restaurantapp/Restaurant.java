package com.shireapps.ian.restaurantapp;

/**
 * Created by Ian on 10/9/15.
 */
public class Restaurant implements Comparable<Restaurant>{
    private String name;
    private double dist;
    private String phoneNumber;
    private String menu;

    public Restaurant(String name) {
        this(name, 0, "", "");
    }

    public Restaurant(String name, double dist, String phoneNumber, String menu) {
        this.name = name;
        this.dist = dist;
        this.phoneNumber = phoneNumber;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public double getDist() {
        return dist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }

    @Override
    public int compareTo(Restaurant r) throws NullPointerException {
        final int BEFORE = -1;
        final int EQUALS = 0;
        final int AFTER =   1;

        if(r == null) {
            throw new NullPointerException();
        }

        if(r instanceof Restaurant) {
            if(this.getDist() < r.getDist()) {
                return BEFORE;
            } else if(this.getDist() < r.getDist()) {
                return AFTER;
            } else {
                return EQUALS;
            }
        }

        throw new ClassCastException();
    }
}
