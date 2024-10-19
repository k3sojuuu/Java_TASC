package Exception;

import java.util.Scanner;

class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
    //custom exception
}

public class ExceptionTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExceptionTest2 test2 = new ExceptionTest2();
        int a = 0;
        a = test2.getInput(scanner, "Nhập số cần kiểm tra: ");
        System.out.println("Number invalid: " + a);
        scanner.close();
    }

    public int getInput(Scanner scanner, String str) {
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(str);
                String input = scanner.nextLine();
                number = Integer.parseInt(input);
                if (number < 0) {
                    throw new InvalidNumberException("Số không được âm. Vui lòng nhập lại.");
                }
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println(" Vui lòng nhập một số nguyên.");
            } catch (InvalidNumberException e) {
                System.out.println("Lỗi " + e.getMessage());
            }
        }
        return number;
    }
}
