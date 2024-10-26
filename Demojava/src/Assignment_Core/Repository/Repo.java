package Assignment_Core.Repository;

import Assignment_Core.Model.Customers;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Repo {
    private static final String FILE_PATH = "src/Assignment_Core/resources/customer.txt";
    private static final Map<String, Customers> customers = new HashMap<>();

    public static void loadCustomersFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String phoneNumber = parts[0].trim();
                    String name = parts[1].trim();
                    String email = parts[2].trim();
                    customers.put(phoneNumber, new Customers(name, email, phoneNumber));
                }
            }
        }
    }

    public static void addCustomer(Customers customer) throws IOException {
        // Thêm khách hàng vào HashMap
        customers.put(customer.getPhoneNumber(), customer);

        // Ghi khách hàng vào file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String customerData = customer.getPhoneNumber() + "," + customer.getName() + "," + customer.getEmail();
            writer.write(customerData);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            throw e;
        }
    }

    public static boolean removeCustomer(String phoneNumber) throws IOException {
        if (customers.containsKey(phoneNumber)) {
            customers.remove(phoneNumber);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                for (Customers customer : customers.values()) {
                    String customerData = customer.getPhoneNumber() + "," + customer.getName() + "," + customer.getEmail();
                    writer.write(customerData);
                    writer.newLine();
                }
            }
            return true;
        }
        return false;
    }

    public static void updateCustomer(Customers customer, String oldPhoneNumber) throws IOException {
        customers.remove(oldPhoneNumber);
        customers.put(customer.getPhoneNumber(), customer);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Customers c : customers.values()) {
                String customerData = c.getPhoneNumber() + "," + c.getName() + "," + c.getEmail();
                writer.write(customerData);
                writer.newLine();
            }
        }
    }

    public static Customers getCustomerByPhoneNumber(String phoneNumber) {
        return customers.get(phoneNumber);
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        return customers.containsKey(phoneNumber);
    }

    static public List<Customers> getAll() {
        return new ArrayList<>(customers.values());
    }

    public static int loadCustomersFromFiles() throws IOException {
        int count = 0; // Biến để đếm số lượng khách hàng
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String phoneNumber = parts[0].trim();
                    String name = parts[1].trim();
                    String email = parts[2].trim();
                    customers.put(phoneNumber, new Customers(name, email, phoneNumber));
                    count++;
                }
            }
        }
        return count;
    }
}
