package Array;

public class ArrayTest {
    public static void main(String[] args) {
        int[] numbers = new int[5]; // Khởi tạo mảng với 5 phần tử

        // Gán giá trị cho từng phần tử
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        // 2. Khởi tạo mảng và gán giá trị ngay lập tức
        String[] fruits = {"Apple", "Banana", "Cherry"};

        System.out.println("Mảng số nguyên:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        System.out.println("\nMảng trái cây:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
