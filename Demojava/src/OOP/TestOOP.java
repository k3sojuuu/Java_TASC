package OOP;

public class TestOOP {

    // Interface CanFly, chứa các phương thức cần được triển khai cho các loài có thể bay
    interface CanFly {
        void fly(); // Phương thức trừu tượng (abstract method)
    }

    // Lớp trừu tượng Animal
    abstract class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }

        // Phương thức trừu tượng, lớp con phải ghi đè
        public abstract void sound();

        // Phương thức thông thường
        public void eat() {
            System.out.println(name + " is eating.");
        }
    }

    // Lớp Bird kế thừa từ lớp trừu tượng Animal và triển khai interface CanFly
    class Bird extends Animal implements CanFly {

        public Bird(String name) {
            super(name); // Gọi constructor của lớp cha (Animal)
        }

        // Ghi đè phương thức sound() từ lớp trừu tượng Animal
        @Override
        public void sound() {
            System.out.println(name + " chirps!");
        }

        // Triển khai phương thức fly() từ interface CanFly
        @Override
        public void fly() {
            System.out.println(name + " is flying high.");
        }
    }

    // Một lớp khác, Dog chỉ kế thừa từ lớp trừu tượng Animal
    class Dog extends Animal {

        public Dog(String name) {
            super(name);
        }

        // Ghi đè phương thức sound() từ lớp trừu tượng Animal
        @Override
        public void sound() {
            System.out.println(name + " barks!");
        }
    }

    public static void main(String[] args) {
        // Tạo một instance của lớp TestOOP để truy cập các lớp con
        TestOOP testOOP = new TestOOP();

        // Tạo đối tượng Bird và Dog
        Bird bird = testOOP.new Bird("Bird");
        Dog dog = testOOP.new Dog("Shibaaaaa");

        // Gọi các phương thức từ các đối tượng
        bird.sound();      // Output: Eagle chirps!
        bird.eat();        // Output: Eagle is eating.
        bird.fly();        // Output: Eagle is flying high.

        dog.sound();       // Output: Bulldog barks!
        dog.eat();         // Output: Bulldog is eating.
    }
}

