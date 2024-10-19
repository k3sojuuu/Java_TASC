package Assignment_Core.Service;

import Assignment_Core.Model.Customers;
import Assignment_Core.Repository.Repo;
import Assignment_Core.View.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService{
    Scanner sc = new Scanner(System.in);
    private Repo repo;
    public CustomerServiceImpl() {
        this.repo = new Repo();
    }
    @Override
    public void viewAllCustomer() {
        System.out.println("List customer");
        System.out.println("| id  |   Name                  |    Email                    |   PhoneNumber             |");
        List<Customers> cus = repo.getAllCustomers();
        for (Customers cs: cus) {
            System.out.println(cs);
        }
        System.out.println("Press any key to exit and return to the main menu...");
        sc.nextLine();
    }

    @Override
    public void addNewCustomer() {
        try {
            System.out.println("Enter the number of customers you want to add:");
            List<Customers> customers =new ArrayList<>();
            int numUser = 0;

            while (true) {
                try {
                    numUser = sc.nextInt();
                    if (numUser <= 0) {
                        System.out.println("Please re-enter customer numbers");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid, please re-enter");
                    sc.next();
                }
            }

            sc.nextLine();
            List<Customers> existingCustomers = repo.getAllCustomers();

            for (int i = 0; i < numUser; i++) {
                System.out.println("Enter info customer " + (i + 1) + ":");
                System.out.println("Enter id:");
                String id = sc.nextLine();
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                String email;

                while (true) {
                    System.out.print("Enter Email: ");
                    email = sc.nextLine();
                    if (isValidEmail(email)) {
                        break;
                    } else {
                        System.out.println("Invalid email format. Please enter a valid email.");
                    }
                }
                String phoneNumber;
                while (true) {
                    System.out.print("Enter Phone Number: ");
                    phoneNumber = sc.nextLine();
                    if (isValidPhoneNumber(phoneNumber) && !isPhoneNumberDuplicate(phoneNumber)) {
                        break;
                    } else if (!isValidPhoneNumber(phoneNumber)) {
                        System.out.println("Invalid phone number format. Please enter a valid phone number.");
                    } else {
                        System.out.println("This phone number is already in use. Please enter a different phone number.");
                    }
                }
                existingCustomers.add(new Customers(id, name, email, phoneNumber));
                System.out.println("Add success customer" + name);
            }
            repo.saveAllCustomers(existingCustomers);
            System.out.println("List Customer Update:");
            for (Customers es: existingCustomers) {
                System.out.println(es.toString());
            }

            System.out.println("Press any key to exit and return to the main menu...");
            sc.nextLine();
        }catch (Exception e){
            System.out.println("Errr");
        }
    }

    @Override
    public void findCustomerByPhoneNumber() {
        List<Customers> customers = repo.getAllCustomers();
        boolean flag= false;
        System.out.println("Enter the phone number you want to find:");
        String phone = sc.nextLine();
        for (Customers cus: customers) {
            if (cus.getPhoneNumber().equals(phone)){
                System.out.println("Info Customer " + phone);
                System.out.println(cus.toString());
                flag = true;
                break;
            }
        }if (!flag) {
            System.out.println("Phone Number invalid. No customer found with this phone number.");
        }
        System.out.println("Press any key to exit and return to the main menu...");
        sc.nextLine();
    }

    @Override
    public void updateCustomer() {
        while (true){
            List<Customers> customersUpdate = repo.getAllCustomers();
            for (Customers cus: customersUpdate){
                System.out.println(cus.toString());
            }
            System.out.println("Enter customerId want to change: ");
            String id = sc.nextLine();
            boolean flag = false;
            for (Customers cs:customersUpdate) {
                if (cs.getId().equals(id)){
                    System.out.println("Enter new name:");
                    String newName = sc.nextLine();
                    String newEmail;
                    while (true) {
                        System.out.print("Enter Email: ");
                        newEmail = sc.nextLine();
                        if (isValidEmail(newEmail)) {
                            break;
                        } else {
                            System.out.println("Invalid email format. Please enter a valid email.");
                        }
                    }
                    String newPhone;
                    while (true) {
                        System.out.print("Enter Phone Number: ");
                        newPhone = sc.nextLine();
                        if (isValidPhoneNumber(newPhone) && !isPhoneNumberDuplicate(newPhone)) {
                            break;
                        } else if (!isValidPhoneNumber(newPhone)) {
                            System.out.println("Invalid phone number format. Please enter a valid phone number.");
                        } else {
                            System.out.println("This phone number is already in use. Please enter a different phone number.");
                        }
                    }
                    cs.setName(newName);
                    cs.setEmail(newEmail);
                    cs.setPhoneNumber(newPhone);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                repo.saveAllCustomers(customersUpdate);
                List<Customers> newCs = repo.getAllCustomers();
                System.out.println("Customer information updated successfully.");
                for (Customers css:newCs) {
                    System.out.println(css.toString());
                }
            } else {
                System.out.println("Customer with ID " + id + " not found.");
            }
            System.out.println("Do you want to update another customer? (y/n): ");
            String response = sc.nextLine().toLowerCase();

            if (!response.equals("y")) {
                System.out.println("Exiting update process...");
                break;
            }
        }
    }

    @Override
    public void deleteCustomer() {
        while (true){
            List<Customers> cus = repo.getAllCustomers();
            for (Customers customers: cus){
                System.out.println(customers.toString());
            }
            System.out.println("Enter customerId want to delete: ");
            String id = sc.nextLine();
            boolean flag = false;
            for (Customers customers1: cus){
                if (id.equals(customers1.getId())){
                    cus.remove(customers1);
                    repo.saveAllCustomers(cus);
                    flag = true;
                    System.out.println("Customer with ID " + id + " has been deleted.");
                    break;
                }
            }
            for (Customers customers: cus){
                System.out.println(customers.toString());
            }
            System.out.println("Do you want to update another customer? (y/n): ");
            String response = sc.nextLine().toLowerCase();

            if (!response.equals("y")) {
                System.out.println("Exiting update process...");
                break;
            }
        }
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
