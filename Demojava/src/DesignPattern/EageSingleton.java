package DesignPattern;

public class EageSingleton {
    private static final EageSingleton INSTANCE = new EageSingleton();

    private EageSingleton(){

    }

    public static EageSingleton getInstance(){
        return INSTANCE;
    }
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}
