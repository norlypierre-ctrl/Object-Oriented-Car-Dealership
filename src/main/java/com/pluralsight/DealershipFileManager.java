package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
                if (vehicleLine.trim().isEmpty()) continue;

                String[] parts = vehicleLine.split("\\|");

                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                Vehicle vehicle = new Vehicle(vin, year, odometer, make, model,
                        vehicleType, color, price);
            if (dealership != null)
                dealership.addVehicle(vehicle);
            }
        }catch (IOException e) {
            System.out.println("Error Reading File: " + e.getMessage());
        }
         return  dealership;
        }
        public void  saveDealership(Dealership dealership){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(File_Path))) {

                writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
                writer.newLine();

                for (Vehicle v : dealership.getAllVehicles()) {
                    writer.write(v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|" +
                            v.getModel() + "|" + v.getVehicleType() + "|" + v.getColor() + "|" +
                            v.getOdometer() + "|" + v.getPrice());
                    writer.newLine();
                }
                System.out.println("Dealership Saved Successfully.");
            } catch (IOException e) {
                System.out.println("Error Saving File: " + e.getMessage());
            }
        }
}
