import java.util.ArrayList;
import java.util.List;

public class Test {

        public static List<String> names;

        static {
            names = new ArrayList<>();
            names.add("Alice");
            names.add("Bob");
            names.add("Charlie");
            System.out.println("Static initialization block executed: " + names);
        }
        static {
            System.out.println("Print1");
        }

        public void print(){
            System.out.println("Array" + names);
        }
    }

