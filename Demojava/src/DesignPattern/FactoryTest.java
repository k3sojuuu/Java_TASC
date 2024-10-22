package DesignPattern;

public class FactoryTest {
    // Abstract product
    public interface Product {
        void doSomething();
    }

    // Concrete product A
    public static class ProductA implements Product {
        @Override
        public void doSomething() {
            System.out.println("ProductA is doing something!");
        }
    }

    // Concrete product B
    public static class ProductB implements Product {
        @Override
        public void doSomething() {
            System.out.println("ProductB is doing something!");
        }
    }

    public static class ProductC implements Product{
        @Override
        public void doSomething(){
            System.out.println("ProductC is doing something!");
        }
    }

    // Abstract creator
    public static abstract class Creator {
        // Phương thức Factory để tạo đối tượng
        public abstract Product createProduct();
    }

    // Concrete creator A
    public static class ConcreteCreatorA extends Creator {
        @Override
        public Product createProduct() {
            return new ProductA();
        }
    }

    // Concrete creator B
    public static class ConcreteCreatorB extends Creator {
        @Override
        public Product createProduct() {
            return new ProductB();  // Trả về ProductB
        }
    }

    public static class ConcreteCreatorC extends Creator{
        @Override
        public Product createProduct() {
            return new ProductC();
        }
    }
}


