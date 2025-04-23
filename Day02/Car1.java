package org.example;
public class Car1 {
   private String make;
   private String model;
   private int year;
   public Car1(String make, String model, int year) {
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

package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ConvertListToJSON {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       List<Car> carList = new ArrayList<>();
       System.out.print("Enter the number of cars you want to add: ");
       int carCount = scanner.nextInt();
       scanner.nextLine();
       for (int i = 0; i < carCount; i++) {
           System.out.println("\nEnter details for Car " + (i + 1) + ":");
           System.out.print("Enter car make: ");
           String make = scanner.nextLine();
           System.out.print("Enter car model: ");
           String model = scanner.nextLine();
           System.out.print("Enter car year: ");
           int year = scanner.nextInt();
           scanner.nextLine();
           carList.add(new Car(make, model, year));
       }
       ObjectMapper objectMapper = new ObjectMapper();
       try {
           String jsonArray = objectMapper.writeValueAsString(carList);
           System.out.println("\nJSON Array of Cars:");
           System.out.println(jsonArray);
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
