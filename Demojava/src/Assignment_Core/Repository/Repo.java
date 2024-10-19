package Assignment_Core.Repository;

import Assignment_Core.Model.Customers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repo {
    private static final String FILE_PATH = "src/Assignment_Core/resources/customers.txt";

    public List<Customers> getAllCustomers() {
        List<Customers> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    customers.add(new Customers(data[0], data[1], data[2],data[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void saveAllCustomers(List<Customers> customers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Customers customer : customers) {
                writer.write(customer.getId() + "," + customer.getName() + "," + customer.getEmail() + "," + customer.getPhoneNumber());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
