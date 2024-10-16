package PrimitiveAndObject;

public class PrimitiveType {
    //các kiểu giá trị mặc định có giá trị khởi tạo và không null
    private int num1 = 1;
    private byte num2 = 2;
    private long num3 = 3;
    private short num4 = 4;

    private float num5 = 5;
    private double num6 = 6;

    private boolean status = false;

    public String Compare(){
        if ( num1 > num2){
             return "bigger";
        } else if (num1 == num2) {
             return "equal";
        } else {
            return "smaller";
        }
    }
    public static void main(String[] args) {
        PrimitiveType primitiveType = new PrimitiveType();
        System.out.println(primitiveType.num1);
        System.out.println(primitiveType.num2);
        System.out.println(primitiveType.num3);
        System.out.println(primitiveType.num4);
        System.out.println(primitiveType.num5);
        System.out.println(primitiveType.num6);
        System.out.println(primitiveType.status);
        System.out.println(primitiveType.Compare());

    }
}
