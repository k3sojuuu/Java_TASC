package Assignment_Core.Controller;

import Assignment_Core.Model.Customers;
import Assignment_Core.Repository.Repo;
import Assignment_Core.Service.CustomerServiceImpl;
import Assignment_Core.View.Function;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerController  {
    private CustomerServiceImpl service;
    private Function function;

    private Repo repo;

    public CustomerController() {
        this.service = new CustomerServiceImpl();
        this.function = new Function();
        this.repo = new Repo();
    }
    private final Scanner sc = new Scanner(System.in);
    public void showMenu() throws IOException {
        while (true) {
            function.MainMenu();
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        viewCustomers();
                        break;
                    case 2:
                        addNewCustomer();
                        break;
                    case 3:
                        findCusByPhoneNumber();
                        break;
                    case 4:
                        updateCustomer();
                        break;
                    case 5:
                        deleteCustomer();
                        break;
                    case 6:
                        System.out.println("ThanksS2");
                        return;
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private void viewCustomers() {
        service.viewAllCustomer();
    }

    private void addNewCustomer() throws IOException{
        service.addNewCustomer();
    }

    private void findCusByPhoneNumber(){
        service.findCustomerByPhoneNumber();
    }

    private void updateCustomer(){
       service.updateCustomer();
    }

    private void deleteCustomer(){
        service.deleteCustomer();
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        return email.matches(emailRegex);
    }


    private boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^\\d{10,15}$";
        return phoneNumber.matches(phoneRegex);
    }

    private boolean isPhoneNumberDuplicate(String phoneNumber) {
        List<Customers> existingCustomers = repo.getAllCustomers();
        for (Customers customer : existingCustomers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
