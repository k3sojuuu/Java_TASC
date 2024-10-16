package PrimitiveAndObject;

public class ObjectType {
    //là các kiểu dữ liệu có giá trị khởi tạo là null và có thể null
    //bao gồm cả các collection,array,...
    private Integer num1 = 1;
    private Long num2 = 2L;
    private Float num3 = 3F;
    private String str = "siuu";

    public static void main(String[] args) {
        ObjectType objectType = new ObjectType();
        System.out.println(objectType.num1);
        System.out.println(objectType.num2);
        System.out.println(objectType.num3);
        System.out.println(objectType.str);
    }
}
