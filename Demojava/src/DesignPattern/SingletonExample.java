package DesignPattern;

public class SingletonExample {
    private static SingletonExample instance;

    // Private constructor để ngăn việc tạo instance từ bên ngoài
    private SingletonExample() {
        System.out.println("LazySingleton instance created");
    }

    // Phương thức để trả về instance duy nhất, khởi tạo nếu cần
    public static SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample(); // Khởi tạo instance khi được gọi lần đầu
        }
        return instance;
    }

    // Một phương thức trong Singleton
    public void showMessage() {
        System.out.println("Hello from LazySingleton!");
    }
}
