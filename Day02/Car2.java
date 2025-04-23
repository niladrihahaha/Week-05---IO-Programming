package org.example;
public class Car2 {
   private String make;
   private String model;
   private int year;
   public Car2(String make, String model, int year) {
       this.make = make;
       this.model = model;
       this.year = year;
   }
   public String getMake() {
       return make;
   }
   public void setMake(String make) {
       this.make = make;
   }
   public String getModel() {
       return model;
   }
   public void setModel(String model) {
       this.model = model;
   }
   public int getYear() {
       return year;
   }
   public void setYear(int year) {
       this.year = year;
   }
}

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ListToJSONArray {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       List<Car> carList = new ArrayList<>();
       System.out.print("Enter number of cars: ");
       int numberOfCars = sc.nextInt();
       sc.nextLine();
       for (int i = 0; i < numberOfCars; i++) {
           System.out.println("Enter details for Car " + (i + 1) + ":");
           System.out.print("Make: ");
           String make = sc.nextLine();
           System.out.print("Model: ");
           String model = sc.nextLine();
           System.out.print("Year: ");
           int year = sc.nextInt();
           sc.nextLine();
           carList.add(new Car(make, model, year));
       }
       try {
           ObjectMapper objectMapper = new ObjectMapper();
           objectMapper.writeValue(new File("src/main/resources/cars.json"), carList);
           System.out.println("JSON Array created successfully.");
       } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
       }
   }
