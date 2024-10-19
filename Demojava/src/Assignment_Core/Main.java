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


//        Repo repo = new Repo();
//        List<Customers> cus =repo.getAllCustomers();
//        System.out.println("Danh sach khach hang");
//        System.out.println("| id  |   Ten                  |    Email                    |   PhoneNumber             |");
//        for (Customers cs: cus) {
//            System.out.println(cs.toString());
//        }
    }
}
