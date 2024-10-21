package DesignPattern;

//public class FactoryTest {
//    // Abstract product
//    interface Product {
//        void doSomething();
//    }
//
//    // Concrete product A
//    class ProductA implements Product {
//        @Override
//        public void doSomething() {
//            System.out.println("ProductA is doing something!");
//        }
//    }
//
//    // Concrete product B
//    class ProductB implements Product {
//        @Override
//        public void doSomething() {
//            System.out.println("ProductB is doing something!");
//        }
//    }
//
//    // Abstract creator
//    abstract class Creator {
//        // Phương thức Factory để tạo đối tượng
//        public abstract Product createProduct();
//    }
//
//    // Concrete creator A
//    class ConcreteCreatorA extends Creator {
//        @Override
//        public Product createProduct() {
//            return new ProductA();  // Trả về ProductA
//        }
//    }
//
//    // Concrete creator B
//    class ConcreteCreatorB extends Creator {
//        @Override
//        public Product createProduct() {
//            return new ProductB();  // Trả về ProductB
//        }
//    }
//
//    public static void main(String[] args) {
//        // Sử dụng factory để tạo đối tượng
//        Creator creatorA = new ConcreteCreatorA();
//        FactoryTest.Product productA = creatorA.createProduct();
//        productA.doSomething();
//
//        FactoryTest.Creator creatorB = new FactoryTest.ConcreteCreatorB();
//        FactoryTest.Product productB = creatorB.createProduct();
//        productB.doSomething();
//    }
//}
public class FactoryTest {

    // Abstract product
    interface Product {
        void doSomething();
    }

    // Concrete product A
    static class ProductA implements Product {
        @Override
        public void doSomething() {
            System.out.println("ProductA is doing something!");
        }
    }

    // Concrete product B
    static class ProductB implements Product {
        @Override
        public void doSomething() {
            System.out.println("ProductB is doing something!");
        }
    }

    // Abstract creator
    abstract static class Creator {
        // Phương thức Factory để tạo đối tượng
        public abstract Product createProduct();
    }

    // Concrete creator A
    static class ConcreteCreatorA extends Creator {
        @Override
        public Product createProduct() {
            return new ProductA();  // Trả về ProductA
        }
    }

    // Concrete creator B
    static class ConcreteCreatorB extends Creator {
        @Override
        public Product createProduct() {
            return new ProductB();  // Trả về ProductB
        }
    }

    public static void main(String[] args) {
        // Sử dụng factory để tạo đối tượng
        Creator creatorA = new ConcreteCreatorA();
        Product productA = creatorA.createProduct();
        productA.doSomething();

        Creator creatorB = new ConcreteCreatorB();
        Product productB = creatorB.createProduct();
        productB.doSomething();
    }
}
