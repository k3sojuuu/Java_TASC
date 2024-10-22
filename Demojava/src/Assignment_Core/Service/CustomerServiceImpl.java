package Assignment_Core.Service;

import Assignment_Core.Model.Customers;
import Assignment_Core.Repository.Repo;
import Assignment_Core.View.Function;

import java.util.*;

public class CustomerServiceImpl implements CustomerService{
    Scanner sc = new Scanner(System.in);
    private Repo repo;
    public CustomerServiceImpl() {
        this.repo = new Repo();
    }
    @Override
    public void viewAllCustomer() {
        System.out.println("List customer");
        System.out.println("| id   |   Name                    |    Email                  |   PhoneNumber        |");
        System.out.println("---------------------------------------------------------------------------------------");
        List<Customers> customers = repo.getAllCustomers();
        for (Customers cus : customers) {
            System.out.printf("| %-4s | %-25s | %-25s | %-20s |\n", cus.getId(), cus.getName(), cus.getEmail(), cus.getPhoneNumber());
            System.out.println("---------------------------------------------------------------------------------------");
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
            String id;
            String email;
            String phoneNumber;
            for (int i = 0; i < numUser; i++) {
                System.out.println("Enter info customer " + (i + 1) + ":");
                while (true) {
                    System.out.println("Enter id:");
                    id = sc.nextLine();

                    boolean idExists = false;
                    for (Customers cus : existingCustomers) {
                        if (cus.getId().equals(id)) {
                            idExists = true;
                            break;
                        }
                    }
                    if (idExists) {
                        System.out.println("This id already exists.Please enter a different id.");
                    } else {
                        break;
                    }
                }

                System.out.print("Enter name: ");
                String name = sc.nextLine();


                while (true) {
                    System.out.print("Enter Email: ");
                    email = sc.nextLine();
                    if (isValidEmail(email)) {
                        break;
                    } else {
                        System.out.println("Invalid email format. Please enter a valid email.");
                    }
                }

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
                System.out.println("Add success customer " + name);
            }
            repo.saveAllCustomers(existingCustomers);
            System.out.println("List Customer Update:");
            for (Customers es: existingCustomers) {
                System.out.printf("| %-4s | %-25s | %-25s | %-20s |\n",es.getId(), es.getName(), es.getEmail(), es.getPhoneNumber());
                System.out.println("---------------------------------------------------------------------------------------");
            }

            System.out.println("Press any key to exit and return to the main menu...");
            sc.nextLine();
        }catch (Exception e){
            System.out.println("Error");
        }
    }

    @Override
    public void findCustomerByPhoneNumber() {
        Map<String, Customers> customerMap = new HashMap<>();
        for (Customers cus : repo.getAllCustomers()) {
            customerMap.put(cus.getPhoneNumber(), cus);
        }

        System.out.println("Enter the phone number you want to find:");
        String phone = sc.nextLine();

        Customers customer = customerMap.get(phone);
        if (customer != null) {
            System.out.println("Info Customer with phone number " + phone + ":");
            System.out.println(customer.toString());
        } else {
            System.out.println("Phone Number invalid. No customer found with this phone number.");
        }

        System.out.println("Press any key to exit and return to the main menu...");
        sc.nextLine();
    }


    @Override
    public void updateCustomer() {
        while (true){
            List<Customers> customersUpdate = repo.getAllCustomers();
            for (Customers es: customersUpdate){
                System.out.printf("| %-4s | %-25s | %-25s | %-20s |\n",es.getId(), es.getName(), es.getEmail(), es.getPhoneNumber());
                System.out.println("---------------------------------------------------------------------------------------");
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
                for (Customers es:newCs) {
                    System.out.printf("| %-4s | %-25s | %-25s | %-20s |\n",es.getId(), es.getName(), es.getEmail(), es.getPhoneNumber());
                    System.out.println("---------------------------------------------------------------------------------------");
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
            List<Customers> cus1 = repo.getAllDelete();

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

            for (Customers es: cus){
                System.out.printf("| %-4s | %-25s | %-25s | %-20s |\n",es.getId(), es.getName(), es.getEmail(), es.getPhoneNumber());
                System.out.println("---------------------------------------------------------------------------------------");
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
