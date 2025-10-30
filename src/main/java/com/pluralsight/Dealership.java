package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private final String name;
    private final String address;
    private final String phone;
    private final List<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }


    public void addVehicle(Vehicle vehicle){inventory.add(vehicle);}
    public void removeVehicle(Vehicle vehicle) {inventory.remove(vehicle);}
    public List<Vehicle> getAllVehicles(){
        return inventory;
    }


    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                matches.add(v);
            }
        }
        return matches;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getMake().equalsIgnoreCase(make.trim()) &&
                    v.getModel().equalsIgnoreCase(model.trim())) {
                matches.add(v);
            }
        }
        return matches;
    }

    public List<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        List<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getYear() >= minYear && v.getYear() <= maxYear) {
                matches.add(v);
            }
        }
        return matches;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getColor().equalsIgnoreCase(color.trim())) {
                matches.add(v);
            }
        }
        return matches;
    }

    public List<Vehicle> getVehiclesByMileage(int minMiles, int maxMiles) {
        List<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getOdometer() >= minMiles && v.getOdometer() <= maxMiles) {
                matches.add(v);
            }
        }
        return matches;
    }

    public List<Vehicle> getVehiclesByType(String type) {
        List<Vehicle> matches = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getVehicleType().equalsIgnoreCase(type.trim())) {
                matches.add(v);
            }
        }
        return matches;
    }
}