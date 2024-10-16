package String;

public class TestString {

    String str1 = "NguyenTan";//    Sử Dụng Literal (Chuỗi Tliteral)

    String str2 = new String("NguyenTan");// Khởi tạo qua constructer Object
    char[] chars = {'H', 'e', 'l', 'l', 'o'};//Khởi tạo qua chuỗi
    String str3 = new String(chars);

    public String Compare(){
        if (str1.equals(str2)){
            return System.out.printf("Equal").toString();
        }else{
            return System.out.printf("Not Equal").toString();
        }
    }
    public void Print(){
        TestString testString = new TestString();
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        testString.Compare();
    }
    public static void main(String[] args) {
        TestString testString = new TestString();
        testString.Print();
    }
}
