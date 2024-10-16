package Exception;

import java.util.Scanner;

import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 0, b = 0;
        boolean validInput = false;
        while (validInput == false) {
            try {
                System.out.print("Nhập số thứ nhất (a): ");
                String inputA = scanner.nextLine();
                a = Integer.parseInt(inputA);
                validInput = true; //
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Định dạng không hợp lệ. Vui lòng nhập một số nguyên.");
            }
        }
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Nhập số thứ hai (b): ");
                String inputB = scanner.nextLine();
                b = Integer.parseInt(inputB);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Định dạng không hợp lệ. Vui lòng nhập một số nguyên.");
            }
        }
        int sum = a + b;
        System.out.println("Tổng của " + a + " và " + b + " là: " + sum);

        scanner.close();
    }
}


