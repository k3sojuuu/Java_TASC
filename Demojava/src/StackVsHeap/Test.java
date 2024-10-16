package StackVsHeap;

public class Test {
    public class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }

        public void Print() {
            System.out.println("This is" + name);
        }

    }

    public static void method() {
        int b = 20;  // Biến 'b' được lưu trên Stack
    }

    public static void main(String[] args) {
        int a = 10;  // Biến 'a' được lưu trên Stack
        Test testInstance = new Test(); // Tạo đối tượng của lớp Test
        Animal cat = testInstance.new Animal("Tom");  // Khởi tạo Animal thông qua đối tượng Test
        Test.method();  // Gọi phương thức
        cat.Print();
    }

}


