package Assignment_Core.Service;

import Assignment_Core.Model.Customers;
import Assignment_Core.Repository.Repo;
import Assignment_Core.View.Function;

import java.io.IOException;
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
        System.out.println("|  Name                    |    Email                  |   PhoneNumber        |");
        System.out.println("-----------------------------------------------------------------------------");
        for (Customers cus : Repo.getAll()) {
            System.out.printf(" %-25s | %-25s | %-20s |\n", cus.getName(), cus.getEmail(), cus.getPhoneNumber());
            System.out.println("--------------------------------------------------------------------------");
        }
        System.out.println("Press any key to exit and return to the main menu...");
        sc.nextLine();
    }

    @Override
    public void addNewCustomer() {
        try {
            System.out.println("Enter the number of customers you want to add:");
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
            String email;
            String phoneNumber;
            for (int i = 0; i < numUser; i++) {
                System.out.println("Enter info customer " + (i + 1) + ":");
                while (true) {
                    System.out.print("Enter Phone Number: ");
                    phoneNumber = sc.nextLine();
                    if (isValidPhoneNumber(phoneNumber) && !Repo.checkPhoneNumber(phoneNumber)) {
                        break;
                    } else if (!isValidPhoneNumber(phoneNumber)) {
                        System.out.println("Invalid phone number format. Please enter a valid phone number.");
                    } else {
                        System.out.println("This phone number is already in use. Please enter a different phone number.");
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

                Customers newCustomer = new Customers(name, email, phoneNumber);

                // Lưu khách hàng vào Repo
                try {
                    Repo.addCustomer(newCustomer);
                    System.out.println("Customer added successfully.");
                } catch (IOException e) {
                    System.out.println("Error saving customer: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
            System.out.println("Press any key to exit and return to the main menu...");
            sc.nextLine();
    }

    @Override
    public void findCustomerByPhoneNumber() {
        System.out.println("Enter the phone number you want to find:");
        String phone = sc.nextLine();

        boolean check = Repo.checkPhoneNumber(phone);
        if (check) {
            Customers customer = Repo.getCustomerByPhoneNumber(phone);
            if (customer != null) {
                System.out.println("Info Customer with phone number " + phone + ":");
                System.out.printf("| %-4s | %-25s | %-25s |\n", customer.getName(), customer.getEmail(), customer.getPhoneNumber());
                System.out.println("---------------------------------------------------------------------------------------");
            } else {
                System.out.println("Customer not found.");
            }
        } else {
            System.out.println("Phone Number invalid. No customer found with this phone number.");
        }

        System.out.println("Press any key to exit and return to the main menu...");
        sc.nextLine();
    }
    @Override
    public void updateCustomer() {
        while (true) {
            System.out.println("Enter PhoneNumber of the Customer you want to update: ");
            String oldPhoneNumber = sc.nextLine();

            Customers customer = Repo.getCustomerByPhoneNumber(oldPhoneNumber);

            if (customer != null) {
                System.out.println("Enter new name:");
                String newName = sc.nextLine();

                String newEmail;
                while (true) {
                    System.out.print("Enter new Email: ");
                    newEmail = sc.nextLine();
                    if (isValidEmail(newEmail)) {
                        break;
                    } else {
                        System.out.println("Invalid email format. Please enter a valid email.");
                    }
                }

                String newPhone;
                while (true) {
                    System.out.print("Enter new Phone Number: ");
                    newPhone = sc.nextLine();
                    if (isValidPhoneNumber(newPhone) && !Repo.checkPhoneNumber(newPhone)) {
                        break;
                    } else if (!isValidPhoneNumber(newPhone)) {
                        System.out.println("Invalid phone number format. Please enter a valid phone number.");
                    } else {
                        System.out.println("This phone number is already in use. Please enter a different phone number.");
                    }
                }


                customer.setName(newName);
                customer.setEmail(newEmail);
                customer.setPhoneNumber(newPhone);

                // Lưu cập nhật vào Repo
                try {
                    Repo.updateCustomer(customer, oldPhoneNumber);
                    System.out.println("Customer information updated successfully.");
                } catch (IOException e) {
                    System.out.println("Error updating customer: " + e.getMessage());
                }
            } else {
                System.out.println("Customer with phone number " + oldPhoneNumber + " not found.");
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
    while (true) {
        System.out.println("Enter the phone number of the customer you want to delete: ");
        String phoneNumber = sc.nextLine();

        try {
            boolean isDeleted = Repo.removeCustomer(phoneNumber);
            if (isDeleted) {
                System.out.println("Customer with phone number " + phoneNumber + " has been deleted.");
            } else {
                System.out.println("Customer with phone number " + phoneNumber + " not found.");
            }
        } catch (IOException e) {
            System.out.println("Error deleting customer: " + e.getMessage());
        }

        System.out.println("Do you want to delete another customer? (y/n): ");
        String response = sc.nextLine().toLowerCase();

        if (!response.equals("y")) {
            System.out.println("Exiting delete process...");
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
}
