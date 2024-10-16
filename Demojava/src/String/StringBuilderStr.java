package String;

public class StringBuilderStr {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");

        sb.append(" World"); // Kết quả: "Hello World"
        System.out.println("After append: " + sb.toString());

        int indexToReplace = 0; // Vị trí của ký tự 'H'
        sb.replace(indexToReplace, indexToReplace + 1, "J"); // Kết quả: "Jello World"
        System.out.println("After replace: " + sb.toString());

        sb.delete(5, 6); // Xóa ký tự ở vị trí 5 (khoảng trắng) => Kết quả: "JelloWorld"
        System.out.println("After delete: " + sb.toString());

        sb.reverse(); // Kết quả: "dlroWolleJ"
        System.out.println("After reverse: " + sb.toString());
    }
}
