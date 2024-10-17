package Collection;

import Collection.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Tạo danh sách (List) chứa các đối tượng User
        List<User> userList = new ArrayList<>();
        List<User> userList1 = new LinkedList<>();


        // Thêm các User vào danh sách arrayList
        userList.add(new User("Tân", 25, "Ha Nam"));
        userList.add(new User("Đạt", 30, "Ha Nam"));
        userList.add(new User("Nhung", 28, "Ha Nam"));
        userList.add(new User("Huy",28,"Ha Noi"));

        // In ra danh sách User
        System.out.println("Danh sách người dùng:");
        for (User user : userList) {
            System.out.println(user.toString());
        }

        // Lấy một đối tượng User cụ thể từ danh sách dựa vào chỉ số
        User firstUser = userList.get(0);
        System.out.println("\nNgười dùng đầu tiên trong danh sách: " + firstUser.toString());

        // Sửa thông tin User tại vị trí chỉ số 1 (Dat)
        userList.get(1).setAddres("Ha Noi");
        System.out.println("\nDanh sách sau khi cập nhật địa chỉ cho Dat:");
        for (User user : userList) {
            System.out.println(user.toString());
        }

        // Xóa một User khỏi danh sách (Bob)
        userList.remove(2);
        System.out.println("\nDanh sách sau khi xóa Nhung:");
        for (User user : userList) {
            System.out.println(user.toString());
        }

        /////////////Test ListConsole///////

        System.out.println("Nhập số lượng người dùng muốn add: ");
        int numUser = 0;

        while (true) {
            try {
                numUser = sc.nextInt();
                if (numUser <= 0) {
                    System.out.println("Vui lòng nhập lại số user");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Đầu vào không hợp lệ, vui lòng nhập lại");
                sc.next();
            }
        }

        sc.nextLine();

        for (int i = 0; i < numUser; i++) {
            System.out.println("Nhập thông tin cho người dùng " + (i + 1) + ":");
            System.out.print("Tên: ");
            String name = sc.nextLine();
            int age = 0;

            while (true) {
                System.out.print("Tuổi: ");
                try {
                    age = sc.nextInt();
                    if (age <= 0) {
                        System.out.println("Nhập sai tuổi, vui lòng nhập lại");
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Sai tuổi, vui lòng nhập lại");
                    sc.next();
                }
            }

            sc.nextLine();

            System.out.print("Nhập địa chỉ: ");
            String address = sc.nextLine();

            User user = new User(name, age, address);
            userList.add(user);
        }


        System.out.println("\nDanh sách người dùng:");
        for (User users : userList) {
            System.out.println(users);
        }

        sc.close();
    }
}

