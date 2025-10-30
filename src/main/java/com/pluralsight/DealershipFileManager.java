package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    public static final String File_Path = "dealership.csv";

    public Dealership getDealership(){
        Dealership dealership = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(File_Path))) {

            String line = bufferedReader.readLine();
            if (line != null) {
                String[] parts = line.split("\\|");
                String name = parts[0];
                String address = parts[1];
                String phone = parts[2];

                dealership = new Dealership(name, address, phone);
            }

            String vehicleLine;
            while ((vehicleLine = bufferedReader.readLine()) != null){
                String[] parts = vehicleLine.split("\\|");

                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                int odometer = Integer.parseInt(parts[2]);
                String make = parts[3];
                String model = parts[4];
                String vehicleType = parts[5];
                String color = parts[6];
                double price = Double.parseDouble(parts[7]);

                Vehicle vehicle = new Vehicle(vin, year, odometer, make, model,
                        vehicleType, color, price);
                dealership.addVehicle(vehicle);
            }
        }catch (IOException e) {
            System.out.println("Error Reading File: " + e.getMessage());
        }
         return  dealership;
        }
        public void  saveDealership(Dealership dealership){
        }
}
