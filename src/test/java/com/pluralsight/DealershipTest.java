package com.pluralsight;

import java.util.List;

public class DealershipTest {
    public static void main(String[] args) {

        System.out.println("=== TESTS ===");

// Load from file
        DealershipFileManager fileManager = new DealershipFileManager();
        Dealership dealership = fileManager.getDealership();

// Confirm dealership loaded
        System.out.println("\nLoaded Dealership Info:");
        System.out.println(dealership.getName() + " | " + dealership.getAddress() + " | " + dealership.getPhone());

// --- All Vehicles ---
        System.out.println("\n--- All Vehicles ---");
        printList(dealership.getAllVehicles());

// --- Vehicles by Price ---
        System.out.println("\n--- Vehicles by Price (16000 - 20000) ---");
        printList(dealership.getVehiclesByPrice(16000, 20000));

// --- Vehicles by Make/Model ---
        System.out.println("\n--- Vehicles by Make=Toyota, Model=Camry ---");
        printList(dealership.getVehiclesByMakeModel("Toyota", "Camry"));

// --- Vehicles by Year ---
        System.out.println("\n--- Vehicles by Year (2017 - 2019) ---");
        printList(dealership.getVehiclesByYear(2017, 2019));

// --- Vehicles by Color ---
        System.out.println("\n--- Vehicles by Color (blue) ---");
        printList(dealership.getVehiclesByColor("blue"));

// --- Vehicles by Mileage ---
        System.out.println("\n--- Vehicles by Mileage (0 - 12000) ---");
        printList(dealership.getVehiclesByMileage(0, 12000));

// --- Vehicles by Type ---
        System.out.println("\n--- Vehicles by Type (SUV) ---");
        printList(dealership.getVehiclesByType("SUV"));

        System.out.println("\n=== MANUAL TESTS COMPLETE ===");
    }

    private static void printList(List<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }
}