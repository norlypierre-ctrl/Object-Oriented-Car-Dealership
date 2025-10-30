package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.println("Enter Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetByGetAllVehicleRequest();
                    break;
                case 8:
                    processGetByAddVehicleRequest();
                    break;
                case 9:
                    processGetByRemoveVehicleRequest();
                    break;
                case 96:
                    System.out.println("Goodbye");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid Option.");
            }
        }
    }

    private void init(){

        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();
    }

    private void displayMenu(){

        System.out.println("\n--- Dealership Menu ---");
        System.out.println("1 - Find Vehicles Within a Price Range");
        System.out.println("2 - Find Vehicles by Make/Model");
        System.out.println("3 - Find Vehicles by Year Range");
        System.out.println("4 - Find Vehicles by Color");
        System.out.println("5 - Find Vehicles by Mileage Range");
        System.out.println("6 - Find Vehicles by Type (car, truck, SUV, van)");
        System.out.println("7 - List ALL Vehicles");
        System.out.println("8 - Add a Vehicle");
        System.out.println("9 - Remove a Vehicle");
        System.out.println("96 - Quit");
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()){
            System.out.println("No Vehicles Found");
            return;
        }
        for (Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }

    private void processGetByPriceRequest(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Minimum Price: ");
        double min = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter Maximum Price: ");
        double max = Double.parseDouble(scanner.nextLine());

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
}

    private void processGetByMakeModelRequest(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Make: ");
        String make = scanner.nextLine();

        System.out.println("Enter Model: ");
        String model = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    private void processGetByYearRequest(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Minimum Year: ");
        int minYear = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Maximum Year: ");
        double maxYear = Integer.parseInt(scanner.nextLine());

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(minYear, maxYear);
        displayVehicles(vehicles);
    }

    private void processGetByColorRequest(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Color: ");
        String color = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    private void processGetByMileageRequest(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Minimum Mileage: ");
        int min = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Maximum Mileage: ");
        double max = Integer.parseInt(scanner.nextLine());

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }

    private void processGetByVehicleTypeRequest(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Vehicle Type (car, SUV, Truck, Van): ");
        String type = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByColor(type);
        displayVehicles(vehicles);
    }

    private void processGetByAddVehicleRequest(){
        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);
    }

    private void processGetByRemoveVehicleRequest(){
        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);
    }

    private void processGetByGetAllVehicleRequest(){
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }
}
