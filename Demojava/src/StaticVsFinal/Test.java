package StaticVsFinal;

public class Test {

        static int count = 0; // Biến static,thuộc về lớp k thuộc ve instance
        static final int number1 = 0; // biến static final không thể bị thay đổi


        static String Name;

        static {
        Name = "Test Application";
        System.out.println("Khối static: Ứng dụng được khởi tạo với tên: " + Name);
         }//khối static đc khởi tạo 1 lần khi chương trình bắt đầu

         public static void changeAppName(String newName) {
           Name = newName;
        System.out.println("Khối static: Tên ứng dụng mới là: " + Name);
        }


    public Test() {
            count++; // Mỗi khi một đối tượng được tạo, count sẽ tăng
        }

        public static void displayCount() {
            System.out.println("Số đối tượng đã được tạo: " + count);
        }
        public static void main(String[] args) {

            Test c1 = new Test();
            Test c2 = new Test();
            Test c3 = new Test();
            Test.displayCount();
            Test.changeAppName("Nguyen Trong Tan");
        }
    }
