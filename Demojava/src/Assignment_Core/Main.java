package Assignment_Core;

import Assignment_Core.Controller.CustomerController;
import Assignment_Core.Model.Customers;
import Assignment_Core.Repository.Repo;

import java.io.IOException;
import java.util.List;



public class Main {
    public static void main(String[] args) throws IOException {
        CustomerController controller = new CustomerController();
        controller.showMenu();


    }
}
