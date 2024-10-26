package Assignment_Core;
//
//import Assignment_Core.Controller.CustomerController;
import Assignment_Core.Controller.CustomerController;
import Assignment_Core.Model.Customers;
import Assignment_Core.Repository.Repo;

import java.io.IOException;
import java.util.List;



public class Main {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis(); // Sử dụng currentTimeMillis để lấy thời gian hiện tại tính bằng milliseconds

        // Tải khách hàng từ file
        Repo.loadCustomersFromFile();
        int customerCount = Repo.loadCustomersFromFiles();

        // Ghi lại thời gian kết thúc
        long endTime = System.currentTimeMillis();

        // Tính toán thời gian đã trôi qua
        long duration = endTime - startTime; // Độ dài thời gian tính bằng milliseconds

        System.out.println("Load file in: " + duration + " ms....");
        System.out.println("Number of customers loaded: " + customerCount);

        // Khởi tạo controller và hiển thị menu
        CustomerController controller = new CustomerController();
        controller.showMenu();
    }
}