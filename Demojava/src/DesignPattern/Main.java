package DesignPattern;

public class Main {
    public static void main(String[] args) {
//        SingletonExample singletonExample = SingletonExample.getInstance();
//        singletonExample.showMessage();
//
//        SingletonExample singletonExample1 = SingletonExample.getInstance();
//        singletonExample.showMessage();
//
//
////        factory
//        FactoryTest.Creator creatorA = new FactoryTest.ConcreteCreatorA();
//        FactoryTest.Product productA = creatorA.createProduct();
//
//        FactoryTest.Creator creatorB = new FactoryTest.ConcreteCreatorB();
//        FactoryTest.Product productB = creatorB.createProduct();
//
//        productA.doSomething();
//        productB.doSomething();

        EageSingleton eageInit = EageSingleton.getInstance();
        eageInit.setName("Huy");
        EageSingleton eageInit1 = EageSingleton.getInstance();
        eageInit1.setName("Tan");
        System.out.println(eageInit.getName());
        System.out.println(eageInit1.getName());
    }
}
